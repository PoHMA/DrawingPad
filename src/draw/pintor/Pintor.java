package draw.pintor;

import draw.components.scribble.ScribbleCanvas;
import java.awt.Point;

public class Pintor extends Notificador{

  private ToolKit drawings ;
  private Tool tool;
  private boolean mouseButtonDown;

  public Pintor(){
    mouseButtonDown = false;
    drawings = new ToolKit();
    remenber();
  }

  private void remenber() {
    drawings.addTool(new ScribbleTool("Scribble"));
    drawings.addTool(new TwoEndsTool("Line", new LineShape()));
    drawings.addTool(new TwoEndsTool("Oval", new OvalShape()));
    drawings.addTool(new TwoEndsTool("Rectangle", new RectangleShape()));
    setTool(drawings.getTool(0));
  }

  public void startShape(Point p) {
    mouseButtonDown = true;
    this.tool.startShape(p);
    notifyDrawing(this.tool.getShape());
  }

  public void addPointToShape(Point p) {
    if (mouseButtonDown) {
      notifyDrawing( this.tool.getShape());
      this.tool.addPointToShape(p);
      notifyDrawing( this.tool.getShape());
      this.tool.addPointToShape(p);
    }
  }

  public void endShape(Point p) {
    this.tool.endShape(p);
    mouseButtonDown = false;
  }

  public Tool getTool() {
    return this.tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public ToolKit getToolkit() {
    return drawings;
  }

}
