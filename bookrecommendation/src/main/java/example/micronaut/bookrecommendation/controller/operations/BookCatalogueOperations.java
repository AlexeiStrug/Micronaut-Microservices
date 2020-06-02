package example.micronaut.bookrecommendation.controller.operations;

import example.micronaut.bookrecommendation.model.Book;
import io.reactivex.Flowable;

public interface BookCatalogueOperations {

    Flowable<Book> findAll();
}
