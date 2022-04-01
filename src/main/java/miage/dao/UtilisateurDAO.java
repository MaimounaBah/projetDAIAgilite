package miage.dao;

import miage.metier.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UtilisateurDAO {

    public UtilisateurDAO() {

    }

    //    //Création des utilisateurs
    public static void enregistrerGroupes(Utilisateur utilisateur) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            session.save(utilisateur);
            t.commit();
            session.close();
        }
    }

    //Fonction de connexion d'un utilisateur
    public static Integer connexionUtilisateur(String mailUtilisateur, String pwdUtilisateur) {
        Integer utilisateurId = null;
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            Query<Integer> query = session.createQuery("SELECT user.identifiantUtilisateur "
                    + "FROM miage.metier.Utilisateur user "
                    + "WHERE user.mailUtilisateur = :mailUtilisateur "
                    + "and user.pwdUtilisateur = :pwdUtilisateur");
            query.setParameter("mailUtilisateur", mailUtilisateur);
            query.setParameter("pwdUtilisateur", pwdUtilisateur);
            if (!query.getResultList().isEmpty()) {
                utilisateurId = query.uniqueResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateurId;
    }

    //Vérification de l'existance du mail
    public static boolean emailExiste(String mailUtilisateur) {
        String hql = "SELECT  user FROM Utilisateur user WHERE user.mailUtilisateur = :mailUtilisateur";
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            Query<Utilisateur> q = session.createQuery(hql, Utilisateur.class);
            q.setParameter("mailUtilisateur", mailUtilisateur);
            if (!q.getResultList().isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Afficher le nom et le prenom d'un utilisateur
    public static Utilisateur rechercherUtilisateur(String mailUtilisateur) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            Query utilisateur = session.createQuery(" FROM miage.metier.Utilisateur u"
                    + " WHERE  u.mailUtilisateur =:mailUtilisateur "
            );
            utilisateur.setParameter("mailUtilisateur", mailUtilisateur);
            Utilisateur user = (Utilisateur) utilisateur.uniqueResult();
            session.close();
            return user;

        }
    }
 //Rechercher un enseignant (à gérer les sessions après)
    public static Utilisateur chargerUtilisateur(int identifiantUtilisateur) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(Utilisateur.class, identifiantUtilisateur);
        }
    }

}
