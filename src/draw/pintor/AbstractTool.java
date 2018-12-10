
package draw.pintor;

public abstract class AbstractTool implements Tool {

  private String name;

  AbstractTool(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }




}
