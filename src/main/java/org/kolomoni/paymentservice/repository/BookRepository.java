package org.kolomoni.paymentservice.repository;

import org.kolomoni.paymentservice.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
