package draw.components.paint;

import draw.pintor.DrawingArea;
import draw.pintor.RectangleShape;
import draw.pintor.Shape;
import java.awt.Graphics;
import java.awt.Point;

public class RectanglePaint extends Paint {

  @Override
  public void draw(Graphics g, Shape shape) {
    paintRectangle(g,shape);
  }

  @Override
  void drag(Graphics g, Point start, Point end) {
    int x,y,w,h;
    x = start.x;
    y = start.y;
    w = end.x - start.x + 1;
    h = end.y - start.y + 1;
    if (w < 0) {
      x = x + w;
      w = -w;
    }
    if (h < 0) {
      y = y + h;
      h = -h;
    }
    g.drawRect(x, y, w, h);
  }

  private void paintRectangle(Graphics g, Shape shape) {
    if(shape instanceof RectangleShape){
      RectangleShape rectangleShape = (RectangleShape) shape;
      DrawingArea drawingArea = rectangleShape.getBounds();
      Point limitDownLeft = drawingArea.getLimitDownLeft();
      g.drawRect(limitDownLeft.x, limitDownLeft.y, drawingArea.getWidth(), drawingArea.getHeight());
    }
  }

}
