package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;

public class RectangleDibujo extends Dibujo {

  private DrawingArea drawingArea;

  public RectangleDibujo() {
    drawingArea = new DrawingArea(new Point(0,0),new Point(0,0));
  }

  @Override
  public String getName() {
    return EShape.RECT.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    this.drawingArea = drawingArea;
  }

  public DrawingArea getBounds(){
    return drawingArea;
  }

  public int getWidth(){
    return drawingArea.getWidth();
  }

  public int getHeight(){
    return drawingArea.getHeight();
  }

  public Point getFirstVertice(){
    return drawingArea.getLimitDownLeft();
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
