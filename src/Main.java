import metier.ListeUtilisateursImpl;
import metier.Personne;
import metier.Utilisateur;

import java.util.ArrayList;

/**
 * Created by sidya on 09/09/15.
 */
public class Main {
    public static void main (String[] args){
        ListeUtilisateursImpl userList = new ListeUtilisateursImpl();
        userList.ajouterUtilisateur(new Utilisateur("Durant", "Paul", Personne.ADMINISTRATEUR, "paul.durant", "tototo", ""));
        userList.ajouterUtilisateur(new Utilisateur("Dupont", "Jean", Personne.STATISTICIEN, "jean.dupont", "tototo", "paul.durant"));

        new FenetreIdentification(userList);
    }
}
