public class Book {
   private int year;
   private String Title;
 private Author autor;

public Book (int y, String tit, Author autor) {
this.year = y;
this.Title = tit;
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
        this.autor = a;
    }
}

