package ApplicationLevelMethods;

import queuePackage.LLNode;
import queuePackage.LinkedUnbndQueue;

public class Methods {

	
	// make a copy of orig queue, leaving it unchanged
	public static LinkedUnbndQueue<String> copyQueue(LinkedUnbndQueue<String> origQ) {

		// copyQueue code goes here
		
		if  (origQ == null) {
			return null;
		}
		
		else if (origQ.isEmpty()) {
			LinkedUnbndQueue<String> emptyList = new LinkedUnbndQueue<String>();
			return emptyList; 
		}
		
		else {
		String deletedItem;
		LinkedUnbndQueue<String> newLList = new LinkedUnbndQueue<String>();
		LinkedUnbndQueue<String> tempQ = new LinkedUnbndQueue<String>();

		while (!origQ.isEmpty()) {
		deletedItem = origQ.dequeue();
			newLList.enqueue(deletedItem);
			tempQ.enqueue(deletedItem);

		}

		// restore origQ from tempQ 
	      while (!tempQ.isEmpty()) {
	  		 deletedItem = tempQ.dequeue();
	           origQ.enqueue(deletedItem);
	      }

      return newLList;
	}
}

	// return a count of the number of elements of the orig queue, leaving it
	// unchanged
	//borrowed from Professor Gibbs's code
	public static int count(LinkedUnbndQueue<String> origQ) {

		// count code goes here
		
		if (origQ == null)
            return 0; // a queue with a null reference has no elements

        else { // anything else traverse and count
    		LinkedUnbndQueue<String> tempQ = new LinkedUnbndQueue<String>();
    		int count = 0; // count the values in the origQ, storing them in tempQ
    		String s;
		
		while (!origQ.isEmpty()) {
			s = origQ.dequeue();
			tempQ.enqueue(s);
			count++;

		}

		// restore origQ from tempQ 
      while (!tempQ.isEmpty()) {
           s = tempQ.dequeue();
           origQ.enqueue(s);
      }

		return count;

	}
}


	// return a nicely formatted string representing the queue, leaving it unchanged
	public static String showQueue(LinkedUnbndQueue<String> origQ) {

		// showQueue code goes here

		if (origQ == null) {
			return "Queue is null";
		}
		
		else if (origQ.isEmpty()) {
			return "Empty Queue";
		}
	 
		else {
			LinkedUnbndQueue<String> newLList = new LinkedUnbndQueue<String>();		
			String result = null;
			String content = "";
			
			while (!origQ.isEmpty()) {
				String deletedItem = origQ.dequeue();
				newLList.enqueue(deletedItem);
				content += deletedItem + "|";	
			}
	
			// restore origQ from newLList 
			while (!newLList.isEmpty()) {
	    	  String deletedItem = newLList.dequeue();
	          origQ.enqueue(deletedItem);
	      }     
	      result = "front|" + content + "rear";
	      return result;
	}
		
	}

}
