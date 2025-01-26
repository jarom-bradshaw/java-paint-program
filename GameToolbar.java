import javax.swing.*;

public class GameToolbar extends Toolbar {
    private GameCanvas gameCanvas;

    public GameToolbar(GameCanvas canvas) {
        super(canvas);
        this.gameCanvas = canvas;

        JMenu gameMenu = new JMenu("Game");

        JMenuItem startGameItem = new JMenuItem("Start New Game");
        startGameItem.addActionListener(e -> gameCanvas.resetGame());

        gameMenu.add(startGameItem);
        add(gameMenu);
    }
}