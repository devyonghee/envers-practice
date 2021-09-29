package me.devyonghee.enverspractice.ui.dto;

public class BookCreateRequest {

    private String title;
    private int price;
    private String content;
    private long categoryId;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public long getCategoryId() {
        return categoryId;
    }
}
