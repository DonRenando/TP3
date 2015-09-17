import metier.ListeUtilisateursImpl;
import metier.Personne;
import metier.Utilisateur;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        ListeUtilisateursImpl userList = new ListeUtilisateursImpl();
        File f = new File("BD");
        if (!f.exists()) {
            userList.ajouterUtilisateur(new Utilisateur("Durant", "Paul", Personne.ADMINISTRATEUR, "paul.durant", "tototo", ""));
            userList.ajouterUtilisateur(new Utilisateur("Dupont", "Jean", Personne.STATISTICIEN, "jean.dupont", "tototo", "paul.durant"));

            userList.sauverListe(f);
        }
        else
            userList.chargerListe(f);

        new FenetreIdentification(userList, f);
    }
}
