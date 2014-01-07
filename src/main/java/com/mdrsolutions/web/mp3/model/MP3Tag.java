/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.mp3.model;

import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @author michael
 */
public class MP3Tag {

    public MP3Tag(boolean isMP3){
        this.isMP3 = isMP3;
    }
    public MP3Tag(Tag tag, String trackLength) {
        this.artist = tag.getFirst(FieldKey.ARTIST);
        this.album = tag.getFirst(FieldKey.ALBUM);
        this.genre = tag.getFirst(FieldKey.GENRE);
        this.title = tag.getFirst(FieldKey.TITLE);
        this.comment = tag.getFirst(FieldKey.COMMENT);
        this.year = tag.getFirst(FieldKey.YEAR);
        this.track = tag.getFirst(FieldKey.TRACK);
        this.trackLength = trackLength;
    }
    private String artist;
    private String title;
    private String album;
    private String comment;
    private String genre;
    private String year;
    private String track;
    private String trackLength;
    private boolean isMP3 = true;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isIsMP3() {
        return isMP3;
    }

    public void setIsMP3(boolean isMP3) {
        this.isMP3 = isMP3;
    }

    @Override
    public String toString() {
        return "MP3Tag = {" + "artist=" + artist + ", title=" + title + ", album=" + album + ", comment=" + comment + ", genre=" + genre + ", year=" + year + ", track=" + track + ", trackLength=" + trackLength + ", isMP3=" + isMP3 + '}';
    }
    
    
    
}
