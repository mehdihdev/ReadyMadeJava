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
        creditCard.addBalance(-1*amnt)
    }

    public void orderLunch() {
        //TODO: Implement orderLunch()
        
    }


}
