<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="miage.metier.Etudiant"%>
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
        <title>Fiche d'appel</title>
    </head>
    <body>

        <!-- Header -->

        <%@include file="../html/Header.html" %>

        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-9">
                    <h3>Fiches d'appel</h3>
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

            <form action="ctrlFicheAppel" method="get">

                <input type="checkbox" class="btn-check" id="btn-check" autocomplete="off" hidden onclick="ToutCocher()">
                <label class="btn btn-primary" for="btn-check"><strong id='cocher'>Tous Absents</strong></label>

                <table class="table table-striped table-borderless text-center">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Photo</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Statut</th>
                            <th scope="col" class="presence">Présence</th>
                            <th scope="col" class="checkboxSupp" hidden>Supprimer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                        //Recupération des utidiants de la seance
                            List<Etudiant> etudiantsSeance = (List<Etudiant>) request.getAttribute("etudiantsSeance");

                            Map<String, String[]> ficheAppel = new HashMap<String, String[]>();
                            int compteur = 1;
                            String checked = "";
                            for (Etudiant e : etudiantsSeance) {

                                out.println("<tr><td class='col-1 align-middle'><img src='" + e.getPhoto() + "' style='width:50px; height:50px; border-radius: 50%;' alt='png'></td>"
                                        + "<td class='align-middle'>" + e.getNomUtilisateur() + " " + e.getPrenomUtilisateur() + "</td>"
                                        + "<td class='align-middle'>" + e.getStatut() + "</td>"
                                        + "<td class='presence col-5 col-lg-3 align-middle'><div>"
                                        + "<div class='form-check form-check-inline'>"
                                        + "<input class='present mr-2' type='radio' name='" + e.getIdentifiantUtilisateur() + "' value='present'  checked id='flexRadioDefault1" + compteur + "' hidden>"
                                        + "<label class='form-check-label' for='flexRadioDefault1" + compteur + "'>Présent</label>"
                                        + "</div>"
                                        + "<div class='form-check form-check-inline'>"
                                        + "<input class='retard mr-2' type='radio' name='" + e.getIdentifiantUtilisateur() + "' value='retard'  id='flexRadioDefault2" + compteur + "' hidden>"
                                        + "<label class='form-check-label' for='flexRadioDefault2" + compteur + "'>Retard</label>"
                                        + "</div>"
                                        + "<div class='form-check form-check-inline'>"
                                        + "<input class='absent mr-2' type='radio' name='" + e.getIdentifiantUtilisateur() + "' value='absent'  id='flexRadioDefault3" + compteur + "' hidden>"
                                        + "<label class='form-check-label' for='flexRadioDefault3" + compteur + "'>Absent</label>"
                                        + "</div>"
                                        + "</div></td>"
                                        + "<td class='groupeSeance' hidden><input type = 'checkbox' name = 'groupeChoisit' checked value = '" + seanceChoisit.getGroupe().getIdGroupe() + "'</td>"
                                        + "<td class='groupeSeance' hidden><input type = 'checkbox' name = 'seanceChoisit' checked value = '" + seanceChoisit.getIdentifiantSeance() + "'</td>"
                                        + "<td class='checkboxSupp  col-5 col-lg-3 align-middle' hidden>");

                                out.println("<input class='checkSupprime' " + checked + "type='checkbox' name='etu_supprimer' value='" + e.getIdentifiantUtilisateur() + "' id='checkSupp" + compteur + "' hidden/>"
                                        + "<label class='custom-checkbox' for='checkSupp" + compteur + "'><i class='bi bi-trash' style='color: black;'></i></label>"
                                        + "</td></tr>"
                                );

                                String[] presence = (String[]) request.getParameterValues("presence" + compteur);
                                String idEtu = String.valueOf(e.getIdentifiantUtilisateur());

                                ficheAppel.put(idEtu, presence);
                                out.println("<input type = 'checkbox' hidden checked name = 'ficheAppel' value = '" + ficheAppel + "'>");
                                compteur++;
                            }

                        %>
                    </tbody>
                </table>

                <!-- The Modal -->
                <div class="modal" id="myModal">
                    <div class="modal-dialog modal-dialog-scrollable">
                        <div class="modal-content">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Ajouter un étudiant</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="modal-body">
                                <input type="text" id="rechercheEtu" placeholder="Rechercher un étudiant" style="width: 100%; margin: 8px 0;" onkeyup="rechercherEtudiant()" />
                                <table id="tableEtudiant" class="table table-striped table-borderless text-center mt-3">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Nom</th>
                                            <th>Prénom</th>
                                            <th>Ajouter</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%                        //Recupération des utidiants de la seance
                                            List<Etudiant> etudiantsAjouter = (List<Etudiant>) request.getAttribute("etudiantsAjouter");
                                            for (Etudiant e : etudiantsAjouter) {
                                                out.println("<tr><td>" + e.getNomUtilisateur() + " </td>"
                                                        + "<td> " + e.getPrenomUtilisateur() + "</td>"
                                                        + "<td class ='checkboxSupp'><input type = 'checkbox' name = 'etu_ajouter' value = '" + e.getIdentifiantUtilisateur() + "'></td></tr>"
                                                );
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success">Ajouter</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!--Buttons-->

                <div class="btnContainer text-center">
                    <div class="row">
                        <div class="col-4">
                            <button  value='retour' name='retour' class="btn btn-outline-secondary">Retour</button>


                        </div>
                        <div class="col-4">
                            <!-- Button Plus(+) -->
                            <i type="button" class="bi bi-plus-circle pr-3" style="font-size: 1.6rem; color: #007bff;" data-toggle="modal" data-target="#myModal"></i>
                            <!-- Button Poubele -->
                            <i type="button" class="bi bi-trash pl_3" onclick="supprimerEtudiants()" style="font-size: 1.6rem; color: #dc3545;"></i>
                            <br>
                            <button id="confirmer" type="submit" hidden class="btn btn-outline-danger mt-2">Confirmer</button>
                        </div>
                        <div class="col-4">
                            <button type="submit" class="btn btn-outline-success" value='valide' name='valide' >Valider</button>
                        </div>
                    </div>
                </div>

            </form><br>


            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
            <script src="js/ficheAppel.js"></script>
    </body>
</html>
