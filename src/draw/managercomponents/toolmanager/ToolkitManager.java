package draw.managercomponents.toolmanager;

import draw.pintor.Pintor;
import draw.pintor.Tool;
import draw.pintor.ToolKit;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ToolkitManager {

  private ToolKit toolkit;
  private EventTool eventTool;
  private Pintor pintor;

  public ToolkitManager(Pintor pintor) {
    this.pintor = pintor;
    toolkit = pintor.getToolkit();
    this.eventTool = new EventTool(this);
  }

  void selectedTool(String nameButton){
    Tool tool = toolkit.setSelectedTool(nameButton);
    pintor.setTool(tool);
  }

  public Tool getSelectedTool() {
    return toolkit.getSelectedTool();
  }

  public JComponent createToolBar() {
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    int n = toolkit.getToolCount();
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i);
      if (tool != null) {
        JButton button = new JButton(tool.getName());
        button.addActionListener(eventTool);
        toolbar.add(button);
      }
    }
    return toolbar;
  }

  public JMenu createToolMenu() {
    JMenu menu = new JMenu("Tools");
    int n = toolkit.getToolCount();
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i);
      if (tool != null) {
        JMenuItem menuitem = new JMenuItem(tool.getName());
        menuitem.addActionListener(eventTool);
        menu.add(menuitem);
      }
    }
    return menu;
  }

}
