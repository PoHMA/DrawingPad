package draw.components.paint;

import draw.pintor.LineShape;
import draw.pintor.Shape;
import java.awt.Graphics;
import java.awt.Point;

public class LinePaint extends Paint {

  @Override
  public void draw(Graphics g, Shape shape) {
    paintLine(g,shape);
  }

  @Override
  void drag(Graphics g, Point start, Point end) {
    g.drawLine(start.x, start.y, end.x, end.y);
  }

  private void paintLine(Graphics g, Shape shape) {
    if(shape instanceof LineShape){
      LineShape line = (LineShape) shape;
      Point p1 = line.getP1();
      Point p2 = line.getP2();
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
  }


}
