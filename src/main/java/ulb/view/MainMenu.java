package ulb.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import ulb.audio.MusicManager;

public class MainMenu extends VBox {
    private static final double BUTTON_WIDTH = 150;

    public MainMenu(double spacing) {
        super(spacing);

        setAlignment(Pos.CENTER);

        Image bg = new Image("file:res/images/menu_background.png");

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

        MusicManager.crossfadeToLoop("/music/menu_music.mp3");

        Button manageTeamButton = new Button("Gérer équipes");
        manageTeamButton.setMaxWidth(BUTTON_WIDTH);
        Button addBugemonButton = new Button("Ajouter un bugémon");
        addBugemonButton.setMaxWidth(BUTTON_WIDTH);
        Button competencesTreeButton = new Button("Arbre de compétence");
        competencesTreeButton.setMaxWidth(BUTTON_WIDTH);
        Button automaticCombatButton = new Button("Combat automatique");
        automaticCombatButton.setMaxWidth(BUTTON_WIDTH);
        Button soloCombatButton = new Button("Combat Solo");
        soloCombatButton.setMaxWidth(BUTTON_WIDTH);
        Button multiplayersCombatButton = new Button("Combat multi-joueurs");
        multiplayersCombatButton.setMaxWidth(BUTTON_WIDTH);
        Button learderboardButton = new Button("Leaderboard");
        learderboardButton.setMaxWidth(BUTTON_WIDTH);

        Button quitButton = new Button("Quitter");
        quitButton.setMaxWidth(BUTTON_WIDTH);
        quitButton.setOnAction(e -> {
            MusicManager.stop();
            Platform.exit();
        });

        getChildren().addAll(
                manageTeamButton,
                addBugemonButton,
                competencesTreeButton,
                automaticCombatButton,
                soloCombatButton,
                multiplayersCombatButton,
                learderboardButton,
                quitButton
        );
    }
}
