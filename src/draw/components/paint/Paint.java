package draw.components.paint;

import draw.components.scribble.ScribbleCanvas;
import draw.pintor.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Paint {

  public void paintDraw(Graphics g, Shape shape){
    g.setPaintMode();
    g.setColor(shape.getColor());
    draw(g,shape);
  }

  public void paintDrag(ScribbleCanvas scribbleCanvas, Point start, Point end){
    Graphics g = scribbleCanvas.getGraphics();
    g.setXORMode(Color.darkGray);
    g.setColor(Color.lightGray);
    drag(g,start, end);
  }

  abstract void draw(Graphics g, Shape tool);
  abstract void drag(Graphics g, Point start, Point end);
}
