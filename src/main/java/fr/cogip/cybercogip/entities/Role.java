package fr.cogip.cybercogip.entities;

public class Role {
    private int id;
    private String title;

    public Role() {
    }

    public Role(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
