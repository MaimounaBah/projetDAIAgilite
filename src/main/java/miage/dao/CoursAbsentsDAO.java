package miage.dao;

import java.util.List;
import miage.metier.CoursAbsents;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CoursAbsentsDAO {

    public CoursAbsentsDAO() {
    }

    //Afficher tous les seances de cours absents d'un etudiant
    public static List<CoursAbsents> afficherSeancesAbsentsEtudiant(int identifiantEtudiant) {
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            org.hibernate.query.Query q = session.createQuery("select new miage.metier.CoursAbsents(sc.identifiantSeance, m.libelleMatiere, sc.dateDebutSeanceCours, sc.dateFinSeanceCours, e.nomUtilisateur, e.prenomUtilisateur, fo.libelleFormation, g.libelleGroupe) "
                    + "from miage.metier.SeanceCours sc, miage.metier.FicheAppel f, miage.metier.Matiere m, miage.metier.Enseignant e, miage.metier.Formation fo, miage.metier.Groupe g "
                    + "where f.seanceCours.identifiantSeance = sc.identifiantSeance "
                    + "and sc.matiere.idMatiere = m.idMatiere "
                    + "and sc.groupe.idGroupe = g.idGroupe "
                    + "and g.formation.idFormation = fo.idFormation "
                    + "and sc.enseignant.identifiantUtilisateur = e.identifiantUtilisateur "
                    + "and f.etudiant.identifiantUtilisateur = :identifiantEtudiant "
                    + "and f.etat_presence like 'abs%'");
            q.setParameter("identifiantEtudiant", identifiantEtudiant);
            List<CoursAbsents> listeCoursAbsents = q.list();
            session.close();

            return listeCoursAbsents;
        }
    }

//    public void afficherSeancesAbsentsEtudiant2(int identifiantEtudiant) {
//        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
//            Transaction t = session.beginTransaction();
//
//            Query q = session.createQuery("from miage.metier.SeanceCours sc, miage.metier.FicheAppel f "
//                    + "where f.seanceCours.identifiantSeance = sc.identifiantSeance "
//                    + "and f.etudiant.identifiantUtilisateur = :identifiantEtudiant "
//                    + "and f.etat_presence = 'absent'");
//
//            q.setParameter("identifiantEtudiant", identifiantEtudiant);
//
//            List<CoursAbsents> liste = (List<CoursAbsents>) q.list();
//            for (CoursAbsents n : liste) {
//                System.out.println(n);
//            }
//
//            session.close();
//        }
//    }
}
