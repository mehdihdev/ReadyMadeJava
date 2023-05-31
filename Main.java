import java.util.*;
import java.util.spi.CalendarDataProvider;

//Main Class
public class Main {
    public static void main(String[] args) {
        //CreditCard newCredit = new CreditCard("Mehdi Hussain", 21387213, "05/31", 828);
        //Student newStudent = new Student("Mehdi Hussain", "Cool Password", "mehdi@mehdi.us", "+1 (919) 342-8412", 123123213, 234324234);

        Scanner input = new Scanner(System.in);
        String finalInput = initialAsk(input);
        ArrayList<Staff> allStaff = new ArrayList<Staff>();

        //These values are for testing, to showcase how staff can create students, etc. Use these values when logging in.
        Staff initialStaff = new Staff("Aditi", "mehdi", "mehdi@mehdi.us", "9191234567", "1234567", 0);

        allStaff.add(0, initialStaff);

        while (!finalInput.equals("0")) {
            if (finalInput.equals("1")) {
                Scanner studentInput = new Scanner(System.in);
                String classID = classIDAsk(studentInput);
                String studentID = studentIDAsk(studentInput);
                break;
                
            }
            if(finalInput.equals("2")) {
                Scanner staffInput = new Scanner(System.in);
                String classID = classIDAsk(staffInput);
                String password = passwordAsk(staffInput);
                Staff newStaff = null;
                for(int i = 0; i < allStaff.size(); i++) {
                    if(allStaff.get(i).getClassID().equals(classID) && allStaff.get(i).getPassword().equals(password)) {
                        newStaff = allStaff.get(i);
                        Scanner actionScanner = new Scanner(System.in);
                        String actionItem = staffActionItem(actionScanner);
                        if(actionItem == "1") {
                            System.out.println("Enter Menu Item to add: ");
                            String itemName = addMenuName(actionScanner);
                            double itemPrice = addMenuPrice(actionScanner);

                            


                        } 
                        if(actionItem == "2") {

                        }
                        if(actionItem == "3") {

                        }


                    }
                } 
                System.out.println("Wrong Class ID and/or password again");
                break;
            }
            if (finalInput.equals("3")) {
                System.out.println("no no dddddd");
                break;
            }
            else {
                System.out.println("Choice not found. Please try again.");
                finalInput = initialAsk(input);
            }
        }



        //newStudent.setCreditCard(newCredit);
        //System.out.println(newStudent);
        //System.out.println(newCredit);
    }

    public static String initialAsk(Scanner input) {
        System.out.print("Welcome! Enter what kind of person you are: \n1. Student\n2. Staff\n3. Parent\nType Here: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static String classIDAsk(Scanner input) {
        System.out.print("Type in your class ID here: ");

        String input1 = input.nextLine();
        return input1;
    }
    public static String passwordAsk(Scanner input) {
        System.out.print("Type in your password here: ");

        String input1 = input.nextLine();
        return input1;
    }
    public static String studentIDAsk(Scanner input) {
        System.out.print("Type in your student ID here: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static String staffActionItem(Scanner input) {
        System.out.print("What do you want to do?\n1. Add to Menu\n2. Remove From Menu\n 3. Summary");

        String input1 = input.nextLine();
        return input1;
    }

    public static String addMenuName(Scanner input) {
        System.out.print("Enter Item Name: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static double addMenuPrice(Scanner input) {
        System.out.print("Enter Price: ");

        Double input1 = input.nextDouble();
        return input1;
    }
}