package example.micronaut.bookcatalogue.controller;

import example.micronaut.bookcatalogue.model.Book;
import example.micronaut.bookcatalogue.service.BookService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller("/books")
public class BooksController {

    @Inject
    BookService bookService;


    @Get("/")
    List<Book> index() {
        Book buildingMicroservices = new Book("1491950358", "Building Microservices");
        Book releaseIt = new Book("1680502395", "Release It!");
        Book cidelivery = new Book("0321601912", "Continuous Delivery:");
        return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);
    }

    @Post("/")
    void createBook() {
        bookService.saveBook();
    }

    @Get("/{id}")
    Optional<Book> getBookById(@NotBlank Long id) {
        return bookService.getBookById(id);
    }
}
