package me.devyonghee.enverspractice.infra;

import me.devyonghee.enverspractice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
