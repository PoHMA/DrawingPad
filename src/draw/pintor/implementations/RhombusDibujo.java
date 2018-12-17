package draw.pintor.implementations;


import draw.pintor.Dibujo;
import java.awt.Point;

public class RhombusDibujo extends Dibujo {


  @Override
  public String getName() {
    return EShape.RHOMBUS.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {

  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
