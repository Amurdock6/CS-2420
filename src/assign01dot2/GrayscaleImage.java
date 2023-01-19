package assign01dot2;


import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * Represents a grayscale (black and white) image as a 2D array of "pixel" brightnesses
 * 255 is "white" 127 is "gray" 0 is "black" with intermediate values in between
 * Author: Ben Jones and Alex Murdock
 */
public class GrayscaleImage {
    private double[][] imageData; // the actual image data


    /**
     * Initialize an image from a 2D array of doubles
     * This constructor creates a copy of the input array
     * @param data initial pixel values
     * @throws IllegalArgumentException if the input array is empty or "jagged" meaning not all rows are the same length
     */
    public GrayscaleImage(double[][] data){
        if(data.length == 0 || data[0].length == 0){
            throw new IllegalArgumentException("Image is empty");
        }

        imageData = new double[data.length][data[0].length];
        for(var row = 0; row < imageData.length; row++){
            if(data[row].length != imageData[row].length){
                throw new IllegalArgumentException("All rows must have the same length");
            }
            for(var col = 0; col < imageData[row].length; col++){
                imageData[row][col] = data[row][col];
            }
        }
    }

    /**
     * Fetches an image from the specified URL and converts it to grayscale
     * Uses the AWT Graphics2D class to do the conversion, so it may add
     * an item to your dock/menu bar as if you're loading a GUI program
     * @param url where to download the image
     * @throws IOException if the image can't be downloaded for some reason
     */
    public GrayscaleImage(URL url) throws IOException {
        var inputImage = ImageIO.read(url);
        //convert input image to grayscale
        //based on (https://stackoverflow.com/questions/6881578/how-to-convert-between-color-models)
        var grayImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d= grayImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, null);
        g2d.dispose();
        imageData = new double[grayImage.getHeight()][grayImage.getWidth()];

        //raster is basically a width x height x 1 3-dimensional array
        var grayRaster = grayImage.getRaster();
        for(var row = 0; row < imageData.length; row++){
            for(var col = 0; col < imageData[0].length; col++){
                //getSample parameters are x (our column) and y (our row), so they're "backwards"
                imageData[row][col] = grayRaster.getSampleDouble(col, row, 0);
            }
        }
    }

    public void savePNG(File filename) throws IOException {
        var outputImage = new BufferedImage(imageData[0].length, imageData.length, BufferedImage.TYPE_BYTE_GRAY);
        var raster = outputImage.getRaster();
        for(var row = 0; row < imageData.length; row++){
            for(var col = 0; col < imageData[0].length; col++){
                raster.setSample(col, row, 0, imageData[row][col]);
            }
        }
        ImageIO.write(outputImage, "png", filename);
    }

    // Methods to be filled in by students below

    /**
     * Get the pixel brightness value at the specified coordinates
     * (0,0) is the top left corner of the image, (width -1, height -1) is the bottom right corner
     * @param x horizontal position, increases left to right
     * @param y vertical position, **increases top to bottom**
     * @return the brightness value at the specified coordinates
     * @throws IllegalArgumentException if x, y are not within the image width/height
     */
	public double getPixel(int x, int y) {

		// Will check to make sure our x and y values are contained in the image.
		if (imageData.length < x || imageData.length < y) {
			throw new IllegalArgumentException("isn't a vaild point");
		}
		
		return imageData[y][x];
	}

    /**
     * Two images are equal if they have the same size and each corresponding pixel
     * in the two images is exactly equal
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof GrayscaleImage)){
            return false;
        }

        GrayscaleImage otherImage = (GrayscaleImage)other;

        
		// Will check to make sure our images have the same dimesions as each other.
		if (otherImage.imageData.length != imageData.length || otherImage.imageData[0].length != imageData[0].length) {
			return false;
		}
        
        // This will iterator over every pixel in both our images and will check to make sure each pixel is the same.
		for (int y = 0; y < imageData[0].length; y++) {
			for (int x = 0; x < imageData.length; x++) {
				if (otherImage.imageData[y][x] != imageData[y][x]) {
					return false;
				}
			}
		}
        
		// If we make it through all of the above code then our images are the same.
        return true;
    }


    /**
     * Computes the average of all values in image data
     * @return the average of the imageData array
     */
    public double averageBrightness() {
        double initialPixelValues = 0;
    	int pixels = 0;
        
        // Will grab the value of each pixel in the image and then add it into our initialPixelValues variable
    	for (int y = 0; y < imageData[0].length; y++) {
			for (int x = 0; x < imageData.length; x++) {
				initialPixelValues += imageData[y][x];
				pixels++;
			}
		}
    	
    	// To get our average we will simply divided the combined value of all the pixels in the image by the number of pixels that are in the image.
        return initialPixelValues / pixels;
    }

    /**
     * Return a new GrayScale image where the average new average brightness is 127
     * To do this, uniformly scale each pixel (ie, multiply each imageData entry by the same value)
     * Due to rounding, the new average brightness will not be 127 exactly, but should be very close
     * The original image should not be modified
     * @return a GrayScale image with pixel data uniformly rescaled so that its averageBrightness() is 127
     */
    public GrayscaleImage normalized(){
        double scaleFactor = 127 / averageBrightness();
        
        // First we make a 2D array that is the same size as the original image.
    	double[][] normalized2DArray = new double[imageData[0].length][imageData.length];
        
    	// Then we will set the brightness of the specified pixel below.
    	for (int y = 0; y < imageData[0].length; y++) {
			for (int x = 0; x < imageData.length; x++) {
				 double newPixelValue = getPixel(y, x) * scaleFactor;
				 normalized2DArray[y][x] = newPixelValue;
			}
		}
    	
    	// We will then turn the 2DArray into a GrayscaleImage
    	GrayscaleImage normalizedImage = new GrayscaleImage(normalized2DArray);
    	System.out.println(normalizedImage.averageBrightness());
    	
        return normalizedImage;
    }


    /**
     * Returns a new grayscale image that has been "mirrored" across the y-axis
     * In other words, each row of the image should be reversed
     * The original image should be unchanged
     * @return a new GrayscaleImage that is a mirrored version of the this
     */
    public GrayscaleImage mirrored(){
    	// First we make a 2D array that is the same size as the original image.
    	double[][] mirroredImage2DArray = new double[imageData[0].length][imageData.length];
    	
		// Here we will copy the initial data from the image and flip it on the x axis.
		for (int y = 0; y < imageData[0].length; y++) {
			for (int x = 0; x < imageData.length; x++) {
				mirroredImage2DArray[y][imageData.length - x - 1] = imageData[y][x];
			}
		}
      	
    	// Then we will convert our 2D array into a GrayscaleImage
    	GrayscaleImage normalizedImage = new GrayscaleImage(mirroredImage2DArray);
    			
        return normalizedImage;
    }

    /**
     * Returns a new GrayscaleImage of size width x height, containing the part of `this`
     * from startRow -> startRow + height, startCol -> startCol + width
     * The original image should be unmodified
     * @param startRow
     * @param startCol
     * @param width
     * @param height
     * @return A new GrayscaleImage containing the sub-image in the specified rectangle
     * @throws IllegalArgumentException if the specified rectangle goes outside the bounds of the original image
     */
    public GrayscaleImage cropped(int startRow, int startCol, int width, int height){
        // We will first check to make sure that the portion of the image we want to crop actually exist.
    	if(startRow < 0 || startCol < 0)
            throw new IllegalArgumentException("Specified rectangle goes outside the bounds of the original image");

    	// Then we will create a 2D array to store the new data for the cropped image.
        double[][] croppedImage2DArray = new double[width][height];
        
        
        // Then we will set the values in our croppedImage2DArray
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
            	croppedImage2DArray[row][col] = imageData[startRow + row][startCol + col];
            }
        }
        GrayscaleImage croppedImage = new GrayscaleImage(croppedImage2DArray);
        
        return croppedImage;
    }
    

	/**
	 * Returns a new "centered" square image (new width == new height) For example,
	 * if the width is 20 pixels greater than the height, this should return a
	 * height x height image, with 10 pixels removed from the left and right edges
	 * of the image If the number of pixels to be removed is odd, remove 1 fewer
	 * pixel from the left or top part (note this convention should be
	 * SIMPLER/EASIER to implement than the alternative) The original image should
	 * not be changed
	 * 
	 * @return a new, square, GrayscaleImage
	 */
	public GrayscaleImage squarified() {
		// Here we will set our width and height variables equal to the current size of the image
		// We will also intilize our newWidth, newHeight and removePixel variables
		int height = imageData[0].length;
		int width = imageData.length;
		int newWidth, newHeight;
		int removePixel;

		// Then we will go through and check our height and width of the current image and set our newWidth and newHeight variables appropitaly so we can get a squared image
		if (height > width) {
			newWidth = width;
			newHeight = width;
			removePixel = (height - width) / 2;
		} else {
			newWidth = height;
			newHeight = height;
			removePixel = (width - height) / 2;
		}

		// We will then create a 2D array that has the the new dimensions we decided upon to be squared.
		double[][] squarifiedImage2DArray = new double[newHeight][newWidth];

		// Then we will go through and set all of the pixels that we want to keep to make our image squared into our 2D Array.
		for (int row = removePixel; row < newHeight + removePixel; row++) {
			for (int col = removePixel; col < newWidth + removePixel; col++) {
				squarifiedImage2DArray[row - removePixel][col - removePixel] = imageData[row][col];
			}
		}

		// Then we create our GrayscaleImage based off of the data in our 2D Array.
		GrayscaleImage squarifiedImage = new GrayscaleImage(squarifiedImage2DArray);

		return squarifiedImage;
	}

}

