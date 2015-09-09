import metier.Personne;
import metier.Utilisateur;

/**
 * Created by sidya on 09/09/15.
 */
public class Main {
    public static void main (String[] args){
        Utilisateur u = new Utilisateur("Durant", "Paul", Personne.ADMINISTRATEUR, "paul.durant", "tototo", "");
        new FentreIdentifatication();
    }
}
