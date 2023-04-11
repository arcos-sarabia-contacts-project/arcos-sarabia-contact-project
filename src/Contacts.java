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


        List<String> contactList = Arrays.asList("");
        Files.write(srcToFile, contactList, StandardOpenOption.APPEND);


        Files.write(srcToFile, Arrays.asList("Lillian, 2108453477"));
        Files.write(srcToFile, Arrays.asList("Genesis, 2106876798"), StandardOpenOption.APPEND);



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

            System.out.print("Select an option: ");

            List<String> contactInfo = Files.readAllLines(srcToFile);
            Scanner stringInput = new Scanner(System.in);

        switch (input.nextInt()){

            case 1:

                for(String info: contactInfo){
                    System.out.printf("%n %s %n", info);
                }
                break;
            case 2:
                System.out.println("Please enter Contact Name and Phone Number separated by a comma.");
                String newContact = stringInput.nextLine();
                Files.write(srcToFile, Arrays.asList(newContact), StandardOpenOption.APPEND);
                break;

            case 3:
                contactInfo = Files.readAllLines(srcToFile);
                System.out.println("Please enter name of contact you wish to search.");
                newContact = stringInput.nextLine();
                for(String info: contactInfo) {
                    if (info.contains(newContact)){
                        System.out.println(info);
                    }
                }
                break;
            case 4:
                contactInfo = Files.readAllLines(srcToFile);
                System.out.println("Please enter name of contact you wish to delete.");
                newContact = stringInput.nextLine();
                for(String info: contactInfo) {
                    if (info.contains(newContact)){
                        contactInfo.remove(Arrays.asList(info));
                        System.out.println(info + " has been removed from your contacts.");

                    }
                }
                break;


        }












//CONFIRM IF USER WANTS TO CONTINUE OR EXIT
            System.out.println("\nWould you like to view another option?");
            wantToContinue = sc.next().equalsIgnoreCase("yes");
            if (!wantToContinue){
                System.out.println("Exiting program. See you next time!");
            }
        } while (wantToContinue);







    }




}
