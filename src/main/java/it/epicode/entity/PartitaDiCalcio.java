package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@NamedQuery(name = "Trova_tutte_PartiteDiCalcio", query = "SELECT e FROM PartitaDiCalcio e")
@NamedQuery(name = "PartiteVinteInCasa",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.vincente = p.squadraDiCasa")
@NamedQuery(name = "PartiteVinteInTrasferta",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.vincente = p.squadraOspite")

public class PartitaDiCalcio extends Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter
    @Setter
    @Column(name = "squadra_di_casa", nullable = false, length = 50)
    private String squadraDiCasa;

    @Getter
    @Setter
    @Column(name = "squadra_ospite", nullable = false, length = 50)
    private String squadraOspite;

    @Getter
    @Setter
    @Column(name = "vincente", length = 50)
    private String vincente;

    @Getter
    @Setter
    @Column(name = "numero_goal_squadra_casa", nullable = false)
    private Integer nGoalSquadraCasa;

    @Getter
    @Setter
    @Column(name = "numero_goal_squadra_ospite", nullable = false)
    private Integer nGoalSquadraOspite;

}
