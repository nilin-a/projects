package com.lab8_web.models;


import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "SONG")
@SequenceGenerator(name = "SEQ_SONG_ID", sequenceName = "SEQ_SONG_ID", allocationSize = 1)
public class Song {
    @Id
    @GeneratedValue(generator = "SEQ_SONG_ID")
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME", nullable=false)
    private String name;
    @Column(name = "DURATION", nullable=false)
    private Time duration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM")
    private Album album;

    public Song() {}

    public Song(long id, String name, Time duration, Album album) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.album = album;
    }

    public Song(String name, Time duration, Album album) {
        this.name = name;
        this.duration = duration;
        this.album = album;
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

    public Time getDuration() {
        return duration;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
}
