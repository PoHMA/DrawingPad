package draw.pintor.implementations;

import draw.library.Utils;
import draw.pintor.Dibujo;
import draw.pintor.interfaces.Edge;
import draw.pintor.interfaces.Nodo;
import java.awt.Point;

public class Inheritance extends Dibujo implements Edge {

  private DrawingArea drawingArea;
  private LineShape line;
  private LineShape l1;
  private LineShape l2;
  private LineShape l3;

  public Inheritance(){
    line = new LineShape();
    l1 = new LineShape();
    l2 = new LineShape();
    l3 = new LineShape();
  }

  @Override
  public String getName() {
    return EShape.INHERITANCE.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    double alfa;
    int xa1,ya1, xa2,ya2;
    Point start = drawingArea.getPointStart();
    Point end = drawingArea.getPointEnd();
    this.drawingArea = drawingArea;
    line = new LineShape(new Point(start.x,start.y),new Point(end.x,end.y));
    alfa = Math.atan2(end.y - start.y, end.x - start.x);
    xa1 = (int) (end.x - Utils.TAM_FIGURE * Math.cos(alfa + 1));
    ya1 = (int) (end.y - Utils.TAM_FIGURE * Math.sin(alfa + 1));
    l1 = new LineShape(new Point(xa1,ya1), new Point(end.x,end.y));
    xa2 = (int) (end.x - Utils.TAM_FIGURE * Math.cos(alfa - 1));
    ya2 = (int) (end.y - Utils.TAM_FIGURE * Math.sin(alfa - 1));
    l2 = new LineShape(new Point(xa2, ya2), new Point(end.x,end.y));
    l3 = new LineShape(new Point(xa1, ya1), new Point(xa2, ya2));
  }

  public LineShape getLine(){
    return line;
  }

  public LineShape getLine1(){
    return l1;
  }

  public LineShape getLine2(){
    return l2;
  }

  public LineShape getLine3(){
    return l3;
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }

  @Override
  public void union(Nodo v1, Nodo v2) {

  }

}
