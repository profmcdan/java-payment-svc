package org.kolomoni.paymentservice.service;

import org.kolomoni.paymentservice.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);
    Optional<Book> getBook(Long bookId);
    List<Book> getAllBooks();
    void deleteBook(Long bookId);
    Book updateBook(Book book, Long bookId);
}
