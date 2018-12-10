package draw.providers.menumanager;

import draw.components.menubar.ColorDialog;
import draw.components.scribble.ScribbleCanvas;
import draw.components.scribble.Scribble;
import draw.pintor.Pintor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorListener implements ActionListener {


  private ColorDialog dialog ;
  private Pintor pintor;

  public ColorListener(Scribble scribble, Pintor pintor){
    this.pintor = pintor;
    dialog = new ColorDialog(scribble, "Choose color", pintor.getColor() );
  }

  public void actionPerformed(ActionEvent e) {
    Color result = dialog.showDialog();
    if (result != null) {
      pintor.changeColor(result);
    }
  }

}
