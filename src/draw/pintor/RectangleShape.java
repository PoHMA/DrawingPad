package draw.pintor;

import java.awt.Graphics;

public class RectangleShape extends TwoEndsShape {

  private int xStart;
  private int yStart;
  private int x2;
  private int y2;
  private int width;
  private int height;

  RectangleShape() {
  }

  private RectangleShape(int x1, int y1, int x2, int y2) {
    this.xStart = x1;
    this.yStart = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public void draw(Graphics g) {
    int x = Math.min(xStart, x2);
    int y = Math.min(yStart, y2);
    int w = Math.abs(xStart - x2) + 1;
    int h = Math.abs(yStart - y2) + 1;
    if (color != null) {
      g.setColor(color);
    }
    g.drawRect(x, y, w, h);
  }

  @Override
  public void setPointStart(int x, int y) {
    this.xStart = x;
    this.yStart = y;
  }

  @Override
  public void setPointEnds(int x, int y) {
    this.x2 = x;
    this.y2 = y;
    this.width = x2 - xStart + 1;
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

  public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
    int x = Math.min(x1, x2); 
    int y = Math.min(y1, y2); 
    int w = Math.abs(x1 - x2) + 1; 
    int h = Math.abs(y1 - y2) + 1;     
    g.drawRect(x, y, w, h);
  }

  /*
  public void endShape(Point p) {
    this.x2 = p.x;
    this.y2 = p.y;
    setColor(drawingCanvas.getCurColor());
    drawingCanvas.addShape(new RectangleShape(xStart, yStart, x2, y2));
    Graphics g = drawingCanvas.getGraphics();
    g.setPaintMode();
    drawingCanvas.repaint();
  }*/

}
