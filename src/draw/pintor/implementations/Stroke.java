
package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Stroke extends Dibujo {

  // The list of points on the stroke
  // elements are instances of java.awt.Point
  private List<Point> points = new ArrayList<>();
  private DrawingArea drawingArea;

  Stroke() {}

  Stroke(List<Point> points){
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
  public void draw(DrawingArea drawingArea) {
    this.drawingArea = drawingArea;
  }

  public List<Point> getPoints() {
    return points; 
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
