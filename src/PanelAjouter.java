import metier.ListeUtilisateursImpl;
import metier.Personne;
import metier.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelAjouter extends JPanel {
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelRole;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JLabel labelSuperieur;

    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldLogin;

    private JComboBox<String> comboBoxRole;
    private JComboBox<String> comboBoxSuperieur;

    private JPasswordField passwordFiledPassword;

    private JButton buttonValider;
    private JButton buttonAnnuler;


    public PanelAjouter() {
        super();
    }

    public void showForm(ListenerAdministration listener, ListeUtilisateursImpl userlist) {
        this.setLayout(new GridLayout(7, 2));

        labelNom = new JLabel("Nom : ");
        labelPrenom = new JLabel("Prenom : ");
        labelRole = new JLabel("Role : ");
        labelLogin = new JLabel("Identifiant : ");
        labelPassword = new JLabel("Mot de passe : ");
        labelSuperieur = new JLabel("Superieur : ");

        textFieldNom = new JTextField();
        textFieldPrenom = new JTextField();
        textFieldLogin = new JTextField();

        String[] listeRole = {"ADMINISTRATEUR", "STATISTICIEN", "INFIRMIER", "PATIENT"};
        comboBoxRole = new JComboBox<String>(listeRole);

        comboBoxSuperieur = new JComboBox();
        comboBoxSuperieur.addItem("");
        for (Utilisateur u : userlist.getUtilisateurs())
            comboBoxSuperieur.addItem(u.getLogin());


        passwordFiledPassword = new JPasswordField();

        buttonValider = new JButton("Valider");
        buttonAnnuler = new JButton("Annuler");

        this.add(labelNom);
        this.add(textFieldNom);
        this.add(labelPrenom);
        this.add(textFieldPrenom);
        this.add(labelRole);
        this.add(comboBoxRole);
        this.add(labelLogin);
        this.add(textFieldLogin);
        this.add(labelPassword);
        this.add(passwordFiledPassword);
        this.add(labelSuperieur);
        this.add(comboBoxSuperieur);
        this.add(buttonAnnuler);
        this.add(buttonValider);

        buttonAnnuler.addActionListener(listener);
        buttonValider.addActionListener(listener);

        this.validate();
    }

    public void annuler() {
        this.removeAll();
        this.repaint();
    }

    public void valider(ListeUtilisateursImpl userList, File f) {
        Integer role =  Personne.getRolebyName(comboBoxRole.getSelectedItem().toString());

        userList.ajouterUtilisateur(new Utilisateur(textFieldNom.getText(),textFieldPrenom.getText(),
                role,textFieldLogin.getText(),
                new String(passwordFiledPassword.getPassword()),
                comboBoxSuperieur.getSelectedItem() != null ?
                        comboBoxSuperieur.getSelectedItem().toString() : ""));
        userList.sauverListe(f);
        annuler();
    }

    public JButton getAnnuler() {
        return buttonAnnuler;
    }

    public JButton getValider() {
        return buttonValider;
    }
}
