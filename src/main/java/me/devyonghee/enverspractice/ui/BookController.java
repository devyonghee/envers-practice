package me.devyonghee.enverspractice.ui;

import me.devyonghee.enverspractice.service.BookService;
import me.devyonghee.enverspractice.ui.dto.BookCreateRequest;
import me.devyonghee.enverspractice.ui.dto.BookResponse;
import me.devyonghee.enverspractice.ui.dto.BookUpdateRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public BookResponse create(@RequestBody BookCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, BookUpdateRequest bookUpdateRequest) {
        service.update(id, bookUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
