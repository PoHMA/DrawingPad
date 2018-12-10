package draw.pintor;

public class RectangleShape extends Shape {

  private int xStart;
  private int yStart;
  private int x2;
  private int y2;
  private int width;
  private int height;

  RectangleShape() {
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

}
