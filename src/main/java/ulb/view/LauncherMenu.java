package ulb.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ulb.audio.MusicManager;

public class LauncherMenu extends VBox {
    private static final String MAINMENU_TITLE = "Bugémon";
    private static final double BUTTON_WIDTH = 100;

    public LauncherMenu(double spacing) {
        super(spacing);

        setAlignment(Pos.CENTER);

        Image bg = new Image("file:res/images/launcher_background.png");

        setBackground(new Background(new BackgroundImage(
                bg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100,
                        true, true,
                        false,
                        true
                )
        )));

        MusicManager.playLoop("/music/launcher_music.mp3");

        Button startButton = new Button("Lancer");
        startButton.setMaxWidth(BUTTON_WIDTH);
        startButton.setOnAction(e -> {

            Stage mainStage = new Stage();
            mainStage.setTitle(MAINMENU_TITLE);
            mainStage.setMaximized(true);
            mainStage.setMinWidth(256);
            mainStage.setMinHeight(144);
            mainStage.getIcons().add(new Image("file:res/images/bugemon_no_background.png"));
            mainStage.setScene(new Scene(new MainMenu(20)));
            mainStage.show();

            Stage launcherStage = (Stage) startButton.getScene().getWindow();
            launcherStage.close();
        });

        Button quitButton = new Button("Quitter");
        quitButton.setMaxWidth(BUTTON_WIDTH);
        quitButton.setOnAction(e -> {Platform.exit();});

        getChildren().addAll(startButton, quitButton);
    }
}