package draw.pintor.implementations;

import draw.pintor.Dibujo;
import java.awt.Point;

public class Text extends Dibujo {

  private String text;
  private int width;
  private int height;
  private Point corner;

  public Text(){
    corner = new Point();
    text = "Text";
    width = 0;
    height = 0;
  }

  @Override
  public String getName() {
    return EShape.TEXT.toString();
  }

  @Override
  public void draw(DrawingArea drawingArea) {
    width = drawingArea.getWidth();
    height = 10;
    corner = drawingArea.getPointStart();
    corner.x = corner.x + 35;
    corner.y = corner.y + height;
  }

  public Point getCenter(){
    return corner;
  }

  public String getFont(){
    return null;
  }

  public void setText(String cadena){
    this.text = cadena;
  }

  public String getText(){
    return this.text;
  }

  @Override
  public boolean isSelected(Point p) {
    return false;
  }
}
