package draw.pintor;

import java.awt.Point;

public class TwoEndsTool extends AbstractTool {

  private Shape shape;
  TwoEndsTool(String name, Shape shape) {
    super(name);
    this.shape = shape;
  }

  @Override
  public void startShape(Point p) {
    this.shape.setPointStart(p.x, p.y);
    this.shape.setPointEnds(p.x, p.y);
  }

  @Override
  public void addPointToShape(Point p) {
    this.shape.setPointEnds(p.x, p.y);
  }

  @Override
  public void endShape(Point p) {
    this.shape.setPointEnds(p.x, p.y);
  }

  @Override
  public Shape getShape() {
    Shape shapeCopy = null;
    try {
      shapeCopy = this.shape.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return shapeCopy;
  }

}
