import java.awt.Color;

public class Apple extends Segment {

    public Apple(int x, int y) {
         super(x,y);
    }

    public Color color() {
      return Color.RED;
    }

    public Color eatenColor() {
      return Color.YELLOW; 
    }

}