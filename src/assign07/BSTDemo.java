package lec13;


public class BSTDemo {

	public static void main(String[] args) {
		BST bst = new BST();
		
		// What happens if items are inserted to a BST in ascending order?
		bst.insert("alpaca");
		bst.insert("cat");
		bst.insert("chupacabra");
		bst.insert("cow");
		bst.insert("dog");
		bst.insert("dragon");
		bst.insert("pelican");
		bst.insert("zebra");
		
		System.out.println(bst.contains("cow"));
		System.out.println(bst.contains("monkey"));
		
		bst.writeDot("BST.dot");					
	}

}