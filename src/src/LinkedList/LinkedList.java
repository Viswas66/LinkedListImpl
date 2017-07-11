package src.LinkedList;

public class LinkedList {
	public LinkedListNode head;
	

	public LinkedList(){
		head = new LinkedListNode(0);
		
	}

    public boolean add(int d){
    	//create new Linked List Node
    	LinkedListNode end = new LinkedListNode(d);
    	LinkedListNode current = head;
        
    	//Traverse to the end of the List
    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = end;
    	
        System.out.println(d+" appended to List!");
        return true;
    }
    
    public int deleteTail(){
    	if(head.next == null)  //handle when head is the only node
    	 { 
    	     //Store the data somewhere since head has to be set to NULL.
    	     int dataToReturn = head.data;

    	     // Since head is the only node, set it to NULL now.
    	     head = null;

    	     // Now return the data the the last node (head in this case) contained.
    	     return dataToReturn;
    	    }

    	LinkedListNode position = head;
    	LinkedListNode temp = head;   //temp has to be initialized to something 
    	    int dataAtEnd =0;

    	    while (position.next != null)
    	    {   dataAtEnd = position.data;    
    	        temp =position;               //safe keep current position
    	       position = position.next;     //update position pointer to get the next value  
    	      }

    	   position = null;
    	   temp.next = null;//this is what deletes the last node.

    	   return dataAtEnd;
    }
    
    public LinkedListNode removeElements(int val) {
    	
    	//check if the head value is greater than the val and move head
        while (head != null && head.data > val) head = head.next;
        LinkedListNode curr = head;
        //traverse the linked list checking the val
        while (curr != null && curr.next != null)
            if (curr.next.data > val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }
	
    public void displayList(){
    	LinkedListNode current = head;
		while(current.next!=null){
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}
    
	public static void main(String[] args) {
		LinkedList L = new LinkedList();
    	L.add(1);
    	
    	L.add(2);
    	
    	L.add(3);
    	
    	L.deleteTail();
    	
    	L.removeElements(2);
    	
    	L.displayList();
    
		

	}

}
