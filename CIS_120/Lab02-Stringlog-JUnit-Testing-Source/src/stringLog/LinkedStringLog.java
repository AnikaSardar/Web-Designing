  package stringLog;

  import java.util.LinkedList;

//----------------------------------------------------------------------
// LinkedStringLog.java       by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using a linked list 
// of LLStringNodes to hold the log strings.
//----------------------------------------------------------------------

  public class LinkedStringLog implements StringLogInterface 
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  
  public LinkedStringLog() {
		//	Constructor with no parameter
		//	Assigns a name to the StringLog 
	  
	  this.name = "Example of LinkedStringLog";
  }
  
  public boolean isEmpty(){
	//Returns true if the StringLog is empty, otherwise returns false.
	  
	  if (log == null)
	        return true;
	      else
	        return false;
  }
  
  public int howMany(String element) {
	  //Returns the number of times "element" occurs in the StringLog
	  
	  int count = 0;
	  LLStringNode node;
	  node = log; 
	  
	   while(node != null) {
		   
		   if(node.getInfo().equals(element)) {
		   count++;
	   }
		   node = node.getLink();
	   }
		return count;
	   
  }
  
  public String smallest() {
	  //Precondition: The StringLog is not empty 
	  //
	  //Compares and finds the smallest
	  //(lexicographic ordering) String in the StringLog
	  
	  LLStringNode node;
	  node = log;
	  String smallestString = node.getInfo();
	  
	  while(node != null) {
		  
		   if(node.getInfo().compareTo(smallestString) < 0) {
			   smallestString = node.getInfo();
		   }
			   node = node.getLink();
		   }
	  return smallestString;
  }
  
  public boolean delete(String element) { 
	//Deletes the first occurrence of String "element" from the StringLog 
	
 	  boolean found = false;
	  LLStringNode node;
	  LLStringNode previousNode=null; 
	  node = log;

	  while(node!= null) {
		  
		  if (node.getInfo().equals(element)) {
			  
			  if (previousNode != null) {
				  previousNode.setLink(node.getLink());
				  } 
			  else {
				  log=node.getLink();
			  }
			 found = true; 
			 break;
			 }
		  
		  else {
			  previousNode = node;
			 
		  }
		  
	  node = node.getLink();
	  }

	  return found;
}

   public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  

  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;
    boolean found = false;
    boolean moreToSearch;
    moreToSearch = (node != null);

    while (moreToSearch && !found) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        found = true;
      else
      {
        node = node.getLink();
        moreToSearch = (node != null);
      }
    }

   return found;
  }
  
  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
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
    LLStringNode node;
    node = log;
    int count = 0;
    
    while (node != null)
    {
      count++;
      logString = logString + count + ". " + node.getInfo() + "\n";
      node = node.getLink();
    }
      
    return logString;
  }
  
}