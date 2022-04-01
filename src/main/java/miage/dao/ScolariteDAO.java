package miage.dao;

import miage.metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ScolariteDAO {

    
    
    public ScolariteDAO(){
        
    }
    
    //   Création de la scolarité
    public static void enregistrerScolarite(Scolarite scolarite) {
        /*----- Ouverture de la session -----*/
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            session.save(scolarite);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }
}
