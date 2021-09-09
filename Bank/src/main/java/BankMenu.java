import java.util.Scanner;

public class BankMenu {

    public static void showStartMenu (){
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("""
               Select one:
               1. Login
               2. Register
               0. Exit""");
            while (true) {
                command = scanner.next();
                switch (command) {
                    case "1" -> showLogin();
                    case "2" -> showRegister();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Repeat one more time");
                }
            }

    }
    private static void showLogin () {
        System.out.println("showLogin");

    }
    private static void showRegister () {
        System.out.println("showRegister");

    }

}
