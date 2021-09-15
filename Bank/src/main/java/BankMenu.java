import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankMenu  {
    private Bank bank;
    String name = "";
    String surName = "";
    Date birthday = new Date();
    boolean gender = true;
    String email = "";
    String password = "";

    User user = new User(name,surName,birthday,gender,email,password,null,null);


    public BankMenu(Bank bank) {
        this.bank =  bank;
    }


    public void showStartMenu () throws ParseException {

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("""
               Select one:
               1. Login
               2. Register
               0. Exit""");
                command = scanner.next();
                switch (command) {
                    case "1" -> showLogin();
                    case "2" -> showRegister();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Repeat one more time");
                }

    }
    private void showLogin () {
        String login;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login:");
        login = scanner.next();
        System.out.println("Enter password:");
        password = scanner.next();

        if (bank.doLogin(login, password)) {
            showBankMenu();
        } else {
            System.out.println("If there is no user with such an email or password");
        }

    }
    private void showRegister () throws ParseException  {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("Enter Name:");
        user.setName(scanner.next());

        System.out.println("Enter Surname:");
        user.setSurName(scanner.next());

        System.out.println("Enter Birthday:");
        System.out.println("Input format dd.MM.yyyy");
        line = scanner.next();
        user.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse(line));

        System.out.println("Enter gender:");
        System.out.println("""
                1. Male
                2. Female""");
        line = scanner.next();
        if (line.equals("female") || line.equals("2")) {
            user.setGender(gender);
        }
        System.out.println("Enter email:");
        user.setEmail(scanner.next());

        System.out.println("Enter password:");
        user.setPassword(scanner.next());

        bank.doRegister(new User(user.getName(), user.getSurName(),user.getBirthday(), user.isGender(), user.getEmail(),user.getPassword(),null,null));



    }
    public static void showBankMenu() {
            System.out.println("""
                1. Show my profile info
                2. Order new service
                3. Show my services info
                0. Exit
                """);


    }

}
