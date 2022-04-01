package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
//Pour la gestion de l'héritage
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifiantUtilisateur;

    @Column(nullable = false)
    private String prenomUtilisateur;

    @Column(nullable = false)
    private String nomUtilisateur;

    @Column(nullable = false)
    private String mailUtilisateur;

    @Column(nullable = false)
    private String pwdUtilisateur;

    @Column(name = "roleUtilisateur")
    private String roleUtilisateur;
//Les constructeurs 

    public Utilisateur() {

    }

    public Utilisateur(int identifiantUtilisateur, String prenomUtilisateur, String nomUtilisateur, String mailUtilisateur, String pwdUtilisateur, String roleUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.pwdUtilisateur = pwdUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
    }

    public Utilisateur(String prenomUtilisateur, String nomUtilisateur, String mailUtilisateur, String pwdUtilisateur, String roleUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.pwdUtilisateur = pwdUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
    }

    public Utilisateur(int identifiantUtilisateur, String prenomUtilisateur, String nomUtilisateur, String roleUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
    }

    public Utilisateur(int identifiantUtilisateur, String prenomUtilisateur, String nomUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
    }

//Getters and Setters
    public int getIdentifiantUtilisateur() {
        return identifiantUtilisateur;
    }

    public void setIdentifiantUtilisateur(int identifiantUtilisateur) {
        this.identifiantUtilisateur = identifiantUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public String getPwdUtilisateur() {
        return pwdUtilisateur;
    }

    public void setPwdUtilisateur(String pwdUtilisateur) {
        this.pwdUtilisateur = pwdUtilisateur;
    }

    public String getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

//ToString
    @Override
    public String toString() {
        return "Utilisateur{" + "identifiantUtilisateur=" + identifiantUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", mailUtilisateur=" + mailUtilisateur + ", pwdUtilisateur=" + pwdUtilisateur + '}';
    }

//HashCode and Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.identifiantUtilisateur);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.identifiantUtilisateur, other.identifiantUtilisateur)) {
            return false;
        }
        return true;
    }

}
