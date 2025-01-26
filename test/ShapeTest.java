// package test;

// import static org.junit.jupiter.api.Assertions.*;
// import java.awt.image.BufferedImage;
// import java.awt.Graphics2D;
// import org.junit.jupiter.api.Test;

// public class ShapeTest {
//     @Test
//     public void testEllipseShape() {
//         EllipseShape ellipse = new EllipseShape();
//         BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
//         Graphics2D g2d = image.createGraphics();
//         ellipse.draw(g2d, 50, 50, 20);
//         // Check if the ellipse is drawn correctly
//         // assertTrue(image.getRGB(50, 50) != 0);
//     }

//     @Test
//     public void testRectangleShape() {
//         RectangleShape rectangle = new RectangleShape();
//         BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
//         Graphics2D g2d = image.createGraphics();
//         rectangle.draw(g2d, 50, 50, 20);
//         // Check if the rectangle is drawn correctly
//         // assertTrue(image.getRGB(50, 50) != 0);
//     }
// }
