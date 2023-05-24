//CreditCard Class
public class CreditCard {
    int cardNumber;
    String expDate;
    int cvvCode;
    String cardName;
    double balance;

    public CreditCard(String name, int number, String expDate, int cvv) {
        cardName = name;
        cardNumber = number;
        this.expDate = expDate;
        cvvCode = cvv;
        balance = 0.00;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public String getName() {
        return cardName;
    } 
    public String getExp() {
        return expDate;
    }
    public int getCVV() {
        return cvvCode;
    }
    public double getBalance() {
        return balance;
    }
    public String toString() {
        return "***********************************\nCredit Card Information\n***********************************\nName:" + getName() + "\nCard Number: " + getCardNumber() + "\nCVV Code: " + getCVV() + "\nExpiry Date: " + getExp() + "\n***********************************";
    }

    public void setCardNumber(int num) {
        cardNumber = num;
    }
    public void setCardName(String newName) {
        cardName = newName;
    }
    public void setExp(String newExp) {
        expDate = newExp;
    }
    public void setCVV(int newCVV) {
        cvvCode = newCVV;
    }
    public void addBalance(double amnt) {
        balance += amnt;
    }
    public void removeBalance(double amnt) {
        balance -= amnt;
    }

}