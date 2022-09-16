package ir.ac.kntu;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Pill extends Medicine {
    private Color color;

    private static Timeline timeline;

    private static Timeline timeline1;

    private static Timeline timeline2;

    private static Timeline timeline3;

    private Random random = new Random();

    @NotNull
    private Pane getPane(Pane root) {
        Pane pane = new Pane();
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
        Medicine.getPanes().add(pane);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        pane.setPrefSize(18.75, 19);
        int numberOfImage = random.nextInt(3);
        paneImplementation(pane, numberOfImage + 1);
        root.getChildren().add(pane);
        return pane;
    }

    private void paneImplementation(Pane pane, int numberOfImage) {
        if (numberOfImage == 1) {
            Image pill = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            pane.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(1);
            this.color = Color.RED;
        } else if (numberOfImage == 2) {
            Image pill = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            pane.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(2);
            this.color = Color.YELLOW;
        } else if (numberOfImage == 3) {
            Image pill = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            pane.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(3);
            this.color = Color.BLUE;
        }
    }

    @Override
    public void throwing(Pane root, GraphicsContext gc, Scene scene) throws InterruptedException {
        Pane pane = firstProcessAndGetPane(root, gc);
        timeline = new Timeline(new KeyFrame(Duration.millis(1), e -> {
            analiseForPill(pane);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline1.setOnFinished(e -> {
            Main.firstMove1 = false;
            Main.secondMove1 = true;
            MainGame.setStopForEventHandler(true);
            timeline2.play();
        });
        timeline2.setOnFinished(e -> {
            Main.secondMove1 = false;
            Main.thirdMove1 = true;
            setX(getX() - 0.75);
            pane.setLayoutX(getX());
            MainGame.setStopForEventHandler(true);
            timeline3.play();
        });
        timeline3.setOnFinished(e -> {
            Main.thirdMove1 = false;
            MainGame.setStopForEventHandler(false);
            timeline.play();
        });
    }//timeline.setOnFinished for start a timeline and then close that and start another one

    @NotNull
    private Pane firstProcessAndGetPane(Pane root, GraphicsContext gc) {
        MainGame.effectOfDoctor(root);
        Pane pane = getPane(root);
        MainGame.getValueOfNumberOfVirusLabel().setText(String.valueOf(MainGame.getNumberOfVirus()));
        MainGame.getValueOfScoreLabel().setText(String.valueOf(MainGame.getCurrentUser().getScore()));
        timeline1 = new Timeline(new KeyFrame(Duration.millis(20), e -> firstMove(root, gc, pane)));
        timeline1.setCycleCount(80);
        MainGame.setStopForEventHandler(true);
        timeline1.play();
        Main.firstMove1 = true;
        timeline2 = new Timeline(new KeyFrame(Duration.millis(50), e -> secondMove(root, gc, pane)));
        timeline2.setCycleCount(4);
        timeline3 = new Timeline(new KeyFrame(Duration.millis(50), e -> thirdMove(root, gc, pane)));
        timeline3.setCycleCount(25);
        if (MainGame.getSpeed() == Speed.MEDIUM) {
            setvY(getvY() * 4);
        } else if (MainGame.getSpeed() == Speed.HIGH) {
            setvY(getvY() * 8);
        }
        return pane;
    }

    private void analiseForPill(Pane pane) {
        setY(getY() + getvY());
        pane.setLayoutY(getY());
        for (int i = 0; i < Medicine.getPanes().size() - 1; i++) {
            if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) >= Medicine.getPanes().get(i).getLayoutY() + 1
                    && Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) <= Medicine.getPanes().get(i).getLayoutY() + 5) {
                if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + ((Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) / 2) >= Medicine.getPanes().get(i).getLayoutX() - 2 &&// difference 2
                        Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + ((Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) / 2) <= Medicine.getPanes().get(i).getLayoutX() + Medicine.getPanes().get(i).getWidth() + 3) {//difference 3
                    Pill pill = (Pill) MainGame.getMedicine();
                    AnaliseForPill.putColorForPills(pill);
                    MainGame.mainTimeLine.setDelay(Duration.ZERO);
                    MainGame.mainTimeLine.play();
                    timeline.stop();
                }
            }
        }
        if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() + Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight() > 470) {
            Pill pill = (Pill) MainGame.getMedicine();
            AnaliseForPill.putColorForPills(pill);
            MainGame.mainTimeLine.setDelay(Duration.ZERO);
            MainGame.mainTimeLine.play();
            timeline.stop();
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
        setX(getX() - 3.5);
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
        Pill.timeline = timeline;
    }

    public static Timeline getTimeline1() {
        return timeline1;
    }

    public void setTimeline1(Timeline timeline1) {
        Pill.timeline1 = timeline1;
    }

    public static Timeline getTimeline2() {
        return timeline2;
    }

    public void setTimeline2(Timeline timeline2) {
        Pill.timeline2 = timeline2;
    }

    public static Timeline getTimeline3() {
        return timeline3;
    }

    public void setTimeline3(Timeline timeline3) {
        Pill.timeline3 = timeline3;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Pill(Color color) {
        super();
        this.color = color;
    }

    public Pill() {
    }
}
