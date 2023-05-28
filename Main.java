import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Main {
 public static JFrame frame = new JFrame("Snake Game");
    

   public static JPanel gamePanel = new JPanel();
    

   public static JPanel[][] grid = new JPanel[10][10];

    


  public static void main(String[] argv) throws Exception {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
    gamePanel.setPreferredSize(new Dimension(500, 500));
    gamePanel.setBackground(Color.GRAY);
    // Controls background color
    frame.add(gamePanel);
  
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        grid[i][j] = new JPanel();
        grid[i][j].setPreferredSize(new Dimension(50, 50));
        grid[i][j].setBackground(Color.WHITE); 
        // Controls the color of the grid 
        gamePanel.add(grid[i][j]);
      }
    }
    grid[Conversion.toGridx(4, 4)][Conversion.toGridy(4, 4)].setBackground(Color.GREEN);
    frame.pack();
    frame.setVisible(true);
    Segment snake = new Segment(4, 4);
    frame.addKeyListener(new KeyAdapter() {  
    public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_LEFT) {
        if(snake.getXCoord() > 0) {
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.WHITE);
        snake.incrementX(-1);
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.GREEN);
        }
      
      }
      else if(key == KeyEvent.VK_RIGHT) {
         if((snake.getXCoord() < 8)) {
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.WHITE);
        snake.incrementX(1);
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.GREEN);
         }
         
      }
      else if(key == KeyEvent.VK_UP) {
        if(snake.getYCoord() > 0){
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.WHITE);
        snake.incrementY(-1);
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.GREEN);
      }
     
      }
      else if(key == KeyEvent.VK_DOWN) {
        if(snake.getYCoord() < 8) {
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.WHITE);
        snake.incrementY(1);
        grid[Conversion.toGridx(snake.getXCoord(), snake.getYCoord())][Conversion.toGridy(snake.getXCoord(), snake.getYCoord())].setBackground(Color.GREEN);
      }
      
    }
  }
});
Apple a = new Apple(snake);
if((snake.getXCoord() == a.getX()) && (snake.getYCoord() == a.getY())){
  a.scramble();
}
}
}
