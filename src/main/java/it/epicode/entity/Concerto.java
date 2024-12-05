package it.epicode.entity;

import it.epicode.GenereConcertoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@NamedQuery(name = "Trova_tutti_Concerti", query = "SELECT e FROM Concerto e")
@NamedQuery(name="Trova_concerti_in_streaming", query="SELECT e FROM Concerto e WHERE e.inStreaming = :inStreaming")
@NamedQuery(name="Trova_concerti_per_genere", query="SELECT e FROM Concerto e WHERE e.genere = :genere")
public class Concerto extends Evento{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "genere", nullable = false)
    private GenereConcertoEnum genere;


    @Getter
    @Setter
    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

}
