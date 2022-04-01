<%@page import="java.util.Date"%>
<%@page import="miage.metier.DocumentJustificatif"%>
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

        <div class="bg-dark">
            <div class="container">
                <div class="row">
                    <nav class="col navbar navbar-expand-lg navbar-dark">
                        <a class="navbar-brand" href="https://www.ut-capitole.fr/">ENT UT1</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="ctrlCentral?fct=accueil">Acceuil</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ctrlCentral?fct=edt">Emploi du temps</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ctrlCentral?fct=mesFiches">Mes fiches d'appel</a>
                                </li>                                
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Modifier mon profil</a>
                                </li>
                            </ul>
                            <form class="form-inline my-2 my-lg-0 ml-auto">
                                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">D&#233connexion</button>
                            </form>
                        </div>
                    </nav>
                </div>
            </div>
        </div>

        <!--Contenu-->

        <div class="container">
            <div class="row">
                <div class="col">
                    <% 
                        // Afficher le numero de justificatif
                        DocumentJustificatif jus = (DocumentJustificatif) request.getAttribute("doc");
                        
                        //info justificatif
                        int idJus = jus.getIdentifiantDocument();
                        Date dateEnvoie = jus.getDateEnvoieJustificatif();
                        String type = jus.getTypeDocumentJustificatif();
                        String description = jus.getTexteJustificatif();
                        String pdf = "./justificatifs/" + jus.getNomDocumentJustificatif();
                        
                        String etat;
                        if(jus.isJustificatifValidee()){
                            etat = "Valivé";
                        } else {
                            etat = "En attente";
                        }
                        
                        //info etudiant
                        int numEtu = jus.getEtudiant().getIdentifiantUtilisateur();
                        String nom = jus.getEtudiant().getNomUtilisateur();
                        String prenom = jus.getEtudiant().getPrenomUtilisateur();
                        String formation = jus.getEtudiant().getGroupe().getFormation().getLibelleFormation();
                        String mail = jus.getEtudiant().getMailUtilisateur();
                        
                        //info cours
                        String cours = jus.getSeanceCours().getMatiere().getLibelleMatiere();
                        Date dateDebut = jus.getSeanceCours().getDateDebutSeanceCours();
                        Date dateFin = jus.getSeanceCours().getDateFinSeanceCours();
                        String nomEn = jus.getSeanceCours().getEnseignant().getNomUtilisateur();
                        String prenomEn = jus.getSeanceCours().getEnseignant().getPrenomUtilisateur();
                        String mailEn = jus.getSeanceCours().getEnseignant().getMailUtilisateur();
                        String groupe = jus.getSeanceCours().getGroupe().getLibelleGroupe();
                    %>
                    <h3>Justificatif n° <% out.println(idJus); %></h3>                  
                </div>
            </div>

            <!--Formulaire-->

                <div class="row">
                    <div class="col-12 col-lg-6 mb-3"> 
                        <p>Date d'envoie : <% out.println(dateEnvoie); %></p>
                        <p>Type de justificatif : <% out.println(type); %></p>
                        <p>description : <% out.println(type); %></p>
                        <%
                            out.println("<p>Pièce-jointe: <a href='"+pdf+"' download=\"w3logo\">"+pdf+"</a></p>");
                        %>
                        <p>Etat : <% out.println(etat); %></p>
                        <br>
                        <p>Déposé par étudiant n° : <% out.println(numEtu); %> <% out.println(nom); %> <% out.println(prenom); %></p>
                        <p>Email : <% out.println(mail); %></p>
                        <br>
                        <p>Pour le cours <% out.println(cours); %> de <% out.println(dateDebut); %> à <% out.println(dateFin); %> pour le groupe <% out.println(groupe); %></p>
                        <p>Enseignant : <% out.println(nomEn); %> <% out.println(prenomEn); %></p>
                        <p>Email: <% out.println(mailEn); %></p>
                    </div>
                </div>
                
                <button value='retour' name='retour' class="btn btn-outline-secondary" onclick="window.location.href = 'ctrlCentralSco?fct=justificatifsSco'">Retour</button>
          
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
            <script src="js/ficheAppel.js"></script>
    </body>
</html>