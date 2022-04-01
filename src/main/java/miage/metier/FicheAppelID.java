package miage.metier;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class FicheAppelID implements Serializable {

    //Propriétés
    @Column(name = "identifiantUtilisateur")
    private int identifiantEtudiant;

    @Column(name = "identifiantSeance")
    private int identifiantSeance;

    //Constructeurs
    public FicheAppelID() {

    }

    public FicheAppelID(int identifiantEtudiant, int identifiantSeance) {
        this.identifiantEtudiant = identifiantEtudiant;
        this.identifiantSeance = identifiantSeance;
    }

    //Getters and setters
    public int getIdentifiantEtudiant() {
        return identifiantEtudiant;
    }

    public void setIdentifiantEtudiant(int identifiantEtudiant) {
        this.identifiantEtudiant = identifiantEtudiant;
    }

    public int getIdentifiantSeance() {
        return identifiantSeance;
    }

    public void setIdentifiantSeance(int identifiantSeance) {
        this.identifiantSeance = identifiantSeance;
    }

    //ToString
    @Override
    public String toString() {
        return "FicheAppelID{" + "identifiantEtudiant=" + identifiantEtudiant + ", identifiantSeance=" + identifiantSeance + '}';
    }

    //HashCode and equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.identifiantEtudiant;
        hash = 23 * hash + this.identifiantSeance;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FicheAppelID other = (FicheAppelID) obj;
        if (this.identifiantEtudiant != other.identifiantEtudiant) {
            return false;
        }
        if (this.identifiantSeance != other.identifiantSeance) {
            return false;
        }
        return true;
    }

}
