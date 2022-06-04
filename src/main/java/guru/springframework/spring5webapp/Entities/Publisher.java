package guru.springframework.spring5webapp.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Publisher
{
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher()
    {
    }

    public Publisher(String name)
    {
        this.name = name;
    }

    public void addBook(Book book)
    {
        this.books.add(book);
        book.setPublisher(this);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }

    @Override
    public String toString()
    {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}
