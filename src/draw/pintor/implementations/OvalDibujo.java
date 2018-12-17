package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;

public class OvalDibujo extends Dibujo {

  private DrawingArea drawingArea;
  private int width;
  private int height;
  private Point central;

  public OvalDibujo() {
    central = new Point();
  }

  @Override
  public String getName() {
    return EShape.OVAL.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    this.drawingArea = drawingArea;
    this.central.x = drawingArea.getWidth()/2;
    this.central.y = drawingArea.getHeight()/2;
    this.width = drawingArea.getWidth();
    this.height = drawingArea.getHeight();
  }

  public DrawingArea getBounds(){
    return drawingArea;
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
