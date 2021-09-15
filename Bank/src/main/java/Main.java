import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Bank bank = new Bank();

        File file = new File("User.dat");
        file.createNewFile();
        bank.start();
    }
}
