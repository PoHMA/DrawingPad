package draw.managercomponents.toolmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class EventTool implements ActionListener {

  private ToolkitManager toolkitManager;

  EventTool(ToolkitManager toolkitManager){
    this.toolkitManager = toolkitManager;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    AbstractButton button = (AbstractButton) source;
    toolkitManager.selectedTool(button.getText());
  }

}
