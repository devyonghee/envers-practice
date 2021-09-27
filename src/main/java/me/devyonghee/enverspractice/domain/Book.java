package me.devyonghee.enverspractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private int price;

    @Column
    private String content;

    @ManyToOne
    private Category category;

    protected Book() {
    }

    public Book(String title, int price, String content, Category category) {
        this.title = title;
        this.price = price;
        this.content = content;
        this.category = category;
    }

}
