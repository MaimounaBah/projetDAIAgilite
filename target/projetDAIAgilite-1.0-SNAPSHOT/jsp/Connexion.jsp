<%
//    if(session.getAttribute("loginUser") != null && session.getAttribute("pwdUtilisateur") !=null){
//        response.sendRedirect("ctrlAccueil?fct=accueil");
    //  }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="styles/styleLogin.css" rel="stylesheet" type="text/css"/>
        <title>Connexion</title>
    </head>
    <body class="body-signin text-center">
        <%
            String mailUtilisateur = request.getParameter("mailUtilisateur") == null ? "" : request.getParameter("mailUtilisateur");
            String mailUtilisateurErreur = request.getAttribute("mailUtilisateur_erreur") == null ? "" : (String) request.getAttribute("mailUtilisateur_erreur");
            String pwdUtilisateurErreur = request.getAttribute("pwdUtilisateur_erreur") == null ? "" : (String) request.getAttribute("pwdUtilisateur_erreur");

        %>
        <form class="form-signin" autocomplete="off" method="GET" action="ctrlConnexionUtilisateur">
            <h1 class="h3 mb-3 font-weight-normal">Connexion</h1>
            <label for="inputEmail" class="sr-only">Identifiant</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Identifiant" required autofocus name="mailUtilisateur">
            <small class="d-flex d-sm-flex justify-content-center justify-content-sm-center text-danger erreur"><%= mailUtilisateurErreur%></small>
            <label for="inputPassword" class="sr-only">Mot de passe</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" required name="pwdUtilisateur">
            <small class="d-flex d-sm-flex justify-content-center justify-content-sm-center text-danger erreur"><%= pwdUtilisateurErreur%></small>
            
            <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>

        </form>
    </body>
</html>
