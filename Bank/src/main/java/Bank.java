import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Bank {
    String fileName = "User.dat";
    File file = new File(fileName);
    BankMenu menu = new BankMenu(this);
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    protected void start () throws ParseException {
        users = new ArrayList<>();
        if (file.length() != 0) {
            users = deserializeUsers();
            System.out.println(users);
        }
        menu.showStartMenu();
    }
    protected boolean doLogin (String email, String password) {
        boolean look = false;
        for (int i = 0; i < users.size(); i++) {
            if (getUsers().get(i).email.equals(email)) {
                if (getUsers().get(i).password.equals(password)) {
                    look = true;
                }

            }
        }
        return look;
    }

    protected void doRegister (User user) {
        users.add(user);
        serializeUsers(users);
    }


   protected void serializeUsers (ArrayList <User> users) {
       try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getFileName()))){
           objectOutputStream.writeObject(users);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

@SuppressWarnings("unchecked")
    protected ArrayList<User> deserializeUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFileName()))) {
            users = (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;

    }

    protected String getFileName() {
        return fileName;
    }

}
