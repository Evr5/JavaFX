package ulb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private final static String WINDOW_TITLE = "Bugémon";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setMaximized(true);
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();

        GamePanel gamePanel = new GamePanel();
        Scene scene = new Scene(gamePanel, primaryStage.getWidth(), primaryStage.getHeight());
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);

        gamePanel.requestFocus();
        gamePanel.startGameLoop();
     }

    public static void main(String[] args) {
        launch(args);
    }
}