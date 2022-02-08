import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.awt.Point;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        //Adding Components to the frame.
        SetBoard s = new SetBoard();
        frame.getContentPane().add(s);
        frame.setVisible(true);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                ///System.out.println(e.getX());
                ///System.out.println(e.getY());
                s.setIm(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    s.next();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}


class ShipSet extends JPanel implements MouseMotionListener {

    private final BufferedImage image;
    private Point imagePosition = new Point(150, 150);
    private Point mousePoint;

    public ShipSet(String name) {
        BufferedImage i = null;
        try {
            i = ImageIO.read(new File("res/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = i;
        addMouseMotionListener(this);

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mousePoint != null) {

                    int centerX = mousePoint.x - (image.getWidth() / 2);
                    int centerY = mousePoint.y - (image.getHeight() / 2);

                    imagePosition.x = centerX;
                    imagePosition.y = centerY;
                    repaint();
                }
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        int cx = image.getWidth() / 2;
        int cy = image.getHeight() / 2;
        AffineTransform oldAT = g.getTransform();
        g.translate(cx + imagePosition.x, cy + imagePosition.y);
        g.translate(-cx, -cy);
        g.drawImage(image, 0, 0, null);
        g.setTransform(oldAT);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePoint = e.getPoint();
        repaint();
    }

}

class SetBoard extends JPanel {
    private final int Ships = 7;
    private Image background;
    private final Image[] ship = new Image[Ships];
    private final int[] xPos = new int[Ships], yPos = new int[Ships];
    private final int[] maxByLength = {0, 415, 370, 325, 285}; // Length - xPos
    private final boolean[] located = new boolean[Ships]; // TODO: function set all to false.
    private int current = 0;

    HashMap<String, int[]> cleanCoordinates = new HashMap<>();
    HashMap<Integer, String> cleanPath = new HashMap<>();

    public SetBoard() {
        cleanCoordinates.put("clean/FourRed.png", new int[]{15, 15, 4}); // X, Y, Length
        cleanCoordinates.put("clean/FourBlue.png", new int[]{15, 15, 4});
        cleanCoordinates.put("clean/ThreeBlue.png", new int[]{12, 10, 3});
        cleanCoordinates.put("clean/TwoRed.png", new int[]{12, 15, 2});
        cleanCoordinates.put("clean/TwoBlue.png", new int[]{12, 15, 2});
        cleanCoordinates.put("clean/EmptyKube.png", new int[]{9, 6, 1});
        cleanCoordinates.put("clean/AlmostKube.png", new int[]{9, 6, 1});
        try {
            background = ImageIO.read(new File("clean/BoardClean.png"));
            int i = 0;
            for (String path : cleanCoordinates.keySet()) {
                ship[i] = ImageIO.read(new File(path));
                cleanPath.put(i, path);
                xPos[i] = cleanCoordinates.get(path)[0];
                yPos[i] = cleanCoordinates.get(path)[1];
                i ++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, this);
        for (int i = 0; i < ship.length; i ++) {
            gr.drawImage(ship[i], xPos[i], yPos[i], this);
        }
    }

    public void setIm(MouseEvent e) {
        xPos[current] = ((((e.getX() - 10) / 45) * 45) + cleanCoordinates.get(cleanPath.get(current))[0]);
        yPos[current] = ((((e.getY() - 40) / 43) * 43) + cleanCoordinates.get(cleanPath.get(current))[1]);

        if (yPos[current] > 402) yPos[current] = 402; // Out of board.
        if (xPos[current] + ship[current].getWidth(this) > 470) xPos[current] =
                maxByLength[cleanCoordinates.get(cleanPath.get(current))[2]]; // Out of board.

        repaint();
    }

    public void next() {
        located[current] = true;
        current ++;
        if (current >= Ships) {
            current = 0;
        }
    }

    public boolean allLocated() {
        for (boolean b : located) {
            if (!b)
                return false;
        }
        return true;
    }
}


