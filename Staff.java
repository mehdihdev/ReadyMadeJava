import java.util.*;
//Child Class - Staff
public class Staff extends User {
    int totalLunchesOrdering;
    int totalLunchesServed;

    ArrayList<String> itemName = new ArrayList<String>();
    ArrayList<Double> itemPrice = new ArrayList<Double>();

    public Staff(String name, String password, String email, String phoneNumber, String classID, int totalLunchesOrdering) {
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
        public String getClassID() {
            return super.getClassID();
        }
        public int getTotalOrders() {
            return totalLunchesOrdering;
        }
        public int getTotalServed() {
            return totalLunchesServed;
        }
        public String getPassword() {
            return super.password;
        }
        public String toString() {
            return super.toString() + "\n***********************************\n Staff Information\n***********************************\nTotal Lunches Ordered: " + getTotalOrders() + "\nTotal Lunches Served: " + getTotalServed() + "\n***********************************\n" + getMenu();
        }
    
        public String getMenu() {
            String returnString = "***********************************\n Menu Information\n***********************************\n";
            if(itemName.size() == 0) { 
                return "No Items in Menu. Add some to see some here!";
            } else {
                for(int i = 0; i < itemName.size(); i++) {
                    returnString = returnString + i + ": " + itemName.get(i) + " - " + itemPrice.get(i) + "\n";
                }
            }
            returnString = returnString + "\n***********************************"; 
            return returnString;
        }

        public String getFromMenuName(int index) {
            return itemName.get(index);
        }

        public double getFromMenuPrice(int index) {
            return itemPrice.get(index);
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

        public void setTotalLunches(int amnt) {
            totalLunchesOrdering = amnt;
        }

        public void addToMenu(String name, double price) {
            itemName.add(name);
            itemPrice.add(price);
        }

        public void removeFromMenu(int index) {
            itemName.remove(index);
            itemPrice.remove(index);
        }
}