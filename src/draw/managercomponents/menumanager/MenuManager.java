package draw.managercomponents.menumanager;

import draw.components.menubar.NavBar;
import draw.components.scribble.Scribble;
import draw.pintor.Pintor;

public class MenuManager {

  private NavBar navBar;

  public MenuManager(Scribble scribble, Pintor pintor) {
    navBar = new NavBar(scribble,pintor);
  }

  public NavBar getComponent(){
    return navBar;
  }

}
