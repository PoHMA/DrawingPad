package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;

public class Text extends Dibujo {

  private String text;
  private int width;
  private int height;
  private Point corner;

  Text(){
    corner = new Point();
    text = "Text";
    width = 0;
    height = 10;
  }

  Text(Point corner, String text, int width){
    this.corner = corner;
    this.text = text;
    this.width = width;
    this.height = 10;
  }

  @Override
  public String getName() {
    return EShape.TEXT.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    height = 10;
    corner = new Point(drawingArea.getPointStart().x,drawingArea.getPointStart().y);
    corner.x = corner.x + 5;
    width = drawingArea.getWidth();
    corner.y = corner.y + height;
  }

  public Point getCenter(){
    return corner;
  }

  public String getText(){
    return this.text;
  }

  public int getWidth(){
    return width;
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
