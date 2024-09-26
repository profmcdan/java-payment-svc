package org.kolomoni.paymentservice.service.impl;

import org.kolomoni.paymentservice.models.Book;
import org.kolomoni.paymentservice.repository.BookRepository;
import org.kolomoni.paymentservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBook(Book book, Long bookId) {
        bookRepository.findById(bookId).ifPresent(bookToUpdate -> bookToUpdate.setAuthor(book.getAuthor()));
        bookRepository.findById(bookId).ifPresent(bookToUpdate -> {
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setPublisher(book.getPublisher());
            bookRepository.save(bookToUpdate);
        });
        return bookRepository.save(book);
    }
}
