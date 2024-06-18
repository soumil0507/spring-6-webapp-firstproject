package bose.soumil.spring6webapp.services;

import bose.soumil.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll(); 

}
