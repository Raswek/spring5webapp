package guru.springframework.spring5webapp.Entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String vorname;

    @ManyToMany(mappedBy = "autors", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Author(String name, String vorname, Set<Book> books)
    {
        this.name = name;
        this.vorname = vorname;
        this.books = books;
    }

    public Author()
    {
    }

    public void addBook(Book book)
    {
        this.books.add(book);
        book.getAutors().add(this);
    }

    public Author(String name, String vorname)
    {
        this.name = name;
        this.vorname = vorname;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode()
    {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", books=" + books +
                '}';
    }
}
