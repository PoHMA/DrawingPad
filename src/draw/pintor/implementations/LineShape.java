package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;

public class LineShape extends Dibujo {

  private Point p1;
  private Point p2;
  private DrawingArea drawingArea;

  public LineShape() {
    this.p1 = new Point();
    this.p2 = new Point();
  }

  public LineShape(Point point, Point point1) {
    this.p1 = point;
    this.p2 = point1;
  }

  @Override
  public String getName() {
    return EShape.LINE.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    this.p1 = drawingArea.getPointStart();
    this.p2 = drawingArea.getPointEnd();
    this.drawingArea = drawingArea;
  }

  public Point getP1(){
    return p1;
  }

  public Point getP2(){
    return p2;
  }


  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
