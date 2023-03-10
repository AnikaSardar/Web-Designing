//-------------------------------------------------------------------------
// RefSortedList.java         by Dale/Joyce/Weems                 Chapter 6
//
// Implements the ListInterface using a linked list. It is kept in increasing
// order as defined by the compareTo method of the added elements. Only 
// Comparable elements may be added to a list.
//
// Null elements are not permitted on a list.
//
// One constructor is provided, one that creates an empty list.
//----------------------------------------------------------------------------

package ch09.priorityQueues;



public class PQ_RefSortedList<T extends Comparable<T>> 
             extends RefUnsortedList<T> 
             implements  ListInterface<T>, PriQueueInterface<T>         
{
	
	  public static int countCompares = 0;
	  public static int countSwaps = 0; 
	
	
  public PQ_RefSortedList() 
  {
    super();
  }

  public void add(T element)
  // Adds element to this list.
  {
    LLNode<T> prevLoc;        // trailing reference
    LLNode<T> location;       // traveling reference
    T listElement;            // current list element being compared      

    // Set up search for insertion point.
    location = list;
    prevLoc = null;

    // Find insertion point.
    while (location != null)
    {
    	countCompares++; // one data value is compared against another
      listElement = location.getInfo();
      if (listElement.compareTo(element) < 0)  // list element < add element
      {
         prevLoc = location;
         location = location.getLink();
      }
      else
        break;
    }

    // Prepare node for insertion.
    LLNode<T> newNode = new LLNode<T>(element);

    // Insert node into list.
    if (prevLoc == null)         
    {
      // Insert as first node.
      newNode.setLink(list);
      list = newNode;
    }
    else
    {
      // Insert elsewhere.
      newNode.setLink(location);
      prevLoc.setLink(newNode);
      countSwaps++;    // a data value is assigned into another position
    }
    numElements++;
  }

public boolean isEmpty() {
	// Returns true if this list is empty; otherwise, returns false.
	return (list == null);
}


public boolean isFull() {
	//unbounded list
	//Always returns false
	return false;       
}

public void enqueue(T element) {
	//unbounded list that calls add method
	//adds element to the list
	 add (element);
	
}

public T dequeue() throws PriQUnderflowException {
	  // Throws PriQUnderflowException if this list is empty;
	  // otherwise, removes element with highest priority (smallest key value) from this 
	  // list and returns it.
	//No countCompare since the head points to the next element
	//after removal of the smallest value
		if (isEmpty()) {
			throw new PriQUnderflowException("Priority queue is empty");
		}

		T element;
		element = list.getInfo();
		list = list.getLink();
		countSwaps++;

		return element;

	}
}
