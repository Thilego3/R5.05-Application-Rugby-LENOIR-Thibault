package application_rugby.tp1.entities;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "matchs")

public class Match {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private int idMatch;

    @Column(name = "date")
    private String date;

    @Column(name = "heure")
    private String heure;

    @Column(name = "nom_equipe_adverse")
    private String nomEquipeAdverse;

    @Column(name = "lieu_de_rencontre")
    private String lieuDeRencontre;

    @Column(name = "domicile")
    @JdbcTypeCode(SqlTypes.TINYINT)
    private int isDomicile;

    @Column(name = "resultat")
    private Integer resultat;

    // Getters and setters

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getNomEquipeAdverse() {
        return nomEquipeAdverse;
    }

    public void setNomEquipeAdverse(String nomEquipeAdverse) {
        this.nomEquipeAdverse = nomEquipeAdverse;
    }

    public String getLieuDeRencontre() {
        return lieuDeRencontre;
    }

    public void setLieuDeRencontre(String lieuDeRencontre) {
        this.lieuDeRencontre = lieuDeRencontre;
    }

    public int getIsDomicile() {
        return isDomicile;
    }

    public void setIsDomicile(int domicile) {
        this.isDomicile = domicile;
    }

    public Integer getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
