import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sidya on 17/09/15.
 */
public class ListenerAdministration implements ActionListener {
    private Administration f;
    public ListenerAdministration(Administration f) {
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(f.getAPropos()))
            JOptionPane.showMessageDialog(null, f.getUserConnected());

    }
}
