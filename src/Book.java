import java.util.Objects;

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
        this.autor.setName(a.getName());
        this.autor.setSurname(a.getSurname());
    }


    public String toString () {
    return this.autor.toString() + " " + this.Title + " " + this.year;
    }

    public boolean equals (Book New) {
    // boolean a = this.year == New.year;
    // boolean b = this.Title == New.Title;
    // boolean c = this.autor == New.autor;

    if (this.getClass() != New.getClass()) {

        return  false;}


        else if (this.year==New.year&&this.Title==New.Title&&this.autor == New.autor) {

           // New = (Book) this;

            return true;}

        else {return false;}




}
    @Override
    public int hashCode() {
        return Objects.hash(year, Title, autor);
    }
}




