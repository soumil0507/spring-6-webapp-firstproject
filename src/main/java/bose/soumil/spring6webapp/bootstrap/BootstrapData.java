package bose.soumil.spring6webapp.bootstrap;

import bose.soumil.spring6webapp.domain.Author;
import bose.soumil.spring6webapp.domain.Book;
import bose.soumil.spring6webapp.domain.Publisher;
import bose.soumil.spring6webapp.repositories.AuthorRepository;
import bose.soumil.spring6webapp.repositories.BookRepository;
import bose.soumil.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Create an author
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

//        Create a book

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

//        saving the author
        Author ericSaved = authorRepository.save(eric);

//        saving the book
        Book dddSaved = bookRepository.save(ddd);

//        Adding one more author and book

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

//      adding books to the author
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

//        adding authors to books
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        //        add a new publisher

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);


//        resave the authors
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("In Bootstrap");
        System.out.println("Author Count : "+ authorRepository.count());
        System.out.println("Book Count : "+bookRepository.count());


        System.out.println("Publisher Count : "+publisherRepository.count());
    }

}
