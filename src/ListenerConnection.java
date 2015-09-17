import metier.Personne;
import metier.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sidya on 09/09/15.
 */
public class ListenerConnection implements ActionListener{

    private FenetreIdentification f;
    public ListenerConnection(FenetreIdentification f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(f.getUserList().verifierIdentite(f.getLogin().getText(), new String(f.getMdp().getPassword())))
        {
            f.setVisible(false);
            Utilisateur user = f.getUserList().obtenirUtilisateur(
                f.getUserList().obtenirNumeroLigneUtilisateur(
                        f.getLogin().getText()));
            if(user.getRole().equals(Personne.ADMINISTRATEUR))
                new FenetreAdministration(f.getUserList(),user,f.getFileSave());
            else if (user.getRole().equals(Personne.STATISTICIEN))
                new Statistique(f.getUserList(),user,f.getFileSave());
            else JOptionPane.showMessageDialog(null, "Votre role n'est pas encore implément !Z");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe invalide !");
        }
    }
}
