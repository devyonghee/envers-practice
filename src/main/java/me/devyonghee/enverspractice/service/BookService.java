package me.devyonghee.enverspractice.service;

import java.util.NoSuchElementException;
import me.devyonghee.enverspractice.domain.Book;
import me.devyonghee.enverspractice.infra.BookRepository;
import me.devyonghee.enverspractice.ui.dto.BookCreateRequest;
import me.devyonghee.enverspractice.ui.dto.BookResponse;
import me.devyonghee.enverspractice.ui.dto.BookUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BookResponse create(BookCreateRequest request) {
        return BookResponse.from(repository.save(book(request)));
    }

    @Transactional
    public void update(long id, BookUpdateRequest request) {
        Book book = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        book.changeContent(request.getContent());
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

    private Book book(BookCreateRequest request) {
        return new Book(request.getTitle(), request.getPrice(), request.getContent());
    }
}
