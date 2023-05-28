import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Apple extends Main {

   public int i = 0;
   public int j = 0;

    public Apple(Segment snake) throws InterruptedException{
         i = (int) (9*Math.random());
         j = (int) (9*Math.random());
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
        while(true){
          Thread.sleep(500);
          int direction = (int) (4*Math.random());
          if(direction == 0){
            if(i > 0) {

              if((snake.getXCoord() == i) && (snake.getYCoord() == j)){
    scramble();
}
            System.out.println(i);
            System.out.println(j);
            grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.WHITE);
            i--;
            grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
            System.out.println(i);
            System.out.println(j);
           
            }
          }
      else if(direction == 1) {
         if((i < 8)) {

          if((snake.getXCoord() == i) && (snake.getYCoord() == j)){
    scramble();
}
        System.out.println(i);
        System.out.println(j);
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.WHITE);
        i++;
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
        System.out.println(i);
        System.out.println(j);
       
         }
      }
      else if(direction == 2) {
        if(j > 0) {
        
        if((snake.getXCoord() == i) && (snake.getYCoord() == j)){
    scramble();
}
        System.out.println(i);
        System.out.println(j);
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.WHITE);
        j--;
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
        System.out.println(i);
        System.out.println(j);
        
      }
      }
      else if(direction == 3) {
        
        if(j < 8) {
          if((snake.getXCoord() == i) && (snake.getYCoord() == j)){
    scramble();
}
        System.out.println(i);
        System.out.println(j);
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.WHITE);
        j++;
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
        System.out.println(i);
        System.out.println(j);
      

}
 
} } 

    }
    public int getX() {
        return i;
    }

    public int getY() {
        return j;
    }
  
    public void scramble(){
       System.out.println("Starting Scramble");
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.YELLOW);
        i = (int) (9*Math.random());
        j = (int) (9*Math.random()); 
        grid[Conversion.toGridx(i, j)][Conversion.toGridy(i, j)].setBackground(Color.RED);
        System.out.println("Scrambled");
    }
    
}