import java.util.Scanner;

public class AddressBookAppMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book Menu: ");
            System.out.println("1. Add New Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Contact Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine();
                    addressBook.addContact(new Contact(name, phoneNumber));
                    break;

                case 2:
                    System.out.print("Enter name of contact to remove: ");
                    String nameToRemove = sc.nextLine();
                    boolean found = false;
                    for (Contact contact : addressBook.getContacts()) {
                        if (contact.getName().equals(nameToRemove)) {
                            addressBook.removeContact(contact);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;
                    
                case 3:
                	 System.out.print("Enter name of contact to update: ");
                     String oldName = sc.nextLine();
                     System.out.print("Enter new name: ");
                     String newName = sc.nextLine();
                     System.out.print("Enter new phone number: ");
                     String newPhoneNumber = sc.nextLine();
                     addressBook.updateContact(oldName, newName, newPhoneNumber);
                     break;


                case 4:
                    addressBook.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting from Address Book...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        }

	}

}
