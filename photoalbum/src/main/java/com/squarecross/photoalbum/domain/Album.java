package com.squarecross.photoalbum.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "album", schema = "photo_album", uniqueConstraints = {@UniqueConstraint(columnNames = "album_id")})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", unique = true, nullable = false)
    private long albumId;

    @Column(name = "album_name", unique = false, nullable = false)
    private String albumName;

    @Column(name = "created_at", unique = false, nullable = false)
    @CreationTimestamp
    private Date createdAt;

    public Album(){};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)
    private List<Photo> photos;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
