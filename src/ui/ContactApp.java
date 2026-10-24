
package ui;

import service.ContactService;
import java.util.Scanner;

public class ContactApp {

    private final ContactService service;
    private final Scanner scanner;

    public ContactApp() {
        service = new ContactService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== CONTACT MANAGEMENT APP =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    service.viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    editContact();
                    break;
                case "5":
                    deleteContact();
                    break;
                case "6":
                    System.out.println("Thank you for using Contact Management App!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1 to 6.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter 10-digit phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        service.addContact(name, phone, email);
    }

    private void searchContact() {
        System.out.print("Enter contact name or phone number to search: ");
        String keyword = scanner.nextLine().trim();
        service.searchContact(keyword);
    }

    private void editContact() {
        System.out.print("Enter the current phone number of the contact: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new 10-digit phone number: ");
        String newPhone = scanner.nextLine().trim();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine().trim();

        service.editContact(phone, name, newPhone, email);
    }

    private void deleteContact() {
        System.out.print("Enter the phone number of the contact to delete: ");
        String phone = scanner.nextLine().trim();
        service.deleteContact(phone);
    }
}
