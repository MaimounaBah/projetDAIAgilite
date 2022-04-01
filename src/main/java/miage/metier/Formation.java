package miage.metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Formation")
public class Formation {

    //Proprietes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Formation")
    private int idFormation;

    @Column(name = "Libelle_Formation")
    private String libelleFormation;

    //relation entre formation et group
    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Groupe> groupes = new HashSet(0);

//    @ManyToMany(mappedBy = "services")
//private Set<Matiere> matieres = new HashSet(0);
    //Contructeurs
    public Formation() {
    }

    public Formation(String libelleFormation) {
        this.libelleFormation = libelleFormation;
    }

    //Getter and Setter
    public int getIdFormation() {
        return idFormation;
    }

    public String getLibelleFormation() {
        return libelleFormation;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setLibelleFormation(String libelleFormation) {
        this.libelleFormation = libelleFormation;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    @Override
    public String toString() {
        return "Formation{" + "idFormation=" + idFormation + ", libelleFormation=" + libelleFormation + '}';
    }

    //Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idFormation;
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
        final Formation other = (Formation) obj;
        if (this.idFormation != other.idFormation) {
            return false;
        }
        return true;
    }

}
