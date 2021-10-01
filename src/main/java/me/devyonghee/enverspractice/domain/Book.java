package me.devyonghee.enverspractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.envers.Audited;

@Entity
@Audited
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

    protected Book() {
    }

    public Book(String title, int price, String content) {
        this.title = title;
        this.price = price;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
