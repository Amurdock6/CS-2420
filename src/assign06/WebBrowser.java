package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

/**
 * This class represents a browser window with forward, backward, visit and history methods that simulate a web browser
 * 
 * @author Todd Oldham and Alex Murdock
 * @version October 7, 2022
 */

public class WebBrowser 
{
	// instances of Stack interface
	private ArrayStack forwardButton;
	private ArrayStack backwardButton;
	private URL current = null;
	/**
	 * 
	 * This constructor creates a new web browser with no previously-visited webpages
	 *  and no webpages to visit next.
	 * 
	 */
	public WebBrowser()
	{
		forwardButton = new ArrayStack();
		backwardButton = new ArrayStack();
	}
	
	/**
	 * 
	 * This constructor creates a new web browser with a preloaded history of visited webpages, 
	 * given as a list of URL objects.  
	 * The first webpage in the list is the "current" page visited, 
	 * and the remaining webpages are ordered from most recently visited to least recently visited.
	 * 
	 * @param history
	 */
	public WebBrowser(SinglyLinkedList<URL> history)
	{
		// create forward and backward stacks
		forwardButton = new ArrayStack();
		backwardButton = new ArrayStack();
		
		int sizeValue = history.size();
		
		// set current equal to the top of the history stack
		current = (URL) history.getFirst();
		
		// going from the last item to the first item in the history stack add them to the backward button stack
		// Should be in order from most recently visited to last visited
		for(int i = sizeValue - 1; i > 0; i--)
			backwardButton.push( (URL) history.get(i));	
		
	}
	
	/**
	 * 
	 * This method simulates visiting a webpage, given as a URL.  
	 * Note that calling this method should clear the forward stack, since there is no URL to visit next. 
	 * This is just like a forward button (right facing arrow) on a real web browser. 
	 * When you visit a link, the right-arrow is cleared.
	 * 
	 * @param webpage
	 */
	public void visit(URL webpage)
	{
		// clear the forward button
		forwardButton.clear();
		
		// add the current webpage to the backward button stack
		if(current != null)
			backwardButton.push(current);

		
		// set the current as the new webpage
		current = webpage;	
	}
	
	/**
	 * 
	 * This method simulates using the back button, returning the URL visited.  
	 * NoSuchElementException is thrown if there is no previously-visited URL.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public URL back() throws NoSuchElementException
	{
		// add the current webpage to the forward button
		forwardButton.push(current);
		
		// make the current the last visited site in the backward stack
		current = (URL) backwardButton.pop();
		
		return current;
	}
	
	/**
	 * 
	 * This method simulates using the forward button, returning the URL visited.  
	 * NoSuchElementException is thrown if there is no URL to visit next.
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException
	{
		// add the current webpage to the backward button
		backwardButton.push(current);
		
		// make the current webpage the most recently visited page in the forward button
		current = (URL) forwardButton.pop();
		
		return current;
	}
	
	/**
	 * 
	 * This method generates a history of URLs visited, 
	 * as a list of URL objects ordered from most recently visited to least recently visited (including the "current" page visited), 
	 * without altering subsequent behavior of this web browser. 
	 * "Forward" links are not included. 
	 * The behavior of the method must be O(N), where N is the number of URLs.
	 * 
	 * @return
	 */
	public SinglyLinkedList<URL> history()
	{
		// a temp stack to stor the values of the backward button
		LinkedListStack tempStack = new LinkedListStack();
		
		// history linked list that we will return
		SinglyLinkedList<URL> hist = new SinglyLinkedList();
		
		// place holder for the URLs so we don't lose them
		URL tempValue = null;
		
		// set the size of the backward button since it will change
		int sizeValue = backwardButton.size();
	
		// move all of the values from backward button into a temp stack
		for(int i = 0; i < sizeValue; i++)
		{
			tempStack.push(backwardButton.pop());
		}
		
		// move all the values from temp stack back into backward button and the history list
		for(int j = 0; j < sizeValue; j++)
		{
			tempValue = (URL) tempStack.pop();
			
			backwardButton.push(tempValue);
			
			hist.insertFirst(tempValue);
		}
		
		
		// add the current webpage to the top of the history stack
		hist.insertFirst(current);
		
		return hist;
	}
}
