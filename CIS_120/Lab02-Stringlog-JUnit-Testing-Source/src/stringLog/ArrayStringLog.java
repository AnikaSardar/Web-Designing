  package stringLog;

  import java.util.Arrays;

//----------------------------------------------------------------------
// ArrayStringLog.java        by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using an array to hold the strings.
//----------------------------------------------------------------------



  public class ArrayStringLog implements StringLogInterface 
{
  protected String name;              // name of this StringLog
  protected String[] log;             // array that holds strings
  protected int lastIndex = -1;       // index of last string in array


  
  public ArrayStringLog() {
	//	Constructor with no parameter
	//	Assigns a name to the StringLog 
	
	  this.name= "Example of ArrayStringLog"; 
	  log = new String[100];
  }
  

 
  public boolean isEmpty() {
	//Returns true if this StringLog is empty, otherwise returns false.
	  
	    if (lastIndex == -1)
	        return true;
	      else
	        return false;
  }
  
  public int howMany(String element) {	
	  //Returns the number of times "element" occurs in the StringLog
	  
	int count = 0;
	
	for(int i = 0; i <= lastIndex; i++) {	
		if (log[i].equals(element)){
			count++;
		}
	}
	return count; 
  
  }
  
  public String smallest() {
	  //Precondition: The StringLog is not empty 
	  //
	  //Compares and finds the smallest String
	  //(lexicographic ordering)in the StringLog
	  
	 String smallest = log[0];
	 
	  for(int i = 1; i <= lastIndex; i++) {
		   if (log[i].compareTo(smallest) < 0) {
			   smallest = log[i];
		  }
	  }
	  return smallest;
  }
  
  
  public boolean delete(String element) { 
	//Deletes the first occurrence of String "element" from the StringLog  
	  
	  boolean found = false;
	    
	  for(int i=0; i <= lastIndex; i++) {
		  
			if (log[i].equals(element)) {
				log[i] = null;
				
				for (int index = i; index < lastIndex; index++) {
					log[index] = log[index+1];  //Shifts every element to the left
					
				}
				
				lastIndex = lastIndex - 1;
				found = true;
			    break;
			}
	  }
	  return found;
  }
  

  
	  
  public ArrayStringLog(String name, int maxSize)
  // Precondition:   maxSize > 0
  //
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name" and room for maxSize strings.
  {
    log = new String[maxSize];
    this.name = name;
  }

  public ArrayStringLog(String name) 
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name" and room for 100 strings.
  {
    log = new String[100];
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    lastIndex++;
    log[lastIndex] = element;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, otherwise returns false.
  {              
    if (lastIndex == (log.length - 1)) 
      return true;
    else
      return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    return (lastIndex + 1);
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case differences when doing string comparison.
  {                 
    boolean moreToSearch;
    int location = 0;
    boolean found = false;
    moreToSearch = (location <= lastIndex);

    while (moreToSearch && !found) 
    {
      if (element.equalsIgnoreCase(log[location]))  // if they match
        found = true;
      else
      {
        location++;
        moreToSearch = (location <= lastIndex);
      }
    }

   return found;
  }
  
  public void clear()
  // Makes this StringLog empty.
  {                  
    for (int i = 0; i <= lastIndex; i++)
      log[i] = null;
    lastIndex = -1;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }

  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";
    
    for (int i = 0; i <= lastIndex; i++)
      logString = logString + (i+1) + ". " + log[i] + "\n";
      
    return logString;
  }
  
}
