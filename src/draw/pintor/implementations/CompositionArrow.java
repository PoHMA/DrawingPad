package draw.pintor.implementations;

import draw.pintor.Dibujo;
import draw.pintor.interfaces.Edge;
import draw.pintor.interfaces.Nodo;
import java.awt.Point;

public class CompositionArrow extends Dibujo implements Edge {

  private AgregationArrow agregationArrow;
  private Nodo head;
  private Nodo tail;

  public CompositionArrow(){
    agregationArrow = new AgregationArrow();
  }

  @Override
  public String getName() {
    return EShape.COMPOSITION.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    agregationArrow = new AgregationArrow();
    agregationArrow.draw(drawingArea);
  }

  public AgregationArrow getAgregationArrow(){
    return agregationArrow;
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
