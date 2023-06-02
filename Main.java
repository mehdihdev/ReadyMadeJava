import java.text.*;
import java.util.*;

//Main Class
public class Main {
    DecimalFormat df = new DecimalFormat("#.00"); 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String finalInput = "5";
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        ArrayList<Student> allStudents = new ArrayList<Student>();
        ArrayList<Parents> allParents = new ArrayList<Parents>();

        //These values are for testing, to showcase how staff can create students, etc. Use these values when logging in.
        Staff initialStaff = new Staff("Aditi", "mehdi", "mehdi@mehdi.us", "9191234567", "1234567", 0);
        CreditCard newCredit = new CreditCard("Mehdi Hussain", 21387213, "05/31", 828);
        initialStaff.setCreditCard(newCredit);

        Student newStudent = new Student("Mehdi Hussain", "Cool Password", "mehdi@mehdi.us", "+1 (919) 342-8412", 123123213, "1234567");
        newStudent.setCreditCard(newCredit);

        Parents newParent = new Parents("Aditi Rai", "password", "aditirai@gmail.com", "9191234567", "1234567", 123123213);
        newParent.setCreditCard(newCredit);

        allStaff.add(initialStaff);
        allStudents.add(newStudent);
        allParents.add(newParent);

        while (!finalInput.equals("0")) {
            finalInput = initialAsk(input);
            while(finalInput.equals("1")) {
                Scanner studentInput = new Scanner(System.in);
                String studentID = studentIDAsk(studentInput);
                Boolean studentExit = false;
                while(!studentExit) {
                    Student studentFound = findStudent(allStudents, studentID);
                    while(!(studentFound == null)) {
                        Staff staffFound = findStaff(allStaff, studentFound.getClassID());
                        System.out.println("Welcome " + studentFound.getName());
                        String studentAction = studentActionAsk(studentInput);

                        if(studentAction.equals("1")) {
                            //Add to Order
                            System.out.println(staffFound.getMenu());
                            System.out.println("Select a number to add to order!");
                            String addToOrder = addMenuNum(studentInput);
                            int addToOrderIndex = Integer.valueOf(addToOrder);
                            studentFound.addToMenu(staffFound.getFromMenuName(addToOrderIndex), staffFound.getFromMenuPrice(addToOrderIndex));
                            System.out.println("Successfully added to cart!");

                        }
                        if(studentAction.equals("2")) {
                            //Remove from Order
                            System.out.println(studentFound.getMenu());
                            System.out.println("Select Item to remove!");
                            String removeFromOrder = addMenuNum(studentInput);
                            int removeFromOrderIndex = Integer.valueOf(removeFromOrder);
                            studentFound.removeFromOrder(removeFromOrderIndex);
                            System.out.println("Item successfully removed from cart!");
                        }
                        if(studentAction.equals("3")) {
                            //Cart / Summary
                            System.out.println(studentFound.getMenu());
                        }
                        if(studentAction.equals("4")) {
                            //Order Foods
                            Boolean orderLunch = orderLunch(staffFound, studentFound);
                            if (orderLunch == true) {
                                System.out.println("Order Succesful!");
                                studentFound.clearCart();
                                
                            } else {
                                System.out.println("Order not succesful. Try again");
                            }
                        }                   
                        if(studentAction.equals("0")) {
                            break;
                        }
                    }
                    if(studentFound == null) {
                        System.out.println("StudentID Wrong. Try Again.");
                    }
                    break;
                }
                break;
            }
            while(finalInput.equals("2")) {
                Scanner staffInput = new Scanner(System.in);
                String classID = classIDAsk(staffInput);
                String password = passwordAsk(staffInput);
                Staff newStaff = null;
                for(int i = 0; i < allStaff.size(); i++) {
                    if(allStaff.get(i).getClassID().equals(classID) && allStaff.get(i).getPassword().equals(password)) {
                        newStaff = allStaff.get(i);
                        Scanner actionScanner = new Scanner(System.in);
                        Boolean exit = false;
                        while(!exit) {
                            String actionItem = staffActionItem(actionScanner);
                            if(actionItem.equals("1")) {
                                System.out.println("Enter Menu Item to add");
                                String itemName = addMenuName(actionScanner);
                                double itemPrice = addMenuPrice(actionScanner);
                                newStaff.addToMenu(itemName, itemPrice);
                                System.out.println(itemName + " added to menu at a price of " + itemPrice);
                            }
                            if(actionItem.equals("2")) {
                                //Remove from Menu
                                System.out.println(newStaff.getMenu());
                                System.out.println("Enter Menu Item to remove");
                                String removeFromOrder = addMenuNum(actionScanner);
                                int removeFromOrderIndex = Integer.valueOf(removeFromOrder);
                                newStaff.removeFromMenu(removeFromOrderIndex);
                                System.out.println("Item Removed successfully");
                            }
                            if(actionItem.equals("3")) {
                                System.out.println(newStaff.toString());
                            }
                            if(actionItem.equals("0")) {
                                break;
                            }
                        }
                        break; 
                    }
                }
                if(newStaff == null) {
                    System.out.println("Wrong Class ID and/or password. Try again");
                }
                break;
            }
            while(finalInput.equals("3")) {
                Scanner parentsInput = new Scanner(System.in);
                String email = emailAsk(parentsInput);
                String password = passwordAsk(parentsInput);
                Parents parentFound = null;
                Student studentFound = null;
                for(int i = 0; i<allParents.size(); i++ ) {
                    if(allParents.get(i).getEmail() == email && allParents.get(i).getPassword() == password) {
                        parentFound = allParents.get(i);
                        studentFound = findStudent(allStudents, Integer.toString(parentFound.getStudentID()));
                        String parentsAction = parentActionAsk(parentsInput);
                        if(parentsAction == "1") {
                            System.out.println(studentFound.getBalance());
                        }
                        if(parentsAction == "2") {
                            String amount = getAmount(parentsInput);
                            studentFound.addFunds(parentFound.getCreditCard(), Integer.valueOf(amount));
                        }
                        if(parentsAction == "3") {
                            System.out.println(parentFound.toString());
                        }
                        if(parentsAction == "0") {
                            break;
                        }

                    }
                }
                if(parentFound == null) {
                    System.out.println("Wrong Email and/or password. Try again");
                }
                break;
            }
            continue;
        }
    }

    public static String initialAsk(Scanner input) {
        System.out.print("Welcome! Enter what kind of person you are: \n1. Student\n2. Staff\n3. Parent\n0. Exit\nType Here: ");

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
        System.out.print("What do you want to do?\n1. Add to Menu\n2. Remove From Menu\n3. Summary\n0. Exit\n");

        String input1 = input.nextLine();
        return input1;
    }

    public static String studentActionAsk(Scanner input) {
        System.out.print("What do you want to do?\n1. Add to Order\n2. Remove From Order\n3. Cart\n4. Order!\n0. Exit\n");

        String input1 = input.nextLine();
        return input1;
    }
    public static String parentActionAsk(Scanner input) {
        System.out.print("What do you want to do?\n1. Check student balance\n2. Add Funds\n3. Summary\n0. Exit\n");

        String input1 = input.nextLine();
        return input1;
    }

    public static String emailAsk(Scanner input) {
        System.out.print("Enter your email: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static String addMenuName(Scanner input) {
        System.out.print("Enter Item Name: ");

        String input1 = input.nextLine();
        return input1;
    }
    public static String getAmount(Scanner input) {
        System.out.print("Enter Item Amount: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static String addMenuNum(Scanner input) {
        System.out.print("Enter Item Number: ");

        String input1 = input.nextLine();
        return input1;
    }

    public static double addMenuPrice(Scanner input) {
        System.out.print("Enter Price: ");

        Double input1 = input.nextDouble();
        return input1;
    }

    public static Staff findStaff(ArrayList<Staff> allStaff, String classID) {
        for(int i = 0; i<allStaff.size();i++) {
            if(allStaff.get(i).getClassID() == classID) {
                return allStaff.get(i);
            }
        }
        return null;
    }

    public static Student findStudent(ArrayList<Student> allStudents, String studentID) {
        for(int i=0; i<allStudents.size();i++) {
            if(allStudents.get(i).getStudentID() == Integer.valueOf(studentID)) {
                return allStudents.get(i);
            }
        }
        return null;
    }

    public static Boolean orderLunch(Staff staff, Student student) {
        staff.totalLunchesOrdering -= 1;
        staff.totalLunchesServed +=1;
        
        double totalPrice = student.getTotalCost();
        Boolean didWork = student.removeBalance(totalPrice);
        return didWork;

    }
}