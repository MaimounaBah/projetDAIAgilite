<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
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
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
        <title>Emploi du temps</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Emploi du temps</h3>
                </div>
            </div>            

            <table class="table table-striped table-borderless text-center mt-3" 
                   >
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="text-left" data-sortable="true" data-field="id">Cours</th>
                        <th scope="col" data-sortable="true" data-field="infosCours">Infos Cours</th>                                         
                        <th scope="col" >Consulter</th>
                    </tr>
                </thead>
                <tbody>               
                    <%
                        System.out.println("Listes Fiches Appel JSP");
                        List<SeanceCours> seances = (List<SeanceCours>) request.getAttribute("seancesEnseignant");
                        System.out.println("seances : " + seances);
                        String valide = "";
                        for (SeanceCours s : seances) {
                            if (s.isValide()) {
                                valide = "✔";
                                //System.out.println("c valide : " + seanceChoisit);
                            } else {
                                valide = "";
                            }
                            out.println("<form action='ctrlEmploiDuTemps' method='GET'>"
                                    + "<tr><td class='text-left'>" + s.getMatiere().getLibelleMatiere() + " <br> " + s.getGroupe().getFormation().getLibelleFormation() + " <br> " + s.getGroupe().getLibelleGroupe()
                                    + "<input type='checkbox' name='seanceChoisit' value='" + s.getIdentifiantSeance() + "' hidden checked></td> "
                                    + "<td>" + s.getLibelle_Salle() + " <br> " + s.getDateDebutSeanceCours() + " <br> " + s.getDateFinSeanceCours() + "</td>"
                                    + "<td><button type='submit' class='btn btn-outline-primary'>Faire l'Appel</button><br>" + valide + "</td></tr></form>"
                            );
                        }

                    %>
                </tbody>
            </table>
        </div>

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
        <script src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
    </body>
</html>
