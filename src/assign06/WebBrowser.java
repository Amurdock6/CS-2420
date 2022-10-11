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
	private LinkedListStack forwardButton;
	private LinkedListStack backwardButton;
	
	/**
	 * 
	 * This constructor creates a new web browser with no previously-visited webpages
	 *  and no webpages to visit next.
	 * 
	 */
	public WebBrowser()
	{
		forwardButton = new LinkedListStack();
		backwardButton = new LinkedListStack();
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
		return null;
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
		return null;
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
		return null;
	}
}
