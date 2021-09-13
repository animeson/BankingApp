import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankMenu {
    private Bank bank;

    public BankMenu(Bank bank) {

        this.bank =  bank;
    }


    public void showStartMenu () throws ParseException {

        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
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
    }
    private void showLogin () {
        String login;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login:");
        login = scanner.next();
        System.out.println("Enter password:");
        password = scanner.next();
        boolean look = bank.doLogin(login, password);
        if (look) {
        showBankMenu();
        }


    }
    private void showRegister () throws ParseException  {
        Scanner scanner = new Scanner(System.in);

        String name;
        String surName;
        Date birthday;
        boolean gender = true;
        String email;
        String password;

        String line;
        System.out.println("Enter Name:");
        name = scanner.next();
        System.out.println("Enter Surname:");
        surName = scanner.next();
        System.out.println("Enter Birthday:");
        System.out.println("Input format dd.MM.yyyy");
        line = scanner.next();
        birthday = new SimpleDateFormat("dd.MM.yyyy").parse(line);
        System.out.println("Enter gender:");
        System.out.println("""
                1. Male
                2. Female""");
        line = scanner.next();
        if (line.equals("male") || line.equals("1")) {
            gender = true;
        } else if (line.equals("female") || line.equals("2")){
            gender = false;
        }
        System.out.println("Enter email:");
        email = scanner.next();

        System.out.println("Enter password:");
        password = scanner.next();

        bank.doRegister(new User(name,surName,birthday,gender,email,password,null,null));



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
