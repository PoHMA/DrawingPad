package draw.managercomponents.menumanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventColor implements ActionListener {

  private MenuManager menuManager;

  public EventColor(MenuManager menuManager){
    this.menuManager = menuManager;
  }

  public void actionPerformed(ActionEvent e) {
    this.menuManager.changeColor();
  }

}
