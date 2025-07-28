import java.util.ArrayList;

public class AddressBook {
	
	private ArrayList<Contact> contacts;
	
	
	public AddressBook() {
		contacts = new ArrayList<>();
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
		System.out.println("Contact Added Successfully...");
	}
		
	public void removeContact(Contact contact) {
		if(contacts.remove(contact)) {
			System.out.println("Contact Removed Successfully...");
		}
		else {
            System.out.println("Contact not found.");
        }
	}
	
	
	 public void updateContact(String oldName, String newName, String newPhoneNumber) {
	        for (Contact contact : contacts) {
	            if (contact.getName().equals(oldName)) {
	                contact.setName(newName);
	                contact.setPhoneNumber(newPhoneNumber);
	                System.out.println("Contact updated successfully.");
	                return;
	            }
	        }
	        System.out.println("Contact not found.");
	    }
	 
	 
	 public void displayAllContacts() {
			if(contacts.isEmpty()) {
				System.out.println("Address Book is Empty");
			} else {
				System.out.println("Contacts in Address Book:");
				for(Contact contact : contacts) {
					 System.out.println(contact);
				}
			}
		}
	
	  // Method to access the contacts list
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

}
