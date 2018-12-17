package draw.components.scribble;

import draw.components.paint.AgregationPaint;
import draw.components.paint.AssociationPaint;
import draw.components.paint.ClassPaint;
import draw.components.paint.CompositionPaint;
import draw.components.paint.LinePaint;
import draw.components.paint.OvalPaint;
import draw.components.paint.Paint;
import draw.components.paint.RectanglePaint;
import draw.components.paint.StrokePaint;
import draw.components.paint.InheritancePaint;
import draw.pintor.Dibujo;
import draw.pintor.implementations.DrawingArea;
import draw.pintor.implementations.Pintor;
import draw.pintor.implementations.EShape;
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

  private void init(){
    map = new HashMap<>();
    map.put(EShape.LINE.toString(), new LinePaint());
    map.put(EShape.OVAL.toString(), new OvalPaint());
    map.put(EShape.RECT.toString(), new RectanglePaint());
    map.put(EShape.SCRIBBLE.toString(), new StrokePaint());
    map.put(EShape.INHERITANCE.toString(), new InheritancePaint());
    map.put(EShape.CLASS.toString(), new ClassPaint());
    map.put(EShape.AGGREGATION.toString(), new AgregationPaint());
    map.put(EShape.ASSOCIATION.toString(), new AssociationPaint());
    map.put(EShape.COMPOSITION.toString(), new CompositionPaint());
  }

  public void paint(Graphics g) {
    List<Dibujo> dibujos = pintor.getDrawingArea().getDrawings();
    Dimension dim = getSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, dim.width, dim.height);    
    g.setColor(Color.black);
    if (dibujos != null) {
      Iterator iter = dibujos.iterator();
      while (iter.hasNext()) {
        Dibujo dibujo = (Dibujo) iter.next();
        if(map.containsKey(dibujo.getName())){
          Paint paint = map.get(dibujo.getName());
          paint.paintDraw(g, dibujo);
        }
      }
    }
  }

  public void drawing(Dibujo dibujo, DrawingArea drawingArea) {
    if(map.containsKey(dibujo.getName())){
      Paint paint = map.get(dibujo.getName());
      paint.paintDrag(this, drawingArea);
    }
  }

  public void paintPoint(Point p, Point canvas, Color color) {
    Graphics g = getGraphics();
    g.setColor(color);
    g.drawLine(canvas.x, canvas.y, p.x, p.y);
  }

  public Dibujo modifyDrawing(Dibujo dibujo){
    Paint paint = map.get(dibujo.getName());
    return paint.modify(dibujo);
  }

}