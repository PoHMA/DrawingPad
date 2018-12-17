package draw.components.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AboutListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null,
        "DrawingPad version 1.0\nCopyright (c) Xiaoping Jia 2002", "About",
        JOptionPane.INFORMATION_MESSAGE);
  }
}
