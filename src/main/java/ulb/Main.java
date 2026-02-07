package ulb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ulb.view.LauncherMenu;

public class Main extends Application {
    private final static String LAUNCHER_TITLE = "Launcher Bugémon";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(LAUNCHER_TITLE);
        primaryStage.setWidth(1152);
        primaryStage.setHeight(896);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:res/images/bugemon_no_background.png"));
        primaryStage.setScene(new Scene(new LauncherMenu(20)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}