//----------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 8
//
// Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------

package bst_Package;

import queues.*;
import stacks.*;

public class BinarySearchTree<T extends Comparable<T>> 
             implements BSTInterface<T>
{
  protected BSTNode<T> root;      // reference to the root of this BST

  boolean found;   // used by remove
  
  // for traversals
  protected LinkedUnbndQueue<T> inOrderQueue;    // queue of info
  protected LinkedUnbndQueue<T> preOrderQueue;   // queue of info
  protected LinkedUnbndQueue<T> postOrderQueue;  // queue of info

  public BinarySearchTree()
  // Creates an empty BST object.
  {
    root = null;
  }
  
  public int leafCount(){
	  //Returns the number of leaf nodes in this BST
	  return recLeafCount(root);
	 
  }
  
  private int recLeafCount(BSTNode<T> tree) {
	  //Returns the number of leaf nodes in this BST
	  if (tree == null) {
		  return 0;
	  }   
	  else if (tree.getLeft() == null && tree.getRight() == null) {
			  return 1;
	  }
	  else {
		return recLeafCount (tree.getLeft()) + recLeafCount (tree.getRight()); 
	  }
  }

  public int singleParentCount(){
	  //Returns the number of nodes in this BST that have only one child
	  return recSingleParentCount(root);
	 
  }
  private int recSingleParentCount (BSTNode<T> tree) {
	  //Returns the number of nodes in this BST that have only one child
	  if (tree == null) {
		  return 0;
	  } 
	  else if  (tree.getLeft() == null && tree.getRight() != null) {
		  return recSingleParentCount(tree.getRight()) + 1; 
			}
	  else if  (tree.getRight() == null && tree.getLeft() != null) {
		  return recSingleParentCount(tree.getLeft()) + 1; 
			}
	  else {
		  return recSingleParentCount(tree.getLeft()) + recSingleParentCount(tree.getRight());
	  }
  }
  
  public boolean isEmpty()
  // Returns true if this BST is empty; otherwise, returns false.
  {
    return (root == null);
  }

  private int recSize(BSTNode<T> tree)
  // Returns the number of elements in tree.
  {
    if (tree == null)    
      return 0;
    else
      return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
  }

  public int size()
  // Returns the number of elements in this BST.
  {
    return recSize(root);
  }

  public int size2()
  // Returns the number of elements in this BST.
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      hold.push(root);
      while (!hold.isEmpty())
      {
        currNode = hold.top();
        hold.pop();
        count++;
        if (currNode.getLeft() != null)
          hold.push(currNode.getLeft());
        if (currNode.getRight() != null)
          hold.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T element, BSTNode<T> tree)
  // Returns true if tree contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
  {
    if (tree == null)
      return false;       // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recContains(element, tree.getLeft());   // Search left subtree
    else if (element.compareTo(tree.getInfo()) > 0)
      return recContains(element, tree.getRight());  // Search right subtree
    else
      return true;        // element is found
  }

  public boolean contains (T element)
  // Returns true if this BST contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
  {
    return recContains(element, root);
  }
  
  private T recGet(T element, BSTNode<T> tree)
  // Returns an element e from tree such that e.compareTo(element) == 0;
  // if no such element exists, returns null.
  {
    if (tree == null)
      return null;             // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recGet(element, tree.getLeft());          // get from left subtree
    else
    if (element.compareTo(tree.getInfo()) > 0)
      return recGet(element, tree.getRight());         // get from right subtree
    else
      return tree.getInfo();  // element is found
  }

  public T get(T element)
  // Returns an element e from this BST such that e.compareTo(element) == 0;
  // if no such element exists, returns null.
  {
    return recGet(element, root);
  }

  private BSTNode<T> recAdd(T element, BSTNode<T> tree)
  // Adds element to tree; tree retains its BST property.
  {
    if (tree == null)
      // Addition place found
      tree = new BSTNode<T>(element);
    else if (element.compareTo(tree.getInfo()) <= 0)
      tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
    else
      tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
    return tree;
  }

  public void add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    root = recAdd(element, root);
  }

  private T getPredecessor(BSTNode<T> tree)
  // Returns the information held in the rightmost node in tree
  {
    while (tree.getRight() != null)
      tree = tree.getRight();
    return tree.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> tree)
  // Removes the information at the node referenced by tree.
  // The user's data in the node referenced by tree is no
  // longer in the tree.  If tree is a leaf node or has only
  // a non-null child pointer, the node pointed to by tree is
  // removed; otherwise, the user's data is replaced by its
  // logical predecessor and the predecessor's node is removed.
  {
    T data;

    if (tree.getLeft() == null)
      return tree.getRight();
    else if (tree.getRight() == null) 
      return tree.getLeft();
    else
    {
      data = getPredecessor(tree.getLeft());
      tree.setInfo(data);
      tree.setLeft(recRemove(data, tree.getLeft()));  
      return tree;
    }
  }

  private BSTNode<T> recRemove(T element, BSTNode<T> tree)
  // Removes an element e from tree such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  {
    if (tree == null)
      found = false;
    else if (element.compareTo(tree.getInfo()) < 0)
      tree.setLeft(recRemove(element, tree.getLeft()));
    else if (element.compareTo(tree.getInfo()) > 0)
      tree.setRight(recRemove(element, tree.getRight()));
    else  
    {
      tree = removeNode(tree);
      found = true;
	 }
    return tree;
  }

  public boolean remove (T element)
  // Removes an element e from this BST such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  {
    root = recRemove(element, root);
    return found;
  }

  private void inOrder(BSTNode<T> tree)
  // Initializes inOrderQueue with tree elements in inOrder order.
  {
    if (tree != null)
    {
      inOrder(tree.getLeft());
      inOrderQueue.enqueue(tree.getInfo());
      inOrder(tree.getRight());
    }
  }

  private void preOrder(BSTNode<T> tree)
  // Initializes preOrderQueue with tree elements in preOrder order.
  {
    if (tree != null)
    {
      preOrderQueue.enqueue(tree.getInfo());
      preOrder(tree.getLeft());
      preOrder(tree.getRight());
    }
  }

  private void postOrder(BSTNode<T> tree)
  // Initializes postOrderQueue with tree elements in postOrder order.
  {
    if (tree != null)
    {
      postOrder(tree.getLeft());
      postOrder(tree.getRight());
      postOrderQueue.enqueue(tree.getInfo());
    }
  }

  public int reset(int orderType)
  // Initializes current position for an iteration through this BST
  // in orderType order. Returns current number of nodes in the BST.
  {
    int numNodes = size();

    if (orderType == INORDER)
    {
      inOrderQueue = new LinkedUnbndQueue<T>();
      inOrder(root);
    }
    else
    if (orderType == PREORDER)
    {
      preOrderQueue = new LinkedUnbndQueue<T>();
      preOrder(root);
    }
    if (orderType == POSTORDER)
    {
      postOrderQueue = new LinkedUnbndQueue<T>();
      postOrder(root);
    }
    return numNodes;
  }

  public T getNext (int orderType)
  // Preconditions: The BST is not empty
  //                The BST has been reset for orderType
  //                The BST has not been modified since the most recent reset
  //                The end of orderType iteration has not been reached
  //
  // Returns the element at the current position on this BST for orderType
  // and advances the value of the current position based on the orderType. 
  {
    if (orderType == INORDER)
      return inOrderQueue.dequeue();
    else
    if (orderType == PREORDER)
      return preOrderQueue.dequeue();
    else
    if (orderType == POSTORDER)
      return postOrderQueue.dequeue();
    else return null;
  }
  
  public void showStructure ( )
  // Outputs the keys in a binary search tree. The tree is output
  // rotated counterclockwise 90 degrees from its conventional
  // orientation using a "reverse" inorder traversal. This operation is
  // intended for testing and debugging purposes only.
{
  if ( root == null )
      System.out.println("Empty tree");
  else
  {
      System.out.println( );
      showSub(root, 1);
      System.out.println( );
  }
}

private void showSub ( BSTNode p, int level )
  // Recursive partner of the showStructure( ) method. Outputs the
  // subtree whose root node is pointed to by p. Parameter level is the
  // level of this node within the tree.

{
  int j;                                          // Loop counter
  
  if ( p == null )
      return;

  Object q = (Object)p.getInfo( );     		  // Cast to Object

  showSub(p.getRight( ), level + 1);          // Output right subtree
  for ( j = 0 ; j < level ; j++ )             // Tab over to level
      System.out.print("\t");
  System.out.print(" " + q);           		  // Output key
  if ( ( p.getLeft( ) != null ) &&            // Output "connector"
       ( p.getRight( ) != null ) )
      System.out.print("<");
  else if ( p.getRight( ) != null )
      System.out.print("/");
  else if ( p.getLeft( ) != null )
      System.out.print("\\");
  System.out.println( );
  showSub(p.getLeft( ), level + 1);          // Output left subtree

}  
  
 
  
}