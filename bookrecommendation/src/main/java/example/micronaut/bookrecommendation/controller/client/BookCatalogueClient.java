package example.micronaut.bookrecommendation.controller.client;

import example.micronaut.bookrecommendation.controller.operations.BookCatalogueOperations;
import example.micronaut.bookrecommendation.model.Book;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;


@Client(id = "bookcatalogue")
public interface BookCatalogueClient extends BookCatalogueOperations {

    @Get("/books")
    Flowable<Book> findAll();
}
