import java.util.Objects;

public class Book {
   private int year;
   private String Title;
 private Author autor;

public Book (int year, String title, Author autor) {
this.year = year;
this.Title = title;
this.autor = autor;
}
public int getYear () {
    return this.year;

}

    public String getTitle () {
        return this.Title;

    }

    public Author getAutor () {
        return this.autor;

    }

    public void setYear (int y) {
    this.year = y;
    }

    public void setTitle (String tit) {
        this.Title = tit;
    }
    public void setAutor (Author a) {
        this.autor.setName(a.getName());
        this.autor.setSurname(a.getSurname());
    }

    @Override
    public String toString () {
    return this.autor.toString() + " " + this.Title + " " + this.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, Title, autor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(Title, book.Title) && Objects.equals(autor, book.autor);
    }
}




