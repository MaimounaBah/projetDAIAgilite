package miage.controler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.dao.DocumentJustificatifDAO;
import miage.dao.FicheAppelDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author zixin
 */
public class CtrlEnvoiJustificatif extends HttpServlet {

    public static final String UPLOAD_DIRECTORY = "upload";
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  //3MB
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;    //40MB
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB
    public static final String APPLICATION_PDF = "application/pdf";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("************** CTRL ENVOIE JUSTIFICATIF *****************");
        HttpSession session = request.getSession(true);
        String idLog = (String) session.getAttribute("utilisateurId");
        System.out.println("**************idLog ETU ***************** = " + idLog);

        String type = "";
        String description = "";
        int idcours = 0;
        String message = "";

        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            List<FileItem> formItems = null;

            try {
                formItems = upload.parseRequest(request);
            } catch (FileUploadException e) {
                message = "Echec du téléchargement du fichier!";
                e.printStackTrace();
            }

            String fileName = "";
            String filePath = "";
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        System.out.println(fileName);
                        File storeFile = new File(filePath);

                        try {
                            item.write(storeFile);
                        } catch (Exception ex) {
                            Logger.getLogger(CtrlEnvoiJustificatif.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String fieldname = item.getFieldName();
                        if (fieldname.equals("type")) {
                            type = item.getString();
                        } else if (fieldname.equals("description")) {
                            description = item.getString();
                        } else if (fieldname.equals("idCours")) {
                            idcours = Integer.parseInt(item.getString());
                        }
                    }
                }

                if (fileName.equals("")) {

                    RequestDispatcher rd = request.getRequestDispatcher("ctrlCentralEtu?fct=mesCoursAbsents");
                    request.setAttribute("fichier_erreur", "Veuillez bien sélectionner un fichier!");
                    rd.forward(request, response);
                } else {

                    DocumentJustificatifDAO justificatifdao = new DocumentJustificatifDAO();
                    justificatifdao.deposerJustificatif(fileName, type, description, Integer.parseInt(idLog), idcours);

                    FicheAppelDAO.justifierAbsence(Integer.parseInt(idLog), idcours);

                    //Un mail est envoyé à la scolarité à chaque insertion de justificatif
                    String from = "aztech.ipm@gmail.com";
                    String msg = ""
                            + "Bonjour,"
                            + "\nUn étudiant "+ idLog+" vient d'ajouter un justificatif pour son absence pour le cours " + idcours
                            + "\nVous pouvez la consulter depuis l'application."
                            + "\nCordialement,"
                            + "\nScolarite";

                    String pwd = "aztech.ipm2022";
                    String sub = "Nouvelle absence";
                    String to = "rosewang0139@gmail.com";  //mail de la scolarite
                    CtrlCoursAbsents.send(from, pwd, to, sub, msg);
                    System.out.println("OKKKKKKKKKKK");

                    // Aller vers consulter mes justificatifs 
                    response.sendRedirect("ctrlCentralEtu?fct=mesCoursAbsents");
                    // RequestDispatcher rd = request.getRequestDispatcher("ctrlCentralEtu?fct=mesCoursAbsents");
                    message = "Justificatif " + fileName + " a bien déposé!";
                    request.setAttribute("message", message);
                    //rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("ctrlCentralEtu?fct=mesCoursAbsents");
                request.setAttribute("fichier_erreur", "Echec!");
                rd.forward(request, response);
            }
        }
    }
}
