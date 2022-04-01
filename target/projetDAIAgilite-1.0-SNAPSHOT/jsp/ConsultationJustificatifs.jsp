
<%@page import="miage.metier.DocumentJustificatif"%>
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
        <title>Consulter les justificatifs</title>
    </head>
    <body>

        <!-- Header -->
        <%@include file="../html/HeaderSco.html" %>


        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Consultation des justificatifs</h3>
                </div>
            </div>            

            <!--Table pour que la scolarite puisse consulter tous les justificatifs que les etudiants ont deja depose-->
            <table class="table table-striped table-borderless text-center mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">n° Justificatif</th>
                        <th scope="col">Séance de cours</th> 
                        <th scope="col">Etudiant</th>   
                        <th scope="col">Etat</th>  
                    </tr>
                </thead>
                <tbody>               
                    <%
                        List<DocumentJustificatif> justificatifs = (List<DocumentJustificatif>) request.getAttribute("justificatifs");

                        for (DocumentJustificatif dj : justificatifs) {
                            String pdf = "./justificatifs/" + dj.getNomDocumentJustificatif();
                            out.println("<form action='validationJustificatif' method='GET'>");
                            out.println("<tr><td class='text-left' id='idJustificatif'><a href='ctrlInfoJustificatif?id=" + dj.getIdentifiantDocument() + "'>" + dj.getIdentifiantDocument() + "</a></td>"
                                    + "<input type='checkbox' name='justificatif' value='" + dj.getIdentifiantDocument() + "' hidden checked></td>"
                                    + "<td>" + dj.getSeanceCours().getMatiere().getLibelleMatiere() + " <br> " + dj.getSeanceCours().getDateDebutSeanceCours() + " - " + dj.getSeanceCours().getDateFinSeanceCours() + "</td>"
                                    + "<td>" + dj.getEtudiant().getIdentifiantUtilisateur() + "<br>" + dj.getEtudiant().getNomUtilisateur() + " " + dj.getEtudiant().getPrenomUtilisateur() + "</td>");
                            if (dj.isJustificatifValidee()) {
                                out.println("<td>Validé</td>");
                            } else {
                                out.println("<td><button type='submit' class='btn btn-outline-primary' locked>Valider</button></td>");
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
