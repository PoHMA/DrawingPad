package draw.components.paint;

import draw.components.scribble.ScribbleCanvas;
import draw.pintor.Shape;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Paint {

  public void paintDrag(ScribbleCanvas scribbleCanvas, Shape tool){
    Graphics g = scribbleCanvas.getGraphics();
    g.setXORMode(Color.darkGray);
    g.setColor(Color.lightGray);
    drag(g,tool);
  }

  public void paintDraw(Graphics g, Shape shape){
    g.setColor(shape.getColor());
    draw(g,shape);
  }

  abstract void draw(Graphics g, Shape tool);
  abstract void drag(Graphics g, Shape tool);
}
