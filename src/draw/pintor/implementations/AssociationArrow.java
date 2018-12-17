package draw.pintor.implementations;

import draw.pintor.Dibujo;
import draw.pintor.interfaces.Edge;
import draw.pintor.interfaces.Nodo;
import java.awt.Point;

public class AssociationArrow extends Dibujo implements Edge {

  private LineShape lineShape;
  private Nodo head;
  private Nodo tail;

  public AssociationArrow(){
    lineShape = new LineShape();
  }

  @Override
  public String getName() {
    return EShape.ASSOCIATION.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    lineShape = new LineShape(drawingArea.getPointStart(),drawingArea.getPointEnd());
  }

  public LineShape getLine(){
    return lineShape;
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
