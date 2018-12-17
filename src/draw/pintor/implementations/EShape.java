package draw.pintor.implementations;


public enum EShape {
  SCRIBBLE{
    @Override
    public String toString(){
      return "Scribble";
    }
  },
  LINE{
    @Override
    public String toString(){
      return "Line";
    }
  },
  OVAL{
    @Override
    public String toString(){
      return "Oval";
    }
  },
  RECT{
    @Override
    public String toString(){
      return "Rectangle";
    }
  },
  INHERITANCE {
    @Override
    public String toString(){
      return "Inheritance";
    }
  },
  RHOMBUS{
    @Override
    public String toString(){
      return "Rhombus";
    }
  },
  CLASS{
    @Override
    public String toString(){
      return "Class";
    }
  },
  TEXT{
    @Override
    public String toString(){
      return "Text";
    }
  };
}
