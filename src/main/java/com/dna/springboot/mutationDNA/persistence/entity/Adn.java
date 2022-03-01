package com.dna.springboot.mutationDNA.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dna")
public class Adn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dna_id")
    private Integer adnId;

    @Column(name = "data")
    private String datos[];

    @Column(name = "mutation")
    private boolean mutacion;

    public Adn() {

    }

    public Adn(Integer adnId, String[] datos, boolean mutacion) {
        this.adnId = adnId;
        this.datos = datos;
        this.mutacion = mutacion;
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
    }

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    public boolean isMutacion() {
        return mutacion;
    }

    public void setMutacion(boolean mutacion) {
        this.mutacion = mutacion;
    }
}
