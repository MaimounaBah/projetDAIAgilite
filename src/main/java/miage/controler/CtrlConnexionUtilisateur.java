package miage.controler;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import miage.dao.UtilisateurDAO;
import miage.metier.Utilisateur;

public class CtrlConnexionUtilisateur extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         Utilisateur users= (Utilisateur) request.getAttribute("utilisateur");
//        Integer userId = users.getIdentifiantUtilisateur();
        //Recupération des attributs saisis par l'utilisateur
        String mailUtilisateur = request.getParameter("mailUtilisateur");
        String pwdUtilisateur = request.getParameter("pwdUtilisateur");

        //Traitement des erreurs
        HashMap<String, String> lesErreurs = new HashMap<>();
        String mailUtilisateur_erreur = request.getParameter("mailUtilisateur");
        String pwdUtilisateur_erreur = request.getParameter("pwdUtilisateur");

        if (mailUtilisateur == null || mailUtilisateur.isEmpty()) {
            lesErreurs.put("mailUtilisateur_erreur", "Veillez saisir votre addresse email");
        }
        if (pwdUtilisateur == null || pwdUtilisateur.isEmpty()) {
            lesErreurs.put("pwdUtilisateur_erreur", "Veillez saisir votre mot de passe");
        }
        //S'il n'ya pas d'erreurs
        if (lesErreurs.isEmpty()) {
            try {
                UtilisateurDAO userDao = new UtilisateurDAO();
                Integer utilisateurId = userDao.connexionUtilisateur(mailUtilisateur, pwdUtilisateur);

                System.out.println("Le mail de l'utilisateur connecté est : " + mailUtilisateur);
                Utilisateur user = userDao.rechercherUtilisateur(mailUtilisateur);

                System.out.println("L'utilisateur qui veut se connecter : " + utilisateurId);
                System.out.println("Le rôle de l'utilisateur qui veut se connecter : " + user.getRoleUtilisateur());

                if (utilisateurId == null) {
                    request.setAttribute("generale_erreur", "Adresse email  ou mot de passe incorrect");
                    request.getRequestDispatcher("connexion").forward(request, response);
                } else {

                    System.out.println("L'utilisateur existe et c'est  : " + utilisateurId);

                    if (user.getRoleUtilisateur().equals("enseignant")) {
                        System.out.println("*****************J'ai le role d'un " + user.getRoleUtilisateur() + "**********************************");
                        request.getSession().setAttribute("utilisateurId", String.valueOf(utilisateurId));
//                        request.setAttribute("calendrier", "calendrier");
                        request.getRequestDispatcher("ctrlCentral?fct=accueil").forward(request, response);

                    } else if (user.getRoleUtilisateur().equals("etudiant")) {
                        System.out.println("*****************J'ai le role d'un " + user.getRoleUtilisateur() + "**********************************");
                        request.getSession().setAttribute("utilisateurId", String.valueOf(utilisateurId));
//                        request.setAttribute("calendrier", "calendrier");
                        request.getRequestDispatcher("ctrlCentralEtu?fct=accueilEtudiant").forward(request, response);

                    } else if (user.getRoleUtilisateur().equals("scolarite")) {
                        System.out.println("*****************J'ai le role d'un " + user.getRoleUtilisateur() + "**********************************");
                        request.getSession().setAttribute("utilisateurId", String.valueOf(utilisateurId));
                        request.getSession().setAttribute("loginUser", utilisateurId);
                        request.getRequestDispatcher("ctrlCentralSco?fct=acceuilScolarite").forward(request, response);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("generale_erreur", "Erreur technique");
                request.getRequestDispatcher("connexion").forward(request, response);
            }
        }

        // request.getRequestDispatcher("connexion").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
