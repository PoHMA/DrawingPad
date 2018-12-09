package draw.components.paint;

import draw.pintor.Shape;
import java.awt.Graphics;

public class RectanglePaint extends Paint {

  @Override
  public void draw(Graphics g, Shape tool) {
    int x, y, w, h;
    x = tool.getXStart();
    y = tool.getYStart();
    w = tool.getWidth();
    h = tool.getHeight();
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

  @Override
  void drag(Graphics g, Shape tool) {
    int x, y, w, h;
    x = tool.getXStart();
    y = tool.getYStart();
    w = tool.getWidth();
    h = tool.getHeight();
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

}