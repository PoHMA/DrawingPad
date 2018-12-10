package draw.components.menubar;

import draw.components.scribble.Scribble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

public class OpenFileListener implements ActionListener {

  private Scribble scribble;
  private JFileChooser chooser = new JFileChooser(".");

  OpenFileListener(Scribble scribble){
    this.scribble = scribble;
  }

  public void actionPerformed(ActionEvent e) {
    int retval = chooser.showDialog(null, "Open");
    if (retval == JFileChooser.APPROVE_OPTION) {
      File theFile = chooser.getSelectedFile();
      if (theFile != null) {
        if (theFile.isFile()) {
          String filename = chooser.getSelectedFile().getAbsolutePath();
          this.scribble.openFile(filename);
        }
      }
    }
  }
}
