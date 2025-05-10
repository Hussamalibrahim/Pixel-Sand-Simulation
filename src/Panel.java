import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    private final int SCREEN_WIDTH = 700;
    private final int SCREEN_HEIGHT = 700;
    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    public ArrayList<Point> point;
    public ArrayList<Color> pointColors;
    Timer timer;
    Timer colorTimer;
    int indexColor = 0;

    private final Color[] color = {new Color(255, 0, 0), new Color(255, 51, 51),
            new Color(0, 0  , 255),new Color(255, 255,  0 ),
            new Color(0, 255, 255),new Color(153 , 153, 153)
    };

    Panel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    point.clear();
                    pointColors.clear();
                }if(e.getKeyCode() == KeyEvent.VK_S){
                    if(colorTimer.isRunning())
                        colorTimer.stop();
                    else
                        colorTimer.start();
                }
            }
        });


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                for (int i = 0; i < 3; i++) {
                    point.add(new Point((e.getX() - (e.getX() % WIDTH)) + WIDTH * i, (e.getY() - (e.getY() % HEIGHT)) + WIDTH * i));
                    pointColors.add(color[indexColor]);
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        point = new ArrayList<>();
        pointColors = new ArrayList<>();

        timer = new Timer(1000 / 60, this);
        colorTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexColor = new Random().nextInt(color.length);
            }
        });
        colorTimer.start();
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < point.size(); i++) {
            g.setColor(pointColors.get(i));
            g.fillRect(point.get(i).x, point.get(i).y, WIDTH, HEIGHT);
        }
    }

    private void move() {
        for (int i = 0; i < point.size(); i++) {
            if (point.get(i).y + HEIGHT < SCREEN_HEIGHT) {
                boolean canFall = true;
                for (Point p : point) {
                    if (p.x == point.get(i).x && p.y == point.get(i).y + HEIGHT) {
                        canFall = false;
                        break;
                    }
                }
                int random = new Random().nextBoolean() ? 1 : -1;
                if (!point.contains(new Point(point.get(i).x + WIDTH * random, point.get(i).y + HEIGHT)) && !canFall) {
                    if (point.get(i).x + WIDTH < SCREEN_WIDTH && point.get(i).x > 0)
                        point.get(i).x += WIDTH * random;
                }
                if (canFall) {
                    point.get(i).y += HEIGHT;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
