/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca_project;

/**
 * @author Daniel García
 * 12/03/2024
 */
public class Playlist implements DLLInterface{
    
    private Node head;
    private Node last;
    private Node curr;
    private int size; //manually manage the list size

    public Playlist() {
        //Sets name of the playlist from user and creates the necessary nodes
        head = null; 
        last = null; 
        size = 0;
        curr = head;
    }
    
    @Override
    public boolean isEmpty() {
        //Returns boolean depending if the list is empty
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        setCurrent(index);
        return curr;
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, Object theElement) {
        //Inserts new node if the list is empty
        if (size == 0){        
            Node newNode = new Node(theElement, null, null);
            head = newNode;
            last = newNode; 
        } else {
            // Insert a new Node at the head position
            if (index == 1){
                Node newNode = new Node(theElement, null, null);
                //set up the links
                newNode.setNext(head);
                head.setPrev(newNode);
                //add the newNode in the head position
                head = newNode;    
            } else if (index == (size+1)){  
                // Insert a new Node at the last position
                Node newNode = new Node(theElement, null, null);
                newNode.setPrev(last); //set up link to prev
                last.setNext(newNode); //set up link to the new node
                last = newNode; //add the newNode to the last reference  
            }else {
                // Insert a new node in the middle
                setCurrent(index); //use method to move the curr ref to that position
                Node newNode = new Node(theElement, null, null);
                //set up the ref links
                newNode.setNext(curr); 
                Node prev = curr.getPrev(); //set the prev ref
                newNode.setPrev(prev); //link to it
                prev.setNext(newNode);//add our new node
                curr.setPrev(newNode); //add our new node
            }
          }
          size++;
    }

    @Override
    public String printList() {
        String output = "";
        for (Node aNode = head; aNode != null; aNode = aNode.getNext()) {
            output += aNode.getElement();
         }
        return output;
    }
    
    private void setCurrent(int index){
        //Sets the node on the position index to be the current
	curr = head;
        //Iterates the full list from the head
	for (int i  = 1; i < index; i++){ 
		curr = curr.getNext();
        }
    }
    
}
