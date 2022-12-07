public class Author {
private String name;
private String sirname;

public Author (String a, String b) {
    this.name = a;
    this.sirname = b;
}

public String getName () {
    return this.name;
}

public String getSirname () {
    return this.sirname;
}

    public void setName(String name) {
        this.name = name;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }
}
