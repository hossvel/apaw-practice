package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class VehicleEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String carRegistration;
    private String make;
    private String model;
    private BigDecimal estimatedBudget;
    private LocalDateTime receptionDate;
    private LocalDateTime estimatedDeliveryDate;
    private List<PieceEntity> pieceEntities;
    private List<MechanicEntity> mechanicEntities;

    public VehicleEntity() {
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(BigDecimal estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public LocalDateTime getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDateTime receptionDate) {
        this.receptionDate = receptionDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public List<PieceEntity> getPieceEntities() {
        return pieceEntities;
    }

    public void setPieceEntities(List<PieceEntity> pieceEntities) {
        this.pieceEntities = pieceEntities;
    }

    public List<MechanicEntity> getMechanicEntities() {
        return mechanicEntities;
    }

    public void setMechanicEntities(List<MechanicEntity> mechanicEntities) {
        this.mechanicEntities = mechanicEntities;
    }
}
