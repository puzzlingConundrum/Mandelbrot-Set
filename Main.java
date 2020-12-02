import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Main extends JPanel {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    Timer timer;
    MandelbrotSet set;

    public Main() {
        set = new MandelbrotSet(HEIGHT, WIDTH);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Mandelbrot Set");
        f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        f.pack();
        f.getContentPane().add(new Main());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        set.draw(g2d);
    }
}
