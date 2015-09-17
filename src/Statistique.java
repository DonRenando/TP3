import metier.ListeUtilisateursImpl;
import metier.Utilisateur;

import javax.swing.*;
import java.io.File;


public class Statistique extends JFrame {
    public Statistique(ListeUtilisateursImpl userList, Utilisateur user, File fileSave) {
        super("Statistique");
    }
}