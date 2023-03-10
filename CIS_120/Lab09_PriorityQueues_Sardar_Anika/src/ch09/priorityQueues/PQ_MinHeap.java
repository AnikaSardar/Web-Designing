//----------------------------------------------------------------------------
// Heap.java               by Dale/Joyce/Weems                       Chapter 9
//
// Defines all constructs for a heap.
// The dequeue method returns the largest element in the heap.
//----------------------------------------------------------------------------

package ch09.priorityQueues;

import java.util.*;

public class PQ_MinHeap<T extends Comparable<T>> implements PriQueueInterface<T>
{
   private ArrayList<T> elements;  // priority queue elements
   private int lastIndex;          // index of last element in priority queue
   private int maxIndex;           // index of last position in ArrayList

   //global values for the driver class to access
  public static int countCompares = 0; 
  public static int countSwaps = 0; 
  
  public PQ_MinHeap(int minSize)
  {
    elements = new ArrayList<T>(minSize);
    lastIndex = -1;
    maxIndex = minSize - 1;
  }

  public boolean isEmpty()
  // Returns true if this priority queue is empty; otherwise, returns false.
  {
    return (lastIndex == -1);
  }

  public boolean isFull()
  // Returns true if this priority queue is full; otherwise, returns false.
  {
    return (lastIndex == maxIndex);
  }

  private void reheapUp(T element)
  // Current lastIndex position is empty.
  // Inserts element into the tree and ensures shape and order properties.
  {
    int hole = lastIndex;
    while (hole > 0) {   // hole is not root  
                                                      
		if (element.compareTo(elements.get((hole - 1) / 2)) < 0) { //element < hole's parent
			// move hole's parent down and then move hole up
			elements.set(hole, elements.get((hole - 1) / 2));
			hole = (hole - 1) / 2;
			countSwaps++; // a data value is assigned into another position
			countCompares++; // a data value is compared against another
		}
	    else {
	    	countCompares++; //since "if" gets evaluated regardless, comparison happens
	    	break;
	    }
	}

	elements.set(hole, element); // place element into final hole
}
  
  public void enqueue(T element) throws PriQOverflowException
  // Throws PriQOverflowException if this priority queue is full;
  // otherwise, adds element to this priority queue.
  {
    if (lastIndex == maxIndex)
      throw new PriQOverflowException("Priority queue is full");
    else
    {
      lastIndex++;
      elements.add(lastIndex,element);
      reheapUp(element);
    }
  }

  private int newHole(int hole, T element)
  // If either child of hole is smaller than element, return the index
  // of the smaller child; otherwise, return the index of hole.
  {
    int left = (hole * 2) + 1;
    int right = (hole * 2) + 2;

	if (left > lastIndex) {
		// hole has no children
		return hole;
	}
	
	if (left == lastIndex) {
		// hole has left child only
		countCompares++;
		if (element.compareTo(elements.get(left)) > 0) {
			// element > left child
			return left;
		} 
		else {
			// element >= left child
			return hole;
		}
	}

	// hole has two children
	if (elements.get(left).compareTo(elements.get(right)) > 0) {
		// left child > right child
		countCompares++;
		if (elements.get(right).compareTo(element) >= 0) {
			// right child >= element
			countCompares++;
			return hole;
		} 
		else {
			// element > right child
			return right;
		}
	}

	// left child >= right child
	if (elements.get(left).compareTo(element) >= 0) {
		// left child >= element
		countCompares++;
		return hole;
	} 
	else {
		// element > left child
		return left;
	}
}

  private void reheapDown(T element)
  // Current root position is "empty";
  // Inserts element into the tree and ensures shape and order properties.
  {
    int hole = 0;      // current index of hole
    int newhole;       // index where hole should move to

    newhole = newHole(hole, element);   // find next hole
    while (newhole != hole)
    {
      countCompares++;
      elements.set(hole,elements.get(newhole));  // move element up
      hole = newhole;                            // move hole down
      countSwaps++; 						
      newhole = newHole(hole, element);          // find next hole
      
    }
    elements.set(hole, element);           // fill in the final hole
  }

  public T dequeue() throws PriQUnderflowException
  // Throws PriQUnderflowException if this priority queue is empty;
  // otherwise, removes element with highest priority (smallest key value) from this 
  // priority queue and returns it.
  {
    T hold;      // element to be dequeued and returned
    T toMove;    // element to move down heap

    if (lastIndex == -1)
      throw new PriQUnderflowException("Priority queue is empty");
    else
    {
      hold = elements.get(0);              // remember element to be returned
      toMove = elements.remove(lastIndex); // element to reheap down
      lastIndex--;                         // decrease priority queue size
      if (lastIndex != -1)
         reheapDown(toMove);               // restore heap properties
      return hold;                         // return smallest element
    }
  }
  
  public String toString()
  // Returns a string of all the heap elements.
  {
    String theHeap = new String("the heap is:\n");
    for (int index = 0; index <= lastIndex; index++)
      theHeap = theHeap + index + ". " + elements.get(index) + "\n";
    return theHeap;
  }



}