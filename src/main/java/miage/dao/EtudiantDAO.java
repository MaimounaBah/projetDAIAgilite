package miage.dao;

import java.util.List;
import miage.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EtudiantDAO {

    public EtudiantDAO() {

    }

    //Création des etudiants
    public static void enregistrerEtudiants(Etudiant etudiant) {
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();

            session.save(etudiant);

            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }

    //HQL: afficher  les informations des étudiants d'un groupe donné
    public static List<Etudiant> afficherListeEtudiantsGroupe(int identifiantGroupe) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from  miage.metier.Etudiant e WHERE e.groupe.idGroupe = :identifiantGroupe AND e.cache = 0");
            q.setParameter("identifiantGroupe", identifiantGroupe);

            List<Etudiant> etudiants = q.list();
            session.close();
            return etudiants;
        }
    }

    //Afficher les etudiants d'une formation donne qui ne sont pas dans un groupe donnne
    public static List<Etudiant> afficherListeEtudiantsFormation(int identifiantFormation, int identifiantGroupe) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Query listeEtudiants = session.createQuery("SELECT new miage.metier.Etudiant(e.identifiantUtilisateur, e.prenomUtilisateur,e.nomUtilisateur)"
                    + " FROM miage.metier.Etudiant e, miage.metier.Groupe g"
                    + " WHERE  e.groupe.idGroupe =  g.idGroupe"
                    + " AND g.formation.idFormation = :identifiantFormation"
                    + " AND e.identifiantUtilisateur NOT IN ( "
                    + " SELECT e1.identifiantUtilisateur FROM miage.metier.Etudiant e1 "
                    + " WHERE e1.groupe.idGroupe = :identifiantGroupe"
                    + " AND e1.cache = false) ");

            listeEtudiants.setParameter("identifiantFormation", identifiantFormation);
            listeEtudiants.setParameter("identifiantGroupe", identifiantGroupe);

            List<Etudiant> etudiants = listeEtudiants.list();
            session.close();
            return etudiants;
        }
    }

    //Méthode pour supprimer un étudiant de la fiche d'appel (bd non modifiee)
    public static void retiterEtudiantFiche(int identifiantUtilisateur) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            //Recupération l'étudiant correspondant
            Etudiant e = session.get(Etudiant.class, identifiantUtilisateur);
            e.setCache(true);
            session.update(e);
            t.commit();
            session.close();

        }
    }

    public static void ajouterEtudiantCours(int idGroupe, int identifiantUtilisateur) {
        //  String sql = "UPDATE `etudiant` SET `Cache` = b'0', `ID_Groupe` = ? WHERE `etudiant`.`Login_Etudiant` = ?";
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            //Recupération l'étudiant correspondant
            Etudiant e = session.get(Etudiant.class, identifiantUtilisateur);
            Groupe g = session.get(Groupe.class, idGroupe);
            e.setCache(false);
            e.setGroupe(g);
            session.update(e);
            t.commit();
            session.close();
        }
    }
    
    //Rechercher un etudiant (à gérer les sessions après)
    public static Etudiant rechercherEtuduant(int identifiantEtudiant) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(Etudiant.class, identifiantEtudiant);
        }
    }
}
