
package repository;

import model.Contact;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    private final String fileName = "contacts.dat";

    public List<Contact> loadContacts() {
        File file = new File(fileName);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                 new ObjectInputStream(new FileInputStream(file))) {

            return (List<Contact>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load contacts: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveContacts(List<Contact> contacts) {
        try (ObjectOutputStream output =
                 new ObjectOutputStream(new FileOutputStream(fileName))) {

            output.writeObject(new ArrayList<>(contacts));

        } catch (IOException e) {
            System.out.println("Could not save contacts: " + e.getMessage());
        }
    }
}
