/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miage.metier;

import java.util.Date;

/**
 *
 * @author zixin
 */
public class CoursAbsents {

    //Proprietes
    private int idCours;
    private String nomCours;
    private Date dateDebut;
    private Date dateFin;
    private String nomEnseignant;
    private String prenomEnseignant;
    private String formation;
    private String groupe;

    //Constructeurs
    public CoursAbsents(int idCours, String nomCours, Date dateDebut, Date dateFin, String nomEnseignant, String prenomEnseignant, String formation, String groupe) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomEnseignant = nomEnseignant;
        this.prenomEnseignant = prenomEnseignant;
        this.formation = formation;
        this.groupe = groupe;
    }

    //Getter et Setter
    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    //toString
    @Override
    public String toString() {
        return "CoursAbsents{" + "idCours=" + idCours + ", nomCours=" + nomCours + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nomEnseignant=" + nomEnseignant + ", prenomEnseignant=" + prenomEnseignant + ", formation=" + formation + ", groupe=" + groupe + '}';
    }

}
