package binarytree;

public class BstApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bst bst = new Bst();
		bst.insert(new Node(10, "Ten"));
		bst.insert(new Node(30, "Thirty"));
		bst.insert(new Node(5, "Five"));
		bst.insert(new Node(15, "Fifteen"));
		bst.insert(new Node(50, "Fifty"));
		bst.insert(new Node(40, "Fourty"));
		bst.insert(new Node(100, "Hundred"));
		
		System.out.println(bst.findMin(bst.root).key);
		System.out.println(bst.findMax(bst.root).key);

	}

}
