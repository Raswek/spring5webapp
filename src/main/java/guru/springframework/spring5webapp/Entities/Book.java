package guru.springframework.spring5webapp.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titel;
    private String nummer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Author> autors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    public Book(String titel, String nummer, Set<Author> autorSet)
    {
        this.titel = titel;
        this.nummer = nummer;
        this.autors = autorSet;
    }

    public Book(String titel, String nummer)
    {
        this.titel = titel;
        this.nummer = nummer;
    }

    public Book()
    {
    }

    public Publisher getPublisher()
    {
        return publisher;
    }

    public void setPublisher(Publisher publisher)
    {
        this.publisher = publisher;
    }

    public void addAutor(Author autor)
    {
        this.autors.add(autor);
        autor.getBooks().add(this);
    }

    public String getTitel()
    {
        return titel;
    }

    public void setTitel(String titel)
    {
        this.titel = titel;
    }

    public String getNummer()
    {
        return nummer;
    }

    public void setNummer(String nummer)
    {
        this.nummer = nummer;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Set<Author> getAutors()
    {
        return autors;
    }

    public void setAutors(Set<Author> autors)
    {
        this.autors = autors;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (titel != null ? !titel.equals(book.titel) : book.titel != null) return false;
        if (nummer != null ? !nummer.equals(book.nummer) : book.nummer != null) return false;
        return autors != null ? autors.equals(book.autors) : book.autors == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", nummer='" + nummer + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
