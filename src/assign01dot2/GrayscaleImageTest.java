package assign01dot2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class GrayscaleImageTest {

    private GrayscaleImage smallSquare;
    private GrayscaleImage smallWide;
    private GrayscaleImage image1;
    private GrayscaleImage image2;
    private GrayscaleImage image3;
    private GrayscaleImage image4;
    private GrayscaleImage image5;
    private GrayscaleImage image6; 
    private GrayscaleImage image7;  
    private GrayscaleImage image8; 

    @BeforeEach
    void setUp() {
        smallSquare = new GrayscaleImage(new double[][]{{1,2},{3,4}});
        smallWide = new GrayscaleImage(new double[][]{{1,2,3},{4,5,6}});
        image1 = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        image2 = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        image3 = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 8}});
        image4 = new GrayscaleImage(new double[][] {{1, 2}, {4, 5}});
        image5 = new GrayscaleImage(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        image6 = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        image7 = new GrayscaleImage(new double[][] {{10, 15, 20}, {30, 40, 50}, {60, 70, 80}});
        image8 = new GrayscaleImage(new double[][] {{100, 100, 100}, {100, 100, 100}, {100, 100, 100}});
    }

    @Test
    void testGetPixel(){
        assertEquals(smallSquare.getPixel(0,0), 1);
        assertEquals(smallSquare.getPixel(1,0), 2);
        assertEquals(smallSquare.getPixel(0,1), 3);
        assertEquals(smallSquare.getPixel(1,1), 4);
    }
    
    @Test
    void testPixelsThatDontExist() {
    	assertThrows(IllegalArgumentException.class, () -> { smallSquare.getPixel(7, 10); });
    }
    
    @Test
    void testGetPixelOutOfBounds() {
    	GrayscaleImage image = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    	assertThrows(IllegalArgumentException.class, () -> { image.getPixel(4, 4); });
    }

	@Test
	void testGetPixelMultiple() {
		GrayscaleImage image = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
		assertEquals(5, image.getPixel(1, 1), 0.1);
		assertEquals(3, image.getPixel(2, 0), 0.1);
		assertEquals(7, image.getPixel(0, 2), 0.1);
	}

    @Test
    void testEquals() {
        assertEquals(smallSquare, smallSquare);
        var equivalent = new GrayscaleImage(new double[][]{{1,2},{3,4}});
        assertEquals(smallSquare, equivalent);
    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Test
    void testDosentEqual() {
    	 var notEquivalent = new GrayscaleImage(new double[][]{{3,4, 6},{3,4,7}});
    	 equals(!notEquivalent.equals(smallSquare));
    }

    @Test
    public void testEqualsMultiple() {
        assertTrue(image1.equals(image2));
        assertFalse(image1.equals(image3));
        assertFalse(image1.equals(image4));
        assertFalse(image1.equals(image5));
    }

    @Test
    void averageBrightness() {
        assertEquals(smallSquare.averageBrightness(), 2.5, 2.5*.001);
        var bigZero = new GrayscaleImage(new double[1000][1000]);
        assertEquals(bigZero.averageBrightness(), 0);
    }
    
    @Test
    void averageBrightness4x4() {
        double[][] imageData = {{0, 10, 20, 30}, {40, 50, 60, 70}, {80, 90, 100, 110}, {120, 130, 140, 150}};
        GrayscaleImage image = new GrayscaleImage(imageData);
        double expected = 75.0;
        double actual = image.averageBrightness();
        assertEquals(expected, actual, 0.001);   
    }
    
    @Test
    void averageBrightness3x3() {
        double[][] imageData = {{0, 10, 20}, {30, 40, 50}, {60, 70, 80}};
        GrayscaleImage image = new GrayscaleImage(imageData);
        double expected = 40.0;
        double actual = image.averageBrightness();
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    void averageBrightness1x1() {
        double[][] imageData = {{255}};
        GrayscaleImage image = new GrayscaleImage(imageData);
        double expected = 255;
        double actual = image.averageBrightness();
        assertEquals(expected, actual, 0.001);
    }
    
	@Test
	void normalized() {
		var smallNorm = smallSquare.normalized();
		assertEquals(smallNorm.averageBrightness(), 127, 127 * .001);
		var scale = 127 / 2.5;
		var expectedNorm = new GrayscaleImage(new double[][] { { scale, 2 * scale }, { 3 * scale, 4 * scale } });
		for (var row = 0; row < 2; row++) {
			for (var col = 0; col < 2; col++) {
				assertEquals(smallNorm.getPixel(col, row), expectedNorm.getPixel(col, row), expectedNorm.getPixel(col, row) * .001, "pixel at row: " + row + " col: " + col + " incorrect");
			}
		}
	}
	
	@Test
	void normalized2() {
		var smallNorm = smallSquare.normalized();
		var scale = 127 / 2.5;
		var expectedNorm = new GrayscaleImage(new double[][] { { scale, 2 * scale }, { 3 * scale, 4 * scale } });
		var expectedNormNomralize = expectedNorm.normalized();
		
		assertEquals(expectedNormNomralize.averageBrightness(), 127, 127 * .001);
		assertEquals(smallNorm.averageBrightness(), expectedNorm.averageBrightness());
	}

    @Test
    public void testNormalized() {
        GrayscaleImage normalizedImage1 = image6.normalized();
        assertEquals(127, normalizedImage1.averageBrightness(), 0.1);
        assertFalse(normalizedImage1 == image6);

        GrayscaleImage normalizedImage2 = image7.normalized();
        assertEquals(127, normalizedImage2.averageBrightness(), 0.1);
        assertFalse(normalizedImage2 == image7);

        GrayscaleImage normalizedImage3 = image8.normalized();
        assertEquals(127, normalizedImage3.averageBrightness(), 0.1);
        assertFalse(normalizedImage3 == image8);
    }

    @Test
    public void testNormalizedWithZeroAverageBrightness() {
        GrayscaleImage image = new GrayscaleImage(new double[][] {{-50, -50, -50}, {-50, -50, -50}, {-50, -50, -50}});
        GrayscaleImage normalizedImage = image.normalized();
        assertEquals(127, normalizedImage.averageBrightness(), 0.1);
    }

    @Test
    void mirrored() {
        var expected = new GrayscaleImage(new double[][]{{2,1},{4,3}});
        assertEquals(smallSquare.mirrored(), expected);
    }
    
//    private GrayscaleImage image1 = new GrayscaleImage(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
//    smallWide = new GrayscaleImage(new double[][]{{1,2,3},{4,5,6}});
    
    @Test
    void testMoreMirrored() {
    	var expected = new GrayscaleImage(new double[][] {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}});
    	assertEquals(image1.mirrored(), expected);
    }
    
//    @Test
//    void testMirrored() {
//        var expected = new GrayscaleImage(new double[][]{{3,2,1},{6,5,4}});
//        assertEquals(smallWide.mirrored(), expected);
//    }


    @Test
    void cropped() {
        var cropped = smallSquare.cropped(1,1,1,1);
        assertEquals(cropped, new GrayscaleImage(new double[][]{{4}}));
    }
    
    private GrayscaleImage image = new GrayscaleImage(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});

    @Test
    public void testCroppedWithInvalidStartRow() {
    	assertThrows(IllegalArgumentException.class, () -> { image.cropped(-1, 1, 2, 2); }); 
    }

    @Test
    public void testCroppedWithInvalidStartCol() {
    	assertThrows(IllegalArgumentException.class, () -> { image.cropped(1, -1, 2, 2); });         
    }

    @Test
    public void testOriginalImageNotModified() {
        GrayscaleImage originalImage = new GrayscaleImage(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        assertEquals(originalImage, image);
    }

    @Test
    void squarified() {
        var squared = smallWide.squarified();
        var expected = new GrayscaleImage(new double[][]{{1,2},{4,5}});
        assertEquals(squared, expected);
    }
    
    @Test
    void testSquarified() {
    	 GrayscaleImage mediumWide = new GrayscaleImage(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}});
    	var squared = mediumWide.squarified();
    	var expected = new GrayscaleImage(new double[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}});
    	 assertEquals(squared, expected);
    }
}