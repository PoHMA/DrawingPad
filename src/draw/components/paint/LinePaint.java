package draw.components.paint;

import draw.pintor.Shape;
import java.awt.Graphics;

public class LinePaint extends Paint {

  @Override
  public void draw(Graphics g, Shape tool) {
    g.drawLine(tool.getXStart(), tool.getYStart(), tool.getXEnd(), tool.getYEnd());
  }

  @Override
  void drag(Graphics g, Shape tool) {
    g.drawLine(tool.getXStart(), tool.getYStart(), tool.getXEnd(), tool.getYEnd());
  }

}
