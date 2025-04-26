public class User {

    private String sPhoneNumber;
    private String sUserName;
    private int    nEventID;
    private Address address;

    // Internal record (if only used by User)
    public record Address(
            String sStreet,
            String sCity,
            String sState,
            String sZipCode,
            String sCountry
    ) {}

    // Constructor
    public User(String sUserName, String sPhoneNumber){
        this.sUserName    = sUserName;
        this.sPhoneNumber = sPhoneNumber;
        this.nEventID     = 0;

        System.out.println("User created: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber);
    }

    public String UpdateNumber(String sPhoneNumber) {
        this.sPhoneNumber = sPhoneNumber;
        this.nEventID     = UpdateEventID();

        return "User updated: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber;
    }

    public String UpdateName(String sUserName) {
        this.sUserName = sUserName;
        this.nEventID  = UpdateEventID();

        return "User updated: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber;
    }

    public void AddOrUpdateAddr(Address address) {
        this.address = address;
        this.nEventID  = UpdateEventID();
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User[name=" + this.sUserName + ", phone=" + this.sPhoneNumber + ", address=" + address + "]";
    }

    private int UpdateEventID() {
        this.nEventID +=1;

        System.out.println("New Event. ID: " + this.nEventID);

        return this.nEventID;
    }
}
