package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class ProcessPosition {
    public static void part2() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 337 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 356) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 9;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 356 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 375) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 10;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 375 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 394) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 11;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 394 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 413) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 12;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 413 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 432) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 13;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 432 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 451) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 14;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 451 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 470) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 15;
        }
    }

    public static void part1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 7;
        } else {
            p1();
        }
    }

    public static void p1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 318 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 337) {
            AnaliseForPill.xElement = 0;
            AnaliseForPill.yElement = 8;
        } else {
            part2();
        }
    }

    public static void partTwoOfLose(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, Button button) {
        button.setOnAction(e1 -> {
            Main main = new Main();
            GameAnimations.getTimeline1().stop();
            GameAnimations.getTimeline2().stop();
            GameAnimations.getTimeline3().stop();
            root.getChildren().clear();
            root.getChildren().add(gc.getCanvas());
            MainGame.setInGameForEventOfSetUpMenu(false);
            main.restOfLevel3(root, gc, scene, primaryStage, true);
        });
        Pane paneGameOver = new Pane();
        paneGameOver.setLayoutX(247);
        paneGameOver.setLayoutY(227);
        paneGameOver.setPrefSize(110, 100);
        Image background3 = new Image("images/GameOver.png", 110, 100, false, true);
        ImageView back3 = new ImageView(background3);
        root.getChildren().remove(MainGame.paneDR1);
        root.getChildren().remove(MainGame.paneDR2);
        root.getChildren().remove(MainGame.helper);
        Image background2 = new Image("images/5.png", 100, 100, false, true);
        ImageView back2 = new ImageView(background2);
        back2.setLayoutX(430);
        back2.setLayoutY(150);
        root.getChildren().add(back2);
        paneGameOver.getChildren().add(back3);
        root.getChildren().add(button);
        root.getChildren().add(paneGameOver);
    }

    public static void partOneOfLose(Pane root) {
        MainGame.gameState = GameState.FINISHED;
        root.getChildren().removeAll(Medicine.getPanes());
        Medicine.getPanes().clear();
        Medicine.getIntegersForCapsuleOrNot().clear();
        Medicine.getIntegersForImage().clear();
        Medicine.getImageViews().clear();
        MainGame.getCurrentUser().setScore(0);
        MainGame.getCurrentUser().setNumberOfGames(MainGame.getCurrentUser().getNumberOfGames() + 1);
        User user = new User();
        user.setName(MainGame.getCurrentUser().getName());
        user.setUserName(MainGame.getCurrentUser().getUserName());
        user.setHighScore(MainGame.getCurrentUser().getHighScore());
        user.setNumberOfGames(MainGame.getCurrentUser().getNumberOfGames());
        try {
            FileWriter f = new FileWriter("number of objects.txt", true);
            Formatter formatter = new Formatter(f);
            UsersMenu.setNumberOfObjects(UsersMenu.getNumberOfObjects() + 1);
            formatter.format("%d\n", UsersMenu.getNumberOfObjects());
            formatter.close();
            UsersMenu.objectOutput.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void partOneOfVirusExist(Pane root) {
        MainGame.gameState = GameState.FINISHED;
        root.getChildren().removeAll(Medicine.getPanes());
        Medicine.getPanes().clear();
        Medicine.getIntegersForCapsuleOrNot().clear();
        Medicine.getIntegersForImage().clear();
        Medicine.getImageViews().clear();
        if (MainGame.getCurrentUser().getHighScore() < MainGame.getCurrentUser().getScore()) {
            MainGame.getCurrentUser().setHighScore(MainGame.getCurrentUser().getScore());
        }
        MainGame.getCurrentUser().setScore(0);
        MainGame.getCurrentUser().setNumberOfGames(MainGame.getCurrentUser().getNumberOfGames() + 1);
        User user = new User();
        user.setName(MainGame.getCurrentUser().getName());
        user.setUserName(MainGame.getCurrentUser().getUserName());
        user.setHighScore(MainGame.getCurrentUser().getHighScore());
        user.setNumberOfGames(MainGame.getCurrentUser().getNumberOfGames());
        try {
            FileWriter f = new FileWriter("number of objects.txt", true);
            Formatter formatter = new Formatter(f);
            UsersMenu.setNumberOfObjects(UsersMenu.getNumberOfObjects() + 1);
            formatter.format("%d\n", UsersMenu.getNumberOfObjects());
            formatter.close();
            UsersMenu.objectOutput.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void partCapsule1() {
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 166 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 185) {
            Virus.xElement = 0;
            Virus.yElement = 0;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 185 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 204) {
            Virus.xElement = 0;
            Virus.yElement = 1;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 204 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 223) {
            Virus.xElement = 0;
            Virus.yElement = 2;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 223 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 242) {
            Virus.xElement = 0;
            Virus.yElement = 3;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 242 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 261) {
            Virus.xElement = 0;
            Virus.yElement = 4;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 261 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 280) {
            Virus.xElement = 0;
            Virus.yElement = 5;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 280 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 299) {
            Virus.xElement = 0;
            Virus.yElement = 6;
        } else if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 > 299 && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + 7 < 318) {
            Virus.xElement = 0;
            Virus.yElement = 7;
        } else {
            part2();
        }
    }
}
