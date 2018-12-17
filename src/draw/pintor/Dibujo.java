package draw.pintor;

import draw.pintor.implementations.DrawingArea;
import draw.pintor.interfaces.Selectable;
import java.awt.Color;
import java.io.Serializable;

public abstract class Dibujo implements Serializable, Cloneable, Selectable {

  private Color color ;

  public Dibujo(){
    this.color = Color.black;
  }

  public abstract String getName();
  public abstract void draw(DrawingArea drawingArea);

  public void setColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public Dibujo clone() throws CloneNotSupportedException{
    Dibujo clonDibujo = (Dibujo) super.clone();
    return clonDibujo;
  }

}
