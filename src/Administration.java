import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Administration extends JFrame {

    public Administration() {

        super("Application");

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("Fichier");
        JMenu gestion = new JMenu("Gestion");
        file.setMnemonic(KeyEvent.VK_F);
        gestion.setMnemonic(KeyEvent.VK_G);

        menubar.add(file);
        menubar.add(gestion);
        setJMenuBar(menubar);

        GridLayout mainGrid = new GridLayout(2, 3);
        mainGrid.setHgap(15); // 5 pixels d'espace entre les colonnes (H comme Horizontal)
        mainGrid.setVgap(15); //
        main.setLayout(mainGrid);

        JPanel P1 = new JPanel();

        TitledBorder titleNorthBorder = new TitledBorder("P1");
        titleNorthBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P1.setBorder(titleNorthBorder);

        JPanel P2 = new JPanel();
        P2.setBorder(BorderFactory.createLineBorder(Color.black));

        TitledBorder titleNorthBorder2 = new TitledBorder("P2");
        titleNorthBorder2.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P2.setBorder(titleNorthBorder2);

        JPanel P3 = new JPanel();

        TitledBorder titleNorthBorder3 = new TitledBorder("P3");
        titleNorthBorder3.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P3.setBorder(titleNorthBorder3);

        JPanel P4 = new JPanel();

        TitledBorder titleNorthBorder4 = new TitledBorder("P4");
        titleNorthBorder4.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P4.setBorder(titleNorthBorder4);


        JPanel P5 = new JPanel();

        TitledBorder titleNorthBorder5 = new TitledBorder("P5");
        titleNorthBorder5.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P5.setBorder(titleNorthBorder5);


        JPanel P6 = new JPanel();
        TitledBorder titleNorthBorder6 = new TitledBorder("P6");
        titleNorthBorder6.setTitleFont(new Font("Arial", Font.BOLD, 15));
        P6.setBorder(titleNorthBorder6);

        P1.setLayout(new BorderLayout());
        P2.setLayout(new BorderLayout());
        P3.setLayout(new BorderLayout());
        P3.setLayout(new BorderLayout());
        P4.setLayout(new BorderLayout());
        P5.setLayout(new BorderLayout());
        P6.setLayout(new BorderLayout());

        main.add(P1);
        main.add(P2);
        main.add(P3);
        main.add(P4);
        main.add(P5);
        main.add(P6);







        this.setContentPane(main);
        this.setVisible(true);
        this.setSize(1200, 600);
    }

}
