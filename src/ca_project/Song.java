/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca_project;

/**
 * @author Daniel García
 * 12/03/2024
 */
public class Song {
    private String name, artist, album, releaseYear;

    public Song(String name, String artist, String album, String releaseYear) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Song: " + "Name: " + name;
        if(!artist.isBlank()) output += " | Artist: " + artist;
        if(!album.isBlank())output += " | Album: " + album;
        if(!releaseYear.isBlank())output += " | Release Year: " + releaseYear;
        output += "\n";
        return output;
    }

}
