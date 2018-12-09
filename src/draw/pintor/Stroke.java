
package draw.pintor;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.awt.Color;

public class Stroke extends Shape {

  // The list of points on the stroke
  // elements are instances of java.awt.Point
  private List<Point> points = new ArrayList<>();
  private int xStart, yStart, xEnd, yEnd;

  public Stroke() {} 
  
  Stroke(Color color) {
    super(color); 
  } 

  void addPoint(Point p) {
    if (p != null) {
      points.add(p);
    }
  }

  public List getPoints() { 
    return points; 
  }

  @Override
  public void setPointStart(int x, int y) {
    this.xStart = x;
    this.yStart = y;
  }

  @Override
  public void setPointEnds(int x, int y) {
    this.xEnd = x;
    this.yEnd = y;
  }

  @Override
  public int getXStart() {
    return xStart;
  }

  @Override
  public int getYStart() {
    return yStart;
  }

  @Override
  public int getXEnd() {
    return xEnd;
  }

  @Override
  public int getYEnd() {
    return yEnd;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

}
