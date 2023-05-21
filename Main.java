//Main Class
public class Main {
    public static void main(String[] args) {
        CreditCard newCredit = new CreditCard("Mehdi Hussain", 21387213, "05/31", 828);
        Student newStudent = new Student("Mehdi Hussain", "Cool Password", "mehdi@mehdi.us", "+1 (919) 342-8412", 123123213, 234324234);
        newStudent.setCreditCard(newCredit);
        System.out.println(newStudent);
        //System.out.println(newCredit);
    }
}

//CreditCard Class
class CreditCard {
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
    public void addBalance(int amnt) {
        balance += amnt;
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
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getClassID() {
        return classID;
    }
    public String toString() {
        return "***********************************\n User Information\n***********************************\nName: " + getName() + "\nEmail: " + getEmail() + "\nPhone Number: " + getPhoneNumber() + "\nClass: " + getClassID() + "\n" + creditCard.toString() + "\n***********************************";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String oldPass, String newPass) {
        if (password.equals(oldPass))  {
            this.password = newPass;
        } else {
            System.out.println("Incorrect Old Password given. Password unchanged.");
        }
    }
    public void setPhoneNumber(String newPhone) {
        phoneNumber = newPhone;
    }
    public void setCreditCard(CreditCard newCard) {
        creditCard = newCard;
    }
    public void setClassID(int classID) {
        this.classID = classID;
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
    public int getClassID() {
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
    public void setClassID(int classID) {
        super.setClassID(classID);
    }



    //Core methods
    public void addFunds(CreditCard creditCard, double amnt) {
        //TODO: Implement Add Funds
        balance += amnt;
    }

    public void orderLunch() {
        //TODO: Implement orderLunch()
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
        public int getClassID() {
            return super.getClassID();
        }
    
        public int getTotalOrders() {
            return totalLunchesOrdering;
        }
        public int getTotalServed() {
            return totalLunchesServed;
        }
        public String toString() {
            return super.toString() + "\n***********************************\n Staff Information\n***********************************\nTotal Lunches Ordered: " + getTotalOrders() + "\nTotal Lunches Served: " + getTotalServed() + "\n***********************************";
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
        public void setClassID(int classID) {
            super.setClassID(classID);
        }

        public void setTotalLunches(int amnt) {
            totalLunchesOrdering = amnt;
        }


        //Other methods
        public void addLunch() {
            totalLunchesOrdering += 1;
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
        public int getClassID() {
            return super.getClassID();
        }
        public int getStudentID() {
            return studentID;
        }
        public String toString() {
            return super.toString() + "\n***********************************\n Parent Information\n***********************************\nStudentID: " + getStudentID() + "\nCredit Card: " + creditCard.toString() + "\n***********************************";
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
        public void setClassID(int classID) {
            super.setClassID(classID);
        }
}