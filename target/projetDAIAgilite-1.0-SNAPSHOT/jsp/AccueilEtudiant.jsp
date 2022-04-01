<%@page import="miage.dao.EtudiantDAO"%>
<%@page import="miage.metier.Etudiant"%>
<%@page import="miage.metier.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="styles/style.css" rel="stylesheet" type="text/css"/>
        <title>Acceuil Etudiant</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/HeaderEtu.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="jumbotron">
                        <h1>Bienvenue !</h1>
                        <%
                            //Recupérer l'utilisateur connecté en  session 
                            Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
                            Etudiant etudiant = EtudiantDAO.rechercherEtuduant(utilisateur.getIdentifiantUtilisateur());
                            out.println("<div class='row'>"
                                    + "<div class='col-12 col-lg-2'>"
                                    + "<img src='" + etudiant.getPhoto() + "' style='width:100px; height:100px;' alt='png'>"
                                    + "</div>"
                                    + "<div class='col-12 col-lg-10'>"
                                    + "<h3>" + utilisateur.getPrenomUtilisateur() + " " + utilisateur.getNomUtilisateur() + " &#128525</h3>"
                                    + "</div>"
                                    + "</div>");
                        %> 
                    </div>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-12 col-lg-4 d-flex align-items-stretch mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Mes absences</h5>
                            <p class="card-text">Accédez à l'ensemble de vos absences. Justifiez vos absences en lignes.</p>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-lg-4 d-flex align-items-stretch mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Modifier mon profil</h5>
                            <p class="card-text">Gérez vos préfrences et votre profil.</p>
                        </div>
                    </div>
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
