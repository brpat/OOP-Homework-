//Brijesh Patel 3670789
package assignment8;


import javafx.scene.control.TextField;

// generic linked list class
public class LinkedList <T extends Number & Comparable<? super T>>{
    
    protected Node<T> head;
    
    public LinkedList()
    {
        head = null;
    }
    
    public Node insertData(T value)
    {
       Node<T> newNode = new Node(value);
       
       return insertSorted(newNode, value);
    }
    // will insert value in the correct position (accending order)
    public Node insertSorted(Node newNode, T value)
    {
        Node <T>prev = null;
        Node <T>curr = head;
             
        while((curr != null) &&  (curr.data).compareTo(value) < 0)
        {      
            prev = curr;
            curr = curr.next;
        }
        // linked list does not exist
        if(prev == null && curr == null)
            head = newNode;
        // head insert
        else if(prev == null && (curr != null))
        {
            newNode.next = curr;
            head = newNode;
        }
        // tail insert
        else if(prev != null && curr == null)
            prev.next = newNode;
        // insert in between nodes
        else 
        {
            prev.next = newNode;
            newNode.next = curr;    
        }
         
        return newNode;               
    }
    
     public void clearList(LinkedList list, StringBuilder sb, TextField textField)
    {
        // resets values in linked list and prints list out 
           list.head = null;
           list.printList(sb, textField, list);
    }
    
    // Prints out Linked List in sorted order 
    public void printList(StringBuilder sb, TextField textField, LinkedList list)
    {
        Node tmp = list.head;
        // deletes everything except mHead
        sb.delete(5, sb.length());
        
        while(tmp != null)
        {
            sb.append("->");
            sb.append(Integer.toString((int)(Object)tmp.data));
            tmp = tmp.next;
        }
        // update text field
        textField.setText(sb.toString());  
    }

    
    
    
}
