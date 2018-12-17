package draw.pintor.implementations;

import draw.pintor.Dibujo;
import draw.pintor.interfaces.Edge;
import draw.pintor.interfaces.Nodo;
import java.awt.Point;

public class AgregationArrow extends Dibujo implements Edge {

  private LineShape line;
  private RhombusDibujo rhombusDibujo;
  private Nodo head;
  private Nodo tail;

  public AgregationArrow(){
    line = new LineShape();
    rhombusDibujo = new RhombusDibujo();
  }

  @Override
  public String getName() {
    return EShape.AGGREGATION.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    Point start = drawingArea.getPointStart();
    rhombusDibujo = new RhombusDibujo();
    rhombusDibujo.draw(drawingArea);
    Point end = rhombusDibujo.getL3().getP2();
    line = new LineShape(start, end);
  }

  public LineShape getLine(){
    return line;
  }

  public RhombusDibujo getRhombusDibujo(){
    return rhombusDibujo;
  }

  @Override
  public void union(Nodo v1, Nodo v2) {
    this.head = v2;
    this.tail = v1;
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }

}
