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

