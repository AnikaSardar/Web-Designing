package bst_Package;

public class DisplayBST {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(15);
		bst.add(18); bst.add(5);
		bst.add(3); bst.add(10); 
		bst.add(21); bst.add(17); 
		
		System.out.println(bst.size());
		bst.reset(1);
		System.out.println(bst.getNext(1));
		bst.showStructure();
		
	}

}
