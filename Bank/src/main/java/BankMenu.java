import javax.swing.text.html.parser.Parser;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankMenu  {
    private final Bank bank;
    private boolean look;

    public BankMenu(Bank bank) {
        this.bank =  bank;
    }


    public void showStartMenu () {

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!look) {
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


        if (bank.doLogin(login, password)) {
            look = true;
            showBankMenu();
        } else {
            System.out.println("If there is no user with such an email or password");
        }

    }
    private void showRegister () {
        Scanner scanner = new Scanner(System.in);
        String line;
        String name;
        String surName;
        Date birthday = new Date();
        boolean gender = true;
        String email;
        String password;
        System.out.println("Enter Name:");
        name = scanner.next();

        System.out.println("Enter Surname:");
        surName = scanner.next();

        System.out.println("Enter Birthday:");
        System.out.println("Input format dd.MM.yyyy");
        line = scanner.next();

        try {
            birthday = new SimpleDateFormat("dd.MM.yyyy").parse(line);
        } catch (Exception e) {
            System.out.println("Invalid date format");
            System.exit(0);
        }


        System.out.println("Enter gender:");
        System.out.println("""
                1. Male
                2. Female""");
        line = scanner.next().toLowerCase(Locale.ROOT);

        if (line.equals("male") || line.equals("1")) {
            gender = true;
        }
        if (line.equals("female") || line.equals("2")) {
            gender = false;
        }
        System.out.println("Enter email:");
        email = scanner.next();

        System.out.println("Enter password:");
        password = scanner.next();

        User user = new User(name,surName,birthday,gender,email,password,new ArrayList<DebitCard>(),new ArrayList<Loan>());
        bank.doRegister(user);



    }

    private void createACreditCard () {
        SecureRandom random = new SecureRandom();
        double currentBalance = 0.0;


        String cardNumber = random.ints(48, 90)
                .filter(i -> (i < 57 || i > 65))
                .mapToObj(i -> (char) i)
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        Date expirationDate = new Date();

        int CVV = random.nextInt(999 - 100 + 1)+ 100;

        DebitCard debitCard = new DebitCard(currentBalance,cardNumber,expirationDate,CVV);

        bank.addCart(debitCard);

        System.out.println("Cart created");
    }


    private void createLoan () {
        Scanner scanner = new Scanner(System.in);
        Date dateOfRegistration;
        double amount;
        double interestRate;
        int creditTerm;
        double monthlyPayment;

        dateOfRegistration = new Date();
        System.out.println("Enter the loan amount:");
        amount = scanner.nextDouble();
        System.out.println("At what percentage do you want to take out a loan?");
        interestRate = scanner.nextDouble();
        System.out.println("""
                For how long would a hotide take credit?
                (Indicated in months)""");
        creditTerm = scanner.nextInt();
        System.out.println("How much will you pay per month?");
        monthlyPayment = scanner.nextDouble();
        Loan loan = new Loan(dateOfRegistration,amount,interestRate,creditTerm,monthlyPayment);
        bank.addLoan(loan);
        System.out.println("Loan created");
    }

    private void showBankMenu() {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("""
                    1. My account
                    2. My balance
                    3. My loan data
                    4. Create a credit card
                    5. Create loan
                    0. Exit
                    """);
            command = scanner.next();
            switch (command) {
                case "1" -> bank.myAccount();
                case "2" -> bank.balance();
                case "3" -> bank.myLoanData();
                case "4" -> createACreditCard();
                case "5" -> createLoan();
                case "0" -> System.exit(1);
                default -> System.out.println("Repeat one more time");
            }

        }

    }

}
