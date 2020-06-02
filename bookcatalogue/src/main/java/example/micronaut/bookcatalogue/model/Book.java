package example.micronaut.bookcatalogue.model;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Introspected
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;
    @NotNull
    @Column(name = "name", nullable = false, unique = false)
    private String name;

    public Book() {
    }

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name);
    }
}
