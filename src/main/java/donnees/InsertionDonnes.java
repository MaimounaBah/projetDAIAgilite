package donnees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import miage.dao.*;
import miage.metier.Enseignant;
import miage.metier.Etudiant;
import miage.metier.Formation;
import miage.metier.Groupe;
import miage.metier.Matiere;
import miage.metier.Scolarite;
import miage.metier.SeanceCours;

public class InsertionDonnes {

    public InsertionDonnes() {

    }

    public static final SimpleDateFormat DF = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
    public static DocumentJustificatifDAO documentJustDOA = new DocumentJustificatifDAO();
    public static EnseignantDAO enseignantDAO = new EnseignantDAO();
    public static EtudiantDAO etudiantDAO = new EtudiantDAO();
    public static FicheAppelDAO ficheAppelDAO = new FicheAppelDAO();
    public static FormationDAO formationDAO = new FormationDAO();
    public static GroupeDAO groupeDAO = new GroupeDAO();
    public static MatiereDAO matierreDAO = new MatiereDAO();
    public static ScolariteDAO scolariteDAO = new ScolariteDAO();
    public static SeanceCoursDAO seanceCoursDAO = new SeanceCoursDAO();
    public static UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public static void inserer() throws ParseException {

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

    }

    private static void insererDocumentJustificatif() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void insererEnseignant() {
        ArrayList<Enseignant> enseignants = new ArrayList<>(Arrays.asList(
                new Enseignant("Raphaelle", "BOUR", "raphaelle.Bour@ut-capitole.fr", "bour", "enseignant", "photosEtu/lbour.jpg"),
                new Enseignant("Nathalie", "VALLES", "nathalie.valles-parlangeau@ut-capitole.fr", "valles", "enseignant", "photosEtu/valles.jpg"),
                new Enseignant("Franck", "RAVAT", "franck.ravat@ut-capitole.fr", "franck", "enseignant", "photosEtu/ravat.jpg"),
                new Enseignant("Eric", "ANDONOFF", "eric.andonoff@ut-capitole.fr", "eric", "enseignant", "photosEtu/login.jpg"),
                new Enseignant("Alain", "BERRO", "alain.berro@ut-capitole.fr", "berro", "enseignant", "photosEtu/berroAlain.jpg")
        ));

        for (Enseignant lEnseignant : enseignants) {
            enseignantDAO.enregistrerEnseignant(lEnseignant);
        }
    }

    public static void insererEtudiant() {
        ArrayList<Etudiant> etudiants = new ArrayList<>(Arrays.asList(
                new Etudiant("Milo", "PARRA", "milo@gmail.com", "123", "photosEtu/milo.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Wenhui", "GAN", "vivi@gmail.com", "123", "photosEtu/vivi.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Maimouna", "BAH", "mouna@gmail.com", "123", "photosEtu/mouna.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Sebastian", "NOGALES", "seb@gmail.com", "123", "photosEtu/nogales.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Xiaofei", "Wang", "rose@gmail.com", "123", "photosEtu/xiaofei.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Zixin", "PU", "zixin@gmail.com", "123", "photosEtu/zixin.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Haoyang", "YU", "yu@gmail.com", "123", "photosEtu/haoyang.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Ten", "DAT", "dat@gmail.com", "123", "photosEtu/dat.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(1)),
                new Etudiant("Ruddy", "MONLOUIS", "ruddy@gmail.com", "123", "photosEtu/ruddy.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(1)),
                new Etudiant("Btissam", "NACHIT", "tissam@gmail.com", "123", "photosEtu/tissam.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(1)),
                new Etudiant("Mehdi", "MOURI", "mouri@gmail.com", "123", "photosEtu/mehdi.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Vlada", "STEGARESCU", "vlada@gmail.com", "123", "photosEtu/vlada.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(1)),
                new Etudiant("Zijian", "LI", "li@gmail.com", "123", "photosEtu/zijian.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Yuni", "CHEN", "yuni@gmail.com", "123", "photosEtu/yuni.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(3)),
                new Etudiant("Zijing", "ZHOU", "zhou@gmail.com", "123", "photosEtu/zhou.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(1)),
                new Etudiant("Amir", "SAID", "amir@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(4)),
                new Etudiant("Yifen", "ZENG", "yifen@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(2)),
                new Etudiant("Wan", "JIN", "wan@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(4)),
                new Etudiant("Andres", "Ortiz", "andres@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(2)),
                new Etudiant("David", "GOMEZ", "david@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FI", false, groupeDAO.recupererGroupe(4)),
                new Etudiant("Aurelien", "MICOINE", "aurelien@gmail.com", "123", "photosEtu/zhou.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(2)),
                new Etudiant("Julia", "NADAL", "julia@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(2)),
                new Etudiant("Fabrice", "BECKER", "fabrice@gmail.com", "123", "photosEtu/login.jpg", "etudiant", "FA", false, groupeDAO.recupererGroupe(2))
        ));

        for (Etudiant lEtudiant : etudiants) {
            etudiantDAO.enregistrerEtudiants(lEtudiant);
        }
    }

    public static void insererFicheAppel() {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void insererFormations() {
        ArrayList<Formation> formations = new ArrayList<>(Arrays.asList(
                new Formation("Master 2 MIAGE  IPM"),
                new Formation("Master 2 MIAGE ISIAD")
        ));

        for (Formation laFormation : formations) {
            formationDAO.enregistrerFormation(laFormation);
        }
    }

    public static void insererGroupes() {
        ArrayList<Groupe> groupes = new ArrayList<>(Arrays.asList(
                new Groupe("FA IPM", formationDAO.recupererFormationIPM(1)),
                new Groupe("FA ISIAD", formationDAO.recupererFormationISIAD(2)),
                new Groupe("FI IPM", formationDAO.recupererFormationIPM(1)),
                new Groupe("FI ISIAD", formationDAO.recupererFormationISIAD(2))
        ));
        for (Groupe leGroupe : groupes) {
            groupeDAO.enregistrerGroupes(leGroupe);
        }
    }

    public static void insererMatiere() {

        ArrayList<Matiere> matieres = new ArrayList<>(Arrays.asList(
                new Matiere("Agilité"),
                new Matiere("SIAD"),
                new Matiere("Big Data "),
                new Matiere("DIA"),
                new Matiere("BPMN"),
                new Matiere("DAI"),
                new Matiere("IPM"),
                new Matiere("Data Mining"),
                new Matiere("PLSQL")
        ));

        for (Matiere laMatiere : matieres) {
            matierreDAO.enregistrerMatiere(laMatiere);
        }

    }

    public static void insererScolarite() {
        //  public Scolarite(int identifiantScolarite, String nomScolarite, String prenomScolarite, String mailScolarite, String MDP) {

        ArrayList<Scolarite> scolarite = new ArrayList<>(Arrays.asList(
                new Scolarite("Jerome", "BARATHIEU", "jerome.barathieu@ut-capitole.fr", "jerome", "scolarite")
        ));

        for (Scolarite laScolarite : scolarite) {
            scolariteDAO.enregistrerScolarite(laScolarite);
        }
    }

    public static void insererSeancesCours() {
        ArrayList<SeanceCours> seancesCours = null;
        try {
            seancesCours = new ArrayList<>(Arrays.asList(
                    //   SeanceCours(Enseignant enseignant, Matiere matiere, Groupe groupeEtudiant, Date dateDebutSeance, Date dateFinSeance, String libelleSalle) {
                    //Cours de Bour
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("01-02-2022 09:30:00"), DF.parse("01-02-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("01-02-2022 14:00:00"), DF.parse("01-02-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("02-02-2022 09:30:00"), DF.parse("02-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("02-02-2022 14:00:00"), DF.parse("02-02-2022 17:00:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("03-02-2022 09:30:00"), DF.parse("03-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("03-02-2022 14:00:00"), DF.parse("03-02-2022 17:00:00"), "MC05", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(4), DF.parse("04-02-2022 09:30:00"), DF.parse("04-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(4), DF.parse("04-02-2022 14:00:00"), DF.parse("04-02-2022 17:00:00"), "MC05", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("08-02-2022 09:30:00"), DF.parse("08-02-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("08-02-2022 14:00:00"), DF.parse("08-02-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("09-02-2022 09:30:00"), DF.parse("09-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("09-02-2022 14:00:00"), DF.parse("09-02-2022 17:00:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("10-02-2022 09:30:00"), DF.parse("10-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("10-02-2022 14:00:00"), DF.parse("10-02-2022 17:00:00"), "MC05", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(4), DF.parse("11-02-2022 09:30:00"), DF.parse("11-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(4), DF.parse("11-02-2022 14:00:00"), DF.parse("11-02-2022 17:00:00"), "MC05", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("15-02-2022 09:30:00"), DF.parse("15-02-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("15-02-2022 14:00:00"), DF.parse("15-02-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("16-02-2022 09:30:00"), DF.parse("16-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("16-02-2022 14:00:00"), DF.parse("16-02-2022 17:00:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("17-02-2022 09:30:00"), DF.parse("17-02-2022 12:30:00"), "MC405", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(2), DF.parse("17-02-2022 14:00:00"), DF.parse("17-02-2022 17:00:00"), "MC05", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(1), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(4), DF.parse("18-02-2022 09:30:00"), DF.parse("18-02-2022 12:30:00"), "MC405", false),
                    
                    //Cours de VALLES
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("01-03-2022 09:30:00"), DF.parse("01-03-2022 12:30:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("01-03-2022 14:00:00"), DF.parse("01-03-2022 17:00:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("02-03-2022 09:30:00"), DF.parse("02-03-2022 12:30:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("02-03-2022 14:00:00"), DF.parse("02-03-2022 17:00:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("03-03-2022 09:30:00"), DF.parse("03-03-2022 12:30:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("03-03-2022 14:00:00"), DF.parse("03-03-2022 17:00:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("04-03-2022 09:30:00"), DF.parse("04-03-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("04-03-2022 14:00:00"), DF.parse("04-03-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("08-03-2022 09:30:00"), DF.parse("08-03-2022 12:30:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("08-03-2022 14:00:00"), DF.parse("08-03-2022 17:00:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("09-03-2022 09:30:00"), DF.parse("09-03-2022 12:30:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("09-03-2022 14:00:00"), DF.parse("09-03-2022 17:00:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("10-03-2022 09:30:00"), DF.parse("10-03-2022 12:30:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("10-03-2022 14:00:00"), DF.parse("10-03-2022 17:00:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("11-03-2022 09:30:00"), DF.parse("11-03-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("11-03-2022 14:00:00"), DF.parse("11-03-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("15-03-2022 09:30:00"), DF.parse("15-03-2022 12:30:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("15-03-2022 14:00:00"), DF.parse("15-03-2022 17:00:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("16-03-2022 09:30:00"), DF.parse("16-03-2022 12:30:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("16-03-2022 14:00:00"), DF.parse("16-03-2022 17:00:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("17-03-2022 09:30:00"), DF.parse("17-03-2022 12:30:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("17-03-2022 14:00:00"), DF.parse("17-03-2022 17:00:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("18-03-2022 09:30:00"), DF.parse("18-03-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("18-03-2022 14:00:00"), DF.parse("18-03-2022 17:00:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("22-03-2022 09:30:00"), DF.parse("22-03-2022 12:30:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(1), DF.parse("22-03-2022 14:00:00"), DF.parse("22-03-2022 17:00:00"), "MF103", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("23-03-2022 09:30:00"), DF.parse("23-03-2022 12:30:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(1), groupeDAO.rechercherGroupe(3), DF.parse("23-03-2022 14:00:00"), DF.parse("23-03-2022 17:00:00"), "MC402", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("24-03-2022 09:30:00"), DF.parse("24-03-2022 12:30:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(2), DF.parse("24-03-2022 14:00:00"), DF.parse("24-03-2022 17:00:00"), "MH003", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("25-03-2022 09:30:00"), DF.parse("25-03-2022 12:30:00"), "MF105", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(2), matierreDAO.rechercherMatiere(2), groupeDAO.rechercherGroupe(4), DF.parse("25-03-2022 14:00:00"), DF.parse("25-03-2022 17:00:00"), "MF105", false),
                    //Cours de RAVAT                                                                                                                                                                                
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("01-04-2022 09:30:00"), DF.parse("01-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("01-04-2022 14:00:00"), DF.parse("01-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("02-04-2022 09:30:00"), DF.parse("02-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("02-04-2022 14:00:00"), DF.parse("02-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("03-04-2022 09:30:00"), DF.parse("03-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("03-04-2022 14:00:00"), DF.parse("03-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("04-04-2022 09:30:00"), DF.parse("04-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("04-04-2022 14:00:00"), DF.parse("04-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("08-04-2022 09:30:00"), DF.parse("08-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("08-04-2022 14:00:00"), DF.parse("08-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("09-04-2022 09:30:00"), DF.parse("09-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("09-04-2022 14:00:00"), DF.parse("09-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("10-04-2022 09:30:00"), DF.parse("10-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("10-04-2022 14:00:00"), DF.parse("10-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("11-04-2022 09:30:00"), DF.parse("11-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("11-04-2022 14:00:00"), DF.parse("11-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("15-04-2022 09:30:00"), DF.parse("15-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("15-04-2022 14:00:00"), DF.parse("15-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("16-04-2022 09:30:00"), DF.parse("16-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("16-04-2022 14:00:00"), DF.parse("16-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("17-04-2022 09:30:00"), DF.parse("17-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("17-04-2022 14:00:00"), DF.parse("17-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("18-04-2022 09:30:00"), DF.parse("18-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("18-04-2022 14:00:00"), DF.parse("18-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("22-04-2022 09:30:00"), DF.parse("22-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(1), DF.parse("22-04-2022 14:00:00"), DF.parse("22-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("23-04-2022 09:30:00"), DF.parse("23-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(3), groupeDAO.rechercherGroupe(3), DF.parse("23-04-2022 14:00:00"), DF.parse("23-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("24-04-2022 09:30:00"), DF.parse("24-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(2), DF.parse("24-04-2022 14:00:00"), DF.parse("24-04-2022 17:00:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("25-04-2022 09:30:00"), DF.parse("25-04-2022 12:30:00"), "ME407", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(3), matierreDAO.rechercherMatiere(4), groupeDAO.rechercherGroupe(4), DF.parse("25-04-2022 14:00:00"), DF.parse("25-04-2022 17:00:00"), "ME407", false),
                    //Cours de ANDONOFF                                                                                                                                                                             
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("01-05-2022 09:30:00"), DF.parse("01-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("01-05-2022 14:00:00"), DF.parse("01-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("02-05-2022 09:30:00"), DF.parse("02-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("02-05-2022 14:00:00"), DF.parse("02-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("03-05-2022 09:30:00"), DF.parse("03-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("03-05-2022 14:00:00"), DF.parse("03-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("04-05-2022 09:30:00"), DF.parse("04-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("04-05-2022 14:00:00"), DF.parse("04-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("08-05-2022 09:30:00"), DF.parse("08-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("08-05-2022 14:00:00"), DF.parse("08-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("09-05-2022 09:30:00"), DF.parse("09-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("09-05-2022 14:00:00"), DF.parse("09-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("10-05-2022 09:30:00"), DF.parse("10-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("10-05-2022 14:00:00"), DF.parse("10-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("11-05-2022 09:30:00"), DF.parse("11-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("11-05-2022 14:00:00"), DF.parse("11-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("15-05-2022 09:30:00"), DF.parse("15-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("15-05-2022 14:00:00"), DF.parse("15-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("16-05-2022 09:30:00"), DF.parse("16-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("16-05-2022 14:00:00"), DF.parse("16-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("17-05-2022 09:30:00"), DF.parse("17-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("17-05-2022 14:00:00"), DF.parse("17-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("18-05-2022 09:30:00"), DF.parse("18-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("18-05-2022 14:00:00"), DF.parse("18-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("22-05-2022 09:30:00"), DF.parse("22-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(1), DF.parse("22-05-2022 14:00:00"), DF.parse("22-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("23-05-2022 09:30:00"), DF.parse("23-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(5), groupeDAO.rechercherGroupe(3), DF.parse("23-05-2022 14:00:00"), DF.parse("23-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("24-05-2022 09:30:00"), DF.parse("24-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(2), DF.parse("24-05-2022 14:00:00"), DF.parse("24-05-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("25-05-2022 09:30:00"), DF.parse("25-05-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(4), matierreDAO.rechercherMatiere(9), groupeDAO.rechercherGroupe(4), DF.parse("25-05-2022 14:00:00"), DF.parse("25-05-2022 17:00:00"), "ME401", false),
                    //Cours de BERRO                                                                                                                                                                                 
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("01-06-2022 09:30:00"), DF.parse("01-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("01-06-2022 14:00:00"), DF.parse("01-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("02-06-2022 09:30:00"), DF.parse("02-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("02-06-2022 14:00:00"), DF.parse("02-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("03-06-2022 09:30:00"), DF.parse("03-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("03-06-2022 14:00:00"), DF.parse("03-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("04-06-2022 09:30:00"), DF.parse("04-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("04-06-2022 14:00:00"), DF.parse("04-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("08-06-2022 09:30:00"), DF.parse("08-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("08-06-2022 14:00:00"), DF.parse("08-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("09-06-2022 09:30:00"), DF.parse("09-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("09-06-2022 14:00:00"), DF.parse("09-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("10-06-2022 09:30:00"), DF.parse("10-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("10-06-2022 14:00:00"), DF.parse("10-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("11-06-2022 09:30:00"), DF.parse("11-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("11-06-2022 14:00:00"), DF.parse("11-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("15-06-2022 09:30:00"), DF.parse("15-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("15-06-2022 14:00:00"), DF.parse("15-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("16-06-2022 09:30:00"), DF.parse("16-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("16-06-2022 14:00:00"), DF.parse("16-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("17-06-2022 09:30:00"), DF.parse("17-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("17-06-2022 14:00:00"), DF.parse("17-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("18-06-2022 09:30:00"), DF.parse("18-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("18-06-2022 14:00:00"), DF.parse("18-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("22-06-2022 09:30:00"), DF.parse("22-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(1), DF.parse("22-06-2022 14:00:00"), DF.parse("22-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("23-06-2022 09:30:00"), DF.parse("23-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(6), groupeDAO.rechercherGroupe(3), DF.parse("23-06-2022 14:00:00"), DF.parse("23-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("24-06-2022 09:30:00"), DF.parse("24-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(2), DF.parse("24-06-2022 14:00:00"), DF.parse("24-06-2022 17:00:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("25-06-2022 09:30:00"), DF.parse("25-06-2022 12:30:00"), "ME401", false),
                    new SeanceCours(enseignantDAO.rechercherEnseignant(5), matierreDAO.rechercherMatiere(8), groupeDAO.rechercherGroupe(4), DF.parse("25-06-2022 14:00:00"), DF.parse("25-06-2022 17:00:00"), "ME401", false)
            ));
            for (SeanceCours lesSeanceCours : seancesCours) {
                seanceCoursDAO.enregistrerSeanceCours(lesSeanceCours);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void insererUtilisateur() {

    }

}
