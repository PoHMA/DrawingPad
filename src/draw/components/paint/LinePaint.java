package draw.components.paint;

import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.LineShape;
import draw.pintor.Dibujo;
import java.awt.Graphics;
import java.awt.Point;

public class LinePaint extends Paint {

  private LineShape lineShape;

  public LinePaint(){
    lineShape = new LineShape();
  }

  @Override
  public void draw(Graphics g, Dibujo dibujo) {
    if(dibujo instanceof LineShape){
      LineShape line = (LineShape) dibujo;
      Point p1 = line.getP1();
      Point p2 = line.getP2();
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    lineShape.draw(drawingArea);
    draw(g,lineShape);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
