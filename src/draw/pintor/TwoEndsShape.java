package draw.pintor;

import java.awt.Graphics;
import java.awt.Color;

public abstract class TwoEndsShape extends Shape implements Cloneable {

  TwoEndsShape() {}
  
  public TwoEndsShape(Color color) {
    super(color); 
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public abstract void drawOutline(Graphics g, int x1, int y1, int x2, int y2);

}
