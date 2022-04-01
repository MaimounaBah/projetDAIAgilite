package miage.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.dao.SeanceCoursDAO;
import miage.metier.SeanceCours;

public class CtrlDeposerJustificatif extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("**********************************CTRL DEPOSER JUSTIFICATIF**********************************");
            //On recupere la seance justifie choisi
            String identifiantSeance = request.getParameter("seanceJustifie");
            HttpSession session = request.getSession(true);
            session.setAttribute("identifiantSeance", identifiantSeance);
            //System.err.println("identifiantSeance : " + identifiantSeance);

            SeanceCours seanceJustifie = SeanceCoursDAO.rechercherSeance(Integer.parseInt(identifiantSeance));
            //System.err.println("seanceJustifie : " + seanceJustifie);

            //Recuperer le numero de seance pour le cours justifie
            long numSeance;
            numSeance = SeanceCoursDAO.afficherNbSeance(seanceJustifie.getGroupe().getIdGroupe(), seanceJustifie.getMatiere().getIdMatiere(), seanceJustifie.getEnseignant().getIdentifiantUtilisateur(), seanceJustifie.getIdentifiantSeance());
            //System.err.println("numSeance : " + numSeance);

            request.setAttribute("seanceJustifie", seanceJustifie);
            request.setAttribute("numSeance", numSeance);

            request.getRequestDispatcher("justificatifAbsence").forward(request, response);
            //System.out.println("okkkkkkkkkkk");
        } catch (Exception e) {
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
