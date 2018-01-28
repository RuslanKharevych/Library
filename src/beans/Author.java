package beans;

public class Author {

    public Author() {
    }

    private String name_a;

    public Author(String name) {
        this.name_a = name;
    }

    public String getName() {
        return name_a;
    }

    public void setName(String name) {
        this.name_a = name;
    }

}
