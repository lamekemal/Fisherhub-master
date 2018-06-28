package daraunited.com.fisherinnovapps.models;


public class User {

    private String name;
    private String adress;
    private String mnum;
    private String age;
    private String alias;
    private String city;
    private String email;
    private String unique_id;
    private String password;
    private String old_password;
    private String new_password;


    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getMnum() {
        return mnum;
    }

    public String getAge() {
        return age;
    }

    public String getAlias() {
        return alias;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getUnique_id() {
        return unique_id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

}
