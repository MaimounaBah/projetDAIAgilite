
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
        <title>Mes fiches d'appel</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <h3>Mes fiches d'appel</h3>
                </div>
            </div>            

            <table class="table table-striped table-borderless text-center mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="text-left">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Cours</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </th>
                        <th scope="col">Infos Cours</th>
                        <th scope="col">Horaire</th>                       
                        <th scope="col">Consulter</th>
                    </tr>
                </thead>
                <tbody>               
                    <%
                        System.out.println("Listes Fiches Appel JSP");
                        List<SeanceCours> seances = (List<SeanceCours>) request.getAttribute("seancesValidesEnseignant");
                        System.out.println("seances : " + seances);
                        String valide = "";
                        for (SeanceCours s : seances) {
                            if (s.isValide()) {
                                valide = "✔";
                            } else {
                                valide = "";
                            }
                            out.println("<form action='ctrlMesFiches' method='GET'>"
                                    + "<tr'><td class='text-left'>" + s.getMatiere().getLibelleMatiere()
                                    + "<input type='checkbox' name='seanceChoisit' value='" + s.getIdentifiantSeance() + "' hidden checked></td> "
                                    + "<td>" + s.getGroupe().getFormation().getLibelleFormation() + " <br> " + s.getGroupe().getLibelleGroupe() + "</td>"
                                    + "<td>" + s.getDateDebutSeanceCours() + " <br> " + s.getDateFinSeanceCours() + "</td>"
                                    + " <td><button type='submit' class='btn btn-outline-primary'>Consulter</button><br>" + valide + "</td></tr></form>"
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
    </body>
</html>
