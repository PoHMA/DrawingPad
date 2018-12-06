
package draw.pintor;

import draw.components.scribble.ScribbleCanvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ScribbleTool extends AbstractTool {

  private Stroke curStroke = null;
  private Point canvasShape;

  ScribbleTool(String name) {
    super(name);
    canvasShape = new Point();
  }

  public void startShape(Point p) {
    curStroke = new Stroke(Color.BLACK);
    curStroke.addPoint(p);
    curStroke.setPointStart(p.x, p.y);
    curStroke.setPointEnds(p.x, p.y);
    canvasShape.x = p.x;
    canvasShape.y = p.y;
  }

  public void addPointToShape(Point p) {
    if (curStroke != null) {
      curStroke.addPoint(p);
      curStroke.setPointStart(canvasShape.x,canvasShape.y);
      curStroke.setPointEnds(p.x,p.y);
      canvasShape.x = p.x;
      canvasShape.y = p.y;
    }
  }

  public void endShape(Point p) {
    if (curStroke != null) {
      curStroke.addPoint(p);
      //canvas.addShape(curStroke);
      curStroke = null;
    }
  }

  @Override
  public Shape getShape() {
    return this.curStroke;
  }

}
