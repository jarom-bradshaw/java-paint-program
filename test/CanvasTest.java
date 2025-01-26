// package test;

// import static org.junit.jupiter.api.Assertions.*;
// import java.awt.Color;
// import java.awt.image.BufferedImage;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// public class CanvasTest {
//     private Canvas canvas;

//     @BeforeEach
//     public void setUp() {
//         canvas = new Canvas();
//     }

//     @Test
//     public void testSetColor() {
//         canvas.setColor(Color.RED);
//         // Assuming there's a way to get the current color from the canvas
//         // assertEquals(Color.RED, canvas.getCurrentColor());
//     }

//     @Test
//     public void testSetBrushSize() {
//         canvas.setBrushSize(20);
//         // Assuming there's a way to get the current brush size from the canvas
//         // assertEquals(20, canvas.getBrushSize());
//     }

//     @Test
//     public void testClear() {
//         canvas.clear();
//         BufferedImage image = canvas.getImage();
//         for (int x = 0; x < image.getWidth(); x++) {
//             for (int y = 0; y < image.getHeight(); y++) {
//                 assertEquals(0, image.getRGB(x, y));
//             }
//         }
//     }

//     @Test
//     public void testUndoRedo() {
//         // Draw something on the canvas
//         canvas.setColor(Color.BLUE);
//         canvas.setBrushSize(10);
//         // Simulate drawing
//         // canvas.draw(100, 100);
//         canvas.undo();
//         // Check if the canvas is in the previous state
//         // assertEquals(previousState, canvas.getImage());
//         canvas.redo();
//         // Check if the canvas is in the redo state
//         // assertEquals(redoState, canvas.getImage());
//     }
// }
