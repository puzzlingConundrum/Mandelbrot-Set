import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MandelbrotSet {
    Color[][] colors;
    int height, width;
    float maxiter = 500;

    public MandelbrotSet(int height, int width) {
        this.height = height;
        this.width = width;

        colors = new Color[height][width];
        initialize();
    }

    public void initialize() {
        Complex c = new Complex();
        for (int i = 0; i < colors[0].length; i++) {
            for (int j = 0; j < colors.length; j++) {
                double x = (i * 3.0 / width) - 2.0;
                double y = -1.0*(j * 3.0 / height) + 1.5;

                c.set(x,y);
                colors[j][i] = new Color(colorCode(c, maxiter));
            }
        }
    }

    private int colorCode(Complex c, float maxIter) {
        Complex z = new Complex();
        float iter = 0;
        while (z.real*z.real + z.imaginary*z.imaginary <= 4 && iter < maxIter) {
            z.set(Complex.add(Complex.multiply(z,z),c));
            iter++;
        }
        if (iter <= maxIter) {
            iter += 1 - Math.log(Math.log(z.abs()))/Math.log(2);
        }
        float  hue = (int)(iter / maxIter);
        float saturation = 255;
        float value = iter < maxIter ? 1f : 0f;
        return Color.HSBtoRGB(0.95f + 10 * iter /maxIter,0.6f, value);
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < colors[0].length; i++) {
            for (int j = 0; j < colors.length; j++) {
                g.setColor(colors[j][i]);
                g.fill(new Rectangle2D.Float(i, j, 1f, 1f));
            }
        }
    }

}
