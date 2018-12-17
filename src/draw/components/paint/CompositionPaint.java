package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.AgregationArrow;
import draw.pintor.implementations.CompositionArrow;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.LineShape;
import draw.pintor.implementations.RhombusDibujo;
import java.awt.Graphics;
import java.awt.Point;

public class CompositionPaint extends Paint {

  private CompositionArrow compositionArrow;

  public CompositionPaint(){
    compositionArrow = new CompositionArrow();
  }

  @Override
  void draw(Graphics g, Dibujo shape) {
    Point start;
    Point end;
    LineShape line;
    int tamPolygon = 4;
    int [] x = new int[tamPolygon];
    int [] y = new int[tamPolygon];
    if (shape instanceof CompositionArrow){
      AgregationArrow agregationArrow = ((CompositionArrow) shape).getAgregationArrow();
      RhombusDibujo rhombusDibujo = agregationArrow.getRhombusDibujo();
      line = agregationArrow.getLine();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL1();
      start = line.getP1();
      end = line.getP2();
      x[0] = start.x;
      y[0] = start.y;
      x[1] = end.x;
      y[1] = end.y;
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL2();
      start = line.getP1();
      end = line.getP2();
      x[2] = start.x;
      y[2] = start.y;
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL3();
      start = line.getP1();
      end = line.getP2();
      x[3] = end.x;
      y[3] = end.y;
      g.drawLine(start.x, start.y, end.x, end.y);
      line = rhombusDibujo.getL4();
      start = line.getP1();
      end = line.getP2();
      g.drawLine(start.x, start.y, end.x, end.y);
      g.fillPolygon(x, y, tamPolygon);
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    compositionArrow.draw(drawingArea);
    draw(g,compositionArrow);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
