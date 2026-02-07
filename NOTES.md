# Notes pour JavaFX

## Élément central du programme pour utiliser JavaFX

```java
import javafx.application.Application;
```

## Notre class Maindoit étendre la classe Application de JavaFX

```java
public class Main extends Application {
}
```

## Il faut override la méthode start de JavaFX qui est un peu le main de l'interface graphique. Stage est la fenêtre du programme. Il pourrait y en avoir plusieurs

Ici, la fonction `main` doit appeler la méthode launch de JavaFX pour lancer l'interface graphique. Pour afficher la fenêtre, il faut `show()` la stage (ici primaryStage car il pourrait y en avoir plusieurs).

```java
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
```

## Architecture de JavaFX

![architecture-javafx](./res/arch.png)
