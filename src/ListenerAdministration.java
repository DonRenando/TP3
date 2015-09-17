import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sidya on 17/09/15.
 */
public class ListenerAdministration implements ActionListener {
    private FenetreAdministration f;
    public ListenerAdministration(FenetreAdministration f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(f.getAPropos()))
            JOptionPane.showMessageDialog(null, f.getUserConnected());
        
        else if(actionEvent.getSource().equals(f.getQuitter()))
            System.exit(0);

        else if(actionEvent.getSource().equals(f.getAjouter()))
            f.getP1().showForm(this, f.getListeUser());

        else if(actionEvent.getSource().equals(f.getP1().getAnnuler()))
            f.getP1().annuler();

        else if(actionEvent.getSource().equals(f.getP1().getValider()))
            f.getP1().valider(f.getListeUser(), f.getFileSave());

        else if(actionEvent.getSource().equals(f.getSupprimer()))
            f.getP2().showForm(this, f.getListeUser());

        else if(actionEvent.getSource().equals(f.getP2().getAnnuler()))
            f.getP2().annuler();

        else if(actionEvent.getSource().equals(f.getP2().getSupprimer()))
            f.getP2().valider(f.getListeUser(), f.getFileSave());

    }
}
