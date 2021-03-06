package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities;

import es.upm.miw.apaw_practice.domain.models.veterinary.Veterinary;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class VeterinaryEntity {

    @Id
    private String id;
    private String name;
    private Integer age;

    public VeterinaryEntity() {
        //Empty for framework
    }

    public VeterinaryEntity(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeterinaryEntity that = (VeterinaryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "VeterinaryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Veterinary toVeterinary() {
        Veterinary veterinary = new Veterinary();
        BeanUtils.copyProperties(this, veterinary);
        return veterinary;
    }
}
