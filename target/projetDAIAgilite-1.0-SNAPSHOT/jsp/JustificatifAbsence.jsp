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
        <title>Justificatif absence</title>
    </head>
    <body>
        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Justificatif absence</h3>
                    <h6>Cours justifié</h6>
                    <%
                        // recuperer le numero de seance
                        long numSeance = (long) request.getAttribute("numSeance");

                        // recuperer le seance
                        SeanceCours seanceJustifie = (SeanceCours) request.getAttribute("seanceJustifie");
                    %>
                    <p>Séance n° <% out.println(numSeance); %> du cours <% out.println(seanceJustifie.getMatiere().getLibelleMatiere()); %></p>
                    <p>Horaires : <% out.println(seanceJustifie.getDateDebutSeanceCours()); %> - <% out.println(seanceJustifie.getDateFinSeanceCours()); %></p>
                    <br>
                </div>
            </div>

            <!--Formulaire-->
            <form method="post" action="ctrlEnvoiJustificatif" enctype="multipart/form-data">
                <%
                    // recuperer id de la seance
                    String idCours = (String) session.getAttribute("identifiantSeance");
                %>
                <input type ="checkbox" name="idCours" value = "<%=idCours%>" hidden checked />
                <div class="row">
                    <div class="col-12 col-lg-6 mb-3">                       
                        <label for="typeAbsence" class="form-label">Type de justificatif</label>
                        <br>
                        <select name="type" class="form-select px-3" aria-label="Default select example" id="typeAbsence">
                            <option selected>Choisir un motif d'absence</option>
                            <option value="Malade">Malade</option>
                            <option value="Accident">Accident</option>
                            <option value="Entretien">Entretien</option>
                            <option value="Autres">Autres</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>

                <div class="form-group mb-3">
                    <label>Sélectionner un fichier</label>
                    <input type="file" name="multiPartServlet" class="form-control-file" id="exampleFormControlFile1">
                </div>

                <!--Message pour erreurs-->
                <h2>${message}</h2>
                <input class="btn btn-outline-success mt-3" type="submit" value="Envoyer" /><br>
                <button value='retour' name='retour' class="btn btn-outline-secondary" onclick="window.location.href = 'ctrlCentralEtu?fct=mesCoursAbsents'">Retour</button>
                

            </form>            
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
            <script src="js/ficheAppel.js"></script>
    </body>
</html>