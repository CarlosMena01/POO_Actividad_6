package actividad6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadContact {
    private String filePath;

    public ReadContact(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Obtiene una lista de todos los contactos en el archivo de la agenda.
     * @return Lista de contactos.
     */
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    long number = Long.parseLong(data[1]);
                    String email = data[2];
                    Contact contact = new Contact(name, number, email);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer la agenda: " + e.getMessage());
        }

        return contacts;
    }

    /**
     * Lee y muestra todos los contactos en el archivo de la agenda.
     */
    public void readContacts() {
        List<Contact> contacts = getContacts();
        for (Contact contact : contacts) {
            System.out.println("Contacto: " + contact.getName() + ", " + contact.getNumber() + ", " + contact.getEmail());
        }
    }
}

