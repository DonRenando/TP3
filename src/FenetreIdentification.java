import metier.ListeUtilisateursImpl;

import java.awt.*;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FenetreIdentification extends JDialog {
    private ListeUtilisateursImpl userlist;

    private JTextField login;
    private JButton valider;
    private JPasswordField mdp;
    private JPanel global;
    private File fileSave;

    public FenetreIdentification(ListeUtilisateursImpl userlist, File fileSave) {
        this.userlist = userlist;
        this.fileSave = fileSave;

        valider = new JButton("Connexion");
        login = new JTextField("paul.durant");
        mdp = new JPasswordField("tototo");
        global = new JPanel();

        TitledBorder title = new TitledBorder("Connexion à l'Application");
        title.setTitleFont(new Font("Arial", Font.BOLD, 15));

        valider.addActionListener(new ListenerConnection(this));

        global.setLayout(new GridLayout(3, 2));

        global.setBorder(title);


        global.add(new JLabel("Identifiant : "));
        global.add(login);
        global.add(new JLabel("Mot de Passe : "));
        global.add(mdp);
        global.add(new JPanel());
        global.add(valider);
        this.add(global);


        this.addWindowListener(new ListenerCloseWindow());

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public JTextField getLogin() {
        return login;
    }

    public JPasswordField getMdp() {return mdp;}

    public ListeUtilisateursImpl getUserList() {return userlist;}

    public File getFileSave() {
        return fileSave;
    }
}
