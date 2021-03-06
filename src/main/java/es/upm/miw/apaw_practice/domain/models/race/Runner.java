package es.upm.miw.apaw_practice.domain.models.race;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;

public class Runner {

    private String id;
    private String name;
    private String dni;
    private Integer dorsal;
    private Boolean isProfessional;
    private RunnerClub runnerClub;

    public Runner() {
        // empty for framework
    }

    public Runner(String id, String name, String dni, Integer dorsal, Boolean isProfessional, RunnerClub runnerClub) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.dorsal = dorsal;
        this.isProfessional = isProfessional;
        this.runnerClub = runnerClub;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Boolean getProfessional() {
        return isProfessional;
    }

    public void setProfessional(Boolean professional) {
        isProfessional = professional;
    }

    public RunnerClub getRunnerClub() {
        return runnerClub;
    }

    public void setRunnerClub(RunnerClub runnerClub) {
        this.runnerClub = runnerClub;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((Runner) obj).dni));
    }

    @Override
    public String toString() {
        return "RunnerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", dorsal=" + dorsal +
                ", isProfessional=" + isProfessional +
                ", runnerClub=" + runnerClub +
                '}';
    }

}
