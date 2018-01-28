package beans;

public class Genre {

    private int id_g;
    private String name_g;

    public Genre(int id_g, String name_g) {
        this.id_g = id_g;
        this.name_g = name_g;
    }

    public Genre() {
    }

    public int getId_g() {
        return id_g;
    }

    public void setId_g(int id_g) {
        this.id_g = id_g;
    }

    public String getName_g() {
        return name_g;
    }

    public void setName_g(String name_g) {
        this.name_g = name_g;
    }
}
