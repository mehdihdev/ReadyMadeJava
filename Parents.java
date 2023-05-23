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