package miage.controler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.dao.CoursAbsentsDAO;
import miage.dao.DocumentJustificatifDAO;
import miage.dao.UtilisateurDAO;
import miage.metier.CoursAbsents;
import miage.metier.DocumentJustificatif;
import miage.metier.Utilisateur;

public class CtrlCentralSco extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("**************CTRL CENTRAL SCO *****************");
        //recuperer les parametres fct
        String fct = request.getParameter("fct");

        //Recuperer id de l'utilisateur
        HttpSession session = request.getSession(true);
        String idLog = (String) session.getAttribute("utilisateurId");
        System.out.println("**************idLog ETU ***************** = " + idLog);

        switch (fct) {

            case "acceuilScolarite": {
                try {
                    //Recuperer les infos en session 
                    Utilisateur u = UtilisateurDAO.chargerUtilisateur(Integer.parseInt(idLog));
                    request.setAttribute("utilisateur", u);

                    request.getRequestDispatcher("acceuilScolarite").forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "justificatifsSco":
                try {
                List<DocumentJustificatif> justificatifs = DocumentJustificatifDAO.afficherTousJustificatifs();
                request.setAttribute("justificatifs", justificatifs);
                request.getRequestDispatcher("justificatifsSco").forward(request, response);

            } catch (Exception e) {

            }
            break;
            case "mesFiches":
                try {

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
