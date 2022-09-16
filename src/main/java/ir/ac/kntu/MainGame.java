package ir.ac.kntu;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class MainGame {
    private static User currentUser;

    private static int level;

    private static Speed speed;

    private static boolean stopForEventHandler = true;

    private static boolean added = false;

    public static Timeline mainTimeLine;

    private static Medicine medicine;

    private static boolean eventOneTimeChecker = false;

    private static boolean firstCapsule = false;

    private static boolean oneTimeVirus = false;

    private static int numberOfVirus = 0;

    private static Color[][] color = new Color[8][16];// x : 0 -> 7 , y : 0 -> 15

    private static int[][] numberOfPanes = new int[8][16];// x : 0 -> 7 , y : 0 -> 15

    private static boolean firstLabelVirus = false;

    private static boolean firstLabelScore = false;

    private static Label valueOfNumberOfVirusLabel = new Label();

    private static Label valueOfScoreLabel = new Label();

    private static boolean stopButtonOneTimeChecker = false;

    private static int stopChecker = 1;

    private static boolean firstCheckForExistVirus = false;

    static GameState gameState;

    private static boolean inGameForEventOfSetUpMenu = false;

    private static boolean firstTimeToDrawBackground = false;

    private static boolean firstTimeForEffects = false;

    private static boolean selfTreatment = false;

    static Pane helper = new Pane();

    static Pane paneDR1 = new Pane();

    static Pane paneDR2 = new Pane();

    public static void continueOfEffectOfDoctor(Pane panedr1, Pane panedr2) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), panedr2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(2);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), panedr1);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(2);
        fadeTransition1.play();
        fadeTransition2.play();
    }

    public static void timeLineImplementation(Pane panedr1, Pane panedr2) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {// 3 images :)
            continueOfEffectOfDoctor(panedr1, panedr2);
        }));
        timeline.setCycleCount(1);
        timeline.playFrom(Duration.seconds(999));
    }

    public static void effectOfDoctor(Pane root) {
        helper.setPrefSize(100, 100);
        helper.setLayoutX(440);
        helper.setLayoutY(155);
        paneDR1.setPrefSize(100, 100);
        paneDR1.setLayoutX(440);
        paneDR1.setLayoutY(155);
        paneDR2.setPrefSize(100, 100);
        paneDR2.setLayoutX(410);
        paneDR2.setLayoutY(155);
        timeLineImplementation(paneDR1, paneDR2);
        Image helpImage = new Image("images/helper2.png", 80, 80, false, true);
        ImageView dr = new ImageView(helpImage);
        Image dr1 = new Image("images/3.png", 80, 80, false, true);
        ImageView dr11 = new ImageView(dr1);
        Image dr2 = new Image("images/4.1.png", 110, 80, false, true);
        ImageView dr22 = new ImageView(dr2);
        helper.getChildren().add(dr);
        paneDR1.getChildren().add(dr11);
        paneDR2.getChildren().add(dr22);
        if (!added) {
            root.getChildren().add(helper);
            root.getChildren().add(paneDR1);
            root.getChildren().add(paneDR2);
            added = true;
        }
    }

    public static void putVirus(Pane root, GraphicsContext gc, Scene scene) {
        for (int i = 0; i < 4 + (level * 4); i++) {
            Pane pane = new Pane();
            pane.setPrefSize(18.75, 19);
            Medicine.getIntegersForCapsuleOrNot().add(0);
            Medicine.getPanes().add(pane);
            Random random = new Random();
            int virusNumber = random.nextInt(3);
            processOneForPutVirus(pane, virusNumber + 1);
            while (true) {
                if (processTwoForPutVirus(root, pane, random)) {
                    break;
                }
            }
        }
    }

    private static boolean processTwoForPutVirus(Pane root, Pane pane, Random random) {
        boolean xY = true;
        int xVirus = random.nextInt(8);// 0 -> 7
        int yVirus = random.nextInt(12);// 1 -> 12
        yVirus++;
        for (int j = 0; j < Medicine.getPanes().size() - 1; j++) {
            if (Medicine.getPanes().get(j).getLayoutX() == 226 + (xVirus * 18.75) && Medicine.getPanes().get(j).getLayoutY() == 470 - (yVirus * 19)) {
                xY = false;
            }
        }
        if (xY) {
            pane.setLayoutX(226 + (xVirus * 18.75));
            pane.setLayoutY(470 - (yVirus * 19));
            root.getChildren().add(pane);
            if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 1) {
                color[xVirus][(17 - yVirus) - 1] = Color.BLUE;
                numberOfPanes[xVirus][(17 - yVirus) - 1] = Medicine.getPanes().size() - 1;
            } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 2) {
                color[xVirus][(17 - yVirus) - 1] = Color.RED;
                numberOfPanes[xVirus][(17 - yVirus) - 1] = Medicine.getPanes().size() - 1;
            } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 3) {
                color[xVirus][(17 - yVirus) - 1] = Color.YELLOW;
                numberOfPanes[xVirus][(17 - yVirus) - 1] = Medicine.getPanes().size() - 1;
            }
            return true;
        }
        return false;
    }

    private static void processOneForPutVirus(Pane pane, int virusNumber) {
        if (virusNumber == 1) {
            Image virus = new Image("images/42.png", 18.75, 19, false, true);
            ImageView virus1 = new ImageView(virus);
            Medicine.getImageViews().add(virus1);
            pane.getChildren().add(virus1);
            Medicine.getIntegersForImage().add(1);
        } else if (virusNumber == 2) {
            Image virus = new Image("images/44.png", 18.75, 19, false, true);
            ImageView virus1 = new ImageView(virus);
            Medicine.getImageViews().add(virus1);
            pane.getChildren().add(virus1);
            Medicine.getIntegersForImage().add(2);
        } else if (virusNumber == 3) {
            Image virus = new Image("images/46.png", 18.75, 19, false, true);
            ImageView virus1 = new ImageView(virus);
            Medicine.getImageViews().add(virus1);
            pane.getChildren().add(virus1);
            Medicine.getIntegersForImage().add(3);
        }
    }

    public static void start(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, boolean firstTimeOfGame) throws InterruptedException {
        firstPartOfStart(root, gc, firstTimeOfGame);
        currentUser = UsersMenu.getCurrentUser();
        speed = MainMenu.getSpeed();
        level = MainMenu.getLevel();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                color[i][j] = Color.EMPTY;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                numberOfPanes[i][j] = -1;
            }
        }
        mainTimeLine(root, gc, scene, primaryStage);
    }

    private static void mainTimeLine(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage) {
        mainTimeLine = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            firstProcessForMainTimeLine(root);
            wonOrLose(root, gc, scene, primaryStage);
            if (gameState == GameState.RUNNING) {
                if (selfTreatment) {
                    SelfTreatment.selfTreatment(root);
                }
            }
            selfTreatment = true;
            firstCheckForExistVirus = true;
            if (gameState != GameState.FINISHED) {
                Random random = new Random();
                boolean randomGenerator = random.nextBoolean();
                mainPartOfMainTimeLine(root, gc, scene, randomGenerator);
                Medicine.setNumberOfFaster(0);
            }
        }));
        mainTimeLine.setDelay(Duration.millis(5000));// for showing loading
        mainTimeLine.setCycleCount(1);
        mainTimeLine.play();
    }

    private static void wonOrLose(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage) {
        boolean lose = false;
        if (MainGame.getNumberOfPanes()[3][0] != -1 || MainGame.getNumberOfPanes()[4][0] != -1) {
            lose = true;
        }
        if (lose) {
            ProcessPosition.partOneOfLose(root);
            currentUser.setNumberOfGames(currentUser.getNumberOfGames() + 1);
            Button button = new Button("* New Game *");
            button.setLayoutX(252);
            button.setLayoutY(340);
            button.setPrefSize(100, 35);
            button.setTextFill(javafx.scene.paint.Color.rgb(236, 45, 34));
            ProcessPosition.partTwoOfLose(root, gc, scene, primaryStage, button);
        }
        if (!lose) {
            wonPart(root, gc, scene, primaryStage);
        }
    }

    private static void wonPart(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage) {
        if (firstCheckForExistVirus) {
            boolean existVirus = false;
            for (int i = 0; i < Medicine.getIntegersForCapsuleOrNot().size(); i++) {
                if (Medicine.getIntegersForCapsuleOrNot().get(i) == 0) {
                    existVirus = true;
                }
            }
            if (!existVirus) {
                ProcessPosition.partOneOfVirusExist(root);
                Button button = new Button("* New Game *");
                button.setLayoutX(252);
                button.setLayoutY(340);
                button.setPrefSize(100, 35);
                button.setTextFill(javafx.scene.paint.Color.rgb(236, 45, 34));
                partTwoOfVirusExist(root, gc, scene, primaryStage, button);
            }
        }
    }

    private static void firstProcessForMainTimeLine(Pane root) {
        stopForEventHandler = true;
        EventHandler.setCheck1(false);
        EventHandler.setCheck2(false);
        EventHandler.setCheck3(false);
        EventHandler.setCheck4(1);
        EventHandler.setCheck5(1);
        EventHandler.setCheck6(1);
        RemoveVerticalSameColors.removeVerticalSameColors(root);
        RemoveHorizontalSameColors.removeHorizontalSameColors(root);
        gameState = GameState.RUNNING;
        MainGame.getValueOfNumberOfVirusLabel().setText(String.valueOf(MainGame.getNumberOfVirus()));
        MainGame.getValueOfScoreLabel().setText(String.valueOf(MainGame.getCurrentUser().getScore()));
    }

    private static void mainPartOfMainTimeLine(Pane root, GraphicsContext gc, Scene scene, boolean randomGenerator) {
        if (!firstCapsule) {
            randomGenerator = false;
            firstCapsule = true;
        }
        if (randomGenerator) {
            Medicine pill = new Pill();
            medicine = pill;
            try {
                pill.throwing(root, gc, scene);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        } else {
            Medicine capsule = new Capsule();
            medicine = capsule;
            try {
                capsule.throwing(root, gc, scene);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    private static void partTwoOfVirusExist(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, Button button) {
        button.setOnAction(e1 -> {
            Main main = new Main();
            GameAnimations.getTimeline1().stop();
            GameAnimations.getTimeline2().stop();
            GameAnimations.getTimeline3().stop();
            root.getChildren().clear();
            root.getChildren().add(gc.getCanvas());
            inGameForEventOfSetUpMenu = false;
            main.restOfLevel3(root, gc, scene, primaryStage, true);
        });
        Pane pane1 = new Pane();
        pane1.setLayoutX(247);
        pane1.setLayoutY(227);
        pane1.setPrefSize(110, 100);
        Image background2 = new Image("images/StageClear.png", 110, 100, false, true);
        ImageView back2 = new ImageView(background2);
        root.getChildren().remove(paneDR1);
        root.getChildren().remove(paneDR2);
        root.getChildren().remove(helper);
        Image background3 = new Image("images/1.png", 90, 90, false, true);
        ImageView back3 = new ImageView(background3);
        back3.setLayoutX(435);
        back3.setLayoutY(155);
        root.getChildren().add(back3);
        pane1.getChildren().add(back2);
        root.getChildren().add(button);
        root.getChildren().add(pane1);
    }

    private static void firstPartOfStart(Pane root, GraphicsContext gc, boolean firstTimeOfGame) {
        if (!firstTimeOfGame) {
            stopButtonOneTimeChecker = false;
            firstCheckForExistVirus = false;
            firstCapsule = false;
            gameState = GameState.RUNNING;
            oneTimeVirus = false;
            firstLabelScore = false;
            firstLabelVirus = false;
            added = false;
            firstTimeToDrawBackground = false;
            firstTimeForEffects = false;
            GameAnimations.setAdded1(false);
            GameAnimations.setAdded2(false);
            GameAnimations.setAdded3(false);
            selfTreatment = false;
            GameAnimations.setNumberOfLoops(1);
            SelfTreatment.timer = 1;
        }
        Image background1 = new Image("images/loading.png", 600, 520, false, true);
        ImageView back = new ImageView(background1);
        Pane pane = new Pane();
        pane.getChildren().add(back);
        root.getChildren().add(pane);
        PauseTransition pause = new PauseTransition(Duration.seconds(5));//PauseTransition for show loading image with some delay
        pause.setOnFinished(e -> root.getChildren().remove(pane));
        pause.play();
        Image background = new Image("images/MainScene.png", 600, 600, true, true);
        gc.drawImage(background, 0, 0);
    }

    public static boolean isStopButtonOneTimeChecker() {
        return stopButtonOneTimeChecker;
    }

    public static void setStopButtonOneTimeChecker(boolean stopButtonOneTimeChecker) {
        MainGame.stopButtonOneTimeChecker = stopButtonOneTimeChecker;
    }

    public static int getStopChecker() {
        return stopChecker;
    }

    public static void setStopChecker(int stopChecker) {
        MainGame.stopChecker = stopChecker;
    }

    public static boolean isFirstTimeForEffects() {
        return firstTimeForEffects;
    }

    public static void setFirstTimeForEffects(boolean firstTimeForEffects) {
        MainGame.firstTimeForEffects = firstTimeForEffects;
    }

    public static boolean isFirstTimeToDrawBackground() {
        return firstTimeToDrawBackground;
    }

    public static void setFirstTimeToDrawBackground(boolean firstTimeToDrawBackground) {
        MainGame.firstTimeToDrawBackground = firstTimeToDrawBackground;
    }

    public static boolean isInGameForEventOfSetUpMenu() {
        return inGameForEventOfSetUpMenu;
    }

    public static void setInGameForEventOfSetUpMenu(boolean inGameForEventOfSetUpMenu) {
        MainGame.inGameForEventOfSetUpMenu = inGameForEventOfSetUpMenu;
    }

    public static Label getValueOfScoreLabel() {
        return valueOfScoreLabel;
    }

    public static boolean isFirstLabelScore() {
        return firstLabelScore;
    }

    public static void setFirstLabelScore(boolean firstLabelScore) {
        MainGame.firstLabelScore = firstLabelScore;
    }

    public static Label getValueOfNumberOfVirusLabel() {
        return valueOfNumberOfVirusLabel;
    }

    public static boolean isFirstLabelVirus() {
        return firstLabelVirus;
    }

    public static void setFirstLabelVirus(boolean firstLabelVirus) {
        MainGame.firstLabelVirus = firstLabelVirus;
    }

    public static Color[][] getColor() {
        return color;
    }

    public static void setColor(Color[][] color) {
        MainGame.color = color;
    }

    public static int[][] getNumberOfPanes() {
        return numberOfPanes;
    }

    public static int getNumberOfVirus() {
        return numberOfVirus;
    }

    public static void setNumberOfVirus(int numberOfVirus) {
        MainGame.numberOfVirus = numberOfVirus;
    }

    public static boolean isOneTimeVirus() {
        return oneTimeVirus;
    }

    public static void setOneTimeVirus(boolean oneTimeVirus) {
        MainGame.oneTimeVirus = oneTimeVirus;
    }

    public static boolean isStopForEventHandler() {
        return stopForEventHandler;
    }

    public static void setStopForEventHandler(boolean stopForEventHandler) {
        MainGame.stopForEventHandler = stopForEventHandler;
    }

    public static boolean isEventOneTimeChecker() {
        return eventOneTimeChecker;
    }

    public static void setEventOneTimeChecker(boolean eventOneTimeChecker) {
        MainGame.eventOneTimeChecker = eventOneTimeChecker;
    }

    public static Medicine getMedicine() {
        return medicine;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static int getLevel() {
        return level;
    }

    public static Speed getSpeed() {
        return speed;
    }

    public MainGame() {
    }
}