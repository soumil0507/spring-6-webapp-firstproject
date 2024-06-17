package bose.soumil.spring6webapp.repositories;


import bose.soumil.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

//this interface will extend Spring data package
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
