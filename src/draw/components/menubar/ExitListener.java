package draw.components.menubar;

import draw.components.scribble.Scribble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitListener implements ActionListener {

  private Scribble scribble;

  ExitListener(Scribble scribble){
    this.scribble = scribble;
  }

  public void actionPerformed(ActionEvent e) {
    int result = JOptionPane.showConfirmDialog(null,
        "Do you want to exit Scribble Pad?",
        "Exit Scribble Pad?",
        JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      this.scribble.saveFile();
      System.exit(0);
    }else {
      scribble.setDefaultCloseOperation(JFrame.NORMAL);
    }
  }

}
