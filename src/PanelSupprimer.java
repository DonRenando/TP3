import metier.ListeUtilisateursImpl;
import metier.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelSupprimer extends JPanel{
    private JLabel labelListe;
    private JComboBox comboBoxListe;
    private JButton buttonSupprimer;
    private JButton buttonAnnuler;


    public PanelSupprimer(){
        super();
    }

    public void showForm(ListenerAdministration listener, ListeUtilisateursImpl userlist) {
        JPanel container = new JPanel();
        this.add(container);
        container.setLayout(new GridLayout(2, 2));

        labelListe = new JLabel("Liste utilisateurs : ");
        comboBoxListe = new JComboBox();
        for (Utilisateur u : userlist.getUtilisateurs())
            comboBoxListe.addItem(u.getLogin());
        buttonSupprimer = new JButton("Supprimer");
        buttonAnnuler = new JButton("Annuler");

        container.add(labelListe);
        container.add(comboBoxListe);
        container.add(buttonSupprimer);
        container.add(buttonAnnuler);

        buttonAnnuler.addActionListener(listener);
        buttonSupprimer.addActionListener(listener);

        this.validate();
    }

    public JButton getAnnuler() {
        return buttonAnnuler;
    }

    public void annuler() {
        this.removeAll();
        this.repaint();
    }

    public JButton getSupprimer() {
        return buttonSupprimer;
    }

    public void valider(ListeUtilisateursImpl listeUser, File fileSave) {
        listeUser.supprimerUtilisateur(listeUser.obtenirNumeroLigneUtilisateur(comboBoxListe.getSelectedItem().toString()));
        listeUser.sauverListe(fileSave);
        annuler();
    }
}
