// import java.awt.*;
// import java.awt.event.*;
// import java.awt.geom.*;
// import java.awt.image.BufferedImage;
// import java.io.*;
// import java.util.Stack;
// import javax.imageio.ImageIO;
// import javax.swing.*;

// public class SimplePaintAppVersionControl extends JFrame {
//     private BufferedImage image;
//     private Graphics2D g2d;
//     private int x1, y1, x2, y2;
//     private int brushSize = 10;
//     private Shape currentBrush = new Ellipse2D.Float();
//     private Stack<BufferedImage> undoStack = new Stack<>();
//     private Stack<BufferedImage> redoStack = new Stack<>();
//     private static final int MAX_UNDO_STATES = 20; // Limit number of undo steps

//     public SimplePaintAppVersionControl() {
//         // Initialize frame
//         setTitle("Simple Paint App");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         setVisible(true);

//         // Set up drawing area
//         image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//         g2d = image.createGraphics();
//         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//         g2d.setColor(Color.BLACK);

//         // Mouse listener to track drawing
//         addMouseListener(new MouseAdapter() {
//             public void mousePressed(MouseEvent e) {
//                 x1 = e.getX();
//                 y1 = e.getY();
//             }

//             public void mouseReleased(MouseEvent e) {
//                 // Save current image to undo stack after drawing
//                 undoStack.push(copyImage(image));
//                 if (undoStack.size() > MAX_UNDO_STATES) {
//                     undoStack.remove(0); // Remove the oldest undo state if stack is too large
//                 }
//             }
//         });

//         addMouseMotionListener(new MouseMotionAdapter() {
//             public void mouseDragged(MouseEvent e) {
//                 x2 = e.getX();
//                 y2 = e.getY();

//                 // Draw the current shape (brush) at the mouse location
//                 if (currentBrush instanceof Ellipse2D) {
//                     g2d.fill(new Ellipse2D.Float(x2 - brushSize / 2, y2 - brushSize / 2, brushSize, brushSize));
//                 } else if (currentBrush instanceof Rectangle2D) {
//                     g2d.fill(new Rectangle2D.Float(x2 - brushSize / 2, y2 - brushSize / 2, brushSize, brushSize));
//                 }

//                 // Update the last coordinates for the next drag event
//                 x1 = x2;
//                 y1 = y2;
//                 repaint(x2 - brushSize / 2, y2 - brushSize / 2, brushSize, brushSize);
//             }
//         });

//         // Adding the menu and tools
//         JMenuBar menuBar = new JMenuBar();
//         JMenu menu = new JMenu("Options");

//         // Color Picker
//         JMenuItem colorItem = new JMenuItem("Change Color");
//         colorItem.addActionListener(e -> {
//             Color newColor = JColorChooser.showDialog(this, "Choose a Color", g2d.getColor());
//             if (newColor != null) {
//                 g2d.setColor(newColor);
//             }
//         });

//         // Brush Size
//         JMenuItem brushSizeItem = new JMenuItem("Brush Size");
//         brushSizeItem.addActionListener(e -> {
//             String size = JOptionPane.showInputDialog(this, "Enter Brush Size (1-50):");
//             if (size != null && !size.isEmpty()) {
//                 try {
//                     brushSize = Integer.parseInt(size);
//                     if (brushSize < 1) brushSize = 1;
//                     if (brushSize > 50) brushSize = 50;
//                 } catch (NumberFormatException ex) {
//                     brushSize = 10;
//                 }
//             }
//         });

//         // Brush Type
//         JMenu brushTypeMenu = new JMenu("Brush Type");
//         JMenuItem roundBrush = new JMenuItem("Round Brush");
//         JMenuItem squareBrush = new JMenuItem("Square Brush");
//         roundBrush.addActionListener(e -> currentBrush = new Ellipse2D.Float(x1 - brushSize / 2, y1 - brushSize / 2, brushSize, brushSize));
//         squareBrush.addActionListener(e -> currentBrush = new Rectangle2D.Float(x1 - brushSize / 2, y1 - brushSize / 2, brushSize, brushSize));
//         brushTypeMenu.add(roundBrush);
//         brushTypeMenu.add(squareBrush);

//         // Clear Screen
//         JMenuItem clearItem = new JMenuItem("Clear");
//         clearItem.addActionListener(e -> {
//             g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
//             g2d.fillRect(0, 0, getWidth(), getHeight()); // Clear canvas
//             g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); // Reset alpha composite
//             repaint();
//         });

//         // Save Image
//         JMenuItem saveItem = new JMenuItem("Save");
//         saveItem.addActionListener(e -> {
//             JFileChooser fileChooser = new JFileChooser();
//             fileChooser.setDialogTitle("Save Image");
//             if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//                 File file = fileChooser.getSelectedFile();
//                 try {
//                     ImageIO.write(image, "PNG", file);
//                 } catch (IOException ex) {
//                     ex.printStackTrace();
//                 }
//             }
//         });

//         // Undo/Redo
//         JMenuItem undoItem = new JMenuItem("Undo");
//         undoItem.addActionListener(e -> {
//             if (!undoStack.isEmpty()) {
//                 redoStack.push(copyImage(image));
//                 image = undoStack.pop();
//                 g2d = image.createGraphics();
//                 repaint();
//             }
//         });

//         JMenuItem redoItem = new JMenuItem("Redo");
//         redoItem.addActionListener(e -> {
//             if (!redoStack.isEmpty()) {
//                 undoStack.push(copyImage(image));
//                 image = redoStack.pop();
//                 g2d = image.createGraphics();
//                 repaint();
//             }
//         });

//         menu.add(colorItem);
//         menu.add(brushSizeItem);
//         menu.add(brushTypeMenu);
//         menu.add(clearItem);
//         menu.add(saveItem);
//         menu.add(undoItem);
//         menu.add(redoItem);
//         menuBar.add(menu);
//         setJMenuBar(menuBar);
//     }

//     // Paint the image on the frame
//     @Override
//     public void paint(Graphics g) {
//         super.paint(g);
//         g.drawImage(image, 0, 0, null); // Draw the image
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new SimplePaintAppVersionControl());
//     }

    
//     // Copy the image for undo/redo functionality
//     private BufferedImage copyImage(BufferedImage original) {
//         BufferedImage copy = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
//         Graphics2D g = copy.createGraphics();
//         g.drawImage(original, 0, 0, null);
//         g.dispose();
//         return copy;
//     }
// }
