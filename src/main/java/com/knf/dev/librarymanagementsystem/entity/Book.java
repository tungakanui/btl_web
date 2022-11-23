package com.knf.dev.librarymanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "author", length = 100, nullable = false, unique = true)
    private String author;

    @Column(name = "description", length = 250, nullable = false)
    private String description;


    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "publishDate", nullable = false)
    private String publishDate;

    @Column(name = "totalPage", nullable = false)
    private int totalPage;

    private String category;

    public Book(String name, String author, String description, String publishDate, int totalPage, String category) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.publishDate = publishDate;
        this.totalPage = totalPage;
        this.category = category;
    }

    public Book() {
        super();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
