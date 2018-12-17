package draw.managercomponents.menumanager;

import draw.components.menubar.ColorDialog;
import draw.components.menubar.NavBar;
import draw.components.scribble.Scribble;
import draw.components.scribble.ScribbleCanvas;
import draw.managercomponents.canvasmanager.DrawingCanvas;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.Pintor;
import java.awt.Color;

public class MenuManager {

  private NavBar navBar;
  private ColorDialog dialog ;
  private Pintor pintor;
  private DrawingCanvas drawingCanvas;

  public MenuManager(Scribble scribble, Pintor pintor, DrawingCanvas drawingCanvas) {
    this.pintor = pintor;
    this.drawingCanvas = drawingCanvas;
    navBar = new NavBar(scribble, this);
    dialog = new ColorDialog(scribble, "Choose color", pintor.getColor() );
  }

  void changeColor(){
    Color result = dialog.showDialog();
    if (result != null) {
      pintor.changeColor(result);
    }
  }

  public NavBar getComponent(){
    return navBar;
  }

  public void undoItem() {
    this.drawingCanvas.undo();
  }

}
