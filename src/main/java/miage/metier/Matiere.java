package miage.metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Matiere")
public class Matiere {

    //Proprietes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Matiere")
    private int idMatiere;

    @Column(name = "Libelle_Matiere")
    private String libelleMatiere;

    //Relation matiere seances cours
    @OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SeanceCours> seancesCours = new HashSet(0);

    //Contructeurs
    public Matiere() {
    }

    public Matiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }

    //Getter and Setter
    public int getIdMatiere() {
        return idMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }

    public Set<SeanceCours> getSeancesCours() {
        return seancesCours;
    }

    public void setSeancesCours(Set<SeanceCours> seancesCours) {
        this.seancesCours = seancesCours;
    }

    //toString
    @Override
    public String toString() {
        return "Matiere{" + "idMatiere=" + idMatiere + ", libelleMatiere=" + libelleMatiere + '}';
    }

    //Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idMatiere;
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
        final Matiere other = (Matiere) obj;
        if (this.idMatiere != other.idMatiere) {
            return false;
        }
        return true;
    }

}
