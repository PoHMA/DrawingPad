package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.RectangleDibujo;
import java.awt.Graphics;
import java.awt.Point;

public class RectanglePaint extends Paint {

  private RectangleDibujo rectangleDibujo;

  public RectanglePaint (){
    rectangleDibujo = new RectangleDibujo();
  }

  @Override
  public void draw(Graphics g, Dibujo dibujo) {
    if(dibujo instanceof RectangleDibujo){
      RectangleDibujo rectangleShape = (RectangleDibujo) dibujo;
      DrawingArea drawingArea = rectangleShape.getBounds();
      Point limitDownLeft = drawingArea.getLimitDownLeft();
      g.drawRect(limitDownLeft.x, limitDownLeft.y, drawingArea.getWidth(), drawingArea.getHeight());
    }
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {
    rectangleDibujo.draw(drawingArea);
    draw(g,rectangleDibujo);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
