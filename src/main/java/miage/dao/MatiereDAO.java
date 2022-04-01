package miage.dao;

import miage.metier.Matiere;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatiereDAO {

    //Création des matières
    public static void enregistrerMatiere(Matiere matiere) {
        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();

            session.save(matiere);

            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }

    //Recupérer la matière
    public Matiere recupererMatiere(int idMatiere) {

        //
        Matiere matiere = null;

        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            matiere = session.get(Matiere.class, idMatiere);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }

        return matiere;
    }
    
    
    
    
     //HQL: afficher tous les enseignants
    public  Matiere afficherUneMatiere(int identifiantMatiere) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("from miage.metier.Matiere  m WHERE m.idMatiere = :identifiantMatiere");
            q.setParameter("identifiantMatiere", identifiantMatiere);
               
                           Matiere matiere = (Matiere) q.uniqueResult();
                          session.close();
                            return matiere;
        }
    }

    //Rechercher une matiere
    public Matiere rechercherMatiere(int identifiantMatiere) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(Matiere.class, identifiantMatiere);
        }
    }
    
    

//    //Recupérer les matières de l'enseignant identifiantEnseignant
//    public List<Matiere> recupererMatieres(int identifiantEnseignant) {
//        String hql = " SELECT DISTINCT c FROM  Cours c, SeanceCours sc " +
//                     " where sc.enseignant.id = :enseignantId " +
//                     " and ci.cours.id = c.id ";
//        List<Matiere> cours = new ArrayList<>();
//        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
//               Query<Matiere> query = session.createQuery(hql);
//            query.setParameter("identifiantEnseignant", identifiantEnseignant);
//            if (!query.getResultList().isEmpty()) {
//                cours = query.getResultList();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return cours;
//    }
}
