package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CustomerCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CustomerSporty;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class CustomerSportyEntity {

    @Id
    private String idCustomer;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String surnames;
    private String email;
    private String phone;

    public CustomerSportyEntity() {
    }

    public CustomerSportyEntity(String idCustomer, String dni, String name, String surnames, String email, String phone) {
        this.idCustomer = idCustomer;
        this.dni = dni;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.phone = phone;
    }

    public CustomerSportyEntity(CustomerCreationSporty customerCreationSporty) {
        BeanUtils.copyProperties(customerCreationSporty, this);
        this.idCustomer = UUID.randomUUID().toString();
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

    public CustomerSporty convertToCustomerSporty() {
        return new CustomerSporty(this.idCustomer, this.dni, this.name, this.surnames, this.email, this.phone);
    }

    @Override
    public String toString() {
        return "CustomerSportyEntity{" +
                "idCustomer='" + idCustomer + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
