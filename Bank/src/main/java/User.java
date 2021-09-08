import java.util.Arrays;
import java.util.Date;

public class User {
    String name;
    String surName;
    Date birthday;
    boolean gender;
    String email;
    DebitCard[] cart;
    Loan[] credit;

    public User(String name, String surName, Date birthday, boolean gender, String email, DebitCard[] cart, Loan[] credit) {
        this.name = name;
        this.surName = surName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
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

    public DebitCard[] getCart() {
        return cart;
    }

    public void setCart(DebitCard[] cart) {
        this.cart = cart;
    }

    public Loan[] getCredit() {
        return credit;
    }

    public void setCredit(Loan[] credit) {
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
                ", cart=" + Arrays.toString(cart) +
                ", credit=" + Arrays.toString(credit) +
                '}';
    }
}




