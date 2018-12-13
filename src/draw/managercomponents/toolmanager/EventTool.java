package draw.managercomponents.toolmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

public class EventTool implements ActionListener {

  private ToolManager toolManager;

  EventTool(ToolManager toolManager){
    this.toolManager = toolManager;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    AbstractButton button = (AbstractButton) source;
    toolManager.selectedShape(button.getText());
  }

}
