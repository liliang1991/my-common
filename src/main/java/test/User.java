package test;

public class User {
    private String name;
    private String dt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public User(String name, String dt) {
        this.name = name;
        this.dt = dt;
    }
}
