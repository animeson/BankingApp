import java.io.*;
import java.util.ArrayList;

public class Bank {
   public final static String fileName = "User.dat";
    File file = new File(fileName);
    private User thisUser;
    BankMenu menu = new BankMenu(this);
    private ArrayList<User> users;

/*    public ArrayList<User> getUsers() {
        return users;
    }*/

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
      if (thisUser.getCart().size() != 0) {
          for (int i = 0; i <= thisUser.getCart().size() - 1; i++) {
                System.out.println (
                "|" + "Cart "+  thisUser.getCart().get(i).getCardNumber() + " = "+
                thisUser.getCart().get(i).getCurrentBalance() + " $ "+"|");
          }
        } else { System.out.println("You have no cards.");
      }


    }
    protected void myLoanData () {
        if (thisUser.getCredit().size() == 0) {
            System.out.println("You have no credits");
        } else {
            System.out.println(thisUser.getCredit());
        }

    }

    protected void addCart (DebitCard debitCard) {
        thisUser.getCart().add(debitCard);
        serializeUsers(users);
    }

    protected void addLoan (Loan loan) {
        thisUser.getCredit().add(loan);
        serializeUsers(users);
    }





}
