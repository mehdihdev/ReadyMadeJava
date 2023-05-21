//Main Class
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

//CreditCard Class
class CreditCard {
    int cardNumber;
    int expDate;
    int cvvCode;
    String cardName;

    public CreditCard(String name, int number, int expDate, int cvv) {
        cardName = name;
        cardNumber = number;
        this.expDate = expDate;
        cvvCode = cvv;
    }
}

//Parent Class - User
class User {
    String name;
    String password;
    String email;
    String phoneNumber;
    int classID;
    CreditCard creditCard;
    public User(String name, String password, String email, String phoneNumber, int classID) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.classID = classID;
        creditCard = null;
    }
}

//Child Class - Student
class Student extends User {
    int studentID;
    double balance;
    boolean orderedLunch;
    String mealPlan;
    public Student(String name, String password, String email, String phoneNumber, int studentID, int classID) {
        super(name, password, email, phoneNumber, classID);
        this.studentID = studentID;
        balance = 0.00;
        orderedLunch = false;
    }
}

//Child Class - Staff
class Staff extends User {
    int totalLunchesOrdering;
    int totalLunchesServed;
    public Staff(String name, String password, String email, String phoneNumber, int classID, int totalLunchesOrdering) {
        super(name, password, email, phoneNumber, classID);
        this.totalLunchesOrdering = totalLunchesOrdering;
        totalLunchesServed = 0;
    }
}

//Child Class - Parents
class Parents extends User {
    int studentID;
    CreditCard creditCard;
    public Parents(String name, String password, String email, String phoneNumber, int classID, int studentID) {
        super(name, password, email, phoneNumber, classID);  
        this.studentID = studentID;
        creditCard = null;
    }
}