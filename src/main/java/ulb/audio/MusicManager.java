package ulb.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.net.URL;

public final class MusicManager {
    private static MediaPlayer current;
    private static double volume = 0.1;
    private static Timeline transition;

    private MusicManager() {}

    public static double getVolume() {
        return volume;
    }

    public static void setVolume(double newVolume) {
        volume = clamp01(newVolume);
        if (current != null) {
            current.setVolume(volume);
        }
    }

    public static void playLoop(String resourcePath) {
        stop();

        URL url = MusicManager.class.getResource(resourcePath);

        Media media = new Media(url.toExternalForm());
        current = new MediaPlayer(media);
        current.setCycleCount(MediaPlayer.INDEFINITE);
        current.setVolume(volume);
        current.play();
    }

    public static void stop() {
        if (current == null) return;
        try {
            current.stop();
        } finally {
            current.dispose();
            current = null;
        }
    }

    private static double clamp01(double v) {
        if (v < 0.0) return 0.0;
        if (v > 1.0) return 1.0;
        return v;
    }

    public static void crossfadeToLoop(String resourcePath) {
        crossfadeToLoop(resourcePath, Duration.millis(450));
    }

    public static void crossfadeToLoop(String resourcePath, Duration duration) {
        if (current == null) {
            playLoop(resourcePath);
            return;
        }

        if (transition != null) {
            transition.stop();
            transition = null;
        }

        MediaPlayer oldPlayer = current;
        MediaPlayer newPlayer = buildLoopPlayer(resourcePath);

        double targetVolume = volume;
        newPlayer.setVolume(0.0);
        newPlayer.play();

        transition = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(oldPlayer.volumeProperty(), oldPlayer.getVolume()),
                new KeyValue(newPlayer.volumeProperty(), 0.0)
            ),
            new KeyFrame(duration,
                e -> {
                    try {
                        oldPlayer.stop();
                    } finally {
                        oldPlayer.dispose();
                    }
                    current = newPlayer;
                    transition = null;
                },
                new KeyValue(oldPlayer.volumeProperty(), 0.0),
                new KeyValue(newPlayer.volumeProperty(), targetVolume)
            )
        );

        transition.play();
    }

    private static MediaPlayer buildLoopPlayer(String resourcePath) {
        URL url = MusicManager.class.getResource(resourcePath);

        Media media = new Media(url.toExternalForm());
        MediaPlayer player = new MediaPlayer(media);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        return player;
    }
}
