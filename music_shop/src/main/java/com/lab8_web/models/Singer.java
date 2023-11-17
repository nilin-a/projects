package com.lab8_web.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SINGER")
@SequenceGenerator(name = "SEQ_SINGER_ID", sequenceName = "SEQ_SINGER_ID", allocationSize = 1)
public class Singer {
    @Id
    @GeneratedValue(generator = "SEQ_SINGER_ID")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable=false)
    private String name;
    @OneToMany(mappedBy = "singer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Album> albums;

    public Singer() {}

    public Singer(long id) {
        this.id = id;
    }

    public Singer(long id, String name, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public Singer(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
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


    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}

