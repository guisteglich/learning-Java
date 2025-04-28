import java.util.logging.Logger;

public class User {

    private String sPhoneNumber;
    private String sUserName;
    private int    nEventID;
    private Address address;

    private static final Logger LOGGER = Logger.getLogger(User.class.getName());

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
        // validations
        if (sUserName == null || sUserName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (sPhoneNumber == null || !sPhoneNumber.matches("[+\\d\\s()-]+")) {
            throw new IllegalArgumentException("Phone number must contain only digits");
        }

        this.sUserName    = sUserName;
        this.sPhoneNumber = sPhoneNumber;
        this.nEventID     = 0;

        System.out.println("User created: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber);
    }

    public String setPhoneNumber(String sPhoneNumber) {
        if (sPhoneNumber == null || !sPhoneNumber.matches("[+\\d\\s()-]+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.sPhoneNumber = sPhoneNumber;
        this.nEventID     = UpdateEventID();

        return "User updated: " + this.sUserName + " PhoneNumber: " + this.sPhoneNumber;
    }

    public String setUserName(String sUserName) {
        if (sUserName == null || sUserName.isEmpty()) {
            throw new IllegalArgumentException("Invalid user name");
        }
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

        LOGGER.info("New Event ID: " + this.nEventID);

        return this.nEventID;
    }
}
