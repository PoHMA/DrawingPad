package draw.components.paint;

import draw.pintor.Shape;
import draw.pintor.Stroke;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

public class StrokePaint extends Paint{

  @Override
  public void draw(Graphics g, Shape tool) {
    if (tool instanceof Stroke){
      List points = ((Stroke) tool ).getPoints();
      Point prev = null;
      Iterator iter = points.iterator();
      while (iter.hasNext()) {
        Point cur = (Point) iter.next();
        if (prev != null) {
          g.drawLine(prev.x, prev.y, cur.x, cur.y);
        }
        prev = cur;
      }
    }
  }

  @Override
  void drag(Graphics g, Point start, Point end) {
    g.drawLine(end.x, end.y, end.x+5, end.y+5);
  }

}
