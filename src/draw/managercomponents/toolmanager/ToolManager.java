package draw.managercomponents.toolmanager;

import draw.pintor.Dibujo;
import draw.pintor.implementations.Pintor;
import draw.pintor.implementations.ShapeList;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ToolManager {

  private ShapeList shapekit;
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
      Dibujo dibujo = shapekit.getShape(i);
      if (dibujo != null) {
        JButton button = new JButton(dibujo.getName());
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
      Dibujo dibujo = shapekit.getShape(i);
      if (dibujo != null) {
        JMenuItem menuitem = new JMenuItem(dibujo.getName());
        menuitem.addActionListener(eventTool);
        menu.add(menuitem);
      }
    }
    return menu;
  }

}
