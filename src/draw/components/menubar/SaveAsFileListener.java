package draw.components.menubar;

import draw.components.scribble.Scribble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;

public class SaveAsFileListener implements ActionListener {

  private JFileChooser chooser = new JFileChooser(".");
  private Scribble scribble;

  public SaveAsFileListener(Scribble scribble){
    this.scribble = scribble;
  }

  public void actionPerformed(ActionEvent e) {
    int retval = chooser.showDialog(null, "Save As");
    if (retval == JFileChooser.APPROVE_OPTION) {
      File theFile = chooser.getSelectedFile();
      if (theFile != null) {
        if (!theFile.isDirectory()) {
          String filename = chooser.getSelectedFile().getAbsolutePath();
          this.scribble.saveFileAs(filename);
        }
      }
    }
  }

}
