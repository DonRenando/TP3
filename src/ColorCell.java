import metier.Personne;
import metier.Utilisateur;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

import static metier.Personne.*;

/**
 * Created by renando on 02/11/15.
 */
public class ColorCell extends DefaultTableCellRenderer {

    public ColorCell()
    {
        super();
    }
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        setOpaque(false);

        if(column == 2) {
            setOpaque(true);
            switch (((String)value)) {
                case ADMINISTRATEUR:
                    setForeground(Color.black);
                    setBackground(Color.red);
                    break;
                case STATISTICIEN:
                    setForeground(Color.black);
                    setBackground(Color.ORANGE);
                    break;
                case PATIENT:
                    setForeground(Color.black);
                    setBackground((Color.cyan));
                    break;
                case INFIRMIER:
                    setForeground(Color.black);
                    setBackground(Color.green);
                    break;
                default:
                    setForeground(Color.black);
                    setBackground(Color.WHITE);
                    break;


            }
        }
        setText(value != null ? value.toString() : "");
        return this;
    }
}
