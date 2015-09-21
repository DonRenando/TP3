import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by renando on 21/09/15.
 */
public class PanelListeUtilisateur extends JPanel {

    private JTable tableListe;
    public PanelListeUtilisateur(){
        super();
    }


    public void showListe(){

        JPanel container = new JPanel();
        this.add(container);

        tableListe = new JTable();

        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true },
                {"Nicolas", "Van de Kampf", Color.black, true},
                {"Damien", "Cuthbert", Color.cyan, true },
                {"Corinne", "Valance", Color.blue, false},
                {"Emilie", "Schrödinger", Color.magenta, false},
                {"Delphine", "Duke", Color.yellow, false},
                {"Eric", "Trump", Color.pink, true},
        };

        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme"};

        JTable tableau = new JTable(donnees, entetes);

        container.add(tableau);

        this.validate();
    }

}
