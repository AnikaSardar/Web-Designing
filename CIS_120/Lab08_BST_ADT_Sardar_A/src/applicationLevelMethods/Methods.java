package applicationLevelMethods;

import bst_Package.BSTInterface;
import bst_Package.BSTNode;
import bst_Package.BinarySearchTree;
import stacks.LinkedStack;

public class Methods<T extends Comparable<T>>{
	
	public static Comparable min(BinarySearchTree tree) {
		//Calls the reset method for initializing 
		//current position for an iteration through this BST for inOrder traversal
		//Returns the smallest value in this BST 
	
		if (tree == null || tree.isEmpty()) { 
			  return null; 
		  } 
		else {
		tree.reset(1); 
		return tree.getNext(1); //returns the current value and points to the next value
	}
}
	
	public static Comparable max(BinarySearchTree tree) {
		//Calls the reset method for initializing 
		//current position for an iteration through this BST for inOrder traversal and
		//returns the current number of nodes in this BST
		//Returns the largest value in this BST 
		
		if (tree == null || tree.isEmpty()) {
			  return null;  
		  } 
		else {
		int size = tree.reset(1); //reset method returns the number of nodes in BST
		Comparable max = 0;
		int iter = 0;
		
		while (iter != size) {
			max = tree.getNext(1);
			iter++;
		}
		return max;
		}
	}

}
