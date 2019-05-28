package com.mhoveidafar.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;

@Entity // Default: The entity will be mapped to Book table, unless using Table
		// annotation
@Table(name = "Book") // if write "Books" the table name will be Books not Book

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Title")
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Author_ID") // specifies the name of the column in the Book table to store the ID of the
									// Author
	@JsonIgnore
	private Author author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Book() {
		super();
	}

	public Book(String title) {
		this.title = title;
	}

	@Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author.getName() +
                '}';
    }	
}
