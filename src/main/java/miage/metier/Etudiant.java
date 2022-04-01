package miage.metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Etudiant")
@PrimaryKeyJoinColumn
public class Etudiant extends Utilisateur {

    @Column(name = "Photo")
    private String photo;

    @Column(name = "Statut")
    private String statut;

    @Column(name = "Cache")
    private boolean cache;

    //Relation entre Etudiant et Groupe
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Groupe")
    private Groupe groupe;

    //Relation entre Etudiant et DOcument Justitificatif cours
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DocumentJustificatif> justificatifs = new HashSet<>();

    //Relations
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "identifiantSeance")
    private Map<SeanceCours, FicheAppel> ficheAppelSeance = new HashMap(0);

//Constructeurs
    public Etudiant() {
    }

    //Constructeur pour charger tous les etudiants
    public Etudiant(int identifiantEtudiant, String prenomEtudiant, String nomEtudiant, String mailEtudiant, String passwordEtudiant, String role) {
        super(identifiantEtudiant, prenomEtudiant, nomEtudiant, mailEtudiant, passwordEtudiant, role);
    }

    public Etudiant(int identifiantEtudiant, String prenomEtudiant, String nomEtudiant, String mailEtudiant, String passwordEtudiant, String photo, String role, String statut, boolean cache, Groupe groupe) {
        super(identifiantEtudiant, prenomEtudiant, nomEtudiant, mailEtudiant, passwordEtudiant, role);
        this.photo = photo;
        this.statut = statut;
        this.cache = cache;
        this.groupe = groupe;
    }

    public Etudiant(int identifiantUtilisateur, String prenomUtilisateur, String nomUtilisateur){
        super(identifiantUtilisateur, prenomUtilisateur, nomUtilisateur);
    }
    
    public Etudiant(String prenomEtudiant, String nomEtudiant, String loginEtudiant, String passwordEtudiant, String photo, String role, String statut, boolean cache, Groupe groupe) {
        super(prenomEtudiant, nomEtudiant, loginEtudiant, passwordEtudiant, role);
        this.photo = photo;
        this.statut = statut;
        this.cache = cache;
        this.groupe = groupe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public Set<DocumentJustificatif> getJustificatifs() {
        return justificatifs;
    }

    public void setJustificatifs(Set<DocumentJustificatif> justificatifs) {
        this.justificatifs = justificatifs;
    }

    public Map<SeanceCours, FicheAppel> getFicheAppelSeance() {
        return ficheAppelSeance;
    }

    public void setFicheAppelSeance(Map<SeanceCours, FicheAppel> ficheAppelSeance) {
        this.ficheAppelSeance = ficheAppelSeance;
    }

}
