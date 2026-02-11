package ulb;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import ulb.entity.Player;

public class GamePanel extends Pane {
    
    public final int tileSize = 48;
    
    private Canvas canvas;
    private GraphicsContext gc;
    private KeyHandler keyH = new KeyHandler();
    private Player player;

    public GamePanel() {
        canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        this.getChildren().add(canvas);

        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());

        player = new Player(this, keyH);
        
        this.setFocusTraversable(true);
        this.setOnKeyPressed(e -> keyH.handleKeyPress(e));
        this.setOnKeyReleased(e -> keyH.handleKeyRelease(e));
    }

    public void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        }.start();
    }

    public void update() {
        player.update();
    }

    public void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        player.draw(gc);
    }
}
