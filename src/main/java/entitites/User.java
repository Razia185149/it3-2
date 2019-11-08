package entitites;

public class User {

    private int cpr;
    private String password;
    private String name;
    private String lastname;
    private String diverse;

    public User(){}

    public User(int cpr, String password, String name, String lastname, String diverse){
        this.cpr=cpr;
        this.name=name;
        this.lastname=lastname;
        this.diverse=diverse;
    }

    public boolean isValid(){
        if(cpr!=0 && password.isEmpty()==false){
            return true;
        }
        return false;
    }

    public int getCpr() {
        return cpr;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getDiverse() {
        return diverse;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDiverse(String diverse) {
        this.diverse = diverse;
    }

    @Override
    public String toString() {
        return "User{" +
                "cpr=" + cpr +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", diverse='" + diverse + '\'' +
                '}';
    }
}
