import java.io.*;
import java.util.ArrayList;

public class Bank {
   public final static String fileName = "User.dat";
    File file = new File(fileName);
    private User thisUser;
    BankMenu menu = new BankMenu(this);

    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    protected void start () {
        users = new ArrayList<>();
        if (file.length() != 0) {
            users = deserializeUsers();
            System.out.println(users);
        }
            menu.showStartMenu();

    }
    protected boolean doLogin (String email, String password) {

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                thisUser = user;
                return true;
            }
        }
        return false;
    }

    protected void doRegister (User user) {
        users.add(user);
        serializeUsers(users);
    }


   protected void serializeUsers (ArrayList <User> users) {
       try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(getFileName()))){
           objectOutputStream.writeObject(users);
       } catch (IOException e) {
            System.out.println("Error" + " " + e);
       }

   }

@SuppressWarnings("unchecked")
    private ArrayList<User> deserializeUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFileName()))) {
            users = (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;

    }

    private String getFileName() {
        return fileName;
    }
    protected void myAccount () {
        System.out.println(thisUser);
    }

    protected void balance () {
        for (int i = 0; i < users.size(); i++) {
            System.out.println (thisUser.getCart().get(i).getCurrentBalance());
        }

    }
    protected void myLoanData () {
        System.out.println(thisUser.getCredit());
    }



}
