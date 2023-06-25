package actividad6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateContact {
    private String filePath;

    public CreateContact(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Crea un nuevo contacto en el archivo de la agenda.
     * @param name   Nombre del contacto.
     * @param number Número de teléfono del contacto.
     * @param email  Correo electrónico del contacto.
     * @return true si el contacto se creó exitosamente, false si el contacto ya existe o si ocurrió un error.
     */
    public boolean createContact(String name, long number, String email) {
        if (contactExists(name)) {
            return false; // El contacto ya existe
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(name + "," + number + "," + email);
            return true; // Contacto creado exitosamente
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Error al crear el contacto
        }
    }

    /**
     * Verifica si un contacto con el nombre especificado ya existe en el archivo de la agenda.
     * @param name Nombre del contacto a verificar.
     * @return true si el contacto ya existe, false si no existe o si ocurrió un error.
     */
    private boolean contactExists(String name) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String contactName = parts[0];
                if (contactName.equals(name)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
