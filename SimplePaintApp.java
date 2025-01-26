import java.awt.BorderLayout;
import javax.swing.*;

public class SimplePaintApp extends JFrame {
    public SimplePaintApp() {
        // Set up the frame
        setTitle("Simple Paint App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the game canvas and toolbar
        GameCanvas gameCanvas = new GameCanvas();
        GameToolbar gameToolbar = new GameToolbar(gameCanvas);

        // Add the canvas and toolbar
        add(gameCanvas, BorderLayout.CENTER);
        setJMenuBar(gameToolbar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimplePaintApp::new);
    }
}