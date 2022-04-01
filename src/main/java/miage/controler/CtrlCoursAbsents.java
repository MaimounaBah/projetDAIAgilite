package miage.controler;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import miage.dao.EtudiantDAO;
import miage.dao.SeanceCoursDAO;
import miage.metier.Etudiant;
import miage.metier.SeanceCours;

public class CtrlCoursAbsents extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //On recupere la seance choisit
            String identifiantSeance = request.getParameter("seanceChoisit");
            //System.out.println("identifiantSeance" + identifiantSeance);

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
            request.setAttribute("seanceChoisit", seanceChoisit);
            request.setAttribute("numSeance", numSeance);
            request.setAttribute("etudiantsSeance", etudiantsSeance);
            request.setAttribute("etudiantsAjouter", etudiantsAjouter);

            request.getRequestDispatcher("ficheAppel").forward(request, response);
        } catch (Exception e) {
        }
    }

    public static void send(final String from, final String pwd, String to, String sub, String msg) {
        //Propriétés
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.socketFactory.port", "465");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "465");
        //Session
        Session s = Session.getDefaultInstance(p,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pwd);
            }
        });
        //composer le message
        try {
            MimeMessage m = new MimeMessage(s);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setText(msg);
            //envoyer le message
            Transport.send(m);
        } catch (MessagingException e) {
            e.printStackTrace();
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
