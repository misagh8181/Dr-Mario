package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

public class RemoveHorizontalSameColors {
    public static void removeHorizontalSameColors(Pane root) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j <= 4; j++) {
                if (MainGame.getColor()[j][i] == MainGame.getColor()[j + 1][i] && MainGame.getColor()[j + 1][i] == MainGame.getColor()[j + 2][i] && MainGame.getColor()[j + 2][i] == MainGame.getColor()[j + 3][i]) {
                    if (MainGame.getColor()[j][i] != Color.EMPTY) {
                        if (!(Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[j][i]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[j + 1][i]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[j + 2][i]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[j + 3][i]) == 0)) {
                            firstProcess(root, i, j);
                            for (int k = 0; k < 16; k++) {
                                for (int l = 0; l < 8; l++) {
                                    secondProcess(root, i, j, k, l);
                                }
                            }
                            MainGame.getNumberOfPanes()[j][i] = -1;
                            MainGame.getNumberOfPanes()[j + 1][i] = -1;
                            MainGame.getNumberOfPanes()[j + 2][i] = -1;
                            MainGame.getNumberOfPanes()[j + 3][i] = -1;
                            MainGame.getColor()[j][i] = Color.EMPTY;
                            MainGame.getColor()[j + 1][i] = Color.EMPTY;
                            MainGame.getColor()[j + 2][i] = Color.EMPTY;
                            MainGame.getColor()[j + 3][i] = Color.EMPTY;
                        }
                    }
                }
            }
        }
    }

    private static void secondProcess(Pane root, int i, int j, int k, int l) {
        if (MainGame.getNumberOfPanes()[l][k] == MainGame.getNumberOfPanes()[j][i]) {
            if (k == i) {
                part11(root, j, k, l);
            } else {
                part12(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[l][k] == MainGame.getNumberOfPanes()[j + 1][i]) {
            if (k == i) {
                part21(root, j, k, l);
            } else {
                part22(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[l][k] == MainGame.getNumberOfPanes()[j + 2][i]) {
            if (k == i) {
                part31(root, j, k, l);
            } else {
                part32(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[l][k] == MainGame.getNumberOfPanes()[j + 3][i]) {
            if (k == i) {
                part41(root, j, k, l);
            } else {
                part42(root, k, l);
            }
        }
    }

    private static void part42(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[l][k] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[l][k] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
            Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(2);
        }
    }

    private static void part41(Pane root, int j, int k, int l) {
        if (l != j && l != j + 1 && l != j + 2 && l != j + 3) {
            Pane pane2 = getPane4(k, l);
            Medicine.getPanes().add(pane2);
            root.getChildren().add(pane2);
            Medicine.getIntegersForCapsuleOrNot().add(1);
            MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[l][k] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[l][k] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
                Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(2);
            }
        }
    }

    @NotNull
    private static Pane getPane4(int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        return pane2;
    }

    private static void part32(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[l][k] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[l][k] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
            Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(2);
        }
    }

    private static void part31(Pane root, int j, int k, int l) {
        if (l != j && l != j + 1 && l != j + 2 && l != j + 3) {
            Pane pane2 = getPane3(k, l);
            Medicine.getPanes().add(pane2);
            root.getChildren().add(pane2);
            Medicine.getIntegersForCapsuleOrNot().add(1);
            MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[l][k] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[l][k] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
                Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(2);
            }
        }
    }

    @NotNull
    private static Pane getPane3(int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        return pane2;
    }

    private static void part22(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[l][k] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[l][k] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
            Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(2);
        }
    }

    private static void part21(Pane root, int j, int k, int l) {
        if (l != j && l != j + 1 && l != j + 2 && l != j + 3) {
            Pane pane2 = getPane2(k, l);
            Medicine.getPanes().add(pane2);
            root.getChildren().add(pane2);
            Medicine.getIntegersForCapsuleOrNot().add(1);
            MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[l][k] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[l][k] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
                Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(2);
            }
        }
    }

    @NotNull
    private static Pane getPane2(int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        return pane2;
    }

    private static void part12(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[l][k] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[l][k] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
            Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(2);
        }
    }

    private static void part11(Pane root, int j, int k, int l) {
        if (l != j && l != j + 1 && l != j + 2 && l != j + 3) {
            Pane pane2 = getPane1(k, l);
            Medicine.getPanes().add(pane2);
            root.getChildren().add(pane2);
            Medicine.getIntegersForCapsuleOrNot().add(1);
            MainGame.getNumberOfPanes()[l][k] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[l][k] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[l][k] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[l][k] == Color.YELLOW) {
                Image pill1 = new Image("images/pill2.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(2);
            }
        }
    }

    @NotNull
    private static Pane getPane1(int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (l * 18.75));
        pane2.setLayoutY(470 - ((16 - k) * 19));
        return pane2;
    }

    private static void firstProcess(Pane root, int i, int j) {
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[j][i]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[j + 1][i]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[j + 2][i]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[j + 3][i]));
        Pane pane1 = new Pane();
        pane1.setPrefSize(0, 0);
        pane1.setLayoutX(0);
        pane1.setLayoutY(0);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[j][i], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[j + 1][i], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[j + 2][i], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[j + 3][i], pane1);
        for (int k = 0; k < 4; k++) {
            if (Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[j + k][i]) == 0) {
                MainGame.setNumberOfVirus(MainGame.getNumberOfVirus() - 1);
                if (MainGame.getSpeed() == Speed.LOW) {
                    MainGame.getCurrentUser().setScore(MainGame.getCurrentUser().getScore() + 10);
                } else if (MainGame.getSpeed() == Speed.MEDIUM) {
                    MainGame.getCurrentUser().setScore(MainGame.getCurrentUser().getScore() + 11);
                } else if (MainGame.getSpeed() == Speed.HIGH) {
                    MainGame.getCurrentUser().setScore(MainGame.getCurrentUser().getScore() + 15);
                }
            }
        }
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[j][i], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[j + 1][i], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[j + 2][i], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[j + 3][i], -1);
    }
}
