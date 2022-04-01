package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class FicheAppel implements Serializable {

    @EmbeddedId
    private FicheAppelID identifiantFiche;

    @Column
    private String etat_presence;

    //Relations
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identifiantUtilisateur", insertable = false, updatable = false)
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identifiantSeance", insertable = false, updatable = false)
    private SeanceCours seanceCours;

    public FicheAppel() {

    }

    public FicheAppel(FicheAppelID identifiantFiche, String etat_presence) {
        this.identifiantFiche = identifiantFiche;
        this.etat_presence = etat_presence;
    }

    public FicheAppelID getIdentifiantFiche() {
        return identifiantFiche;
    }

    public void setIdentifiantFiche(FicheAppelID identifiantFiche) {
        this.identifiantFiche = identifiantFiche;
    }

    public String getEtat_presence() {
        return etat_presence;
    }

    public void setEtat_presence(String etat_presence) {
        this.etat_presence = etat_presence;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public SeanceCours getSeanceCours() {
        return seanceCours;
    }

    public void setSeanceCours(SeanceCours seanceCours) {
        this.seanceCours = seanceCours;
    }

    @Override
    public String toString() {
        return "FicheAppel{" + "identifiantFiche=" + identifiantFiche + ", etat_presence=" + etat_presence + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.identifiantFiche);
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
        final FicheAppel other = (FicheAppel) obj;
        if (!Objects.equals(this.identifiantFiche, other.identifiantFiche)) {
            return false;
        }
        return true;
    }

}
