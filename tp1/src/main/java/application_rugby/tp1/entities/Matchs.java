package application_rugby.tp1.entities;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "matchs")

public class Matchs {
    
    @Id
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
    private int domicile;

    @Column(name = "resultat")
    private int resultat;

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

    public int isDomicile() {
        return domicile;
    }

    public void setDomicile(int domicile) {
        this.domicile = domicile;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
