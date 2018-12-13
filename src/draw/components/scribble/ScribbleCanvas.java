package draw.components.scribble;

import draw.components.paint.LinePaint;
import draw.components.paint.OvalPaint;
import draw.components.paint.Paint;
import draw.components.paint.RectanglePaint;
import draw.components.paint.StrokePaint;
import draw.pintor.Pintor;
import draw.pintor.EShape;
import draw.pintor.Shape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

public class ScribbleCanvas extends JPanel {

  // The list of shapes of the drawing
  // The elements are instances of StrokePaint

  private Pintor pintor;
  private HashMap<String, Paint> map;

  public ScribbleCanvas(Pintor pintor) {
    this.pintor = pintor;
    init();
  }

  void init(){
    map = new HashMap<>();
    map.put(EShape.LINE.toString(), new LinePaint());
    map.put(EShape.OVAL.toString(), new OvalPaint());
    map.put(EShape.RECT.toString(), new RectanglePaint());
    map.put(EShape.SCRIBBLE.toString(), new StrokePaint());
  }

  public void paint(Graphics g) {
    List<Shape> shapes = pintor.getDrawings();
    Dimension dim = getSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, dim.width, dim.height);    
    g.setColor(Color.black);
    if (shapes != null) { 
      Iterator iter = shapes.iterator();
      while (iter.hasNext()) {
        Shape shape = (Shape) iter.next();
        Paint paint = map.get(shape.getName());
        paint.paintDraw(g, shape);
      }
    }
  }

  public void drawing(Shape shape, Point start, Point canvas) {
    Paint paint = map.get(shape.getName());
    paint.paintDrag(this, start, canvas);
  }

  public void paintPoint(Point p, Point canvas) {
    Graphics g = getGraphics();
    g.drawLine(canvas.x, canvas.y, p.x, p.y);
  }

}