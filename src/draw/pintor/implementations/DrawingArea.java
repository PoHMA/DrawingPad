package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DrawingArea implements Serializable {

  private List<Dibujo> drawings;
  private Point limitTopRight;
  private Point limitDownLeft;
  private Point limitTopLeft;
  private Point limitDownRight;
  private int width;
  private int height;
  private Point[] points;

  public DrawingArea(Point start, Point end){
    drawings = new ArrayList<Dibujo>();
    points = new Point[2];
    points[0] = start;
    points[1] = end;
    init();
  }

  private void init(){
    limitDownLeft = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
    limitTopRight = new Point(0,0);
    limitDownRight = new Point(0,Integer.MAX_VALUE);
    limitTopLeft = new Point(Integer.MAX_VALUE,0);
    calculateVertices();
  }

  public void addDibujo(Dibujo dibujo){
    if(dibujo != null){
      drawings.add(dibujo);
    }
  }

  private void calculateVertices() {
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

  public Point getLimitDownLeft(){
    return limitDownLeft;
  }

  public Point getPointStart(){
    return points[0];
  }

  public Point getPointEnd(){
    return points[1];
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }

  public List<Dibujo> getDrawings(){
    return drawings;
  }

  Point getLimitTopRight() {
    return limitTopRight;
  }

  void newDrawingArea() {
    this.drawings.clear();
  }

  public Dibujo removeDibujo(Point end) {
    Dibujo selected = null;
    for(int i = drawings.size()-1; i >= 0 ; i--){
      selected = drawings.get(i);
      if(selected.isSelected(end)){
        drawings.remove(i);
        break;
      }
    }
    return selected;
  }

  public boolean isSelectedDibujo(Point end){
    boolean selected = false;
    Dibujo d;
    for(int i = drawings.size()-1; i >= 0; i--){
      d = drawings.get(i);
      if(d.isSelected(end)){
        selected = true;
      }
    }
    return selected;
  }

}
