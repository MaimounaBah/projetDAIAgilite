$(document).ready(function () {
    //Dès qu'on clique sur supprimer les chebox et confimer s'affichent
    $("#supprimer").click(function () {
        $("#confirmer").show();
        $("#checkboxSupp").show();
    });

});

function myFunction() {
    var confirmer = document.getElementById("confirmer");
    if (confirmer.hidden == true) {
        confirmer.hidden = false;
        var checkboxSupp = document.getElementsByClassName("checkboxSupp");
        for (var i = 0; i < checkboxSupp.length; i++) {
            checkboxSupp[i].hidden = false;
        }
    } else {
        confirmer.hidden = true;
        var checkboxSupp = document.getElementsByClassName("checkboxSupp");
        for (var i = 0; i < checkboxSupp.length; i++) {
            checkboxSupp[i].hidden = true;
        }
    }

}

/*tester*/
function myFunction2() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


/*Pour ajouter un etudiant, choisir un etudiant par loginEtudiant dans la zone de recherche*/
function rechercherEtudiant() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("rechercheEtu");
    filter = input.value.toUpperCase();
    table = document.getElementById("tableEtudiant");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function supprimerEtudiants() {

    var confirmer = document.getElementById("confirmer");
    if (confirmer.hidden === true) {
        confirmer.hidden = false;
        var checkboxSupp = document.getElementsByClassName("checkboxSupp");
        for (var i = 0; i < checkboxSupp.length; i++) {
            checkboxSupp[i].hidden = false;
        }
        var presence = document.getElementsByClassName("presence");
        for (var i = 0; i < presence.length; i++) {
            presence[i].hidden = true;
        }
    } else {
        confirmer.hidden = true;
        var checkboxSupp = document.getElementsByClassName("checkboxSupp");
        for (var i = 0; i < checkboxSupp.length; i++) {
            checkboxSupp[i].hidden = true;
        }
        var presence = document.getElementsByClassName("presence");
        for (var i = 0; i < presence.length; i++) {
            presence[i].hidden = false;
        }
    }
}

/*Pour ajouter un cours, choisir un cours par nomCours dans la zone de recherche*/
function rechercherCours() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("rechercheCours");
    filter = input.value.toUpperCase();
    table = document.getElementById("tableCours");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function ToutCocher() {
    
    var confirmer = document.getElementById("btn-check");
    var cocher = document.getElementById("cocher");
    var absent = document.getElementsByClassName("absent");
    var present = document.getElementsByClassName("present");
    // on va tous les mettre a absent 
    if (confirmer.checked == true) {
        for (var i = 0; i < absent.length; i++) {

            absent[i].checked = true;
        }
        cocher.innerHTML = "Tous Présents";
    } else {
        //tous a present 
        for (var i = 0; i < present.length; i++) {

            present[i].checked = true;
        }
        cocher.innerHTML = "Tous Absents";
    }
}          