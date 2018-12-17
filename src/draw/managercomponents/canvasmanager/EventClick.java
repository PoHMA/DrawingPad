
package draw.managercomponents.canvasmanager;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventClick
    implements MouseListener {

  private DrawingCanvas drawingCanvas;

  EventClick(DrawingCanvas drawingCanvas) {
    this.drawingCanvas = drawingCanvas;
  }

  public void mousePressed(MouseEvent e) {
    Point p = e.getPoint();
    this.drawingCanvas.startShape(p);
  }

  public void mouseReleased(MouseEvent e) {
    Point p = e.getPoint();
    if(e.getButton() == 1){
      this.drawingCanvas.endShape(p);
    }else{
      this.drawingCanvas.setUpDibujo(p);
    }
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {}  
  public void mouseExited(MouseEvent e) {}

}

