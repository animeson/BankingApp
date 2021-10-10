import java.io.Serializable;
import java.util.Date;
public class Loan  implements Serializable {
    private Date dateOfRegistration;
    private double amount;
    private double interestRate;
    private int creditTerm;
    private double monthlyPayment;

    public Loan(Date dateOfRegistration, double amount, double interestRate, int creditTerm, double monthlyPayment) {
        this.dateOfRegistration = dateOfRegistration;
        this.amount = amount;
        this.interestRate = interestRate;
        this.creditTerm = creditTerm;
        this.monthlyPayment = monthlyPayment;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "dateOfRegistration=" + dateOfRegistration +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", creditTerm=" + creditTerm +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}

