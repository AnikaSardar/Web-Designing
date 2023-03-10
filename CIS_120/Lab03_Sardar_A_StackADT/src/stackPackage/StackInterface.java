//----------------------------------------------------------------------------
// StackInterface.java           by Dale/Joyce/Weems                 Chapter 3
//
// Interface for a class that implements a stack of <T>.
// A stack is a last-in, first-out structure.
//----------------------------------------------------------------------------

package stackPackage;

public interface StackInterface<T>

{
  void pop() throws StackUnderflowException;
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  
  T top() throws StackUnderflowException;
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element from this stack.
  
  boolean isEmpty();
  // Returns true if this stack is empty, otherwise returns false.
  
  String toString();
	// Returns a nicely formatted string representing this stack 
  
  int sizeIs();
  //Returns the number of elements in this stack
  
  void clear();
	// Makes this stack empty.

}
