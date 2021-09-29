package me.devyonghee.enverspractice.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import me.devyonghee.enverspractice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void save() {
        Book book = testEntityManager.persistAndFlush(new Book("title", 1000, "content"));
        assertNotNull(book.getId());
    }

    @Test
    void update() {
        Book book = testEntityManager.persistAndFlush(new Book("title", 1000, "content"));

        book.changeContent("updated contents");
        testEntityManager.flush();

        Book updatedBook = testEntityManager.find(Book.class, book.getId());
        assertEquals("updated contents", updatedBook.getContent());
    }

    @Test
    void delete() {
        Book book = testEntityManager.persistAndFlush(new Book("title", 1000, "content"));

        testEntityManager.remove(book);
        testEntityManager.flush();

        assertNull(testEntityManager.find(Book.class, book.getId()));
    }
}