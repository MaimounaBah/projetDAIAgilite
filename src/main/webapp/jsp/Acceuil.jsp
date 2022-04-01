<%@page import="miage.dao.EnseignantDAO"%>
<%@page import="miage.metier.Enseignant"%>
<%@page import="miage.metier.Utilisateur"%>
<%@page import="miage.dao.UtilisateurDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Acceuil</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <!--Contenu-->

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="jumbotron">
                        <%
                            //Recupérer l'utilisateur connecté en  session 
                            Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
                            Enseignant enseignant = EnseignantDAO.rechercherEnseignant(utilisateur.getIdentifiantUtilisateur());
                            out.println("<div class='row'>"
                                            + "<div class='col-12 col-lg-2'>"
                                                + "<img src='" + enseignant.getPhoto() + "' style='width:100px; height:100px;' alt='png'>"
                                            + "</div>"
                                            + "<div class='col-12 col-lg-10'>"
                                                + "<h3>" + utilisateur.getPrenomUtilisateur() + " " + utilisateur.getNomUtilisateur() + " &#128525</h3>"
                                            + "</div>"
                                      + "</div>");
                        %>  
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Emploi du temps</h5>
                            <p class="card-text">Accédez à votre emploi du temps depuis lequel vous pourrez accéder aux fiches d'appel.</p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Mes fiches d'appel</h5>
                            <p class="card-text">Conultez l'ensemble des vos fiches d'appel archivées. Cette page vous permet aussi d'en voir les détails.</p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Paramètres</h5>
                            <p class="card-text">Gérez vos préféernces et votre profil.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
