package draw.components.tool;

import draw.pintor.Shape;
import java.awt.Graphics;

public class LinePaint implements Paint {

  @Override
  public void draw(Graphics g, Shape tool) {
    g.drawLine(tool.getXStart(), tool.getYStart(), tool.getXEnd(), tool.getYEnd());
  }
}
