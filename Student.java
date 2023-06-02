//Child Class - Student
import java.text.*;
import java.util.*;
public class Student extends User {
    DecimalFormat df = new DecimalFormat("#.00"); 
    int studentID;
    double balance;
    boolean orderedLunch;
    String mealPlan;

    ArrayList<String> menuItemName = new ArrayList<String>();
    ArrayList<Double> menuItemPrice = new ArrayList<Double>();


    public Student(String name, String password, String email, String phoneNumber, int studentID, String classID) {
        super(name, password, email, phoneNumber, classID);
        this.studentID = studentID;
        balance = 0.00;
        orderedLunch = false;
    }
    //getters
    public String getName() {
        return super.getName();
    }
    public String getEmail() {
        return super.getEmail();
    }
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }
    public String getClassID() {
        return super.getClassID();
    }
    public double getBalance() {
        return balance;
    }
    public int getStudentID() {
        return studentID;
    }
    public String toString() {
        return super.toString() + "\n***********************************\n Student Information\n***********************************\nStudentID: " + getStudentID() + "\nBalance: " + getBalance() + "\n***********************************";
    }

    public String getMenu() {
        String returnString = "***********************************\n Cart Information\n***********************************\n";
        if(menuItemName.size() == 0) { 
            return "No Items in Cart. Add some to see some here! Total: $0.00";
        } else {
            for(int i = 0; i < menuItemName.size(); i++) {
                returnString = returnString + i + ": " + menuItemName.get(i) + " - " + menuItemPrice.get(i) + "\n";
            }
        }
        returnString = returnString + "\n***********************************" + "\nTotal Price: " + String.format("%.2f",getTotalCost()) + "\n***********************************" ; 
        return returnString;
    }

    public double getTotalCost() {
        double totalCost = 0.00;
        for(int i = 0; i<menuItemPrice.size(); i++) {
            totalCost += menuItemPrice.get(i);
        }
        return totalCost;
    }

    //setters
    public void setName(String name) {
        super.setName(name);
    }
    public void setPassword(String oldPass, String newPass) {
        super.setPassword(oldPass, newPass);
    }
    public void setPhoneNumber(String newPhone) {
        super.setPhoneNumber(newPhone);
    }
    public void setCreditCard(CreditCard newCard) {
        super.setCreditCard(newCard);
    }
    public void setClassID(String classID) {
        super.setClassID(classID);
    }

    public void addToMenu(String name, double price) {
        menuItemName.add(name);
        menuItemPrice.add(price);
    }

    public void removeFromOrder(int index) {
        menuItemName.remove(index);
        menuItemPrice.remove(index);
    }


    //Core methods
    public void addFunds(CreditCard creditCard, double amnt) {
        if (creditCard.getBalance() >= amnt) {
            balance += amnt;
            creditCard.removeBalance(amnt);
        } else {
            System.out.println("Insufficient Funds");
        }
    }

    public Boolean removeBalance(double amnt) {
        if (balance >= amnt) {
            balance -= amnt;
            return true;
        }
        return false;
        
    }
}
