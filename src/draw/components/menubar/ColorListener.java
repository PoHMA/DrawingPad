package draw.components.menubar;

import draw.components.scribble.ScribbleCanvas;
import draw.components.scribble.Scribble;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorListener implements ActionListener {


  private ColorDialog dialog ;
  private ScribbleCanvas scribbleCanvas;

  public ColorListener(Scribble scribble, ScribbleCanvas scribbleCanvas){
    this.scribbleCanvas = scribbleCanvas;
    dialog = new ColorDialog(scribble, "Choose color", scribbleCanvas.getCurColor());
  }

  public void actionPerformed(ActionEvent e) {
    Color result = dialog.showDialog();
    if (result != null) {
      scribbleCanvas.setCurColor(result);
    }
  }
}
