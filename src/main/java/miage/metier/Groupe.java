package miage.metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Groupe")
public class Groupe {

    //Proprietes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Groupe")
    private int idGroupe;

    @Column(name = "Libelle_Groupe")
    private String libelleGroupe;

    //Relation entre groupe et seances cours
    @OneToMany(mappedBy = "groupe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SeanceCours> seanceCours = new HashSet<>();

    //Relation entre groupe et formation
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Formation")
    private Formation formation;

    //Relation entre groupe et etudiants
    @OneToMany(mappedBy = "groupe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants = new HashSet(0);

    //Contructeurs
    public Groupe() {
    }

    public Groupe(int idGroupe, String libelleGroupe) {
        this.idGroupe = idGroupe;
        this.libelleGroupe = libelleGroupe;
    }

    public Groupe(String libelleGroupe) {
        this.libelleGroupe = libelleGroupe;
    }

    public Groupe(String libelleGroupe, Formation formation) {
        this.libelleGroupe = libelleGroupe;
        this.formation = formation;
    }

    //Getter and Setter
    public int getIdGroupe() {
        return idGroupe;
    }

    public String getLibelleGroupe() {
        return libelleGroupe;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public void setLibelleGroupe(String libelleGroupe) {
        this.libelleGroupe = libelleGroupe;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Set<SeanceCours> getSeanceCours() {
        return seanceCours;
    }

    public void setSeanceCours(Set<SeanceCours> seanceCours) {
        this.seanceCours = seanceCours;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    //toString
    @Override
    public String toString() {
        return "Groupe{" + "idGroupe=" + idGroupe + ", libelleGroupe=" + libelleGroupe + '}';
    }

    //Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.idGroupe;
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
        final Groupe other = (Groupe) obj;
        if (this.idGroupe != other.idGroupe) {
            return false;
        }
        return true;
    }

}
