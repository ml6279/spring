package springbatis.entity;

public class NewsUser {
    private int id;
    private String name;
    private String password;

    public NewsUser() {
    }

    public NewsUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public NewsUser(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewsUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passeord='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasseord() {
        return password;
    }

    public void setPasseord(String passeord) {
        this.password = password;
    }
}
