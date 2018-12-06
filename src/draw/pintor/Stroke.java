
package draw.pintor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Stroke extends Shape {

  // The list of points on the stroke
  // elements are instances of java.awt.Point
  private List<Point> points = new ArrayList<Point>();

  public Stroke() {} 
  
  public Stroke(Color color) {
    super(color); 
  } 

  public void addPoint(Point p) {
    if (p != null) {
      points.add(p);
    }
  }

  public List getPoints() { 
    return points; 
  }

  public void draw(Graphics g) {
    if (color != null) {
      g.setColor(color);
    }
    Point prev = null; 
    Iterator iter = points.iterator();
    while (iter.hasNext()) { 
      Point cur = (Point) iter.next(); 
      if (prev != null) {
      	g.drawLine(prev.x, prev.y, cur.x, cur.y);
      }
      prev = cur; 
    }
  }

  @Override
  public void setPointStart(int x, int y) {

  }

  @Override
  public void setPointEnds(int x, int y) {

  }

  @Override
  public int getXStart() {
    return 0;
  }

  @Override
  public int getYStart() {
    return 0;
  }

  @Override
  public int getXEnd() {
    return 0;
  }

  @Override
  public int getYEnd() {
    return 0;
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