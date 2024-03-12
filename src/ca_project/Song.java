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
    private String name, album, releaseYear;

    public Song(String name, String album, String releaseYear) {
        this.name = name;
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
}
