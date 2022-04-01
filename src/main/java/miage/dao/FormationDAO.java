package miage.dao;

import java.util.List;
import miage.metier.Formation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormationDAO {

    public FormationDAO() {

    }

    //Création des formations
    public static void enregistrerFormation(Formation formation) {
        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            session.save(formation);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }

    //Recupérer la formation pour pouvoir l'affecter à un groupe
    public Formation recupererFormationIPM(int idFormation) {

        Formation formation = null;

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            formation = session.get(Formation.class, idFormation);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }

        return formation;
    }

    //Recupérer la formation pour pouvoir l'affecter à un groupe
    public Formation recupererFormationISIAD(int idFormation) {

        Formation formation = null;

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            formation = session.get(Formation.class, idFormation);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }

        return formation;
    }
    //HQL: afficher tous les formations
    public static List<Formation> afficherFormations() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.Formation");

            List<Formation> listeFormations = q.list();

            session.close();

            return listeFormations;
        }
    }

}
