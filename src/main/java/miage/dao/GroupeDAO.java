package miage.dao;

import java.text.ParseException;
import miage.metier.Formation;
import miage.metier.Groupe;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupeDAO {

    public GroupeDAO() {

    }

//    //Création des groupes
    public static void enregistrerGroupes(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            session.save(groupe);
            t.commit();
            session.close();
        }
    }

    //Recupérer le groupe  pour pouvoir affecter étudiant
    public Groupe recupererGroupe(int idGroupe) {

        //
        Groupe groupe = null;

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            groupe = session.get(Groupe.class, idGroupe);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
        return groupe;

    }

    //Rechercher un groupe
    public Groupe rechercherGroupe(int identifiantEnseignant) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(Groupe.class, identifiantEnseignant);
        }
    }

}
