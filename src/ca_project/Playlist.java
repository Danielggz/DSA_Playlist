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
    public Object remove(int index) {
        //Gets node to be deleted
        Node nodeDel = null;
        if(index<=size && index>0){
            //Search if index is not bigger than size (OutOfBounds)
            nodeDel = (Node) get(index);
        }
        if(head != null && nodeDel != null){
            if(head == nodeDel){
                //If the node to delete is the head
                head = nodeDel.getNext();
            }
            if (last == nodeDel) { 
                //If the node is not the end nodeW
                last = nodeDel.getPrev();
                last.setNext(null);
            } 
            if(nodeDel.getPrev() != null && nodeDel.getNext() != null){
                //set the next node reference to the previous of nodeDel
                nodeDel.getNext().setPrev(nodeDel.getPrev());
                //set the prev node reference to the next of nodeDel
                nodeDel.getPrev().setNext(nodeDel.getNext());
                //Now the references are updated so the deletion node is not referenced anymore
            }
            size--;
            return nodeDel.getElement();
        }
        return null;
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
        int counter = 1;
        for (Node aNode = head; aNode != null; aNode = aNode.getNext()) {
            output += counter + ". " + aNode.getElement().toString();
            counter++;
        }
        output += "\n Number of songs in the playlist: " + size;
        return output;
    }
    
    public String printRepeatable(){
        String output = "";
        int counter = 1;
        for (Node aNode = head; aNode != null; aNode = aNode.getNext()) {
            output += counter + ". " + aNode.getElement().toString();
            counter++;
            //Stop the loop when it comes to ten when repeatable
            if(counter > 10) 
                break;
        }
        return output;
    }
    
    public Song searchByName(String name){
        //Iterates element to find by Name
        curr = head;
        for (int i  = 1; i <= size; i++){
            //Get element from node and cast it to Song type
            Song currSong = (Song) curr.getElement();
            if(name.equalsIgnoreCase(currSong.getName())){
                //If the searched name is equal to the song in the current node return
                return currSong;
            }
            curr = curr.getNext();
        }
        return null;
    } 
    
    public void moveElement(int index, int newIndex){
        if(index <= size && newIndex <= size){
            //Store the reference to the object of the index given
            Node oldNodeRef = (Node) get(index); 
            //Create a copy to store the value of the object from the reference (with same next and prev)
            Node oldNodeTemp = new Node(oldNodeRef.getElement(), oldNodeRef.getPrev(), oldNodeRef.getNext());
            //Store the element in the position of the new index
            Node newNode = (Node) get(newIndex); 
            //Set the current to be the element to change
            setCurrent(index);
            curr.setElement(newNode.getElement());
            setCurrent(newIndex);
            //Get the old node from the temp node
            curr.setElement(oldNodeTemp.getElement());
        }else{
            System.out.println("One of the positions given is out of the bounds of array");
        }
    }
    
    public Playlist getRepeatableList(){
        Playlist repeatPl = new Playlist();
        //Add some songs to demonstrate functionality
        repeatPl.add(repeatPl.size() + 1, new Song("Walk this Way", "Aerosmith", "Toys In The Attic", "1975"));
        repeatPl.add(repeatPl.size() + 1, new Song("Child in Time", "Deep Purple", "Deep Purple in Rock", "1970"));
        repeatPl.add(repeatPl.size() + 1, new Song("Fortress", "Queens of the Stone Age", "Villains", "2017"));
        //Connect head with last node
        repeatPl.head.setPrev(last);
        repeatPl.last.setNext(head);

        return repeatPl;
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
