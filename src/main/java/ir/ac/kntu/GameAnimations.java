package ir.ac.kntu;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameAnimations {

    private static Pane paneBVR1 = new Pane();

    private static Pane paneBVR2 = new Pane();

    private static Pane paneBVR3 = new Pane();

    private static boolean added1 = false;

    private static Pane paneRVR1 = new Pane();

    private static Pane paneRVR2 = new Pane();

    private static Pane paneRVR3 = new Pane();

    private static boolean added2 = false;

    private static Pane paneYVR1 = new Pane();

    private static Pane paneYVR2 = new Pane();

    private static Pane paneYVR3 = new Pane();

    private static boolean added3 = false;

    private static Pane helper1 = new Pane();

    private static Pane helper2 = new Pane();

    private static Pane helper3 = new Pane();

    private static Timeline timeline1;

    private static Timeline timeline2;

    private static Timeline timeline3;

    private static ImageView checkedPage1;

    private static int numberOfLoops = 1;


    public static void continueOfEffectOfBlueVirus1(Pane paneBVR1, Pane paneBVR2, Pane paneBVR3) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), paneBVR2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(2);
        FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(200), paneBVR1);
        fadeTransition4.setFromValue(1);
        fadeTransition4.setToValue(0);
        fadeTransition4.setAutoReverse(true);
        fadeTransition4.setCycleCount(2);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), paneBVR3);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(2);
        FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(200), paneBVR1);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.setAutoReverse(true);
        fadeTransition3.setCycleCount(2);
        fadeTransition1.play();
        fadeTransition4.play();
        fadeTransition2.setDelay(Duration.millis(600));
        fadeTransition2.play();
        fadeTransition3.setDelay(Duration.millis(600));
        fadeTransition3.play();
    }

    public static void timeLineImplementation1(Pane paneBVR1, Pane paneBVR2, Pane paneBVR3) {
        timeline1 = new Timeline(new KeyFrame(Duration.millis(1600), e -> {// 3 images :)
            continueOfEffectOfBlueVirus1(paneBVR1, paneBVR2, paneBVR3);
        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.playFrom(Duration.millis(1600));
    }

    public static void effectOfBlueVirus(Pane root) {
        processBlueVirus();
        timeLineImplementation1(paneBVR1, paneBVR2, paneBVR3);
        Image helper = new Image("images/helper3.png", 50, 45, false, true);
        ImageView helper2 = new ImageView(helper);
        Image vr1 = new Image("images/10.png", 70, 60, false, true);
        ImageView vr11 = new ImageView(vr1);
        Image vr2 = new Image("images/8.png", 70, 60, false, true);
        ImageView vr22 = new ImageView(vr2);
        Image vr3 = new Image("images/6.png", 62, 60, false, true);
        ImageView vr33 = new ImageView(vr3);
        helper1.getChildren().add(helper2);
        paneBVR1.getChildren().add(vr11);
        paneBVR2.getChildren().add(vr22);
        paneBVR3.getChildren().add(vr33);
        if (!added1) {
            root.getChildren().add(helper1);
            root.getChildren().add(paneBVR1);
            root.getChildren().add(paneBVR2);
            root.getChildren().add(paneBVR3);
            added1 = true;
        }
    }

    private static void processBlueVirus() {
        helper1.setPrefSize(100, 100);
        helper1.setLayoutX(102);
        helper1.setLayoutY(310);
        paneBVR1.setPrefSize(100, 100);
        paneBVR1.setLayoutX(93);
        paneBVR1.setLayoutY(305);
        paneBVR2.setPrefSize(100, 100);
        paneBVR2.setLayoutX(93);
        paneBVR2.setLayoutY(305);
        paneBVR3.setPrefSize(100, 100);
        paneBVR3.setLayoutX(97);
        paneBVR3.setLayoutY(305);
    }

    public static void continueOfEffectOfRedVirus1(Pane paneRVR1, Pane paneRVR2, Pane paneRVR3) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), paneRVR2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(2);
        FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(200), paneRVR1);
        fadeTransition4.setFromValue(1);
        fadeTransition4.setToValue(0);
        fadeTransition4.setAutoReverse(true);
        fadeTransition4.setCycleCount(2);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), paneRVR3);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(2);
        FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(200), paneRVR1);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.setAutoReverse(true);
        fadeTransition3.setCycleCount(2);
        fadeTransition1.play();
        fadeTransition4.play();
        fadeTransition2.setDelay(Duration.millis(600));
        fadeTransition2.play();
        fadeTransition3.setDelay(Duration.millis(600));
        fadeTransition3.play();
    }

    public static void timeLineImplementation2(Pane paneRVR1, Pane paneRVR2, Pane paneRVR3) {
        timeline2 = new Timeline(new KeyFrame(Duration.millis(1600), e -> {// 3 images :)
            continueOfEffectOfRedVirus1(paneRVR1, paneRVR2, paneRVR3);
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.playFrom(Duration.millis(1600));
    }

    public static void effectOfRedVirus(Pane root) {
        processForRedVirus();
        timeLineImplementation2(paneRVR1, paneRVR2, paneRVR3);
        Image helper = new Image("images/helper5.png", 32, 40, false, true);
        ImageView helperRed = new ImageView(helper);
        Image vr1 = new Image("images/16.png", 106, 60, false, true);
        ImageView vr11 = new ImageView(vr1);
        Image vr2 = new Image("images/14.png", 106, 95, false, true);
        ImageView vr22 = new ImageView(vr2);
        Image vr3 = new Image("images/12.png", 66, 95, false, true);
        ImageView vr33 = new ImageView(vr3);
        helper2.getChildren().add(helperRed);
        paneRVR1.getChildren().add(vr11);
        paneRVR2.getChildren().add(vr22);
        paneRVR3.getChildren().add(vr33);
        if (!added2) {
            root.getChildren().add(helper2);
            root.getChildren().add(paneRVR1);
            root.getChildren().add(paneRVR2);
            root.getChildren().add(paneRVR3);
            added2 = true;
        }
    }

    private static void processForRedVirus() {
        helper2.setPrefSize(100, 100);
        helper2.setLayoutX(107);
        helper2.setLayoutY(388);
        paneRVR1.setPrefSize(100, 100);
        paneRVR1.setLayoutX(73);
        paneRVR1.setLayoutY(382);
        paneRVR2.setPrefSize(100, 100);
        paneRVR2.setLayoutX(73);
        paneRVR2.setLayoutY(359);
        paneRVR3.setPrefSize(100, 100);
        paneRVR3.setLayoutX(92);
        paneRVR3.setLayoutY(365);
    }

    public static void continueOfEffectOfYellowVirus1(Pane paneYVR1, Pane paneYVR2, Pane paneYVR3, Pane root) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(200), paneYVR2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(2);
        FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(200), paneYVR1);
        fadeTransition4.setFromValue(1);
        fadeTransition4.setToValue(0);
        fadeTransition4.setAutoReverse(true);
        fadeTransition4.setCycleCount(2);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(200), paneYVR3);
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(2);
        FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(200), paneYVR1);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.setAutoReverse(true);
        fadeTransition3.setCycleCount(2);
        fadeTransition1.play();
        fadeTransition4.play();
        fadeTransition2.setDelay(Duration.millis(600));
        fadeTransition2.play();
        fadeTransition3.setDelay(Duration.millis(600));
        fadeTransition3.play();
        checkedPage(root);
    }

    private static void checkedPage(Pane root) {
        if (numberOfLoops == 1) {
            numberOfLoops++;
        } else if (numberOfLoops == 2) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), checkedPage1);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();
            numberOfLoops++;
        } else if (numberOfLoops == 3) {
            root.getChildren().remove(checkedPage1);
            numberOfLoops++;
        }
    }

    public static void timeLineImplementation3(Pane paneYVR1, Pane paneYVR2, Pane paneYVR3, Pane root) {
        timeline3 = new Timeline(new KeyFrame(Duration.millis(1600), e -> {// 3 images :)
            continueOfEffectOfYellowVirus1(paneYVR1, paneYVR2, paneYVR3, root);
        }));
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.playFrom(Duration.millis(1600));
    }

    public static void effectOfYellowVirus(Pane root) {
        processForYellowVirus();
        timeLineImplementation3(paneYVR1, paneYVR2, paneYVR3, root);
        Image helper = new Image("images/helper4.png", 40, 38.5, false, true);
        ImageView helper2 = new ImageView(helper);
        Image vr1 = new Image("images/22.png", 90, 70, false, true);
        ImageView vr11 = new ImageView(vr1);
        Image vr2 = new Image("images/18.png", 66, 60, false, true);
        ImageView vr22 = new ImageView(vr2);
        Image vr3 = new Image("images/20.png", 64, 56, false, true);
        ImageView vr33 = new ImageView(vr3);
        Image checkedPage = new Image("images/checkedPage.png", 155.5, 169.5, false, true);
        checkedPage1 = new ImageView(checkedPage);
        checkedPage1.setLayoutX(24.5);
        checkedPage1.setLayoutY(290.5);
        helper3.getChildren().add(helper2);
        paneYVR1.getChildren().add(vr11);
        paneYVR2.getChildren().add(vr22);
        paneYVR3.getChildren().add(vr33);
        if (!added3) {
            root.getChildren().add(helper3);
            root.getChildren().add(paneYVR1);
            root.getChildren().add(paneYVR2);
            root.getChildren().add(paneYVR3);
            root.getChildren().add(checkedPage1);
            added3 = true;
        }
    }

    private static void processForYellowVirus() {
        helper3.setPrefSize(100, 100);
        helper3.setLayoutX(45);
        helper3.setLayoutY(347);
        paneYVR1.setPrefSize(100, 100);
        paneYVR1.setLayoutX(23);
        paneYVR1.setLayoutY(330);
        paneYVR2.setPrefSize(100, 100);
        paneYVR2.setLayoutX(35);
        paneYVR2.setLayoutY(337);
        paneYVR3.setPrefSize(100, 100);
        paneYVR3.setLayoutX(33);
        paneYVR3.setLayoutY(340);
    }

    public static void setAdded1(boolean added1) {
        GameAnimations.added1 = added1;
    }

    public static void setAdded2(boolean added2) {
        GameAnimations.added2 = added2;
    }

    public static void setAdded3(boolean added3) {
        GameAnimations.added3 = added3;
    }

    public static Timeline getTimeline1() {
        return timeline1;
    }

    public static void setTimeline1(Timeline timeline1) {
        GameAnimations.timeline1 = timeline1;
    }

    public static Timeline getTimeline2() {
        return timeline2;
    }

    public static void setTimeline2(Timeline timeline2) {
        GameAnimations.timeline2 = timeline2;
    }

    public static Timeline getTimeline3() {
        return timeline3;
    }

    public static void setTimeline3(Timeline timeline3) {
        GameAnimations.timeline3 = timeline3;
    }

    public static int getNumberOfLoops() {
        return numberOfLoops;
    }

    public static void setNumberOfLoops(int numberOfLoops) {
        GameAnimations.numberOfLoops = numberOfLoops;
    }
}