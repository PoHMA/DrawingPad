package draw.managercomponents.menumanager;

import draw.components.menubar.NavBar;
import draw.components.scribble.Scribble;
import draw.components.scribble.ScribbleCanvas;

public class MenuManager {

  private NavBar navBar;

  public MenuManager(ScribbleCanvas canvas, Scribble scribble) {
    navBar = new NavBar(scribble,canvas);
  }

  public NavBar getComponent(){
    return navBar;
  }

}
