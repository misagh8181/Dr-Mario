package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class SelfTreatment implements Runnable {
    private int counter;

    private int xSelf;

    private int ySelf;

    public static int timer = 1;

    @Override
    public void run() {
        if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 1) {
            MainGame.getColor()[xSelf][(17 - ySelf) - 1] = Color.RED;
            MainGame.getNumberOfPanes()[xSelf][(17 - ySelf) - 1] = counter;
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 2) {
            MainGame.getColor()[xSelf][(17 - ySelf) - 1] = Color.YELLOW;
            MainGame.getNumberOfPanes()[xSelf][(17 - ySelf) - 1] = counter;
        } else if (Medicine.getIntegersForImage().get(Medicine.getIntegersForImage().size() - 1) == 3) {
            MainGame.getColor()[xSelf][(17 - ySelf) - 1] = Color.BLUE;
            MainGame.getNumberOfPanes()[xSelf][(17 - ySelf) - 1] = counter;
        }
    }

    public static void selfTreatment(Pane root) {
        boolean yesOrNot = new Random().nextBoolean();
        if (timer == 1) {
            timer++;
        } else if (timer == 2) {
            timer++;
        } else if (timer == 3) {
            timer++;
        } else if (timer == 4) {
            timer++;
        } else if (timer == 5) {
            if (yesOrNot) {
                for (int i = 0; i < 2; i++) {
                    Pane selfPill = new Pane();
                    Medicine.getPanes().add(selfPill);
                    Medicine.getIntegersForCapsuleOrNot().add(1);
                    selfPill.setPrefSize(18.75, 19);
                    Random random = new Random();
                    int numberOfImage = random.nextInt(3);
                    analiseForNumberOfImages(selfPill, numberOfImage + 1);
                    while (true) {
                        if (repetitionForSelfTreatment(root, selfPill, random)) {
                            break;
                        }
                    }
                }
            }
            timer = 1;
        }
    }

    private static boolean repetitionForSelfTreatment(Pane root, Pane selfPill, Random random) {
        boolean xY = true;
        int xSelf = random.nextInt(7);// 0 -> 7
        xSelf++;
        int ySelf = random.nextInt(10);// 1 -> 10
        ySelf++;
        for (int j = 0; j < Medicine.getPanes().size() - 1; j++) {
            if (MainGame.getColor()[xSelf][(17 - ySelf) - 1] != Color.EMPTY) {
                xY = false;
            }
            if (Medicine.getPanes().get(j).getLayoutX() == 226 + (xSelf * 18.75) && Medicine.getPanes().get(j).getLayoutY() == 470 - (ySelf * 19)) {
                xY = false;
            }
        }
        if (xY) {
            int counter = Medicine.getPanes().size() - 1;
            Thread thread = new Thread(new SelfTreatment(counter, xSelf, ySelf));
            selfPill.setLayoutX(226 + (xSelf * 18.75));
            selfPill.setLayoutY(470 - (ySelf * 19));
            root.getChildren().add(selfPill);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return true;
        }
        return false;
    }

    private static void analiseForNumberOfImages(Pane selfPill, int numberOfImage) {
        if (numberOfImage == 1) {
            Image pill = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            selfPill.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(1);
        } else if (numberOfImage == 2) {
            Image pill = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            selfPill.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(2);
        } else if (numberOfImage == 3) {
            Image pill = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill1 = new ImageView(pill);
            Medicine.getImageViews().add(pill1);
            selfPill.getChildren().add(pill1);
            Medicine.getIntegersForImage().add(3);
        }
    }

    public SelfTreatment(int counter, int xSelf, int ySelf) {
        this.xSelf = xSelf;
        this.ySelf = ySelf;
        this.counter = counter;
    }
}