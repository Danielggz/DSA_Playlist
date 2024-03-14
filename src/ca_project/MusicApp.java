/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_project;

/**
 *
 * @author Daniel García
 */
public class MusicApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Testing of functionalities
        Playlist playlist = new Playlist();
        Genre genre1 = new Genre("Rock");
        Genre genre2 = new Genre("Pop");
        
        //Create songs
        Song song1 = new Song("Walk this Way", "Aerosmith", "Toys In The Attic", "1975");
        Song song2 = new Song("Child in Time", "Deep Purple", "Deep Purple in Rock", "1970");
        Song song3 = new Song("Fortress", "Queens of the Stone Age", "Villains", "2017");
        Song song4 = new Song("Like a Virgin", "Madonna", "", "1982");
        Song song5 = new Song("Toxic", "Britney Spears", "", "1997");
        //Add songs to main playlist
        playlist.add(playlist.size()+1, song1);
        playlist.add(playlist.size()+1, song2);
        playlist.add(playlist.size()+1, song3);
        playlist.add(playlist.size()+1, song4);
        playlist.add(playlist.size()+1, song5);
        //Display list of songs
        System.out.println("<----------AFTER ADDING ELEMENTS---------->");
        System.out.println(playlist.printList());
        //Search song by name (returns object)
        Song foundSong = (Song) playlist.searchByName("Toxic");
        System.out.println("<----------SEARCH FOR SONG---------->");
        System.out.println("Song found: " + foundSong.toString());
        //Delete songs
        playlist.remove(1);
        playlist.remove(3);
        //Display again
        System.out.println("<----------AFTER REMOVING ELEMENTS 1 AND 3---------->");
        System.out.println(playlist.printList());
        //Move song 3 to position 1 
        playlist.moveElement(1, 3);
        System.out.println("<----------AFTER CHANGING POSITIONS---------->");
        System.out.println(playlist.printList());
        
        //Add songs to each genre
        genre1.push(song1);
        genre1.push(song2);
        genre1.push(song3);
        genre2.push(song4);
        genre2.push(song5);
        //Show genre lists
        System.out.println("<----------ROCK SONGS---------->");
        System.out.println(genre1.displayStack());
        System.out.println("<----------POP SONGS---------->");
        System.out.println(genre2.displayStack());
        
        MusicGUI gui = new MusicGUI();
        gui.setVisible(true);
    }
    
}
