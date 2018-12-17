package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.LineShape;
import draw.pintor.implementations.Inheritance;
import java.awt.Graphics;

public class InheritancePaint extends Paint {

  private Inheritance inheritanceModel;

  public InheritancePaint(){
    inheritanceModel = new Inheritance();
  }

  @Override
  void draw(Graphics g, Dibujo shape) {
    if(shape instanceof Inheritance){
      Inheritance inheritance = (Inheritance) shape;
      LineShape lineShape = inheritance.getLine();
      LineShape lineShape1 = inheritance.getLine1();
      LineShape lineShape2 = inheritance.getLine2();
      LineShape lineShape3 = inheritance.getLine3();
      g.drawLine(lineShape.getP1().x, lineShape.getP1().y, lineShape.getP2().x, lineShape.getP2().y);
      g.drawLine(lineShape1.getP1().x, lineShape1.getP1().y, lineShape1.getP2().x, lineShape1.getP2().y);
      g.drawLine(lineShape2.getP1().x, lineShape2.getP1().y, lineShape2.getP2().x, lineShape2.getP2().y);
      g.drawLine(lineShape3.getP1().x, lineShape3.getP1().y, lineShape3.getP2().x, lineShape3.getP2().y);
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    inheritanceModel.draw(drawingArea);
    draw(g,inheritanceModel);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
