package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.AssociationArrow;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.LineShape;
import java.awt.Graphics;
import java.awt.Point;

public class AssociationPaint extends Paint {

  private AssociationArrow associationArrow;

  public AssociationPaint(){
    associationArrow = new AssociationArrow();
  }

  @Override
  public void draw(Graphics g, Dibujo dibujo) {
    if(dibujo instanceof AssociationArrow){
      LineShape line = ((AssociationArrow) dibujo).getLine();
      Point p1 = line.getP1();
      Point p2 = line.getP2();
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    associationArrow.draw(drawingArea);
    draw(g,associationArrow);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
