
package service;

import model.Contact;
import repository.ContactRepository;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final ContactRepository repository;
    private final List<Contact> contacts;

    public ContactService() {
        repository = new ContactRepository();
        contacts = new ArrayList<>(repository.loadContacts());
    }

    public boolean addContact(String name, String phone, String email) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return false;
        }

        if (phone == null || !phone.matches("[0-9]{10}")) {
            System.out.println("Phone must contain exactly 10 digits.");
            return false;
        }

        if (email == null ||
                !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Please enter a valid email address.");
            return false;
        }

        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                System.out.println("This phone number already exists.");
                return false;
            }
        }

        contacts.add(new Contact(name.trim(), phone, email));
        repository.saveContacts(contacts);
        System.out.println("Contact added successfully!");
        return true;
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact(String keyword) {
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || contact.getPhone().contains(keyword)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public boolean deleteContact(String phone) {
        boolean removed = contacts.removeIf(
                contact -> contact.getPhone().equals(phone));

        if (removed) {
            repository.saveContacts(contacts);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }

        return removed;
    }

    public boolean editContact(String phone, String newName,
                               String newPhone, String newEmail) {
        Contact existing = null;

        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                existing = contact;
                break;
            }
        }

        if (existing == null) {
            System.out.println("Contact not found.");
            return false;
        }

        if (newName == null || newName.trim().isEmpty()
                || newPhone == null || !newPhone.matches("[0-9]{10}")
                || newEmail == null
                || !newEmail.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Invalid name, phone, or email.");
            return false;
        }

        for (Contact contact : contacts) {
            if (contact != existing
                    && contact.getPhone().equals(newPhone)) {
                System.out.println("That phone number is already in use.");
                return false;
            }
        }

        existing.setName(newName.trim());
        existing.setPhone(newPhone);
        existing.setEmail(newEmail);

        repository.saveContacts(contacts);
        System.out.println("Contact updated successfully!");
        return true;
    }
}
