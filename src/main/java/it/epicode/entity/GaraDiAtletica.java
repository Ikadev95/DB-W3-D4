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

    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    @Column(name = "atleti")
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    @Column(name = "vincitore")
    private Persona vincitore;

}
