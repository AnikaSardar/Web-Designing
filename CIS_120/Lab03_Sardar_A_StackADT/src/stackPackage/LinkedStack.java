//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 3
//
// Implements UnboundedStackInterface using a linked list 
// to hold the stack elements.
//-----------------------------------------------------------------------

package stackPackage;



public class LinkedStack<T> implements UnboundedStackInterface<T> {
	protected LLNode<T> top; // reference to the top of this stack



	public String toString() {
		// Returns a nicely formatted string representing this stack 
		//Builds string from right to left
		


//		if(!isEmpty()) {
//			while (top!=null) {
//				content = top.getInfo()+"|"+content; 
//				top=top.getLink();
//			}
//			result = "bottom|"+ content + "top"; 
//		}
//		
//		else {
//			result="Empty Stack";
//		}
//		return result; 
		
		if(isEmpty()) {
			return "Empty Stack";
		}
		else {
			String result = null;
			String content = "";
			while (top!=null) {
			content = top.getInfo()+"|"+content; 
			top=top.getLink();
		}
		result = "bottom|"+ content + "top"; 
		return result;
	}
	
		}
	

	public int sizeIs() {
		// Returns the number of elements in this stack
		
		int count = 0;
		LLNode<T> node;
		node = top;

		while (node != null) {
			count++;
			node = node.getLink();
		}
		return count;
	}

	public void clear(){ 
		// Makes this stack empty.
		
		top = null;
	}

	public LinkedStack() {
		top = null;
	}

	public void push(T element)
	// Places element at the top of this stack.
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

	public void pop()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	{
		if (!isEmpty()) {
			top = top.getLink();
		} else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	public T top()
	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	{
		if (!isEmpty())
			return top.getInfo();
		else
			throw new StackUnderflowException("Top attempted on an empty stack.");
	}

	public boolean isEmpty()
	// Returns true if this stack is empty, otherwise returns false.
	{
		if (top == null)
			return true;
		else
			return false;
	}

}
