package miage.metier;

public class SessionUtilisateur {

    public static String loginUtilisateur;

    public SessionUtilisateur() {
    }

    public static String getLoginUtilisateur() {
        return loginUtilisateur;
    }

    public static void setLoginUtilisateur(String loginUtilisateur) {
        SessionUtilisateur.loginUtilisateur = loginUtilisateur;
    }

    public static String nomUtilisateur, prenomUtilisateur;

    //Identique à la fonction toString 
    public static String informations() {
        return nomUtilisateur + " " + prenomUtilisateur;
    }

    public static String informationsNom() {
        return nomUtilisateur;
    }

}
