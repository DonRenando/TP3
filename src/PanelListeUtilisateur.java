import metier.ListeUtilisateursImpl;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by renando on 21/09/15.
 */
public class PanelListeUtilisateur extends JPanel {

    private JTable tableListe;
    public PanelListeUtilisateur(){
        super();
        setLayout(new BorderLayout());
    }


    public void showListe(ListeUtilisateursImpl listeUser){




        tableListe = new JTable(listeUser);

        JScrollPane container = new JScrollPane(tableListe);
        this.add(container,BorderLayout.CENTER);

        this.validate();
    }

}
