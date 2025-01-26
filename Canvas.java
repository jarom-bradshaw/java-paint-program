import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.swing.*;

public class Canvas extends JComponent {
    private BufferedImage image;
    private Graphics2D g2d;
    private int x1, y1, x2, y2;
    private int brushSize = 10;
    private Shape currentBrush = new EllipseShape();
    private Stack<BufferedImage> undoStack = new Stack<>();
    private Stack<BufferedImage> redoStack = new Stack<>();
    private static final int MAX_UNDO_STATES = 20;

    public Canvas() {
        // Set up drawing area
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        // Mouse listeners for drawing
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                undoStack.push(copyImage(image));
                if (undoStack.size() > MAX_UNDO_STATES) {
                    undoStack.remove(0);
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                currentBrush.draw(g2d, x2, y2, brushSize);
                repaint(x2 - brushSize / 2, y2 - brushSize / 2, brushSize, brushSize);
                x1 = x2;
                y1 = y2;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void setColor(Color color) {
        g2d.setColor(color);
    }

    public void setBrushSize(int size) {
        this.brushSize = size;
    }

    public void setBrushType(Shape shape) {
        this.currentBrush = shape;
    }

    public void clear() {
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        repaint();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(copyImage(image));
            image = undoStack.pop();
            g2d = image.createGraphics();
            repaint();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(copyImage(image));
            image = redoStack.pop();
            g2d = image.createGraphics();
            repaint();
        }
    }

    private BufferedImage copyImage(BufferedImage original) {
        BufferedImage copy = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = copy.createGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return copy;
    }
}
