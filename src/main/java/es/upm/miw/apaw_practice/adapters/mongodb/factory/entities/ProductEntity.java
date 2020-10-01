package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class ProductEntity {

    @Id
    private String id;
    private String description;
    private BigDecimal wholesalePrice;

    public ProductEntity() {
        // empty for framework
    }

    public ProductEntity(String id, String description, BigDecimal wholesalePrice) {
        this.id = id;
        this.description = description;
        this.wholesalePrice = wholesalePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (id.equals(((ProductEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", wholesalePrice=" + wholesalePrice +
                ", description='" + description + '\'' +
                '}';
    }
}