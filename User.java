//Parent Class - User
public class User {
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