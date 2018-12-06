package draw.pintor;

import java.util.ArrayList;
import java.util.List;

public class ToolKit {

  private List<Tool> tools = new ArrayList<Tool>(16);
  private Tool selectedTool = null;

  ToolKit() {
  }
  
  /**
    Add a new tool to the tool kit.
    Return the index of the new tool.
   */
  int addTool(Tool tool) {
    if (tool != null) {
      tools.add(tool);
      return (tools.size() - 1);
    }
    return -1;
  }

  public int getToolCount() {
    return tools.size();
  }
  
   public Tool getTool(int i) {
    if (i >= 0 && i < tools.size()) {
      return (Tool) tools.get(i);
    }
    return null;
  }

  private Tool findTool(String name) {
    if (name != null) {
      for (int i = 0; i < tools.size(); i++) {
        Tool tool = tools.get(i);
        if (name.equals(tool.getName())) {
          return tool;
        }
      }
    }
    return null;
  }

  public void setSelectedTool(int i) {
    Tool tool = getTool(i);
    if (tool != null) {
      selectedTool = tool;
    }
  }

  public Tool setSelectedTool(String name) {
    Tool tool = findTool(name);
    if (tool != null) {
      selectedTool = tool;
    }
    return tool;
  }

  public void setSelectedTool(Tool tool) {
    selectedTool = tool;
  }

  public Tool getSelectedTool() {
    return selectedTool;
  }

}