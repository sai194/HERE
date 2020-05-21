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
	
	public boolean delete(int key) {
		
		Node parent = root;
		Node current = root;
		boolean isLeft = true;
		
		while(current.key != key) {
			parent = current;
			if(current.key > key) {
				isLeft = true;
				current = current.left;
			} else {
				isLeft = false;
				current = current.right;
			}
			if(current == null) {
				return false;
			}
			
		}
		
		Node deleteNode = current;
		
		if(deleteNode.left == null && deleteNode.right == null) {
			if(deleteNode == root) {
				root = null;
			}else if(isLeft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		else if(deleteNode.right == null) {
			if(deleteNode == root) {
				root = deleteNode.left;
			} else if(isLeft) {
				parent.left = deleteNode.left;
			} else {
				parent.right = deleteNode.left;
			}
		}
		else if(deleteNode.left == null) {
			if(deleteNode == root) {
				root = deleteNode.right;
			} else if(isLeft) {
				parent.left = deleteNode.right;
			} else {
				parent.right = deleteNode.right;
			}
		} else {
			
			Node successor = this.getScuccessor(deleteNode);
			
			if(deleteNode == root) {
				root = successor;
			} else if(isLeft) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			
			successor.left = deleteNode.left;
			
			
		}
		
		return true;
	}
	
	Node getScuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;
		Node current = nodeToDelete.right;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != nodeToDelete.right) {
			successorParent.left = successor.right;
			successor.right = nodeToDelete.right;
		}
		return successor;
	}
	
	public void print() {
	    printHelper(root, "");
	  }
	
	private static void printHelper(Node root, String indent) {
	    if (root == null) {
	      System.out.println(indent + "|");
	      return;
	    }

	    // Pick a pretty indent.
	    String newIndent;
	    if (indent.equals("")) {
	      newIndent = ".. ";
	    }
	    else {
	      newIndent = "..." + indent;
	    }

	    printHelper(root.right, newIndent);
	    System.out.println(indent + root.key);
	    printHelper(root.left, newIndent);
	  }
}
