import java.awt.*;
import javax.swing.*;

public class GameCanvas extends Canvas {
    private int score = 0;
    private Timer timer;
    private int timeLeft = 60; // 60 seconds for the game

    public GameCanvas() {
        super();
        startGame();
    }

    private void startGame() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            if (timeLeft <= 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 10);
        g.drawString("Time Left: " + timeLeft, 10, 25);
    }

    // @Override
    // public void mouseDragged(MouseEvent e) {
    //     super.mouseDragged(e);
    //     score++;
    // }

    public void resetGame() {
        score = 0;
        timeLeft = 60;
        clear();
        timer.restart();
    }
}
