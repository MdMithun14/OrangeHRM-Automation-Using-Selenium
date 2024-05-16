package config;

public class userModal {
    private  String firstname;
    private String lastname;
    private String username;
    private String password;
    private String empid;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public userModal(String firstname,String lastname,String username,String password,String empid){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username=username;
        this.password=password;
        this.empid = empid;

    }
    public userModal(){
    }
}
