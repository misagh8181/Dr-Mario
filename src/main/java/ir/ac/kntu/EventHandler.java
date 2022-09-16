package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class EventHandler {//singleton
    private static final EventHandler INSTANCE = new EventHandler();// instance -> shahed

    private static boolean check1 = false;

    private static boolean check2 = false;

    private static boolean check3 = false;

    private static int check4 = 1;

    private static int check5 = 1;

    private static int check6 = 1;

    public static EventHandler getInstance() {
        return INSTANCE;
    }

    private EventHandler() {
    }

    public void attachEventHandlersForSetUpMenu(Scene scene, GraphicsContext gc) {
        if (!MainGame.isInGameForEventOfSetUpMenu()) {
            scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                KeyCode code = keyEvent.getCode();
                if (code == KeyCode.RIGHT) {
                    Image background = new Image("images/setUpMenu.png", 600, 520, false, true);
                    gc.drawImage(background, 0, 0);
                    MainMenu.drawPolygons(gc, true, true);
                } else if (code == KeyCode.LEFT) {
                    Image background = new Image("images/setUpMenu.png", 600, 520, false, true);
                    gc.drawImage(background, 0, 0);
                    MainMenu.drawPolygons(gc, true, false);
                } else if (code == KeyCode.UP) {
                    Image background = new Image("images/setUpMenu.png", 600, 520, false, true);
                    gc.drawImage(background, 0, 0);
                    MainMenu.drawLine(gc, true, true);
                } else if (code == KeyCode.DOWN) {
                    Image background = new Image("images/setUpMenu.png", 600, 520, false, true);
                    gc.drawImage(background, 0, 0);
                    MainMenu.drawLine(gc, true, false);
                }
            });
            scene.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
                return;
            });
        } else {
            int i = 0;
        }
    }

    public void attachEventHandlersForMainGame(Scene scene, GraphicsContext gc, Pane root) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            KeyCode code = keyEvent.getCode();
            if (MainGame.isStopForEventHandler()) {
                int i = 0;
            } else {
                if (code == KeyCode.RIGHT) {
                    rightProcess();
                } else if (code == KeyCode.LEFT) {
                    leftProcess();
                } else if (code == KeyCode.DOWN) {
                    Medicine.faster();
                } else if (code == KeyCode.X) {
                    if (Medicine.getIntegersForCapsuleOrNot().get(Medicine.getIntegersForCapsuleOrNot().size() - 1).equals(2)) {
                        xProcess();
                    }
                }
            }
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
            KeyCode code = keyEvent.getCode();
            if (code == KeyCode.DOWN) {
                Medicine.lower();
            }
            return;
        });
    }

    private void xProcess() {
        if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(24)) {
            image24();
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(26)) {
            image26();
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(28)) {
            image28();
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(30)) {
            partOneImage30();
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(34)) {
            partOneImage34();
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1).equals(38)) {
            partOneImage38();
        }
    }

    private void partTwoImage38() {
        if (check6 == 3) {
            Image pill = new Image("images/41.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL2);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.RED);
            check6++;
        } else if (check6 == 4) {
            Image pill = new Image("images/38.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.YELLOW);
            check6 = 1;
        }
    }

    private void partOneImage38() {
        if (check6 == 1) {
            Image pill = new Image("images/39.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.YELLOW);
            check6++;
        } else if (check6 == 2) {
            Image pill = new Image("images/40.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL2);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.RED);
            check6++;
        } else {
            partTwoImage38();
        }
    }

    private void partTwoImage34() {
        if (check5 == 3) {
            Image pill = new Image("images/37.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL2);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.RED);
            check5++;
        } else if (check5 == 4) {
            Image pill = new Image("images/34.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.BLUE);
            check5 = 1;
        }
    }

    private void partOneImage34() {
        if (check5 == 1) {
            Image pill = new Image("images/35.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.BLUE);
            check5++;
        } else if (check5 == 2) {
            Image pill = new Image("images/36.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL2);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.RED);
            check5++;
        } else {
            partTwoImage34();
        }
    }

    private void partTwoImage30() {
        if (check4 == 3) {
            Image pill = new Image("images/33.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL2);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.BLUE);
            check4++;
        } else if (check4 == 4) {
            Image pill = new Image("images/30.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.YELLOW);
            check4 = 1;
        }
    }

    private void partOneImage30() {
        if (check4 == 1) {
            Image pill = new Image("images/31.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.YELLOW);
            check4++;
        } else if (check4 == 2) {
            Image pill = new Image("images/32.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL2);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.BLUE);
            check4++;
        } else {
            partTwoImage30();
        }
    }

    private void image28() {
        if (!check3) {
            Image pill = new Image("images/29.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.YELLOW);
            check3 = true;
        } else {
            Image pill = new Image("images/28.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.YELLOW);
            capsule.setColor2(Color.YELLOW);
            check3 = false;
        }
    }

    private void image26() {
        if (!check2) {
            Image pill = new Image("images/27.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.RED);
            check2 = true;
        } else {
            Image pill = new Image("images/26.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.RED);
            capsule.setColor2(Color.RED);
            check2 = false;
        }
    }

    private void image24() {
        if (!check1) {
            Image pill = new Image("images/25.png", 19, 33.5, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(19, 33.5);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.VERTICAL1);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.BLUE);
            check1 = true;
        } else {
            Image pill = new Image("images/24.png", 33.5, 19, false, true);
            Medicine.getImageViews().get(Medicine.getImageViews().size() - 1).setImage(pill);
            Medicine.getPanes().get(Medicine.getPanes().size() - 1).setPrefSize(33.5, 19);
            Capsule capsule = (Capsule) MainGame.getMedicine();
            capsule.setDirection(Direction.HORIZONTAL1);
            capsule.setColor1(Color.BLUE);
            capsule.setColor2(Color.BLUE);
            check1 = false;
        }
    }

    private void leftProcess() {
        boolean left = false;
        for (int i = 0; i < Medicine.getPanes().size() - 1; i++) {
            if (Medicine.getPanes().get(i).getLayoutY() - Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() < (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) &&
                    Medicine.getPanes().get(i).getLayoutY() - Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() > -(Medicine.getPanes().get(i).getHeight())) {
                if (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() - (Medicine.getPanes().get(i).getLayoutX() + Medicine.getPanes().get(i).getWidth()) < 5 &&
                        Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() - (Medicine.getPanes().get(i).getLayoutX() + Medicine.getPanes().get(i).getWidth()) >= -5) {
                    left = true;
                }
            }
        }
        if (!left) {
            if (Capsule.getPanes().get(Capsule.getPanes().size() - 1).getLayoutX() > 230) {
                Capsule.getPanes().get(Capsule.getPanes().size() - 1).setLayoutX(Capsule.getPanes().get(Capsule.getPanes().size() - 1).getLayoutX() - 18.75);
            }
        }
    }

    private void rightProcess() {
        boolean right = false;
        for (int i = 0; i < Medicine.getPanes().size() - 1; i++) {
            if (Medicine.getPanes().get(i).getLayoutY() - Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() < (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getHeight()) &&
                    Medicine.getPanes().get(i).getLayoutY() - Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutY() > -(Medicine.getPanes().get(i).getHeight())) {
                if (Medicine.getPanes().get(i).getLayoutX() - (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) < 5
                        && Medicine.getPanes().get(i).getLayoutX() - (Medicine.getPanes().get(Medicine.getPanes().size() - 1).getLayoutX() + Medicine.getPanes().get(Medicine.getPanes().size() - 1).getWidth()) >= 0) {
                    right = true;
                }
            }
        }
        if (!right) {
            if (Capsule.getPanes().get(Capsule.getPanes().size() - 1).getLayoutX() + Capsule.getPanes().get(Capsule.getPanes().size() - 1).getWidth() < 370) {
                Capsule.getPanes().get(Capsule.getPanes().size() - 1).setLayoutX(Capsule.getPanes().get(Capsule.getPanes().size() - 1).getLayoutX() + 18.75);
            }
        }
    }

    public static boolean isCheck1() {
        return check1;
    }

    public static void setCheck1(boolean check1) {
        EventHandler.check1 = check1;
    }

    public static boolean isCheck2() {
        return check2;
    }

    public static void setCheck2(boolean check2) {
        EventHandler.check2 = check2;
    }

    public static boolean isCheck3() {
        return check3;
    }

    public static void setCheck3(boolean check3) {
        EventHandler.check3 = check3;
    }

    public static int getCheck4() {
        return check4;
    }

    public static void setCheck4(int check4) {
        EventHandler.check4 = check4;
    }

    public static int getCheck5() {
        return check5;
    }

    public static void setCheck5(int check5) {
        EventHandler.check5 = check5;
    }

    public static int getCheck6() {
        return check6;
    }

    public static void setCheck6(int check6) {
        EventHandler.check6 = check6;
    }
}