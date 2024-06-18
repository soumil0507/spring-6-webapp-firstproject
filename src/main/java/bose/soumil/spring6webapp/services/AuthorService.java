package bose.soumil.spring6webapp.services;

import bose.soumil.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
