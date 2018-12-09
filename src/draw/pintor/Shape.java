
package draw.pintor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable, Cloneable {

  private Color color = Color.black;

  public Shape() {}

  public Shape clone() throws CloneNotSupportedException {
    Shape clonDraw = (Shape) super.clone();
    return clonDraw;
  }
  
  public Shape(Color color) {
    this.color = color;
  } 

  public void setColor(Color color) {
    this.color = color; 
  }

  public Color getColor() {
    return color; 
  }

 //public abstract void draw(Graphics g);

  public abstract void setPointStart(int x, int y);

  public abstract void setPointEnds(int x, int y);

  public abstract int getXStart();

  public abstract int getYStart();

  public abstract int getXEnd();

  public abstract int getYEnd();

  public abstract int getWidth();

  public abstract int getHeight();


}
