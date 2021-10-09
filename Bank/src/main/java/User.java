import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String surName;
    private Date birthday;
    private boolean gender;
    private String email;
    private String password;
    private List<DebitCard> cart;
    private List<Loan> credit;

    public User(String name, String surName, Date birthday, boolean gender, String email, String password, List<DebitCard> cart, List<Loan> credit) {
        this.name = name;
        this.surName = surName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.credit = credit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<DebitCard> getCart() {
        return cart;
    }

    public void setCart(List<DebitCard> cart) {
        this.cart = cart;
    }

    public List<Loan> getCredit() {
        return credit;
    }

    public void setCredit(List<Loan> credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                ", credit=" + credit +
                '}';
    }
}




