
<%@page import="miage.dao.DocumentJustificatifDAO"%>
<%@page import="miage.metier.DocumentJustificatif"%>
<%@page import="miage.dao.SeanceCoursDAO"%>
<%@page import="miage.dao.FicheAppelDAO"%>
<%@page import="miage.metier.FicheAppel"%>
<%@page import="miage.metier.CoursAbsents"%>
<%@page import="java.util.List"%>
<%@page import="miage.metier.SeanceCours"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <title>Mes cours absents</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/HeaderEtu.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Mes cours absents</h3>
                </div>
            </div>            

            <!--Table pour afficher tous les cours absents pour un etudiant-->
            <table class="table table-striped table-borderless text-center mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Cours</th>
                        <th scope="col">Horaire</th> 
                        <th scope="col">Enseignant</th>  
                        <th scope="col">Justification</th>       
                    </tr>
                </thead>
                <tbody>               
                    <%
                        List<CoursAbsents> coursAbsents = (List<CoursAbsents>) request.getAttribute("seancesAbsents");
                        System.out.println("seances : " + coursAbsents);
                        String idLog = (String) request.getAttribute("id");
                        FicheAppel fichea = new FicheAppel();
                        SeanceCours seance = new SeanceCours();
                        DocumentJustificatif doc = new DocumentJustificatif(); //DocumentJustificatifDAO.chargerJustificatif(11, 35);
                        String valide = "";

                        List<DocumentJustificatif> listeDoc = DocumentJustificatifDAO.afficherTousJustificatifs();

                        for (CoursAbsents s : coursAbsents) {
//                            boolean trouve = false;
//                            int i = 0;
//                            while(trouve == false && i <= listeDoc.size()){
//                                if(listeDoc.get(i).getEtudiant().getIdentifiantUtilisateur() == Integer.parseInt(idLog) && listeDoc.get(i).getSeanceCours().getIdentifiantSeance() == s.getIdCours()){
//                                    trouve = true;
//                                    if(listeDoc.get(i).isJustificatifValidee()){
//                                        valide = "✔";
//                                    } else {
//                                        valide = "";
//                                    }
//                                } else {
//                                    i++;
//                                }
//                            }
//                                if (doc.getIdentifiantDocument()!= 0) {
//                                if (s.isValide()) {
//                                    valide = "✔";
//                                } else {
//                                    valide = "";
//                                }
////                           }

                            out.println("<form action='ctrlDeposerJustificatif' method='GET'>"
                                    + "<tr><td class='text-left'>" + s.getNomCours() + "<br>" + s.getFormation() + "<br>" + s.getGroupe() + "</td>"
                                    + "<input type='checkbox' name='seanceJustifie' value='" + s.getIdCours() + "' hidden checked></td> "
                                    + "<td>" + s.getDateDebut() + " <br> " + s.getDateFin() + "</td>"
                                    + "<td>" + s.getNomEnseignant() + " " + s.getPrenomEnseignant() + "</td>"
                            );
//                            out.println("<form action='ctrlDeposerJustificatif' method='GET'>"
//                                    + "<tr><td class='text-left'>" + seance.getMatiere().getLibelleMatiere() + "<br>" + seance.getGroupe().getFormation().getLibelleFormation() + "<br>" + seance.getGroupe().getLibelleGroupe() + "</td>"
//                                    + "<input type='checkbox' name='seanceJustifie' value='" + seance.getIdentifiantSeance() + "' hidden checked></td> "
//                                    + "<td>" + seance.getDateDebutSeanceCours() + " <br> " + seance.getDateFinSeanceCours() + "</td>"
//                                    + "<td>" + seance.getEnseignant().getNomUtilisateur() + " " + seance.getEnseignant().getPrenomUtilisateur() + "</td>"
//                            );
//                            doc = DocumentJustificatifDAO.chargerJustificatif(Integer.parseInt(idLog), s.getIdCours());
//
                            fichea = FicheAppelDAO.chargerFicheAppel(Integer.parseInt(idLog), s.getIdCours());
                            if (fichea.getEtat_presence().equals("absent")) {
                                out.println("<td><button type='submit' class='btn btn-outline-primary'>Justifier</button><br>" + valide + "</td>");
                            } else if (fichea.getEtat_presence().equals("absence justifie")) {
                                out.println("<td>Absence justifié <br>" + valide + "</td>");
                            }
                            out.println("</tr></form>");
                        }

                    %>
                </tbody>
            </table>
        </div>

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
