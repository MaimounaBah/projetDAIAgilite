package miage.metier;

import javax.persistence.*;

@Entity(name = "Scolarite")
public class Scolarite extends Utilisateur {

    //Constructeurs
    public Scolarite() {
    }

    public Scolarite( String nomScolarite, String prenomScolarite, String mailScolarite, String MDP, String role) {
        super( prenomScolarite, nomScolarite, mailScolarite, MDP, role);
    }

}
