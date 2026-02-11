package ulb;

import javafx.scene.input.KeyEvent;

public class KeyHandler {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public void handleKeyPress(KeyEvent e) {
        switch (e.getCode()) {
            case Z -> upPressed = true;
            case S -> downPressed = true;
            case Q -> leftPressed = true;
            case D -> rightPressed = true;
            default -> {}
        }
    }

    public void handleKeyRelease(KeyEvent e) {
        switch (e.getCode()) {
            case Z -> upPressed = false;
            case S -> downPressed = false;
            case Q -> leftPressed = false;
            case D -> rightPressed = false;
            default -> {}
        }
    }
}