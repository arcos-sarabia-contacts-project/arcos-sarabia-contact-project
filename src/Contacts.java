import java.util.HashMap;
import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {

        HashMap<String, Integer> contact = new HashMap<>();

        contact.put("Genesis", 2106876798);
        contact.put("Lillian", 2108453477);

        Scanner sc = new Scanner(System.in);
        boolean wantToContinue = true;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome, to your contacts app.");
            System.out.println("1 - View all contacts\n" +
                    "2 - Add a new contact.\n" +
                    "3 - Search a contact by name.\n" +
                    "4 - Delete an existing contact.\n" +
                    "5 - Exit.");
            Scanner sca = new Scanner(System.in);
            System.out.print("Select an option: ");













        } while (wantToContinue);







    }




}
