package miage.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class SeanceCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifiantSeance;

    private String libelle_Salle;

    //@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebutSeanceCours;

    //@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinSeanceCours;

    private boolean valide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Matiere")
    private Matiere matiere;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identifiantUtilisateur")
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Groupe")
    private Groupe groupe;

    @OneToMany(mappedBy = "seanceCours", fetch = FetchType.LAZY)
    private Set<DocumentJustificatif> justificatifs = new HashSet(0);

    //Les constructeurs
    public SeanceCours() {

    }

    public SeanceCours(Enseignant enseignant, Matiere matiere, Groupe groupeEtudiant, Date dateDebutSeance, Date dateFinSeance, String libelleSalle, boolean valide) {
        this.enseignant = enseignant;
        this.matiere = matiere;
        this.groupe = groupeEtudiant;
        this.dateDebutSeanceCours = dateDebutSeance;
        this.dateFinSeanceCours = dateFinSeance;
        this.libelle_Salle = libelleSalle;
        this.valide = valide;
    }

    public SeanceCours(int identifiantSeance, String libelle_Salle, Date dateDebutSeanceCours, Date dateFinSeanceCours, Matiere matiere, Enseignant enseignant, Groupe groupeEtudiant, boolean valide) {
        this.identifiantSeance = identifiantSeance;
        this.libelle_Salle = libelle_Salle;
        this.dateDebutSeanceCours = dateDebutSeanceCours;
        this.dateFinSeanceCours = dateFinSeanceCours;
        this.matiere = matiere;
        this.enseignant = enseignant;
        this.groupe = groupeEtudiant;
        this.valide = valide;
    }

    public SeanceCours(int numeroSeance, Matiere matiere, Date dateDebutSeance, Date dateFinSeance) {
        this.identifiantSeance = numeroSeance;
        this.matiere = matiere;
        this.dateDebutSeanceCours = dateDebutSeance;
        this.dateFinSeanceCours = dateFinSeance;
    }

    public SeanceCours(int identifiantSeance, String libelle_Salle, Date dateDebutSeanceCours, Date dateFinSeanceCours, boolean valide) {
        this.identifiantSeance = identifiantSeance;
        this.libelle_Salle = libelle_Salle;
        this.dateDebutSeanceCours = dateDebutSeanceCours;
        this.dateFinSeanceCours = dateFinSeanceCours;
        this.valide = valide;
    }

//Getters and Setters
    public int getIdentifiantSeance() {
        return identifiantSeance;
    }

    public void setIdentifiantSeance(int identifiantSeance) {
        this.identifiantSeance = identifiantSeance;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Date getDateDebutSeanceCours() {
        return dateDebutSeanceCours;
    }

    public void setDateDebutSeanceCours(Date dateDebutSeanceCours) {
        this.dateDebutSeanceCours = dateDebutSeanceCours;
    }

    public Date getDateFinSeanceCours() {
        return dateFinSeanceCours;
    }

    public void setDateFinSeanceCours(Date dateFinSeanceCours) {
        this.dateFinSeanceCours = dateFinSeanceCours;
    }

    public String getLibelle_Salle() {
        return libelle_Salle;
    }

    public void setLibelle_Salle(String libelle_Salle) {
        this.libelle_Salle = libelle_Salle;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Set<DocumentJustificatif> getJustificatifs() {
        return justificatifs;
    }

    public void setJustificatifs(Set<DocumentJustificatif> justificatifs) {
        this.justificatifs = justificatifs;
    }

    @Override
    public String toString() {
        return "SeanceCours{" + "identifiantSeance=" + identifiantSeance + ", libelle_Salle=" + libelle_Salle + ", dateDebutSeanceCours=" + dateDebutSeanceCours + ", dateFinSeanceCours=" + dateFinSeanceCours + ", valide=" + valide + ", matiere=" + matiere + ", enseignant=" + enseignant + ", groupe=" + groupe + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.identifiantSeance;
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
        final SeanceCours other = (SeanceCours) obj;
        if (this.identifiantSeance != other.identifiantSeance) {
            return false;
        }
        return true;
    }

    //Gestion des formats de dates
    public String getFormatDateDebutSeance() {
        return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(this.getDateDebutSeanceCours());
    }

//    public String getFormatDateDebutStat(){
//        return  new SimpleDateFormat("dd/MM/yyyy à hh:mm").format(this.getDateDebut());
//    }
    public String getFormatDateFinSeance() {
        return "- " + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(this.getDateFinSeanceCours());
    }

}
