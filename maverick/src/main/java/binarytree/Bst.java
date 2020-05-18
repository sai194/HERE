package binarytree;

public class Bst {

	Node root;
	
	public void insert(Node node) {
		
		if(root == null ) {
			root = node;
			return;
		}
		
		Node current = root;
		while(true) {
			if(current.key > node.key) {
				if(current.left == null) {
					current.left = node;
					return;
				}
				current = current.left;
	
			} else {
				if(current.right == null) {
					current.right = node;
					return;
				}
				current = current.right;
			}
			
		}
	}
	
	public Node findMin(Node node) {
		if(node == null) {
			return null;
		}
		Node current = node;
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	public Node findMax(Node node) {
		if(node == null) {
			return null;
		}
		Node current = node;
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}
}
