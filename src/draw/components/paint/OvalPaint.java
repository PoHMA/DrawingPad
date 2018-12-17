package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.OvalDibujo;
import java.awt.Graphics;
import java.awt.Point;

public class OvalPaint extends Paint {

  private OvalDibujo ovalDibujo;

  public  OvalPaint(){
    ovalDibujo = new OvalDibujo();
  }

  @Override
  public void draw(Graphics g, Dibujo dibujo) {
    if(dibujo instanceof OvalDibujo){
      OvalDibujo ovalShape = (OvalDibujo) dibujo;
      DrawingArea drawingArea = ovalShape.getBounds();
      Point limitDownLeft = drawingArea.getLimitDownLeft();
      g.drawOval(limitDownLeft.x, limitDownLeft.y, drawingArea.getWidth(), drawingArea.getHeight());
    }
  }

  @Override
  void drag(Graphics g,DrawingArea drawingArea) {
    ovalDibujo.draw(drawingArea);
    draw(g,ovalDibujo);
  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    return null;
  }

}
