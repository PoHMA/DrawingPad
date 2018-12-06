
package draw.pintor;

import draw.components.scribble.ScribbleCanvas;
import java.awt.Graphics;
import java.awt.Point;

public class ScribbleTool extends AbstractTool {

  private Stroke curStroke = null;
  private ScribbleCanvas canvas;

  ScribbleTool(ScribbleCanvas scribbleCanvas, String name) {
    super(name);
    this.canvas = scribbleCanvas;
  }

  public void startShape(Point p) {
    curStroke = new Stroke(canvas.getCurColor()); 
    curStroke.addPoint(p); 
  }

  public void addPointToShape(Point p) {
    Point canvasShape = new Point(0,0);
    if (curStroke != null) { 
      curStroke.addPoint(p); 
      Graphics g = canvas.getGraphics();
      g.setColor(canvas.getCurColor());
      g.drawLine(canvasShape.x, canvasShape.y, p.x, p.y);
    }
  }

  public void endShape(Point p) {
    if (curStroke != null) { 
      curStroke.addPoint(p); 
      canvas.addShape(curStroke); 
      curStroke = null; 
    }
  }

  @Override
  public Shape getShape() {
    return this.curStroke;
  }

}
