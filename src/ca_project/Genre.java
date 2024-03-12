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
               output += genreStack.get(i).toString();
           }
       }
       return output;
    }
    
}
