package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@NamedQuery(name = "Trova_tutte_GareDiAtletica", query = "SELECT e FROM GaraDiAtletica e")
public class GaraDiAtletica extends Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Set<Persona> atleti;

    private Persona vincitore;

}
