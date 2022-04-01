<%@page import="miage.dao.FicheAppelDAO"%>
<%@page import="miage.metier.SeanceCours"%>
<%@page import="miage.dao.EtudiantDAO"%>
<%@page import="java.util.List"%>
<%@page import="miage.metier.Etudiant"%>
<%@page import="miage.dao.SeanceCoursDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Fiche d'appel valide</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Fiche d'appel validée</h3>
                </div>
                <ul class="list-unstyled col-12 col-lg-3 my-3 p-3">
                    <%
                        //Recupération des informations d'une seance
                        SeanceCours seanceChoisit = (SeanceCours) request.getAttribute("seanceChoisit");

                        //Recupération numero de seance 
                        long numSeance = (long) request.getAttribute("numSeance");

                        out.println("<li>" + seanceChoisit.getMatiere().getLibelleMatiere() + "</li>"
                                + "<li>" + seanceChoisit.getGroupe().getFormation().getLibelleFormation() + "</li>"
                                + "<li>" + seanceChoisit.getLibelle_Salle() + "</li>"
                                + "<li>" + numSeance + "</li>");

                    %>

                </ul>
            </div>
            <table class="table table-striped table-borderless text-center">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Photo</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Statut</th>
                        <th scope="col">Présence</th>
                    </tr>
                </thead>
                <tbody>
                    <%                        //Recupération des utidiants de la seance
                        List<Etudiant> etudiantsSeance = (List<Etudiant>) request.getAttribute("etudiantsSeance");
                        for (Etudiant e : etudiantsSeance) {
                            out.println("<tr><td><img src='" + e.getPhoto() + "' style='width:50px; height:50px; border-radius: 50%;' alt='png'></td>"
                                    + "<td>" + e.getNomUtilisateur() + " <br> " + e.getPrenomUtilisateur() + "</td>"
                                    + "<td>" + e.getStatut() + "</td>"
                                    + "<td> " + FicheAppelDAO.afficherPresenceEtudiant(e.getIdentifiantUtilisateur(), seanceChoisit.getIdentifiantSeance()).getEtat_presence() + " </td></tr>"
                            );
                        }
                        //VOIR LA PRESENCE

                    %>
                </tbody>                
            </table> <br>
            <button class="btn btn-outline-secondary" onclick="window.location.href = 'ctrlCentral?fct=mesFiches'">Retour</button>
            <br> <br>
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
            <script src="js/ficheAppel.js"></script>
    </body>
</html>
