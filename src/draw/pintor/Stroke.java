
package draw.pintor;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Stroke extends Shape {

  // The list of points on the stroke
  // elements are instances of java.awt.Point
  private List<Point> points = new ArrayList<>();

  public Stroke() {}

  public Stroke(List<Point> points){
    this.points = points;
  }

  public void addPoint(Point p) {
    if (p != null) {
      points.add(p);
    }
  }

  @Override
  public String getName() {
    return EShape.SCRIBBLE.toString();
  }

  @Override
  public Shape draw(DrawingArea drawingArea) {
    Stroke stroke = new Stroke();
    List<Point> lista = drawingArea.getPoints();
    return new Stroke(lista);
  }

  public List getPoints() {
    return points; 
  }

}
