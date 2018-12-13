package draw.pintor;

import java.awt.Point;

public class LineShape extends Shape {

  private Point p1;
  private Point p2;

  public LineShape() {
  }

  public LineShape(Point p1, Point p2){
    this.p1 = p1;
    this.p2 = p2;
  }

  @Override
  public String getName() {
    return EShape.LINE.toString();
  }

  @Override
  public Shape draw(DrawingArea drawingArea) {
    return new LineShape(drawingArea.getPointStart(), drawingArea.getPointEnd());
  }

  public Point getP1(){
    return p1;
  }

  public Point getP2(){
    return p2;
  }


}
