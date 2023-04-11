import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {


    public static void main(String[] args) throws IOException {

        String contactFile = "contacts.txt";
        Path srcToFile = Paths.get("src", contactFile);


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

            List<String> contactInfo;
            Scanner stringInput = new Scanner(System.in);

        switch (input.nextInt()){

            case 1:
                System.out.printf("%-10s | %-15s%n", "Name", "Phone number");
                System.out.println("-----------------------------------");

                contactInfo = Files.readAllLines(srcToFile);
                for(String info: contactInfo){
                    String[] splitInfo = info.split(",");
                    String nameInfo = splitInfo[0].trim();
                    String numInfo = splitInfo[1].trim();

                    String contactDash =
                            numInfo.substring(0, 3) + "-" + numInfo.substring(3, 6) + "-" + numInfo.substring(6);
                    System.out.printf("%-10s | %-15s%n", nameInfo, contactDash);

                }
                break;
            case 2:
                contactInfo = Files.readAllLines(srcToFile);
                System.out.println("Please enter Contact Name and Phone Number separated by a comma.");
                String newContact = stringInput.nextLine();
                if (contactInfo.contains(newContact)){
                    System.out.println(newContact + " already exists in contacts.");
                    System.out.println("Are you sure you want to add again?");

                    Scanner sca = new Scanner(System.in);
                    Boolean yesOrNo = sca.nextLine().equalsIgnoreCase("yes");
                    if (!yesOrNo){
                        System.out.println("Contact was not added.");
                    }
                }
                Files.write(srcToFile, Arrays.asList(newContact), StandardOpenOption.APPEND);
                System.out.println("New contact is added: " + newContact);
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
                for(int i=0 ; i < contactInfo.size(); i++) {
                    if (contactInfo.get(i).contains(newContact)){
                        contactInfo.remove(i);
                        Files.write(srcToFile, contactInfo);
                    }
                }
                System.out.println(newContact + " has been removed from your contacts.");

                break;
            case 5:
                System.out.println("Contacts App closed. Thank you and see you later again!");
                System.exit(0);
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
