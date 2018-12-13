
package draw.pintor;

import java.awt.Color;
import java.io.Serializable;

public abstract class Shape implements Serializable, Cloneable {

  private Color color ;

  public Shape() {
    this.color = Color.black;
  }

  public  abstract String getName();
  public abstract Shape draw(DrawingArea drawingArea);

  public void setColor(Color color) {
    this.color = color; 
  }

  public Color getColor() {
    return color; 
  }


}
