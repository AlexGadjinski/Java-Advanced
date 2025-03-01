package google;

public class Parent {
    private String name;
    private String birthday;

    Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }
}
