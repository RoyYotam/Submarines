import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.awt.Point;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 470);//SCREEN_SIZE, SCREEN_SIZE);
        frame.setResizable(false);

        //Adding Components to the frame.
        //frame.getContentPane().add(new ImageShow("res/Board.png", 0, 0));
        SetBoard s = new SetBoard();
        frame.getContentPane().add(s);
        //frame.getContentPane().add(new ShipSet("TwoRed"));
        //frame.pack();
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

        /*
        while (true) {

            System.out.println(MouseInfo.getPointerInfo().getLocation());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {

            }
        }

         */
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
    private Image background;
    private Image ship;
    int xPos, yPos;

    public SetBoard() {
        try {
            background = ImageIO.read(new File("res/Board2.png"));
            ship = ImageIO.read(new File("res/FourRed2.png"));
            xPos = 5; // 30
            yPos = 10; // 60
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, this);
        gr.drawImage(ship, xPos, yPos, this);
    }

    public void setIm(MouseEvent e) {
        xPos = ((((e.getX() - 10) / 40) * 40) + 15);
        yPos = ((((e.getY() - 40) / 40) * 40) + 15);

        if (yPos > 230) yPos += 10;

        if (xPos > 280) xPos = 260;
        else if (xPos < 50) xPos = 5;

        if (yPos < 40) yPos = 10;
        else if (yPos > 375) yPos = 385;

        repaint();
    }
}


