package draw.components.scribble;

import draw.components.tool.Paint;
import draw.persistencia.DataBase;
import draw.pintor.Shape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

public class ScribbleCanvas extends JPanel {

  // The list of shapes of the drawing
  // The elements are instances of Stroke

  private Color curColor = Color.black;
  private DataBase dataBase;

  public ScribbleCanvas() {
    // calling factory method
    dataBase = DataBase.getInstance();
  }

  public void setCurColor(Color curColor) {
    this.curColor = curColor; 
  }

  public Color getCurColor() { 
    return curColor; 
  }

  public void addShape(Shape shape) {
    if (shape != null) {
      dataBase.addShape(shape);
    }
  }

  public void paint(Graphics g) {
    List<Shape> shapes = dataBase.getShapes();
    Dimension dim = getSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, dim.width, dim.height);    
    g.setColor(Color.black);
    if (shapes != null) { 
      Iterator iter = shapes.iterator();
      while (iter.hasNext()) {
        Shape shape = (Shape) iter.next();
        if (shape != null) {
          Paint paint = dataBase.getPaint(shape);
          paint.draw(g, shape);
        }
      }
    }
  }

}