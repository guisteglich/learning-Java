//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        User user1 = new User("Guilherme", "5199778");
        User.Address address = new User.Address(
                "123 Java St", "Tech City", "RS", "12345", "BRA"
        );

        user1.AddOrUpdateAddr(address);

        System.out.println(user1.setPhoneNumber("51997786199"));
        System.out.println(user1.setUserName("Guilherme Steglich de Oliveira"));

        System.out.println(user1.toString());
        }
    }