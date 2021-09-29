package me.devyonghee.enverspractice.ui.dto;


import me.devyonghee.enverspractice.domain.Book;

public final class BookResponse {

    private final long id;

    private BookResponse(long id) {
        this.id = id;
    }

    public static BookResponse from(Book book) {
        return new BookResponse(book.getId());
    }

    public long getId() {
        return id;
    }
}
