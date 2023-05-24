//Child Class - Staff
public class Staff extends User {
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