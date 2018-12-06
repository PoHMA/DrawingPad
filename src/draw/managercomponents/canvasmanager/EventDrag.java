
package draw.managercomponents.canvasmanager;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EventDrag
    implements MouseMotionListener {

  private DrawingCanvas drawingCanvas;

  EventDrag(DrawingCanvas drawingCanvas) {
    this.drawingCanvas = drawingCanvas;
  }

  public void mouseDragged(MouseEvent e) {
    Point p = e.getPoint();
    this.drawingCanvas.addPointToShape(p);
  }

  public void mouseMoved(MouseEvent e) {}

}

