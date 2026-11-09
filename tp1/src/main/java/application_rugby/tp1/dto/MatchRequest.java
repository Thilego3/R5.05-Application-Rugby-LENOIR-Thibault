package application_rugby.tp1.dto;

public class MatchRequest {

    private String date;
    private String heure;
    private String nomEquipeAdverse;
    private String lieuDeRencontre;
    private int domicile;

    // Getters and setters

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
}
