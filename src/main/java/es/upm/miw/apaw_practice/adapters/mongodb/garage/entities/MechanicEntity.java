package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class MechanicEntity {

    @Id
    private String id;
    private String name;
    private String department;
    private BigDecimal pricePerHour;
    private Double numWorkedHours;

    public MechanicEntity(){
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getNumWorkedHours() {
        return numWorkedHours;
    }

    public void setNumWorkedHours(Double numWorkedHours) {
        this.numWorkedHours = numWorkedHours;
    }

}
