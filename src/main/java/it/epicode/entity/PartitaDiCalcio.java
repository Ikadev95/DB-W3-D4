package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Trova_tutte_PartiteDiCalcio", query = "SELECT e FROM PartitaDiCalcio e")
public class PartitaDiCalcio extends Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String squadraDiCasa;

    private String squadraOspite;

    private String vincente;

    private Integer nGoalSquadraCasa;

    private Integer getnGoalSquadraOspite;

}
