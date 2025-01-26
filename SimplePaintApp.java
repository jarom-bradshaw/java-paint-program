import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SimplePaintApp extends JFrame {
    private Image image;
    private Graphics2D g2d;
    private int x1, y1, x2, y2;

    public SimplePaintApp() {
        // Initialize frame
        setTitle("Simple Paint App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Set up drawing area
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2d = (Graphics2D) image.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK); // Default color

        // Mouse listener to track drawing
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                g2d.drawLine(x1, y1, x2, y2);
                x1 = x2;
                y1 = y2;
                repaint();
            }
        });
        
        // Adding a simple color chooser
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem colorItem = new JMenuItem("Change Color");
        colorItem.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Choose a Color", g2d.getColor());
            if (newColor != null) {
                g2d.setColor(newColor);
            }
        });
        menu.add(colorItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    // Paint the image on the frame
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);  // Only draw the image, no need to clear it
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimplePaintApp());
    }
}
