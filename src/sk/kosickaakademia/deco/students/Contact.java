package sk.kosickaakademia.deco.students;

public class Contact {
    private String email;
    private String mobil;
    private String skype;

    public Contact(String email, String mobil, String skype) {
        this.email = email;
        this.mobil = mobil;
        this.skype = skype;
    }
    public Contact(){}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobil() {
        return mobil;
    }
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }
    public String getSkype() {
        return skype;
    }
    public void setSkype(String skype) {
        this.skype = skype;
    }
}
