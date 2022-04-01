package miage.metier;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class DocumentJustificatif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identifiantDocument;

    private String nomDocumentJustificatif;
    private String typeDocumentJustificatif;
    private String texteJustificatif;

    @CreationTimestamp
    private Date dateEnvoieJustificatif;

    private boolean justificatifValidee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "identifiantEtudiant")
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "identifiantSeance")
    private SeanceCours seanceCours;

    //Constructeur 
    public DocumentJustificatif() {

    }

    public DocumentJustificatif(int identifiantDocument, String nomDocumentJustificatif, String typeDocumentJustificatif, String texteJustificatif, Date dateEnvoieJustificatif, boolean justificatifValidee, Etudiant etudiant) {
        this.identifiantDocument = identifiantDocument;
        this.nomDocumentJustificatif = nomDocumentJustificatif;
        this.typeDocumentJustificatif = typeDocumentJustificatif;
        this.texteJustificatif = texteJustificatif;
        this.dateEnvoieJustificatif = dateEnvoieJustificatif;
        this.justificatifValidee = justificatifValidee;
        this.etudiant = etudiant;
    }

    public DocumentJustificatif(int identifiantDocument, String nomDocumentJustificatif, String typeDocumentJustificatif, String texteJustificatif, Date dateEnvoieJustificatif) {
        this.identifiantDocument = identifiantDocument;
        this.nomDocumentJustificatif = nomDocumentJustificatif;
        this.typeDocumentJustificatif = typeDocumentJustificatif;
        this.texteJustificatif = texteJustificatif;
        this.dateEnvoieJustificatif = dateEnvoieJustificatif;
    }

    public DocumentJustificatif(int identifiantDocument, String nomDocumentJustificatif, String typeDocumentJustificatif, String texteJustificatif, Date dateEnvoieJustificatif, boolean justificatifValidee, Etudiant etudiant, SeanceCours seanceCours) {
        this.identifiantDocument = identifiantDocument;
        this.nomDocumentJustificatif = nomDocumentJustificatif;
        this.typeDocumentJustificatif = typeDocumentJustificatif;
        this.texteJustificatif = texteJustificatif;
        this.dateEnvoieJustificatif = dateEnvoieJustificatif;
        this.justificatifValidee = justificatifValidee;
        this.etudiant = etudiant;
        this.seanceCours = seanceCours;
    }

    public int getIdentifiantDocument() {
        return identifiantDocument;
    }

    public void setIdentifiantDocument(int identifiantDocument) {
        this.identifiantDocument = identifiantDocument;
    }

    public String getNomDocumentJustificatif() {
        return nomDocumentJustificatif;
    }

    public void setNomDocumentJustificatif(String nomDocumentJustificatif) {
        this.nomDocumentJustificatif = nomDocumentJustificatif;
    }

    public String getTypeDocumentJustificatif() {
        return typeDocumentJustificatif;
    }

    public void setTypeDocumentJustificatif(String typeDocumentJustificatif) {
        this.typeDocumentJustificatif = typeDocumentJustificatif;
    }

    public String getTexteJustificatif() {
        return texteJustificatif;
    }

    public void setTexteJustificatif(String texteJustificatif) {
        this.texteJustificatif = texteJustificatif;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Date getDateEnvoieJustificatif() {
        return dateEnvoieJustificatif;
    }

    public void setDateEnvoieJustificatif(Date dateEnvoieJustificatif) {
        this.dateEnvoieJustificatif = dateEnvoieJustificatif;
    }

    public boolean isJustificatifValidee() {
        return justificatifValidee;
    }

    public void setJustificatifValidee(boolean justificatifValidee) {
        this.justificatifValidee = justificatifValidee;
    }

    public SeanceCours getSeanceCours() {
        return seanceCours;
    }

    public void setSeanceCours(SeanceCours seanceCours) {
        this.seanceCours = seanceCours;
    }

    @Override
    public String toString() {
        return "DocumentJustificatif{" + "identifiantDocument=" + identifiantDocument + ", nomDocumentJustificatif=" + nomDocumentJustificatif + ", typeDocumentJustificatif=" + typeDocumentJustificatif + ", texteJustificatif=" + texteJustificatif + ", dateEnvoieJustificatif=" + dateEnvoieJustificatif + ", justificatifValidee=" + justificatifValidee + ", etudiant=" + etudiant + ", seanceCours=" + seanceCours + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.identifiantDocument;
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
        final DocumentJustificatif other = (DocumentJustificatif) obj;
        if (this.identifiantDocument != other.identifiantDocument) {
            return false;
        }
        return true;
    }

}
