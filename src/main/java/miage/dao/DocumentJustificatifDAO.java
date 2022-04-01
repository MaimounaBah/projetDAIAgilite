package miage.dao;

import java.util.Date;
import java.util.List;
import miage.metier.DocumentJustificatif;
import miage.metier.Etudiant;
import miage.metier.SeanceCours;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DocumentJustificatifDAO {

    public DocumentJustificatifDAO() {

    }

    //enregistrer un justificatif
    public static void deposerJustificatif(String nomJustificatif, String typeJustificatif, String texteJustificatif, int idEtudiant, int idSeanceCours) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            DocumentJustificatif dj = new DocumentJustificatif();

            Date date = new Date();

            dj.setDateEnvoieJustificatif(date);
            dj.setJustificatifValidee(false);
            dj.setNomDocumentJustificatif(nomJustificatif);
            dj.setTexteJustificatif(texteJustificatif);
            dj.setTypeDocumentJustificatif(typeJustificatif);
            Etudiant e = session.get(Etudiant.class, idEtudiant);
            dj.setEtudiant(e);
            SeanceCours sc = session.get(SeanceCours.class, idSeanceCours);
            dj.setSeanceCours(sc);
            session.save(dj);

            int idj = dj.getIdentifiantDocument();
            DocumentJustificatif d1 = session.get(DocumentJustificatif.class, idj);

            t.commit();
            session.close();

        }
    }

    //Afficher tous les justificatifs pour la scolarite
    public static List<DocumentJustificatif> afficherTousJustificatifs() {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.DocumentJustificatif");

            List<DocumentJustificatif> listeJustificatifs = q.list();

            session.close();

            return listeJustificatifs;
        }
    }

    //Afficher les informations detailles d'un idJustificatif donne
    public static DocumentJustificatif afficherUnJustificatifs(int idJustificatif) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.DocumentJustificatif  j WHERE j.identifiantDocument = :idJustificatif");
            q.setParameter("idJustificatif", idJustificatif);

            DocumentJustificatif justificatif = (DocumentJustificatif) q.uniqueResult();
            session.close();
            return justificatif;
        }
    }

    //Mettre a jour l'etat de justificatif (valider le justificatif)
    public static void validerJustificatif(int idJustificatif) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            //Recupération l'étudiant correspondant
            DocumentJustificatif dj = session.get(DocumentJustificatif.class, idJustificatif);
            dj.setJustificatifValidee(true);
            session.update(dj);
            t.commit();
            session.close();
        }
    }
    
    //Afficher les informations detailles d'un Justificatif donne
    public static DocumentJustificatif chargerJustificatif(int idEtudiant, int idSceance) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.DocumentJustificatif  j WHERE j.etudiant.identifiantUtilisateur = :idEtudiant AND j.seanceCours.identifiantSeance = :idSceance");
            q.setParameter("idEtudiant", idEtudiant);
            q.setParameter("idSceance", idSceance);

            DocumentJustificatif justificatif = (DocumentJustificatif) q.uniqueResult();
            session.close();
            return justificatif;
        }
    }

}
