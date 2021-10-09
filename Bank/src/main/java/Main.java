import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws  IOException {
        Bank bank = new Bank();
        File file = new File(Bank.fileName);
        boolean b = file.createNewFile();
        bank.start();
    }
}
