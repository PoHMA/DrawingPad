package draw.pintor;

import java.awt.Graphics;

public class LineShape extends TwoEndsShape {

  private int xStart;
  private int yStart;
  private int x2;
  private int y2;
  private int width;
  private int height;

  LineShape() {
    this.width = 0;
    this.height = 0;
  }

  public LineShape(int x1, int y1, int x2, int y2){
    this.xStart = x1;
    this.yStart = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public void draw(Graphics g) {
    if (color != null) {
      g.setColor(color);
    }
    g.drawLine(xStart, yStart, x2, y2);
  }

  @Override
  public void setPointStart(int x, int y) {
    this.xStart = x;
    this.yStart = y;
  }

  @Override
  public void setPointEnds(int x, int y) {
    this.x2 = x;
    width = x2 - xStart + 1;
    this.y2 = y;
    this.height = y2 - yStart + 1;
  }

  @Override
  public int getXStart() {
    return xStart;
  }

  @Override
  public int getYStart() {
    return yStart;
  }

  @Override
  public int getXEnd() {
    return x2;
  }

  @Override
  public int getYEnd() {
    return y2;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
    g.drawLine(x1, y1, x2, y2); 
  }

}
