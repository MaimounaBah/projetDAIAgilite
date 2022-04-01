package miage.dao;

import miage.metier.Etudiant;
import miage.metier.FicheAppel;
import miage.metier.FicheAppelID;
import miage.metier.SeanceCours;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FicheAppelDAO {

    public FicheAppelDAO() {

    }

    //Rechercher une fiche d'appel
    public FicheAppel rechercherFicheAppel(int identifiantFiche) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            return session.get(FicheAppel.class, identifiantFiche);
        }
    }

    //pointer la présence d'un etudiant pour un seance donnee
    public static void pointerPresence(int identifiantEtudiant, int identifiantSeance, String presence) {
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            FicheAppelID idFiche = new FicheAppelID(identifiantEtudiant, identifiantSeance);
            FicheAppel ficheAppel = new FicheAppel(idFiche, presence);
            session.save(ficheAppel);
            t.commit(); // Commit et flush automatique de la session.
            session.close();
        }
    }

    //Savoir si un eleve ete absent a une seance
    public static FicheAppel afficherPresenceEtudiant(int identifiantEtudiant, int identifiantSeance) {
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            /*----- Ouverture d'une transaction -----*/
            Transaction t = session.beginTransaction();
            FicheAppelID idFiche = new FicheAppelID(identifiantEtudiant, identifiantSeance);
            return session.get(FicheAppel.class, idFiche);
        }
    }

    //Mise a jour presence d'un etudiant poiur un seance (absence justifiee)
    public static void justifierAbsence(int identifiantUtilisateur, int identifiantSeanceCours) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            //Recupération l'étudiant correspondant            
            FicheAppelID idFiche = new FicheAppelID(identifiantUtilisateur, identifiantSeanceCours);
            FicheAppel f = session.get(FicheAppel.class, idFiche);
            f.setEtat_presence("absence justifie");

            session.update(f);
            t.commit();
            session.close();
        }
    }

    //charger une fiche d'appel
    public static FicheAppel chargerFicheAppel(int identifiantUtilisateur, int identifiantSeanceCours) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            FicheAppelID idFiche = new FicheAppelID(identifiantUtilisateur, identifiantSeanceCours);
            return session.get(FicheAppel.class, idFiche);
        }
    }
}
