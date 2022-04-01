package miage.controler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.dao.EnseignantDAO;
import miage.dao.SeanceCoursDAO;
import miage.dao.UtilisateurDAO;
import miage.metier.Enseignant;
import miage.metier.SeanceCours;
import miage.metier.Utilisateur;

public class CtrlCentral extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("**************CTRL CENTRAL*****************");
        //recuperer les parametres fct
        String fct = request.getParameter("fct");

        //Recuperer id de l'utilisateur
        HttpSession session = request.getSession(true);
        String idLog = (String) session.getAttribute("utilisateurId");
        //System.out.println("**************idLog***************** = " + idLog);

        switch (fct) {

            case "accueil": {
                try {
                    //Recuperer les infos en session 
                    Utilisateur u = UtilisateurDAO.chargerUtilisateur(Integer.parseInt(idLog));
                    request.setAttribute("utilisateur", u);

                    request.getRequestDispatcher("accueil").forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "edt": {

                try {
                    System.out.println("**************CTRL CENTRAL : EDT*****************");
                    System.out.println("**************idLog***************** = " + idLog);

                    List<SeanceCours> seancesEnseignant = SeanceCoursDAO.afficherSeancesCoursEnseignants(Integer.parseInt(idLog));

                    System.out.println("seancesEnseignant = " + seancesEnseignant);
                    request.setAttribute("seancesEnseignant", seancesEnseignant);
                    request.getRequestDispatcher("edt").forward(request, response);
                } catch (Exception e) {

                }
                break;
            }
            case "mesFiches":
                try {
                System.out.println("**************CTRL CENTRAL : MES FICHES *****************");
                List<SeanceCours> seancesValidesEnseignant = SeanceCoursDAO.afficherSeancesValidesEnseignants(Integer.parseInt(idLog));
                System.out.println("seancesValidesEnseignant = " + seancesValidesEnseignant);
                request.setAttribute("seancesValidesEnseignant", seancesValidesEnseignant);
                request.getRequestDispatcher("mesFiches").forward(request, response);

            } catch (Exception e) {

            }
            break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
