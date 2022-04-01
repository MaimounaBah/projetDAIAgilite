package miage.dao;

import java.util.List;
import miage.metier.SeanceCours;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SeanceCoursDAO {

    public SeanceCoursDAO() {
    }

    //    //Création des seances de cours
    public static void enregistrerSeanceCours(SeanceCours seanceCours) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            session.save(seanceCours);
            t.commit();
            session.close();
        }
    }

    //HQL: afficher  les informations d'une seance de cours
    public SeanceCours afficherUneSeanceCours(int identifiantSeance) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.SeanceCours  s WHERE s.identifiantSeance = :identifiantSeance");
            q.setParameter("identifiantSeance", identifiantSeance);

            SeanceCours seanceCours = (SeanceCours) q.uniqueResult();
            session.close();
            return seanceCours;
        }
    }

    //Trouver le nombre de séances d'une matière
    public static long afficherNbSeance(int idGroupe, int idMatiere, int identifiantEnseignant, int identifiantSeance) {

        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Query listesSeances = session.createQuery(" SELECT COUNT(*) "
                    + " FROM  miage.metier.SeanceCours  sc"
                    + " WHERE  sc.groupe.idGroupe =  :idGroupe"
                    + " AND sc.matiere.idMatiere = :idMatiere"
                    + " AND sc.enseignant.identifiantUtilisateur = :identifiantEnseignant"
                    + " AND sc.identifiantSeance <= :identifiantSeance");

            listesSeances.setParameter("idGroupe", idGroupe);
            listesSeances.setParameter("idMatiere", idMatiere);
            listesSeances.setParameter("identifiantEnseignant", identifiantEnseignant);
            listesSeances.setParameter("identifiantSeance", identifiantSeance);

            long seances = (Long) listesSeances.uniqueResult();
            session.close();
            return seances;
        }

    }

    //Afficher toutes les séances de cours d'un enseignant
    // ordonner par ordre décroissant : 
//    select*
//from SeanceCours sc  
//WHERE identifiantUtilisateur = 1
//ORDER BY sc.dateDebutSeanceCours DESC;
    public static List<SeanceCours> afficherSeancesCoursEnseignants(int identifiantEns) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery(" from miage.metier.SeanceCours sc  WHERE sc.enseignant.identifiantUtilisateur = :identifiantEns ORDER BY sc.dateDebutSeanceCours DESC");
            q.setParameter("identifiantEns", identifiantEns);
            List<SeanceCours> listeSeancesCours = q.list();
            session.close();

            return listeSeancesCours;
        }
    }
    //Afficher toutes les séances validees d'un enseignant

    public static List<SeanceCours> afficherSeancesValidesEnseignants(int identifiantEns) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery(" from miage.metier.SeanceCours sc  WHERE sc.enseignant.identifiantUtilisateur = :identifiantEns and sc.valide='1' ORDER BY sc.dateDebutSeanceCours DESC");
            q.setParameter("identifiantEns", identifiantEns);
            List<SeanceCours> listeSeancesCours = q.list();
            session.close();

            return listeSeancesCours;
        }
    }
    //Rechercher un enseignant (à gérer les sessions après)

    public static SeanceCours rechercherSeance(int identifiantSeance) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(SeanceCours.class, identifiantSeance);
        }
    }

    public static void validerSeance(int identifiantSeance) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            //Recupération l'étudiant correspondant
            SeanceCours s = session.get(SeanceCours.class, identifiantSeance);
            s.setValide(true);
            session.update(s);
            t.commit();
            session.close();

        }
    }

}
