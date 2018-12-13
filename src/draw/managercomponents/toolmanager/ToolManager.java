package draw.managercomponents.toolmanager;

import draw.pintor.Pintor;
import draw.pintor.Shape;
import draw.pintor.ShapeKit;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ToolManager {

  private ShapeKit shapekit;
  private EventTool eventTool;
  private Pintor pintor;

  public ToolManager(Pintor pintor) {
    this.pintor = pintor;
    shapekit = pintor.getShapes();
    this.eventTool = new EventTool(this);
  }

  void selectedShape(String nameButton){
    this.pintor.selectedShape(nameButton);
  }

  public JComponent createToolBar() {
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    int n = shapekit.getShapeCount();
    for (int i = 0; i < n; i++) {
      Shape shape = shapekit.getShape(i);
      if (shape != null) {
        JButton button = new JButton(shape.getName());
        button.addActionListener(eventTool);
        toolbar.add(button);
      }
    }
    return toolbar;
  }

  public JMenu createToolMenu() {
    JMenu menu = new JMenu("Tools");
    int n = shapekit.getShapeCount();
    for (int i = 0; i < n; i++) {
      Shape shape = shapekit.getShape(i);
      if (shape != null) {
        JMenuItem menuitem = new JMenuItem(shape.getName());
        menuitem.addActionListener(eventTool);
        menu.add(menuitem);
      }
    }
    return menu;
  }

}
