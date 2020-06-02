package example.micronaut.bookcatalogue.service;

import example.micronaut.bookcatalogue.model.Book;
import example.micronaut.bookcatalogue.repository.BookRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
public class BookService {

    @Inject
    BookRepository bookRepository;

    @Transactional
    public void saveBook() {
        Book buildingMicroservices = new Book();
        buildingMicroservices.setIsbn("1491950358");
        buildingMicroservices.setName("Building Microservices");
        bookRepository.save(buildingMicroservices);
    }

    @Transactional
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
}
