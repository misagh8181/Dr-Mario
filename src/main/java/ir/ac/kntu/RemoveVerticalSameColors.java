package ir.ac.kntu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.NotNull;

public class RemoveVerticalSameColors {
    public static void removeVerticalSameColors(Pane root) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 12; j++) {
                if (MainGame.getColor()[i][j] == MainGame.getColor()[i][j + 1] && MainGame.getColor()[i][j + 1] == MainGame.getColor()[i][j + 2] && MainGame.getColor()[i][j + 2] == MainGame.getColor()[i][j + 3]) {
                    if (MainGame.getColor()[i][j] != Color.EMPTY) {
                        if (!(Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[i][j]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[i][j + 1]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[i][j + 2]) == 0 && Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[i][j + 3]) == 0)) {
                            firstProcess(root, i, j);
                            for (int k = 0; k < 8; k++) {
                                for (int l = 0; l < 16; l++) {
                                    secondProcess(root, i, j, k, l);
                                }
                            }
                            MainGame.getNumberOfPanes()[i][j] = -1;
                            MainGame.getNumberOfPanes()[i][j + 1] = -1;
                            MainGame.getNumberOfPanes()[i][j + 2] = -1;
                            MainGame.getNumberOfPanes()[i][j + 3] = -1;
                            MainGame.getColor()[i][j] = Color.EMPTY;
                            MainGame.getColor()[i][j + 1] = Color.EMPTY;
                            MainGame.getColor()[i][j + 2] = Color.EMPTY;
                            MainGame.getColor()[i][j + 3] = Color.EMPTY;
                        }
                    }
                }
            }
        }
    }

    private static void secondProcess(Pane root, int i, int j, int k, int l) {
        if (MainGame.getNumberOfPanes()[k][l] == MainGame.getNumberOfPanes()[i][j]) {
            if (k == i) {
                part11(root, j, k, l);
            } else {
                part12(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[k][l] == MainGame.getNumberOfPanes()[i][j + 1]) {
            if (k == i) {
                part21(root, j, k, l);
            } else {
                part22(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[k][l] == MainGame.getNumberOfPanes()[i][j + 2]) {
            if (k == i) {
                part31(root, j, k, l);
            } else {
                part32(root, k, l);
            }
        }
        if (MainGame.getNumberOfPanes()[k][l] == MainGame.getNumberOfPanes()[i][j + 3]) {
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
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[k][l] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[k][l] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
            MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[k][l] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[k][l] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        return pane2;
    }

    private static void part32(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[k][l] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[k][l] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
            MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[k][l] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[k][l] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        return pane2;
    }

    private static void part22(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[k][l] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[k][l] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
            MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[k][l] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[k][l] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        return pane2;
    }

    private static void part12(Pane root, int k, int l) {
        Pane pane2 = new Pane();
        pane2.setPrefSize(18.75, 19);
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        Medicine.getPanes().add(pane2);
        root.getChildren().add(pane2);
        Medicine.getIntegersForCapsuleOrNot().add(1);
        MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
        if (MainGame.getColor()[k][l] == Color.BLUE) {
            Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(3);
        } else if (MainGame.getColor()[k][l] == Color.RED) {
            Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
            ImageView pill2 = new ImageView(pill1);
            Medicine.getImageViews().add(pill2);
            pane2.getChildren().add(pill2);
            Medicine.getIntegersForImage().add(1);
        } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
            MainGame.getNumberOfPanes()[k][l] = Medicine.getPanes().size() - 1;
            if (MainGame.getColor()[k][l] == Color.BLUE) {
                Image pill1 = new Image("images/pill3.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(3);
            } else if (MainGame.getColor()[k][l] == Color.RED) {
                Image pill1 = new Image("images/pill1.png", 18.75, 19, false, true);
                ImageView pill2 = new ImageView(pill1);
                Medicine.getImageViews().add(pill2);
                pane2.getChildren().add(pill2);
                Medicine.getIntegersForImage().add(1);
            } else if (MainGame.getColor()[k][l] == Color.YELLOW) {
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
        pane2.setLayoutX(226 + (k * 18.75));
        pane2.setLayoutY(470 - ((16 - l) * 19));
        return pane2;
    }

    private static void firstProcess(Pane root, int i, int j) {
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[i][j]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[i][j + 1]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[i][j + 2]));
        root.getChildren().remove(Medicine.getPanes().get(MainGame.getNumberOfPanes()[i][j + 3]));
        Pane pane1 = new Pane();
        pane1.setPrefSize(0, 0);
        pane1.setLayoutX(0);
        pane1.setLayoutY(0);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[i][j], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[i][j + 1], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[i][j + 2], pane1);
        Medicine.getPanes().set(MainGame.getNumberOfPanes()[i][j + 3], pane1);
        for (int k = 0; k < 4; k++) {
            if (Medicine.getIntegersForCapsuleOrNot().get(MainGame.getNumberOfPanes()[i][j + k]) == 0) {
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
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[i][j], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[i][j + 1], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[i][j + 2], -1);
        Medicine.getIntegersForCapsuleOrNot().set(MainGame.getNumberOfPanes()[i][j + 3], -1);
    }
}
