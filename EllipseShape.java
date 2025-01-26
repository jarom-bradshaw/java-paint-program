import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseShape implements Shape {
    @Override
    public void draw(Graphics2D g2d, int x, int y, int brushSize) {
        // Draw an ellipse at the specified location with the specified brush size
        g2d.fill(new Ellipse2D.Float(x - brushSize / 2, y - brushSize / 2, brushSize, brushSize));
    }
}