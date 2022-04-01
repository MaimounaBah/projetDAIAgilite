package miage.dao;

import java.util.List;
import miage.metier.Enseignant;
import miage.metier.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnseignantDAO {

    public EnseignantDAO() {

    }

//   Création des enseignants
    public static void enregistrerEnseignant(Enseignant enseignant) {
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            session.save(enseignant);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }

    //HQL: afficher tous les enseignants
    public static List<Enseignant> afficherEnseignants() {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.Enseignant");

            List<Enseignant> listeEnseignants = q.list();

            session.close();

            return listeEnseignants;
        }
    }

    //Fonction pour les tests (à delete)
    //: rechercher un enseignant avec un identifiant
    //HQL: afficher tous les enseignants
    public static Enseignant afficherUnEnseignant(int identifiantEnseignant) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.Enseignant  e WHERE e.identifiantUtilisateur = :identifiantEnseignant");
            q.setParameter("identifiantEnseignant", identifiantEnseignant);

            Enseignant enseignant = (Enseignant) q.uniqueResult();
            session.close();
            return enseignant;
        }
    }

    //Rechercher un enseignant (à gérer les sessions après)
    public static Enseignant rechercherEnseignant(int identifiantEnseignant) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(Enseignant.class, identifiantEnseignant);
        }
    }

}
