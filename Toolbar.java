import java.awt.*;
import javax.swing.*;

public class Toolbar extends JMenuBar {
    private Canvas canvas;

    public Toolbar(Canvas canvas) {
        this.canvas = canvas;
        JMenu menu = new JMenu("Options");

        // Color Picker
        JMenuItem colorItem = new JMenuItem("Change Color");
        colorItem.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(canvas, "Choose a Color", canvas.getForeground());
            if (newColor != null) {
                canvas.setColor(newColor);
            }
        });

        // Brush Size
        JMenuItem brushSizeItem = new JMenuItem("Brush Size");
        brushSizeItem.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(canvas, "Enter Brush Size (1-50):");
            if (size != null && !size.isEmpty()) {
                try {
                    int brushSize = Integer.parseInt(size);
                    if (brushSize < 1) brushSize = 1;
                    if (brushSize > 50) brushSize = 50;
                    canvas.setBrushSize(brushSize);
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                }
            }
        });

        // Brush Type
        JMenu brushTypeMenu = new JMenu("Brush Type");
        JMenuItem roundBrush = new JMenuItem("Round Brush");
        JMenuItem squareBrush = new JMenuItem("Square Brush");

        roundBrush.addActionListener(e -> canvas.setBrushType(new EllipseShape()));
        squareBrush.addActionListener(e -> canvas.setBrushType(new RectangleShape()));

        brushTypeMenu.add(roundBrush);
        brushTypeMenu.add(squareBrush);

        // Clear Screen
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> canvas.clear());

        // Undo/Redo
        JMenuItem undoItem = new JMenuItem("Undo");
        undoItem.addActionListener(e -> canvas.undo());

        JMenuItem redoItem = new JMenuItem("Redo");
        redoItem.addActionListener(e -> canvas.redo());

        menu.add(colorItem);
        menu.add(brushSizeItem);
        menu.add(brushTypeMenu);
        menu.add(clearItem);
        menu.add(undoItem);
        menu.add(redoItem);

        add(menu);
    }
}
