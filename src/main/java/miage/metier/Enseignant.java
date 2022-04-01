package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Enseignant")
@PrimaryKeyJoinColumn
public class Enseignant extends Utilisateur implements Serializable {

    //proprietes
    @Column(name = "Photo")
    private String photo;

    //relation entre formation et group
    @OneToMany(mappedBy = "enseignant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SeanceCours> seancesCours = new HashSet(0);

    //Contructeurs
    public Enseignant() {
    }

    public Enseignant(String prenomEnseignant, String nomEnseignant, String loginEnseignant, String passwordEnseignant, String role) {
        super(prenomEnseignant, nomEnseignant, loginEnseignant, passwordEnseignant, role);
    }

    public Enseignant(String prenomEnseignant, String nomEnseignant, String loginEnseignant, String passwordEnseignant, String role, String photo) {
        super(prenomEnseignant, nomEnseignant, loginEnseignant, passwordEnseignant, role);
        this.photo = photo;
    }

    public Enseignant(int identifiantUtilisateur, String prenomEnseignant, String nomEnseignant, String loginEnseignant, String passwordEnseignant, String role) {
        super(identifiantUtilisateur, prenomEnseignant, nomEnseignant, loginEnseignant, passwordEnseignant, role);
    }

    public Set<SeanceCours> getSeancesCours() {
        return seancesCours;
    }

    public void setSeancesCours(Set<SeanceCours> seancesCours) {
        this.seancesCours = seancesCours;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
