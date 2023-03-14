package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "122313");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book j2ee = new Book("J2EE Development", "52342");
        rod.getBooks().add(j2ee);
        j2ee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(j2ee);

        System.out.println("Started in Bootstrap");
        System.out.println("Num of books: " + bookRepository.count());

        Publisher libris = new Publisher("Craiova", "Dolj", "223432");
        libris.getBooks().add(ddd);
        libris.getBooks().add(j2ee);
        ddd.setPublisher(libris);
        ddd.setPublisher(libris);
        publisherRepository.save(libris);
        System.out.println("Num of publishers: " + publisherRepository.count());
    }
}
