public class User {

    String sPhoneNumber;
    String sUserName;
    int nEventID;

    public User(String sUserName, String sPhoneNumber){
        this.sUserName = sUserName;
        this.sPhoneNumber = sPhoneNumber;
        this.nEventID = 0;

        System.out.println("User created: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber);
    }

    public String UpdateNumber(String sPhoneNumber) {
        this.sPhoneNumber = sPhoneNumber;
        this.nEventID = UpdateEventID();

        return "User updated: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber;
    }

    private int UpdateEventID() {
        this.nEventID =+1;

        return this.nEventID;
    }
}
