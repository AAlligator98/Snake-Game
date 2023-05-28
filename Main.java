import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Main {

  private static int GRID_SIZE = 10;
  public static JFrame frame = new JFrame("Snake Game");
  public static JPanel gamePanel = new JPanel();
  public static JPanel[][] grid = new JPanel[GRID_SIZE][GRID_SIZE];

  private static int score = 0;

  // Sets grid background color to specified color after converting the coordinates
  public static void setGridColor(int x, int y, Color color) {
     grid[Conversion.toGridx(x, y)][Conversion.toGridy(x, y)].setBackground(color);
  }

  public static void drawSnake(Snake snake) {
    setGridColor(snake.getXCoord(), snake.getYCoord(), snake.color());
  } 

  public static void drawApple(Apple apple) {
    setGridColor(apple.getXCoord(), apple.getYCoord(), apple.color());
  } 

  public static void drawEatenApple(Apple apple) {
    setGridColor(apple.getXCoord(), apple.getYCoord(), apple.eatenColor());
  } 

  public static void moveLeft(Segment aSegment) {
    if(aSegment.getXCoord() - 1 >= 0) {
      aSegment.incrementX(-1);
    }
  }

  public static void moveRight(Segment aSegment) {
    if(aSegment.getXCoord() + 1 < 9) {
      aSegment.incrementX(1);
    }
  }

  public static void moveUp(Segment aSegment) {
    if(aSegment.getYCoord() - 1 >= 0) {
      aSegment.incrementY(-1);
    }
  }

  public static void moveDown(Segment aSegment) {
    if(aSegment.getYCoord() + 1 < 9) {
      aSegment.incrementY(1);
    }
  }

  public static boolean isAppleEaten(Apple apple, Snake snake) {
    return (snake.getXCoord() == apple.getXCoord()) && (snake.getYCoord() == apple.getYCoord());
  }

  public static void setupSnakeGameGrid(int size) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
    gamePanel.setPreferredSize(new Dimension(500, 500));
    gamePanel.setBackground(Color.GRAY);
    // Controls background color
    frame.add(gamePanel);

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        grid[i][j] = new JPanel();
        grid[i][j].setPreferredSize(new Dimension(50, 50));
        grid[i][j].setBackground(Color.WHITE);
        // Controls the color of the grid
        gamePanel.add(grid[i][j]);
      }
    }
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] argv) throws Exception {

    // Setup initial game board
    setupSnakeGameGrid(GRID_SIZE);

    Snake snake = new Snake(4, 4);
    drawSnake(snake);

    Apple apple = new Apple((int) (9*Math.random()), (int) (9*Math.random()));
    drawApple(apple);

    frame.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
          setGridColor(snake.getXCoord(), snake.getYCoord(), Color.WHITE);
          moveLeft(snake);
        } else if (key == KeyEvent.VK_RIGHT) {
          setGridColor(snake.getXCoord(), snake.getYCoord(), Color.WHITE);
          moveRight(snake);
        } else if (key == KeyEvent.VK_UP) {
            setGridColor(snake.getXCoord(), snake.getYCoord(), Color.WHITE);
           moveUp(snake);

        } else if (key == KeyEvent.VK_DOWN) {
            setGridColor(snake.getXCoord(), snake.getYCoord(), Color.WHITE);
            moveDown(snake);
        }
        if(isAppleEaten(apple,snake) == true){
          drawEatenApple(apple);
          setRandomXY(apple);
          Toolkit.getDefaultToolkit().beep(); 
          score++;
          System.out.println("Current score: " + score);
        } else {
          drawSnake(snake);
        }
      }
    });
    randomizeApple(apple);
  }

  public static void randomizeApple(Apple apple) throws InterruptedException {
    while (true) {
      int direction = (int) (4*Math.random());
      // Reset the current grid color
      setGridColor(apple.getXCoord(), apple.getYCoord(), Color.WHITE);
      // 0 == LEFT, 1 == RIGHT, 2 == UP, 3 == DOWN
      if(direction == 0) {
        moveLeft(apple);
      } else if(direction == 1) {
        moveRight(apple);
      } else if(direction == 2) {
        moveUp(apple);
      } else if(direction == 3) {
        moveDown(apple);
      }
      drawApple(apple);
      Thread.sleep(1000);
    }
  }

  public static void setRandomXY(Segment segment) {
    segment.setX((int) (9*Math.random()));
    segment.setY((int) (9*Math.random()));
  }
}
