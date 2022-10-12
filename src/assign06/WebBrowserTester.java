package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WebBrowserTester {

	private WebBrowser testBrowser;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testBrowser = new WebBrowser();
	}
	
	@Test
	void testVisit() throws MalformedURLException 
	{
		URL num1 = new URL("https://a");
		URL num2 = new URL("https://b");
		URL num3 = new URL("https://c");
		URL num4 = new URL("https://d");
		
		
		testBrowser.visit(num1);
		testBrowser.visit(num2);
		testBrowser.visit(num3);
		testBrowser.visit(num4);
		
		SinglyLinkedList<URL> webHistory = testBrowser.history();
		
		assertEquals("https://d", webHistory.get(0).toString());
		assertEquals("https://c", webHistory.get(1).toString());
		assertEquals("https://b", webHistory.get(2).toString());
		assertEquals("https://a", webHistory.get(3).toString());

	}

	@Test
	void testBack() throws MalformedURLException 
	{
		URL num1 = new URL("https://a");
		URL num2 = new URL("https://b");
		URL num3 = new URL("https://c");
		URL num4 = new URL("https://d");
		
		
		testBrowser.visit(num1);
		testBrowser.visit(num2);
		testBrowser.visit(num3);
		testBrowser.visit(num4);
		
		assertEquals(testBrowser.back().toString(), "https://c");
		assertEquals(testBrowser.back().toString(), "https://b");
		assertEquals(testBrowser.back().toString(), "https://a");
		
		assertThrows(NoSuchElementException.class, () -> testBrowser.back() );

	}

	@Test
	void testForward() throws MalformedURLException 
	{
		URL num1 = new URL("https://a");
		URL num2 = new URL("https://b");
		URL num3 = new URL("https://c");
		URL num4 = new URL("https://d");
		
		
		testBrowser.visit(num1);
		testBrowser.visit(num2);
		testBrowser.visit(num3);
		testBrowser.visit(num4);
		
		assertEquals(testBrowser.back().toString(), "https://c");
		assertEquals(testBrowser.back().toString(), "https://b");
		assertEquals(testBrowser.back().toString(), "https://a");
		
		
		assertEquals(testBrowser.forward().toString(), "https://b");
		assertEquals(testBrowser.forward().toString(), "https://c");
		assertEquals(testBrowser.forward().toString(), "https://d");
		
		assertThrows(NoSuchElementException.class, () -> testBrowser.forward() );
	}

	@Test
	void testHistory() throws MalformedURLException 
	{
		URL num1 = new URL("https://a");
		URL num2 = new URL("https://b");
		URL num3 = new URL("https://c");
		URL num4 = new URL("https://d");
		
		
		testBrowser.visit(num1);
		testBrowser.visit(num2);
		testBrowser.visit(num3);
		testBrowser.visit(num4);
		
		assertEquals(testBrowser.back().toString(), "https://c");
		assertEquals(testBrowser.back().toString(), "https://b");
		
		SinglyLinkedList<URL> webHistory = testBrowser.history();
		
		assertEquals("https://b", webHistory.get(0).toString());
		assertEquals("https://a", webHistory.get(1).toString());
		
	}
	
	@Test
	void testweb() throws MalformedURLException 
	{
		URL num1 = new URL("https://a");
		URL num2 = new URL("https://b");
		URL num3 = new URL("https://c");
		URL num4 = new URL("https://d");
		
		SinglyLinkedList<URL> webHistoryInsert = new SinglyLinkedList();
		webHistoryInsert.insertFirst(num1);
		webHistoryInsert.insertFirst(num2);
		webHistoryInsert.insertFirst(num3);
		webHistoryInsert.insertFirst(num4);

		
		
		WebBrowser testBrowserHist = new WebBrowser(webHistoryInsert);

		SinglyLinkedList<URL> webHistory = testBrowserHist.history();
		
		assertEquals("https://d", webHistory.get(0).toString());
		assertEquals("https://c", webHistory.get(1).toString());
		assertEquals("https://b", webHistory.get(2).toString());
		assertEquals("https://a", webHistory.get(3).toString());
		
		assertEquals(testBrowserHist.back().toString(), "https://c");

	}

}
