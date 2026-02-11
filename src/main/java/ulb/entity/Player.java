package ulb.entity;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import ulb.GamePanel;
import ulb.KeyHandler;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        this.gp = gamePanel;
        this.keyH = keyH;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "down";
    }

    public void getPlayerImage() {
        up1 = new Image(getClass().getResourceAsStream("/player/boy_up_1.png"));
        up2 = new Image(getClass().getResourceAsStream("/player/boy_up_2.png"));
        down1 = new Image(getClass().getResourceAsStream("/player/boy_down_1.png"));
        down2 = new Image(getClass().getResourceAsStream("/player/boy_down_2.png"));
        left1 = new Image(getClass().getResourceAsStream("/player/boy_left_1.png"));
        left2 = new Image(getClass().getResourceAsStream("/player/boy_left_2.png"));
        right1 = new Image(getClass().getResourceAsStream("/player/boy_right_1.png"));
        right2 = new Image(getClass().getResourceAsStream("/player/boy_right_2.png"));
    }

    public void update() {
        if (this.keyH.upPressed == true) {
            this.direction = "up";
            this.y -= this.speed;
        } else if (this.keyH.downPressed == true) {
            this.direction = "down";
            this.y += this.speed;
        } else if (this.keyH.leftPressed == true) {
            this.direction = "left";
            this.x -= this.speed;
        } else if (this.keyH.rightPressed == true) {
            this.direction = "right";
            this.x += this.speed;
        }
    }

    public void draw(GraphicsContext gc) {
        Image image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            default:
                break;
        }
        gc.drawImage(image, x, y, gp.tileSize, gp.tileSize);
    }
}

