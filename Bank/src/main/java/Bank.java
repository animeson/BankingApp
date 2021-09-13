import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Bank {
    String fileName = "User.dat";
    BankMenu menu = new BankMenu(this);
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    protected void start () throws ParseException {
        users = new ArrayList<>(users = deserializeUsers());
        menu.showStartMenu();
    }
    protected boolean doLogin (String email, String password) {
   /*     if () {
            if () {
                return true;
            }
        } */
        return false;
    }

    protected boolean doRegister (User user) {
        users.add(user);
        System.out.println(users);
        serializeUsers(users);
        return true;
    }


   protected void serializeUsers (ArrayList <User> users) {
       try {
           FileOutputStream fileOutputStream = new FileOutputStream(getFileName());
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
           objectOutputStream.writeObject(users);
           fileOutputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }

   }


    protected ArrayList<User> deserializeUsers() {
        try {
            FileInputStream fileOutputStream = new FileInputStream("User.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
            users = (ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;

    }

    public String getFileName() {
        return fileName;
    }

}
