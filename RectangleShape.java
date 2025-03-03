import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleShape implements Shape {
    @Override
    public void draw(Graphics2D g2d, int x, int y, int brushSize) {
        // Draw a rectangle at the specified location with the specified brush size
        g2d.fill(new Rectangle2D.Float(x - brushSize / 2, y - brushSize / 2, brushSize, brushSize));
    }
}