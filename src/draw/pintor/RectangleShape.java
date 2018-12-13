package draw.pintor;

public class RectangleShape extends Shape {

  private DrawingArea drawingArea;

  public RectangleShape() {
  }

  public RectangleShape(DrawingArea drawingArea) {
    this.drawingArea = drawingArea;
  }

  @Override
  public String getName() {
    return EShape.RECT.toString();
  }

  @Override
  public Shape draw(DrawingArea drawingArea) {
    return new RectangleShape(drawingArea);
  }

  public DrawingArea getBounds(){
    return drawingArea;
  }

}
