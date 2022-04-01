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

public class CtrlEmploiDuTemps extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("**************CTRL MON EMPLOI DU TEMPS*****************");
            //On recupere la seance choisit
            String identifiantSeance = request.getParameter("seanceChoisit");
            System.out.println("identifiantSeance = " + identifiantSeance);

            SeanceCours seanceChoisit = SeanceCoursDAO.rechercherSeance(Integer.parseInt(identifiantSeance));
            //System.out.println("seanceChoisit : " + seanceChoisit);

            //Numero de seance
            long numSeance;
            numSeance = SeanceCoursDAO.afficherNbSeance(seanceChoisit.getGroupe().getIdGroupe(), seanceChoisit.getMatiere().getIdMatiere(), seanceChoisit.getEnseignant().getIdentifiantUtilisateur(), seanceChoisit.getIdentifiantSeance());

            //Etudiants 
            List<Etudiant> etudiantsSeance = EtudiantDAO.afficherListeEtudiantsGroupe(seanceChoisit.getGroupe().getIdGroupe());
            //System.out.println("etudiantsSeance : " + etudiantsSeance);

            //Ajouter Etudiant
            List<Etudiant> etudiantsAjouter = EtudiantDAO.afficherListeEtudiantsFormation(seanceChoisit.getGroupe().getFormation().getIdFormation(), seanceChoisit.getGroupe().getIdGroupe());
            //System.out.println("etudiantsAjouter : " + etudiantsAjouter);

            //passer en session l'information necessaire
//            HttpSession session = request.getSession(true);
//            session.setAttribute("seanceChoisit", seanceChoisit);
//            session.setAttribute("numSeance", numSeance);
//            session.setAttribute("etudiantsSeance", etudiantsSeance);
//            session.setAttribute("etudiantsAjouter", etudiantsAjouter);
            request.setAttribute("seanceChoisit", seanceChoisit);
            request.setAttribute("numSeance", numSeance);
            request.setAttribute("etudiantsSeance", etudiantsSeance);
            request.setAttribute("etudiantsAjouter", etudiantsAjouter);

            System.out.println("**************seanceChoisit = " + seanceChoisit);
            System.out.println("**************numSeance = " + numSeance);
            System.out.println("**************etudiantsSeance = " + etudiantsSeance);
            System.out.println("**************etudiantsAjouter = " + etudiantsAjouter);

            if (seanceChoisit.isValide()) {
                System.out.println("c valide : " + seanceChoisit);
                request.getRequestDispatcher("ficheAppelValide").forward(request, response);
            }
            System.out.println("**************testttté");
            request.getRequestDispatcher("ficheAppel").forward(request, response);
           
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
