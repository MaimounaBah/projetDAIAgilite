package miage.controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.dao.EtudiantDAO;
import miage.dao.FicheAppelDAO;
import miage.dao.SeanceCoursDAO;

public class CtrlFicheAppel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("**************CTRL FICHE APPEL*****************");

        //On recupere les étudiants à supprimer
        String[] identifiantEtudiantSupp = request.getParameterValues("etu_supprimer");

        if (identifiantEtudiantSupp != null) {
            try {
                for (String i : identifiantEtudiantSupp) {
                    EtudiantDAO.retiterEtudiantFiche(Integer.parseInt(i));
                }
            } catch (Exception e) {
            }
        }

        //On recupere les étudiants à supprimer
        String[] identifiantEtudiantAdd = request.getParameterValues("etu_ajouter");
        //groupeChoisit
        String idGroupe = request.getParameter("groupeChoisit");
        //seanceChoisit
        String seanceChoisit = request.getParameter("seanceChoisit");

        if (identifiantEtudiantAdd != null) {
            try {
                //System.out.println("idGroupe : " + idGroupe);
                for (String i : identifiantEtudiantAdd) {
                    EtudiantDAO.ajouterEtudiantCours(Integer.parseInt(idGroupe), Integer.parseInt(i));
                }
            } catch (Exception e) {
            }
        }

        //Pour faire l'appel :
        //Mettre les valeurs de la map recupérée dans une MAP <String, String[]>
        Map ficheAppelMap = request.getParameterMap();
        Set s = ficheAppelMap.entrySet();
        Iterator it = s.iterator();
        //Recuperer les cles et les valuers pour les mettre dans une nouvelle map <String, String>
        Map<String, String> ficheAppel = new HashMap<>();
        String valide = request.getParameter("valide");

        if (valide != null) {
            //Recuperer les cles et les valuers pour les mettre dans une nouvelle map <String, String>
            while (it.hasNext()) {
                Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();
                String key = entry.getKey();
                String[] value = entry.getValue();

                for (String presence : value) {
                    ficheAppel.put(key, presence);
                }
            }

            SeanceCoursDAO.validerSeance(Integer.parseInt(seanceChoisit));
            //Pour chaque etudiant pointer sa presence
            for (String i : ficheAppel.keySet()) {
                if (ficheAppel.get(i).equals("present") || ficheAppel.get(i).equals("absent") || ficheAppel.get(i).equals("retard")) {
                    System.out.println("idEtu : " + i + " - Presence : " + ficheAppel.get(i));
                    FicheAppelDAO.pointerPresence(Integer.parseInt(i), Integer.parseInt(seanceChoisit), ficheAppel.get(i));
                }
            }

        }

        request.getRequestDispatcher("ctrlEmploiDuTemps").forward(request, response);
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
