package com.lab8_web.models;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "ALBUM")
@SequenceGenerator(name = "SEQ_ALBUM_ID", sequenceName = "SEQ_ALBUM_ID", allocationSize = 1)
public class Album {
    @Id
    @GeneratedValue(generator = "SEQ_ALBUM_ID")
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME", nullable=false)
    private String name;
    @Column(name = "GENRE", nullable=false)
    private String genre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SINGER")
    private Singer singer;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Song> songs;

    public Album() { }
    public Album(long id) {
        this.id = id;
    }

    public Album(long id, String name, String genre, Singer singer, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.singer = singer;
        this.songs = songs;
    }

    public Album(String name, String genre, Singer singer, List<Song> songs) {
        this.name = name;
        this.genre = genre;
        this.singer = singer;
        this.songs = songs;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public Singer getSinger() {
        return singer;
    }
    public void setSinger(Singer singer) {
        this.singer = singer;
    }


    public List<Song> getSongs() {
        return songs;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
