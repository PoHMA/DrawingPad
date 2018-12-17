package draw.components.paint;

import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.ClassDrawing;
import draw.pintor.implementations.RectangleDibujo;
import draw.pintor.implementations.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;

public class ClassPaint extends Paint {

  private ClassDrawing classDrawing;

  public ClassPaint(){
    classDrawing = new ClassDrawing();
  }

  @Override
  void draw(Graphics g, Dibujo shape) {
    if (shape instanceof ClassDrawing){
      classDrawing = (ClassDrawing) shape;
      RectangleDibujo rectangleDibujo = classDrawing.getRectangle();
      Point v1 = rectangleDibujo.getFirstVertice();
      clear(g,v1,rectangleDibujo.getWidth(),rectangleDibujo.getHeight());
      g.setColor(shape.getColor());
      Text text = classDrawing.getTitle();
      Point center = text.getCenter();
      g.drawString(text.getText(), center.x, center.y);
      g.drawRect(v1.x,v1.y,
          rectangleDibujo.getWidth(),rectangleDibujo.getHeight());
    }
  }

  private void clear(Graphics g, Point start, int width, int height){
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(start.x,start.y, width, height);
  }

  @Override
  void drag(Graphics g, DrawingArea drawingArea) {

  }

  @Override
  public Dibujo modify(Dibujo dibujo) {
    String nombre = JOptionPane.showInputDialog("Inserte Su nombre");
    if( dibujo instanceof ClassDrawing){
      ClassDrawing classDrawing = (ClassDrawing) dibujo;
      classDrawing.setTitle(nombre);
    }
    return dibujo;
  }

}
