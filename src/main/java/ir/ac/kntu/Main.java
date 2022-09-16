package ir.ac.kntu;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Misagh Maleki
 */
public class Main extends Application {
    private boolean mainMenu = false;

    private boolean setUpMenu = false;

    private boolean mainPage = false;

    private static Label labelForLevel;

    private static int levelOfImprovement = 1;

    private static Button button;

    private static Text text;

    private static int twotimesForEventInSetUpMenu = 1;

    public static boolean firstMove1;

    public static boolean secondMove1;

    public static boolean thirdMove1;

    public static boolean mainMove1;

    public static boolean firstMove2;

    public static boolean secondMove2;

    public static boolean thirdMove2;

    public static boolean mainMove2;

    public static void main(String[] args) {
        launch(args);
    }

    private void mainStart(GraphicsContext gc, Stage primaryStage) throws Exception {
        if (levelOfImprovement == 2 && !mainMenu) {
            start(primaryStage);
            mainMenu = true;
        } else if (levelOfImprovement == 3 && !setUpMenu) {
            start(primaryStage);
            setUpMenu = true;
        } else if (levelOfImprovement == 4 && !mainPage) {
            start(primaryStage);
            mainPage = true;
        }
    }

    @NotNull
    public Timeline getTimeline(Stage primaryStage, GraphicsContext gc) {
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            try {
                mainStart(gc, primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }));
        tl.setCycleCount(Timeline.INDEFINITE);
        return tl;
    }

    public void textHandler1(Pane root, ScrollPane scrollPane, VBox content) {
        Text text = new Text(259, 40, "Add User");
        text.setFill(Color.rgb(200, 120, 23));
        text.setFont(Font.font(20));
        text.setOnMouseClicked(e -> {
            try {
                UsersMenu.registerUser(root, scrollPane, content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        root.getChildren().add(text);
    }

    public void buttonHandler1(Pane root, ScrollPane scrollPane, VBox content) {
        Button button = new Button();
        button.setOnAction(e -> {
            try {
                UsersMenu.registerUser(root, scrollPane, content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        root.getChildren().add(button);
        button.setPrefSize(90, 50);
        button.setLayoutX(255);
        button.setLayoutY(10);
    }

    @NotNull
    public ScrollPane getScrollPane(Pane root, Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(75);
        scrollPane.setLayoutY(280);
        scrollPane.setPrefSize(450, 230);
        scrollPane.setStyle("-fx-background-color: DarkGreen");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.getChildren().add(scrollPane);
        return scrollPane;
    }

    public void timeLineImplementation1(Pane panedr1, Pane panedr2) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {// 3 images :)
            continueOfEffect1(panedr1, panedr2);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void continueOfEffect1(Pane panedr1, Pane panedr2) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(300), panedr2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(Timeline.INDEFINITE);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(300), panedr1);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(Timeline.INDEFINITE);
        fadeTransition1.play();
        fadeTransition2.play();
    }

    public void effect1(Pane root) {
        Pane helper = new Pane();
        Pane panedr1 = new Pane();
        Pane panedr2 = new Pane();
        helper.setPrefSize(15, 15);
        helper.setLayoutX(100);
        helper.setLayoutY(7);
        panedr1.setPrefSize(15, 15);
        panedr1.setLayoutX(100);
        panedr1.setLayoutY(7);
        panedr2.setPrefSize(15, 15);
        panedr2.setLayoutX(100);
        panedr2.setLayoutY(7);
        timeLineImplementation1(panedr1, panedr2);
        Image helpImage = new Image("images/helper1.png", 80, 80, false, true);
        ImageView dr = new ImageView(helpImage);
        Image dr1 = new Image("images/1.png", 80, 80, false, true);
        ImageView dr11 = new ImageView(dr1);
        Image dr2 = new Image("images/2.png", 80, 80, false, true);
        ImageView dr22 = new ImageView(dr2);
        helper.getChildren().add(dr);
        panedr1.getChildren().add(dr11);
        panedr2.getChildren().add(dr22);
        root.getChildren().add(helper);
        root.getChildren().add(panedr1);
        root.getChildren().add(panedr2);
    }

    public void timeLineImplementation2(Pane panedr1, Pane panedr2) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {// 3 images :)
            continueOfEffect2(panedr1, panedr2);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void continueOfEffect2(Pane panedr1, Pane panedr2) {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(300), panedr2);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(Timeline.INDEFINITE);
        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(300), panedr1);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(Timeline.INDEFINITE);
        fadeTransition1.play();
        fadeTransition2.play();
    }

    public void effect2(Pane root) {
        Pane helper = new Pane();
        Pane panedr1 = new Pane();
        Pane panedr2 = new Pane();
        helper.setPrefSize(15, 15);
        helper.setLayoutX(415);
        helper.setLayoutY(7);
        panedr1.setPrefSize(15, 15);
        panedr1.setLayoutX(415);
        panedr1.setLayoutY(7);
        panedr2.setPrefSize(15, 15);
        panedr2.setLayoutX(415);
        panedr2.setLayoutY(7);
        timeLineImplementation2(panedr1, panedr2);
        Image helpImage = new Image("images/helper1.png", 80, 80, false, true);
        ImageView dr = new ImageView(helpImage);
        Image dr1 = new Image("images/1.png", 80, 80, false, true);
        ImageView dr11 = new ImageView(dr1);
        Image dr2 = new Image("images/2.png", 80, 80, false, true);
        ImageView dr22 = new ImageView(dr2);
        helper.getChildren().add(dr);
        panedr1.getChildren().add(dr11);
        panedr2.getChildren().add(dr22);
        root.getChildren().add(helper);
        root.getChildren().add(panedr1);
        root.getChildren().add(panedr2);
    }

    public void restOfLevel2(Pane root, GraphicsContext gc, Stage primaryStage) throws InterruptedException, IOException, ClassNotFoundException {
        TimeUnit.SECONDS.sleep(2);
        Image background = new Image("images/userMenu.png", 600, 600, true, true);
        gc.drawImage(background, 0, 0);
        ScrollPane scrollPane = getScrollPane(root, primaryStage);
        VBox content = new VBox(1);
        scrollPane.setContent(content);
        effect1(root);
        effect2(root);
        UsersMenu.firstCheckUp(content, false);
        buttonHandler1(root, scrollPane, content);
        textHandler1(root, scrollPane, content);
    }

    public void buttonHandler2(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, boolean continueOrNot) {
        button = new Button();
        if (continueOrNot) {
            button.setOnAction(e -> {
                ifPartButton(root, gc, scene, primaryStage);
            });
        } else {
            button.setOnAction(e -> {
                int speed = MainMenu.getNumberOfSpeed();
                if (speed == 1) {
                    MainMenu.setSpeed(Speed.LOW);
                } else if (speed == 2) {
                    MainMenu.setSpeed(Speed.MEDIUM);
                } else if (speed == 3) {
                    MainMenu.setSpeed(Speed.HIGH);
                }
                levelOfImprovement++;
            });
        }
        root.getChildren().add(button);
        button.setPrefSize(90, 50);
        button.setLayoutX(255);
        button.setLayoutY(465);
    }

    private void ifPartButton(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage) {
        int speed = MainMenu.getNumberOfSpeed();
        if (speed == 1) {
            MainMenu.setSpeed(Speed.LOW);
        } else if (speed == 2) {
            MainMenu.setSpeed(Speed.MEDIUM);
        } else if (speed == 3) {
            MainMenu.setSpeed(Speed.HIGH);
        }
        root.getChildren().clear();
        root.getChildren().add(gc.getCanvas());
        MainGame.setInGameForEventOfSetUpMenu(true);
        try {
            MainGame.start(root, gc, scene, primaryStage, false);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void textHandler2(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, boolean continueOrNot) {
        text = new Text(258, 495, "* START *");
        text.setFill(Color.rgb(200, 120, 23));
        text.setFont(Font.font(20));
        if (continueOrNot) {
            text.setOnMouseClicked(e -> {
                ifPartText(root, gc, scene, primaryStage);
            });
        } else {
            text.setOnMouseClicked(e -> {
                int speed = MainMenu.getNumberOfSpeed();
                if (speed == 1) {
                    MainMenu.setSpeed(Speed.LOW);
                } else if (speed == 2) {
                    MainMenu.setSpeed(Speed.MEDIUM);
                } else if (speed == 3) {
                    MainMenu.setSpeed(Speed.HIGH);
                }
                levelOfImprovement++;
            });
        }
        root.getChildren().add(text);
    }

    private void ifPartText(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage) {
        int speed = MainMenu.getNumberOfSpeed();
        if (speed == 1) {
            MainMenu.setSpeed(Speed.LOW);
        } else if (speed == 2) {
            MainMenu.setSpeed(Speed.MEDIUM);
        } else if (speed == 3) {
            MainMenu.setSpeed(Speed.HIGH);
        }
        root.getChildren().clear();
        root.getChildren().add(gc.getCanvas());
        MainGame.setInGameForEventOfSetUpMenu(true);
        try {
            MainGame.start(root, gc, scene, primaryStage, false);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void restOfLevel3(Pane root, GraphicsContext gc, Scene scene, Stage primaryStage, boolean continueOrNot) {
        Image background = new Image("images/setUpMenu.png", 600, 520, false, true);
        gc.drawImage(background, 0, 0);
        buttonHandler2(root, gc, scene, primaryStage, continueOrNot);
        textHandler2(root, gc, scene, primaryStage, continueOrNot);
        labelForLevel = new Label("00");
        labelForLevel.setFont(Font.font("Roboto", 25));
        labelForLevel.setTextFill(Color.rgb(235, 235, 235));
        labelForLevel.setPrefSize(40, 40);
        labelForLevel.setLayoutX(427);
        labelForLevel.setLayoutY(159);
        root.getChildren().add(labelForLevel);
        MainMenu.drawPolygons(gc, false, false);
        MainMenu.drawLine(gc, false, false);
        if (twotimesForEventInSetUpMenu <= 2) {
            EventHandler.getInstance().attachEventHandlersForSetUpMenu(scene, gc);
            twotimesForEventInSetUpMenu++;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Canvas canvas = new Canvas(Constants.CANVAS_WIDTH, Constants.CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        Timeline tl = getTimeline(primaryStage, gc);
        try {
            if (levelOfImprovement == 1) {
                Image background = new Image("images/menu1.png", 600, 520, false, true);
                gc.drawImage(background, 0, 0);
                levelOfImprovement++;
            } else if (levelOfImprovement == 2) {
                restOfLevel2(root, gc, primaryStage);
            } else if (levelOfImprovement == 3) {
                restOfLevel3(root, gc, scene, primaryStage, false);
            } else if (levelOfImprovement == 4) {
                MainGame.start(root, gc, scene, primaryStage, true);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        primaryStage.setTitle("DrMario-Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        tl.play();
    }

    public static Label getLabelForLevel() {
        return labelForLevel;
    }

    public static int getLevelOfImprovement() {
        return levelOfImprovement;
    }

    public static void setLevelOfImprovement(int levelOfImprovement) {
        Main.levelOfImprovement = levelOfImprovement;
    }
}