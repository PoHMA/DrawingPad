package draw.pintor.implementations;

import draw.pintor.Dibujo;
import draw.pintor.interfaces.Nodo;
import java.awt.Point;

public class ClassDrawing extends Dibujo implements Nodo {

  private Text title;
  private RectangleDibujo rectangleDibujo;
  private final int WIDTH = 100;
  private final int HEIGHT = 100;

  public ClassDrawing(){
    this.title = new Text();
    rectangleDibujo = new RectangleDibujo();
  }

  @Override
  public String getName() {
    return EShape.CLASS.toString();
  }

  @Override
  public void draw(DrawingArea drawingAreaa) {
    title = new Text();
    rectangleDibujo = new RectangleDibujo();
    title.setText("Class");
    Point start = drawingAreaa.getPointStart();
    DrawingArea drawingArea = new DrawingArea(new Point(start.x, start.y),
        new Point(start.x + WIDTH, start.y + HEIGHT));
    title.draw(drawingAreaa);
    rectangleDibujo.draw(drawingArea);
  }

  public Text getTitle(){
    return title;
  }

  public void setTitle(String name){
    this.title.setText(name);
  }

  public RectangleDibujo getRectangle(){
    return rectangleDibujo;
  }

  @Override
  public boolean isSelected(Point p) {
    DrawingArea drawingArea = rectangleDibujo.getBounds();
    Point min = drawingArea.getLimitDownLeft();
    Point max = drawingArea.getLimitTopRight();
    return p.x >= min.x && p.y >= min.y && p.x <= max.x && p.y <= max.y;
  }

}
