/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca_project;

import java.util.ArrayList;

/**
 * @author Daniel García
 * 12/03/2024
 */
public class Genre implements StackInterface{

    ArrayList<Object> genreStack;
    private String name;
    
    public Genre(String name) {
        this.name = name;
        genreStack = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public void push(Object newElement) {
        genreStack.add(0, newElement); 
    }

    @Override
    public Object pop() {
        if (!(genreStack.isEmpty())){
            return genreStack.remove(0);
        }else{
            return null;
        }
    }

    @Override
    public Object peek() {
        if (genreStack.isEmpty()) {
            System.out.println("Empty stack");
            return null;
        } else {    
            return genreStack.get(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return genreStack.isEmpty();
    }

    @Override
    public int size() {
        return genreStack.size();
    }

    @Override
    public String displayStack() {
        String output = new String(); 
       //String str = ""; will also work and is more familiar
       if(genreStack.isEmpty()){
           output += name + " list is empty!";
       }else{
           for (int i = 0; i<genreStack.size(); i++){
               output += (i+1) + ". " + genreStack.get(i).toString();
           }
           output += "\nNumber of" + name +  " songs: " + size();
       }
       return output;
    }
    
    public Song search(String name){
        //Iterates element to find by Name
        for (int i  = 1; i < genreStack.size(); i++){
            //Get element from node and cast it to Song type
            Song currSong = (Song) genreStack.get(i);
            if(name.equalsIgnoreCase(currSong.getName())){
                //If the searched name is equal to the song in the current node return
                return currSong;
            }
        }
        return null;
    }
    
    public void move(int index, int newIndex){
        //The positions indicated by user are not 0 based
        index--;
        newIndex--;
        if(index >= 0 && index <= size() && newIndex >= 0 && newIndex <= size()){
            Object obj1 = genreStack.get(index);
            Object obj2 = genreStack.get(newIndex);
            //Store object1 in temporary object
            Object tempO = obj1;
            //Remove the stack element in index and add the second object
            genreStack.remove(index);
            genreStack.add(index, obj2);
            //Remove the stack element in second index and add the temp (original is gone)
            genreStack.remove(newIndex);
            genreStack.add(newIndex, tempO);
        }else{
            System.out.println("One of the positions given is out of the bounds of array");
        }
    }
    
}
