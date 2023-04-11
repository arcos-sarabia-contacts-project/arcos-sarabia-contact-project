import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.Files.createFile;

public class Contacts {


    public static void main(String[] args) throws IOException {

        String contactFile = "contacts.txt";
        Path srcToFile = Paths.get("src", contactFile);


        List<String> contactList = Arrays.asList("Genesis, 2106876798");
        Files.write(srcToFile, contactList, StandardOpenOption.APPEND);


        Files.write(srcToFile, Arrays.asList("Lillian, 2108453477"), StandardOpenOption.APPEND);
        System.out.println(Files.readAllLines(srcToFile));





//        Contact.put("Genesis", 2106876798);
//        Contact.put("Lillian", 2108453477);
//
//        for (Map.Entry<String, Integer> set : Contact.entrySet()){
//            System.out.println("Name: " + set.getKey() + " | Phone Number: " + set.getValue());
//        }


//        Scanner sc = new Scanner(System.in);
//        boolean wantToContinue = true;
//
//        do {
//            Scanner input = new Scanner(System.in);
//            System.out.println("Welcome, to your contacts app.");
//            System.out.println("1 - View all contacts\n" +
//                    "2 - Add a new contact.\n" +
//                    "3 - Search a contact by name.\n" +
//                    "4 - Delete an existing contact.\n" +
//                    "5 - Exit.");
//            Scanner sca = new Scanner(System.in);
//            System.out.print("Select an option: ");
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////CONFIRM IF USER WANTS TO CONTINUE OR EXIT
//            System.out.println("\nWould you like to view another contact?");
//            wantToContinue = sc.next().equalsIgnoreCase("yes");
//            if (!wantToContinue){
//                System.out.println("Exiting program. See you next time!");
//            }
//        } while (wantToContinue);







    }




}
