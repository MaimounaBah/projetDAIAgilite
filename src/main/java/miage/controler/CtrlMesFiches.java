package miage.controler;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import miage.dao.EtudiantDAO;
import miage.dao.SeanceCoursDAO;
import miage.metier.Etudiant;
import miage.metier.SeanceCours;

public class CtrlMesFiches extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("**************CTRL MES FICHES*****************");
            //On recupere la seance choisit
            String identifiantSeance = request.getParameter("seanceChoisit");
            //System.out.println("identifiantSeance" + identifiantSeance);

            SeanceCours seanceChoisit = SeanceCoursDAO.rechercherSeance(Integer.parseInt(identifiantSeance));
            System.out.println("seanceChoisit : " + seanceChoisit);

            //Numero de seance
            long numSeance;
            numSeance = SeanceCoursDAO.afficherNbSeance(seanceChoisit.getGroupe().getIdGroupe(), seanceChoisit.getMatiere().getIdMatiere(), seanceChoisit.getEnseignant().getIdentifiantUtilisateur(), seanceChoisit.getIdentifiantSeance());

            //Etudiants 
            List<Etudiant> etudiantsSeance = EtudiantDAO.afficherListeEtudiantsGroupe(seanceChoisit.getGroupe().getIdGroupe());
            //System.out.println("etudiantsSeance : " + etudiantsSeance);

            request.setAttribute("seanceChoisit", seanceChoisit);
            request.setAttribute("numSeance", numSeance);
            request.setAttribute("etudiantsSeance", etudiantsSeance);

            request.getRequestDispatcher("ficheAppelValide").forward(request, response);
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
