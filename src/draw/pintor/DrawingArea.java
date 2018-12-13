package draw.pintor;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

public class DrawingArea implements Serializable {

  private Point limitTopRight;
  private Point limitDownLeft;
  private Point limitTopLeft;
  private Point limitDownRight;
  private int width;
  private int height;
  private Point start;
  private Point end;
  private List<Point> points;

  public DrawingArea(List<Point> points){
    this.points = points;
    init();
  }

  private void init(){
    limitDownLeft = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
    limitTopRight = new Point(0,0);
    limitDownRight = new Point(0,Integer.MAX_VALUE);
    limitTopLeft = new Point(Integer.MAX_VALUE,0);
    start = new Point();
    end = new Point();
    calculateVertices();
  }

  private void calculateVertices() {
    if(points.size() > 0){
      start = points.get(0);
      end = points.get(points.size()-1);
      for(Point p: points){
        limitDownRight.x = Math.max(p.x, limitDownRight.x);
        limitDownRight.y = Math.min(p.y, limitDownRight.y);
        limitTopLeft.x = Math.min(p.x, limitTopLeft.x);
        limitTopLeft.y = Math.max(p.y, limitTopLeft.y);
        limitDownLeft.x = Math.min(p.x, limitDownLeft.x);
        limitDownLeft.y = Math.min(p.y, limitDownLeft.y);
        limitTopRight.x = Math.max(p.x, limitTopRight.x);
        limitTopRight.y = Math.max(p.y, limitTopRight.y);
      }
      width = limitTopRight.x - limitDownLeft.x;
      height = limitTopRight.y - limitDownLeft.y;
    }
  }

  public Point getLimitDownLeft(){
    return limitDownLeft;
  }

  public Point getPointStart(){
    return start;
  }

  public Point getPointEnd(){
    return end;
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }

  public List<Point> getPoints(){
    return points;
  }

}
