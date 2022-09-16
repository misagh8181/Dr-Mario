package ir.ac.kntu;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Capsule extends Medicine {
    private Color color1;

    private Color color2;

    private Direction direction;

    private static Timeline timeline;

    private static Timeline timeline1;

    private static Timeline timeline2;

    private static Timeline timeline3;

    private static Random random = new Random();

    private static PauseTransition pauseTransition;

    @NotNull
    private Pane getPane(Pane root) {
        Pane pane = new Pane();
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
        Medicine.getPanes().add(pane);
        Medicine.getIntegersForCapsuleOrNot().add(2);
        pane.setPrefSize(33.5, 19);
        int numberOfImage = random.nextInt(6);
        firstPartOfGetpane(pane, numberOfImage + 1);
        root.getChildren().add(pane);
        return pane;
    }

    private void secondPartOfGetPane(Pane pane, int numberOfImage) {
        if (numberOfImage == 4) {
            Image capsule = new Image("images/30.png", 33.5, 19, false, true);
            ImageView capsule1 = new ImageView(capsule);
            Medicine.getImageViews().add(capsule1);
            pane.getChildren().add(capsule1);
            Medicine.getIntegersForImage().add(30);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.BLUE;
            this.color2 = Color.YELLOW;
        } else if (numberOfImage == 5) {
            Image capsule = new Image("images/34.png", 33.5, 19, false, true);
            ImageView capsule1 = new ImageView(capsule);
            Medicine.getImageViews().add(capsule1);
            pane.getChildren().add(capsule1);
            Medicine.getIntegersForImage().add(34);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.RED;
            this.color2 = Color.BLUE;
        } else if (numberOfImage == 6) {
            Image capsule = new Image("images/38.png", 33.5, 19, false, true);
            ImageView capsule1 = new ImageView(capsule);
            Medicine.getImageViews().add(capsule1);
            pane.getChildren().add(capsule1);
            Medicine.getIntegersForImage().add(38);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.RED;
            this.color2 = Color.YELLOW;
        }
    }

    private void firstPartOfGetpane(Pane pane, int numberOfImage) {
        if (numberOfImage == 1) {
            processForFirstimageView(pane);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.BLUE;
            this.color2 = Color.BLUE;
        } else if (numberOfImage == 2) {
            Image capsule = new Image("images/26.png", 33.5, 19, false, true);
            ImageView capsule1 = new ImageView(capsule);
            Medicine.getImageViews().add(capsule1);
            pane.getChildren().add(capsule1);
            Medicine.getIntegersForImage().add(26);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.RED;
            this.color2 = Color.RED;
        } else if (numberOfImage == 3) {
            Image capsule = new Image("images/28.png", 33.5, 19, false, true);
            ImageView capsule1 = new ImageView(capsule);
            Medicine.getImageViews().add(capsule1);
            pane.getChildren().add(capsule1);
            Medicine.getIntegersForImage().add(28);
            this.direction = Direction.HORIZONTAL1;
            this.color1 = Color.YELLOW;
            this.color2 = Color.YELLOW;
        } else {
            secondPartOfGetPane(pane, numberOfImage);
        }
    }

    private void processForFirstimageView(Pane pane) {
        Image capsule = new Image("images/24.png", 33.5, 19, false, true);
        ImageView capsule1 = new ImageView(capsule);
        Medicine.getImageViews().add(capsule1);
        pane.getChildren().add(capsule1);
        Medicine.getIntegersForImage().add(24);
    }

    @Override
    public void throwing(Pane root, GraphicsContext gc, Scene scene) throws InterruptedException {
        Pane pane = firstProcessAndGetPane(root, gc, scene);
        methodForTimeLines(root, gc, pane);
        timeline3.setOnFinished(e -> {
            Main.thirdMove2 = false;
            Main.mainMove2 = true;
            MainGame.setStopForEventHandler(false);
            timeline.play();
        });
        timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            analiseForCapsule(root, gc, scene, pane);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setOnFinished(e -> {
            Main.mainMove2 = false;
        });
    }//timeline.setOnFinished for start a timeline and then close that and start another one

    @NotNull
    private Pane firstProcessAndGetPane(Pane root, GraphicsContext gc, Scene scene) {
        if (!MainGame.isFirstTimeToDrawBackground()) {
            Image background = new Image("images/MainScene.png", 600, 600, true, true);
            ImageView back = new ImageView(background);
            root.getChildren().add(back);
            MainGame.setFirstTimeToDrawBackground(true);
        }
        stopButton(root);
        if (!MainGame.isOneTimeVirus()) {
            MainGame.setNumberOfVirus(4 + (MainGame.getLevel() * 4));
            MainGame.putVirus(root, gc, scene);
            MainGame.setOneTimeVirus(true);
        }
        someLabels1(root);
        someLabels2(root);
        someLabels3(root);
        MainGame.effectOfDoctor(root);
        if (!MainGame.isFirstTimeForEffects()) {
            GameAnimations.effectOfBlueVirus(root);
            GameAnimations.effectOfRedVirus(root);
            GameAnimations.effectOfYellowVirus(root);
            MainGame.setFirstTimeForEffects(true);
        }
        Pane pane = getPane(root);
        return pane;
    }

    private void methodForTimeLines(Pane root, GraphicsContext gc, Pane pane) {
        timeline1 = new Timeline(new KeyFrame(Duration.millis(20), e -> firstMove(root, gc, pane)));
        timeline1.setCycleCount(80);
        MainGame.setStopForEventHandler(true);
        timeline1.play();
        Main.firstMove2 = true;
        timeline2 = new Timeline(new KeyFrame(Duration.millis(50), e -> secondMove(root, gc, pane)));
        timeline2.setCycleCount(7);
        timeline3 = new Timeline(new KeyFrame(Duration.millis(50), e -> thirdMove(root, gc, pane)));
        timeline3.setCycleCount(25);
        if (MainGame.getSpeed() == Speed.MEDIUM) {
            setvY(getvY() * 4);
        } else if (MainGame.getSpeed() == Speed.HIGH) {
            setvY(getvY() * 8);
        }
        timeline1.setOnFinished(e -> {
            Main.firstMove2 = false;
            Main.secondMove2 = true;
            MainGame.setStopForEventHandler(true);
            timeline2.play();
        });
        timeline2.setOnFinished(e -> {
            Main.secondMove2 = false;
            Main.thirdMove2 = true;
            setX(getX() - 0.75);
            pane.setLayoutX(getX());
            MainGame.setStopForEventHandler(true);
            timeline3.play();
        });
    }

    private void analiseForCapsule(Pane root, GraphicsContext gc, Scene scene, Pane pane) {
        setY(getY() + getvY());
        pane.setLayoutY(getY());
        for (int i = 0; i < Medicine.getPanes().size() - 1; i++) {
            if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) >= Medicine.getPanes().get(i).getLayoutY() + 1 &&
                    Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) <= Medicine.getPanes().get(i).getLayoutY() + 5) {
                if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + ((Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) / 2) >= Medicine.getPanes().get(i).getLayoutX() - 2 &&// difference 2
                        Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + ((Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) / 2) <= Medicine.getPanes().get(i).getLayoutX() + Medicine.getPanes().get(i).getWidth() + 3) {//difference 3
                    Capsule capsule = this;
                    Virus.putColorForCapsulesInFirstPosition(capsule);
                    MainGame.mainTimeLine.setDelay(Duration.ZERO);
                    MainGame.mainTimeLine.play();
                    timeline.stop();
                }
            }
        }
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight() > 470) {
            Capsule capsule = this;
            Virus.putColorForCapsulesInFirstPosition(capsule);
            MainGame.mainTimeLine.setDelay(Duration.ZERO);
            MainGame.mainTimeLine.play();
            timeline.stop();
        }
        if (!MainGame.isEventOneTimeChecker()) {
            EventHandler.getInstance().attachEventHandlersForMainGame(scene, gc, root);
            MainGame.setEventOneTimeChecker(true);
        }
    }

    private void someLabels3(Pane root) {
        Label topScoreLabel = new Label("TOP");
        topScoreLabel.setFont(Font.font("Roboto", 30));
        topScoreLabel.setPrefSize(120, 100);
        topScoreLabel.setLayoutX(35);
        topScoreLabel.setLayoutY(60);
        Label valueOfTopScore = new Label();
        valueOfTopScore.setFont(Font.font("Roboto", 30));
        valueOfTopScore.setPrefSize(100, 50);
        valueOfTopScore.setLayoutX(35);
        valueOfTopScore.setLayoutY(120);
        valueOfTopScore.setText(String.valueOf(MainGame.getCurrentUser().getHighScore()));
        root.getChildren().add(topScoreLabel);
        root.getChildren().add(valueOfTopScore);
    }

    private void someLabels2(Pane root) {
        Label numberOfVirusLabel = new Label("VIRUS");
        numberOfVirusLabel.setFont(Font.font("Roboto", 30));
        numberOfVirusLabel.setPrefSize(110, 100);
        numberOfVirusLabel.setLayoutX(435);
        numberOfVirusLabel.setLayoutY(390);
        processForSomeLabel2(root);
        root.getChildren().add(numberOfVirusLabel);
        Label scoreLabel = new Label("SCORE");
        scoreLabel.setFont(Font.font("Roboto", 30));
        scoreLabel.setPrefSize(110, 100);
        scoreLabel.setLayoutX(35);
        scoreLabel.setLayoutY(130);
        if (!MainGame.isFirstLabelScore()) {
            MainGame.getValueOfScoreLabel().setText(String.valueOf(MainGame.getCurrentUser().getScore()));
            MainGame.getValueOfScoreLabel().setFont(Font.font("Roboto", 30));
            MainGame.getValueOfScoreLabel().setPrefSize(100, 50);
            MainGame.getValueOfScoreLabel().setLayoutX(35);
            MainGame.getValueOfScoreLabel().setLayoutY(190);
            root.getChildren().add(MainGame.getValueOfScoreLabel());
            MainGame.setFirstLabelScore(true);
        } else {
            MainGame.getValueOfScoreLabel().setText(String.valueOf(MainGame.getCurrentUser().getScore()));
        }
        root.getChildren().add(scoreLabel);
    }

    private void processForSomeLabel2(Pane root) {
        if (!MainGame.isFirstLabelVirus()) {
            MainGame.getValueOfNumberOfVirusLabel().setText(String.valueOf(MainGame.getNumberOfVirus()));
            MainGame.getValueOfNumberOfVirusLabel().setFont(Font.font("Roboto", 20));
            MainGame.getValueOfNumberOfVirusLabel().setPrefSize(50, 50);
            MainGame.getValueOfNumberOfVirusLabel().setLayoutX(517);
            MainGame.getValueOfNumberOfVirusLabel().setLayoutY(440);
            root.getChildren().add(MainGame.getValueOfNumberOfVirusLabel());
            MainGame.setFirstLabelVirus(true);
        } else {
            MainGame.getValueOfNumberOfVirusLabel().setText(String.valueOf(MainGame.getNumberOfVirus()));
        }
    }

    private void someLabels1(Pane root) {
        Label levelLabel = new Label("LEVEL");
        levelLabel.setFont(Font.font("Roboto", 30));
        levelLabel.setPrefSize(110, 100);
        levelLabel.setLayoutX(435);
        levelLabel.setLayoutY(270);
        Label valueOfLevelLabel = new Label(String.valueOf(MainGame.getLevel()));
        valueOfLevelLabel.setFont(Font.font("Roboto", 20));
        valueOfLevelLabel.setPrefSize(50, 50);
        valueOfLevelLabel.setLayoutX(517);
        valueOfLevelLabel.setLayoutY(320);
        root.getChildren().add(levelLabel);
        root.getChildren().add(valueOfLevelLabel);
        Label speedLabel = new Label("SPEED");
        speedLabel.setFont(Font.font("Roboto", 30));
        speedLabel.setPrefSize(110, 100);
        speedLabel.setLayoutX(435);
        speedLabel.setLayoutY(330);
        Label valueOfSpeedLabel = new Label();
        valueOfSpeedLabel.setFont(Font.font("Roboto", 20));
        valueOfSpeedLabel.setPrefSize(50, 50);
        valueOfSpeedLabel.setLayoutX(500);
        valueOfSpeedLabel.setLayoutY(380);
        processForSomeLabel1(valueOfSpeedLabel);
        root.getChildren().add(speedLabel);
        root.getChildren().add(valueOfSpeedLabel);
    }

    private void processForSomeLabel1(Label valueOfSpeedLabel) {
        if (MainGame.getSpeed() == Speed.LOW) {
            valueOfSpeedLabel.setText("LOW");
        } else if (MainGame.getSpeed() == Speed.MEDIUM) {
            valueOfSpeedLabel.setText("MED");
        } else if (MainGame.getSpeed() == Speed.HIGH) {
            valueOfSpeedLabel.setText("HI");
        }
    }

    private void stopButton(Pane root) {
        if (!MainGame.isStopButtonOneTimeChecker()) {
            Pane pane = new Pane();
            pane.setLayoutX(5);
            pane.setLayoutY(5);
            pane.setPrefSize(40, 40);
            Image background1 = new Image("images/stop.png", 40, 40, false, true);
            ImageView back = new ImageView(background1);
            pane.getChildren().add(back);
            root.getChildren().add(pane);
            pane.setOnMouseClicked(e -> {
                if (MainGame.getStopChecker() == 1) {
                    firstPartOfStopMenu();
                } else if (MainGame.getStopChecker() == 2) {
                    secondPartOfStopMenu();
                }
            });
            MainGame.setStopButtonOneTimeChecker(true);
        }
    }

    private void secondPartOfStopMenu() {
        if (Main.firstMove1) {
            Pill.getTimeline1().play();
            Capsule.getTimeline3().play();
        } else if (Main.secondMove1) {
            Pill.getTimeline2().play();
            Capsule.getTimeline3().play();
        } else if (Main.thirdMove1) {
            Pill.getTimeline3().play();
            Capsule.getTimeline3().play();
        } else if (Main.mainMove1) {
            Pill.getTimeline().play();
            Capsule.getTimeline3().play();
        } else if (Main.firstMove2) {
            Capsule.getTimeline1().play();
            Capsule.getTimeline3().play();
        } else if (Main.secondMove2) {
            Capsule.getTimeline2().play();
            MainGame.setStopChecker(1);
        } else if (Main.thirdMove2) {
            Capsule.getTimeline3().play();
            MainGame.setStopChecker(1);
        } else if (Main.mainMove2) {
            Capsule.getTimeline().play();
            MainGame.setStopChecker(1);
        } else {
            int i = 0;
        }
    }

    private void firstPartOfStopMenu() {
        if (Main.firstMove1) {
            Pill.getTimeline1().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.secondMove1) {
            Pill.getTimeline2().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.thirdMove1) {
            Pill.getTimeline3().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.mainMove1) {
            Pill.getTimeline().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.firstMove2) {
            Capsule.getTimeline1().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.secondMove2) {
            Capsule.getTimeline2().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.thirdMove2) {
            Capsule.getTimeline3().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else if (Main.mainMove2) {
            Capsule.getTimeline().pause();
            MainGame.setStopChecker(MainGame.getStopChecker() + 1);
        } else {
            int i = 0;
        }
    }

    @Override
    public void firstMove(Pane root, GraphicsContext gc, Pane pane) {
        setX(getX() - 1.6);
        setY(getY() - 1.6);
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    @Override
    public void secondMove(Pane root, GraphicsContext gc, Pane pane) {
        setX(getX() - 4);
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    @Override
    public void thirdMove(Pane root, GraphicsContext gc, Pane pane) {
        setY(getY() + 5.5);
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    public static Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        Capsule.timeline = timeline;
    }

    public static Timeline getTimeline1() {
        return timeline1;
    }

    public void setTimeline1(Timeline timeline1) {
        Capsule.timeline1 = timeline1;
    }

    public static Timeline getTimeline2() {
        return timeline2;
    }

    public void setTimeline2(Timeline timeline2) {
        Capsule.timeline2 = timeline2;
    }

    public static Timeline getTimeline3() {
        return timeline3;
    }

    public void setTimeline3(Timeline timeline3) {
        Capsule.timeline3 = timeline3;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Capsule(Color color1, Color color2, Direction direction) {
        super();
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }

    public Capsule() {
    }
}