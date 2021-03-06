package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDEmployee;
import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class CDEmployeeEntity {
    @Id
    private String id;
    private String name;
    private String category;
    private LocalDateTime seniority;
    private BigDecimal salary;

    public CDEmployeeEntity() {
        // Empty for framework
    }

    public CDEmployeeEntity(String id, String name, String category, LocalDateTime seniority, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.seniority = seniority;
        this.salary = salary;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getSeniority() {
        return seniority;
    }

    public void setSeniority(LocalDateTime seniority) {
        this.seniority = seniority;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public CDEmployee toEmployee() {
        CDEmployee employee = new CDEmployee();
        BeanUtils.copyProperties(this, employee);
        return employee;
    }

    public void fromEmployee(CDEmployee employee) {
        BeanUtils.copyProperties(employee, this);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CDEmployeeEntity that = (CDEmployeeEntity) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "CDEmployeeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", seniority=" + seniority +
                ", salary=" + salary +
                '}';
    }
}
