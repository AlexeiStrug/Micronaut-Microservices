package example.micronaut.bookrecommendation.controller;

import example.micronaut.bookrecommendation.controller.operations.BookCatalogueOperations;
import example.micronaut.bookrecommendation.controller.operations.BookInventoryOperations;
import example.micronaut.bookrecommendation.model.BookRecommendation;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/books")
public class BookController {

    private final BookCatalogueOperations bookCatalogueOperations;
    private final BookInventoryOperations bookInventoryOperations;

    public BookController(BookCatalogueOperations bookCatalogueOperations,
                          BookInventoryOperations bookInventoryOperations) {
        this.bookCatalogueOperations = bookCatalogueOperations;
        this.bookInventoryOperations = bookInventoryOperations;
    }

    @Get("/")
    public Flowable<BookRecommendation> index() {
        return bookCatalogueOperations.findAll()
                .flatMapMaybe(b -> bookInventoryOperations.stock(b.getIsbn())
                        .filter(Boolean::booleanValue)
                        .map(rsp -> b)
                ).map(book -> new BookRecommendation(book.getName()));
    }
}
