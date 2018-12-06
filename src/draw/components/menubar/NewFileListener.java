package draw.components.menubar;

import draw.components.scribble.Scribble;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileListener implements ActionListener {

  private Scribble scribble;

  public NewFileListener(Scribble scribble){
    this.scribble = scribble;
  }

  public void actionPerformed(ActionEvent e) {
    scribble.newFile();
  }

}
