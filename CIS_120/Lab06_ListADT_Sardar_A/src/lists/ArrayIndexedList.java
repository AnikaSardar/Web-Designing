//-------------------------------------------------------------------------
// ArrayIndexedList.java        by Dale/Joyce/Weems               Chapter 6
//
// Implements the IndexedListInterface using an array.
//
// Null elements are not permitted on a list.
//
// Two constructors are provided: one that creates a list of a default
// original capacity, and one that allows the calling program to specify the 
// original capacity.
//----------------------------------------------------------------------------

package lists;

public class ArrayIndexedList<T> extends ArrayUnsortedList<T>
                                 implements IndexedListInterface<T>  
{
  public ArrayIndexedList() 
  {
     super();
  }

  public ArrayIndexedList(int origCap) 
  {
     super(origCap);
  }

  public void add(int index, T element)
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index > size().
  // Otherwise, adds element to this list at position index; all current 
  // elements at that index or higher have 1 added to their index.
  {
    if ((index < 0) || (index > size()))
      throw new IndexOutOfBoundsException("illegal index of " + index + 
                             " passed to ArrayIndexedList add method.\n");
                                    
    if (numElements == list.length)
      enlarge();
    
    for (int i = numElements; i > index; i--)
      list[i] = list[i - 1];

    list[index] = element;
    numElements++;
  }
  
  public T set(int index, T element)
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, replaces element on this list at position index and
  // returns the replaced element.
  {
    if ((index < 0) || (index >= size()))
      throw new IndexOutOfBoundsException("illegal index of " + index + 
                             " passed to ArrayIndexedList set method.\n");
 
    T hold = list[index];
    list[index] = element;
    return hold;
  }
    
  public T get(int index)
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, returns the element on this list at position index.
  {
    if ((index < 0) || (index >= size()))
      throw new IndexOutOfBoundsException("illegal index of " + index + 
                             " passed to ArrayIndexedList set method.\n");
 
    return list[index];
  }  

  public int indexOf(T element)
  // If this list contains an element e such that e.equals(element), 
  // then returns the index of the first such element.
  // Otherwise, returns -1.
  {
    find(element);
    if (found)
      return location;
    else  
      return -1;
  }
  
  public T remove(int index)
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, removes element on this list at position index and
  // returns the removed element; all current elements at positions
  // higher than that index have 1 subtracted from their index.
  {
    if ((index < 0) || (index >= size()))
      throw new IndexOutOfBoundsException("illegal index of " + index + 
                             " passed to ArrayIndexedList remove method.\n");

    T hold = list[index];
    for (int i = index; i < numElements; i++)
      list[i] = list[i + 1];
    
    list[numElements] = null;
    numElements--;
    return hold;
  }
  
  public String toString()
  // Returns a nicely formatted string that represents this list.
  {
    String listString = "List:\n";
    for (int i = 0; i < numElements; i++)
      listString = listString + "[" + i + "] " + list[i] + "\n";
    return listString;
  }
}
