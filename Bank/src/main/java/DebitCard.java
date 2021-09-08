import java.util.Date;

public class DebitCard {
    double currentBalance;
    String cardNumber;
    Date expirationDate;
    int CVV;

    public DebitCard(double currentBalance, String cardNumber, Date expirationDate, int CVV) {
        this.currentBalance = currentBalance;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "currentBalance=" + currentBalance +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", CVV=" + CVV +
                '}';
    }
}
