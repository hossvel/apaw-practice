package es.upm.miw.apaw_practice.domain.models.sportyRental;

import org.springframework.data.mongodb.core.index.Indexed;

public class CustomerSporty {

    private String idCustomer;
    private String dni;
    private String name;
    private String surnames;
    private String email;
    private String phone;

    public CustomerSporty() {
    }

    public CustomerSporty(String idCustomer, String dni, String name, String surnames, String email, String phone) {
        this.idCustomer = idCustomer;
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerSporty{" +
                "idCustomer='" + idCustomer + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
