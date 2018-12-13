package draw.pintor;

public class OvalShape extends Shape {

  private DrawingArea drawingArea;

  public OvalShape() {
  }

  OvalShape(DrawingArea drawingArea){
    this.drawingArea = drawingArea;
  }

  @Override
  public String getName() {
    return EShape.OVAL.toString();
  }

  @Override
  public Shape draw(DrawingArea drawingArea) {
    return new OvalShape(drawingArea);
  }

  public DrawingArea getBounds(){
    return drawingArea;
  }

}
