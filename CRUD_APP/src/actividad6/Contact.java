package actividad6;

public class Contact {
    private String name;
    private long number;
    private String email;

    public Contact(String name, long number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    // Obtener el nombre del contacto
    public String getName() {
        return name;
    }

    // Establecer el nombre del contacto
    public void setName(String name) {
        this.name = name;
    }

    // Obtener el número de teléfono del contacto
    public long getNumber() {
        return number;
    }

    // Establecer el número de teléfono del contacto
    public void setNumber(long number) {
        this.number = number;
    }

    // Obtener el correo electrónico del contacto
    public String getEmail() {
        return email;
    }

    // Establecer el correo electrónico del contacto
    public void setEmail(String email) {
        this.email = email;
    }
}
