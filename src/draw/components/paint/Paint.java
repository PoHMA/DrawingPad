package draw.components.paint;

import draw.components.scribble.ScribbleCanvas;
import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Paint {

  public void paintDraw(Graphics g, Dibujo dibujo){
    g.setPaintMode();
    g.setColor(dibujo.getColor());
    draw(g, dibujo);
  }

  public void paintDrag(ScribbleCanvas scribbleCanvas, DrawingArea drawingArea){
    Graphics g = scribbleCanvas.getGraphics();
    g.setXORMode(Color.darkGray);
    g.setColor(Color.lightGray);
    drag(g,drawingArea);
  }

  abstract void draw(Graphics g, Dibujo shape);
  abstract void drag(Graphics g, DrawingArea drawingArea);
  public abstract Dibujo modify(Dibujo dibujo);
}
