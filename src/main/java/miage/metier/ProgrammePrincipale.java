package miage.metier;

import donnees.InsertionDonnes;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import miage.dao.*;

public class ProgrammePrincipale {

    public static void main(String[] args) throws ParseException {
        /*----- Test -----*/
        //Enregistrer des formations dans BD
        InsertionDonnes donnees = new InsertionDonnes();
        EnseignantDAO e = new EnseignantDAO();
        MatiereDAO m = new MatiereDAO();
        SeanceCoursDAO s = new SeanceCoursDAO();
        GroupeDAO g = new GroupeDAO();
        EtudiantDAO etu = new EtudiantDAO();
        SeanceCoursDAO sc = new SeanceCoursDAO();
        /*
                    insererDocumentJustificatif();
        insererEnseignant();
        insererEtudiant();
        insererFicheAppel();
        insererFormations();
        insererGroupes();
        insererMatiere();
        insererScolarite();
        insererSeancesCours();
        insererUtilisateur();
         */
////        
//        donnees.insererFormations();
//        donnees.insererEnseignant();
//        donnees.insererGroupes();
//        donnees.insererEtudiant();
//        //donnees.insererFicheAppel();
//        donnees.insererMatiere();
//        donnees.insererScolarite();
//        donnees.insererSeancesCours();

        //donnees.insererFicheAppel();
        System.out.println("Recherche d'un enseignant");
        System.out.println("------------------------Debut--------------------------------------------------");
        // List<Enseignant> afficherEnseignants() 
        //List<Enseignant> ens = new ArrayList<>();
        //  EnseignantDAO  en = n EnseignantDAO.afficherUnEnseignant(1)){
//        System.out.println("L'enseignant " + e.afficherUnEnseignant(1));
//
//        //e.afficherUnEnseignant(1);
//        System.out.println("---------------------------FIN-----------------------------------------------");
//        System.out.println("*************************************DEBUT MATIERE*******************");
//
//        //System.out.println("La matiere" + m.afficherUneMatiere(1));
//        System.out.println("***********************FIN MATIERE*****************************");
//
//        System.out.println("*************************************DEBUT MATIERE*******************");
//        System.out.println("La seance " + s.afficherUneSeanceCours(1));
//        System.out.println("***********************FIN *****************************");
//
//        System.out.println("*************************************DEBUT *******************");
//        System.out.println("==================Les étudiants du groupe 1 ");
//        for (Etudiant etudiants : etu.afficherListeEtudiantsGroupe(1)) {
//            System.out.println(etudiants);
//        }
//
//        System.out.println("***********************FIN *****************************");
//        System.out.println("Les étudiants de la formation 1 et du groupe 3");
//
//        for (Etudiant etudiants : etu.afficherListeEtudiantsFormation(1, 3)) {
//            System.out.println(etudiants);
//        }
//
//        System.out.println("*************************************DEBUT *******************");
//        System.out.println("Retrait d'un étudiant sur la fiche d'appel");
//        etu.retiterEtudiantFiche(6);
//
//        System.out.println("***********************FIN *****************************");
//        System.out.println("*************************************DEBUT *******************");
//
//        System.out.println("Nombre de séance  " + sc.afficherNbSeance(3, 1, 1, 2));
//
//        System.out.println("***********************FIN *****************************");
//
//        System.out.println("*************************************DEBUT *******************");
//        etu.ajouterEtudiantCours(3, 14);
//
//        System.out.println("***********************FIN *****************************");
//
//        System.out.println("*************************************DEBUT *******************");
//        List<SeanceCours> seancesEnseignant = SeanceCoursDAO.afficherSeancesCoursEnseignants(1);
//        System.out.println("seancesEnseignant : " + seancesEnseignant);
//        System.out.println("***********************FIN *****************************");

        //afficherNbSeance(int idGroupe, int idMatiere, int identifiantEnseignant, int identifiantSeance)
//        System.out.println("*************************************DEBUT *******************");
//        List<Etudiant> etudiantsAjouter = EtudiantDAO.afficherListeEtudiantsFormation(1, 1);
//        System.out.println("etudiantsAjouter : " + etudiantsAjouter);
//
//        System.out.println("***********************FIN *****************************");
//        
//        System.out.println("*************************************DEBUT *******************");
//        FicheAppelDAO.pointerPresence(14, 1, "Present");
//        System.out.println("seancesValides : " + seancesValides);
//
//        System.out.println("***********************FIN *****************************");
//        System.out.println("*************************************DEBUT *******************");
//        FicheAppel maPresence = FicheAppelDAO.afficherPresenceEtudiant(13, 1);
//        System.out.println("maPresence : " + maPresence);
//
//        System.out.println("***********************FIN *****************************");
//        System.out.println("*************************************DEBUT *******************");
////        Utilisateur utilisateur = UtilisateurDAO.rechercherUtilisateur("raphaelle.Bour@ut-capitole.fr");
////        System.out.println("utilisateur = " + utilisateur);
//        List<CoursAbsents> coursAbsent = CoursAbsentsDAO.afficherSeancesAbsentsEtudiant(6);
//        System.out.println("coursAbsent = " + coursAbsent);
//        for (CoursAbsents acb : coursAbsent) {
//            System.out.println("acb = " + acb);
//        }
//        DocumentJustificatif doc = DocumentJustificatifDAO.chargerJustificatif(6, 35);
//        System.out.println("doc = " + doc);
////        FicheAppel fichea = FicheAppelDAO.chargerFicheAppel(11, 35);
//        System.out.println("fichea = " + fichea);
        System.out.println("***********************FIN *****************************");


        /*----- Exit -----*/
        System.exit(0);
    }

    public static void affichage(List l) {
        Iterator e = l.iterator();
        while (e.hasNext()) {
            Object[] tab_obj = ((Object[]) e.next());

            for (Object obj : tab_obj) {
                System.out.print(obj + " ");
            }

            System.out.println("");
        }
    }

}
