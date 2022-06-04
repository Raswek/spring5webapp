package guru.springframework.spring5webapp.bootStraps;

import guru.springframework.spring5webapp.Entities.*;
import guru.springframework.spring5webapp.Repos.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final AutorRepo autorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AutorRepo autorRepo, BookRepo bookRepo, PublisherRepo publisherRepo)
    {
        this.autorRepo = autorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Author author = new Author("Max","Musterman");
        Book book = new Book("Clean Code","951753");
        Book book2 = new Book("Clean Arch","654852");

        author.addBook(book);
        author.addBook(book2);

        autorRepo.save(author);
        bookRepo.save(book);
        bookRepo.save(book2);

        Publisher publisher = new Publisher("MusterPublisher");
        publisher.addBook(book);
        publisher.addBook(book2);

        publisherRepo.save(publisher);

        autorRepo.findAll().forEach(autor1 -> System.out.println(autor1.toString()));

    }
}
