package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class JourneyEntity {
    @Id
    private String id;
    private String departure;
    private String arrive;
    private Integer numStops;


    public JourneyEntity() {
        //empty from framework
    }

    public JourneyEntity(String departure, String arrive, Integer numStops) {
        this.id = UUID.randomUUID().toString();
        this.departure = departure;
        this.arrive = arrive;
        this.numStops = numStops;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public Integer getNumStops() {
        return numStops;
    }

    public void setNumStops(Integer numStops) {
        this.numStops = numStops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JourneyEntity that = (JourneyEntity) o;
        return id.equals(that.id) &&
                departure.equals(that.departure) &&
                arrive.equals(that.arrive) &&
                numStops.equals(that.numStops);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "JourneyEntity{" +
                "id='" + id + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", numStops=" + numStops +
                '}';
    }
}
