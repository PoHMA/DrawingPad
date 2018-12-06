package draw.components.tool;

import draw.pintor.Shape;
import java.awt.Graphics;

public class OvalPaint extends Paint {

  @Override
  public void draw(Graphics g, Shape tool) {
    int x, y, w ,h;
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
    g.drawOval(x, y, w, h);
  }

  @Override
  void drag(Graphics g, Shape tool) {
    int x, y, w ,h;
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
    g.drawOval(x, y, w, h);
  }

}
