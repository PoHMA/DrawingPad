package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.AgregationArrow;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.LineShape;
import draw.pintor.implementations.RhombusDibujo;
import java.awt.Graphics;
import java.awt.Point;

public class AgregationPaint extends Paint {

  private AgregationArrow agregationArrow;

  public AgregationPaint(){
    agregationArrow = new AgregationArrow();
  }

  @Override
  void draw(Graphics g, Dibujo shape) {
    Point start;
    Point end;
    LineShape line;
    if (shape instanceof AgregationArrow){
      AgregationArrow agregationArrow = (AgregationArrow) shape;
      RhombusDibujo rhombusDibujo = agregationArrow.getRhombusDibujo();
      line = agregationArrow.getLine();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL1();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL2();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL3();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL4();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    agregationArrow.draw(drawingArea);
    draw(g,agregationArrow);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
