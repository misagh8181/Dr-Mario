package ir.ac.kntu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MainMenu {
    private static int level = 0;// 0 -> 20

    private static Speed speed;

    private static int numberOfSpeed = 2;// 1 -> 3

    private static double[] firstXes = new double[]{210, 230, 220};

    private static double[] firstYes = new double[]{180, 180, 192};

    private static double height = 37;

    private static double width = 215;

    private static double xForLine = 115;

    private static double yForLine = 125;

    private static int upOrDown = 0;// 0 or -1

    private static double[] secondXes = new double[]{305, 347, 326};

    private static double[] secondYes = new double[]{293, 293, 305};

    public static boolean secondLevelOfUpOrDownMinus1(GraphicsContext gc) {
        if (numberOfSpeed == 1) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        int i = 0;
        double[] final1 = new double[3];
        for (double x : MainMenu.getSecondXes()) {
            final1[i] = x - 90;
            i++;
        }
        MainMenu.setSecondXes(final1);
        numberOfSpeed--;
        return false;
    }

    public static boolean firstLevelOfUpOrDownMinus1(GraphicsContext gc) {
        if (numberOfSpeed == 3) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        int i = 0;
        double[] final1 = new double[3];
        for (double x : MainMenu.getSecondXes()) {
            final1[i] = x + 90;
            i++;
        }
        MainMenu.setSecondXes(final1);
        numberOfSpeed++;
        return false;
    }

    public static boolean secondLevelOfUpOrDown0(GraphicsContext gc) {
        if (level == 0) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        int i = 0;
        double[] final1 = new double[3];
        for (double x : MainMenu.getFirstXes()) {
            final1[i] = x - 8.7;
            i++;
        }
        MainMenu.setFirstXes(final1);
        setLevel(getLevel() - 1);
        return false;
    }

    public static boolean firstLevelOfUpOrDown0(GraphicsContext gc) {
        if (level == 20) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        int i = 0;
        double[] final1 = new double[3];
        for (double x : MainMenu.getFirstXes()) {
            final1[i] = x + 8.7;
            i++;
        }
        MainMenu.setFirstXes(final1);
        setLevel(getLevel() + 1);
        return false;
    }

    public static void finalProcesses1(GraphicsContext gc) {
        if (level < 10) {
            Main.getLabelForLevel().setText(String.format("%02d", level));
        } else {
            Main.getLabelForLevel().setText(String.valueOf(level));
        }
        gc.setFill(Color.rgb(255, 240, 34));
        gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
        gc.setFill(Color.rgb(255, 240, 34));
        gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
        gc.setStroke(Color.rgb(255, 34, 34));
        gc.strokeRect(xForLine, yForLine, width, height);
        gc.setLineWidth(8);
    }

    public static void drawPolygons(GraphicsContext gc, boolean changePosition, boolean right) {
        if (changePosition) {
            if (upOrDown == 0) {
                if (right) {
                    if (firstLevelOfUpOrDown0(gc)) {
                        return;
                    }
                }
                if (!right) {
                    if (secondLevelOfUpOrDown0(gc)) {
                        return;
                    }
                }
            } else if (upOrDown == -1) {
                if (right) {
                    if (firstLevelOfUpOrDownMinus1(gc)) {
                        return;
                    }

                }
                if (!right) {
                    if (secondLevelOfUpOrDownMinus1(gc)) {
                        return;
                    }
                }
            }
        }
        finalProcesses1(gc);
    }

    public static boolean secondLevelOfDrawLine(GraphicsContext gc) {
        if (upOrDown == -1) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        setWidth(105);
        setyForLine(246);
        upOrDown--;
        return false;
    }

    public static boolean firstLevelOfDrawLine(GraphicsContext gc) {
        if (upOrDown == 0) {
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setFill(Color.rgb(255, 240, 34));
            gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
            gc.setStroke(Color.rgb(255, 34, 34));
            gc.strokeRect(xForLine, yForLine, width, height);
            gc.setLineWidth(8);
            return true;
        }
        setWidth(215);
        setyForLine(125);
        upOrDown++;
        return false;
    }

    public static void finalProcesses2(GraphicsContext gc) {
        if (level < 10) {
            Main.getLabelForLevel().setText(String.format("%02d", level));
        } else {
            Main.getLabelForLevel().setText(String.valueOf(level));
        }
        gc.setFill(Color.rgb(255, 240, 34));
        gc.fillPolygon(secondXes, secondYes, Constants.CONSTANT_FOR_TRIANGLE);
        gc.setFill(Color.rgb(255, 240, 34));
        gc.fillPolygon(firstXes, firstYes, Constants.CONSTANT_FOR_TRIANGLE);
        gc.setStroke(Color.rgb(255, 34, 34));
        gc.strokeRect(xForLine, yForLine, width, height);
        gc.setLineWidth(8);
    }

    public static void drawLine(GraphicsContext gc, boolean changePosition, boolean up) {
        if (changePosition) {
            if (up) {
                if (firstLevelOfDrawLine(gc)) {
                    return;
                }
            }
            if (!up) {
                if (secondLevelOfDrawLine(gc)) {
                    return;
                }
            }
        }
        finalProcesses2(gc);
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        MainMenu.level = level;
    }

    public static Speed getSpeed() {
        return speed;
    }

    public static void setSpeed(Speed speed) {
        MainMenu.speed = speed;
    }

    public static double[] getFirstXes() {
        return firstXes;
    }

    public static void setFirstXes(double[] firstXes) {
        MainMenu.firstXes = firstXes;
    }

    public static double[] getFirstYes() {
        return firstYes;
    }

    public static void setFirstYes(double[] firstYes) {
        MainMenu.firstYes = firstYes;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        MainMenu.height = height;
    }

    public static double getWidth() {
        return width;
    }

    public static void setWidth(double width) {
        MainMenu.width = width;
    }

    public static int getUpOrDown() {
        return upOrDown;
    }

    public static void setUpOrDown(int upOrDown) {
        MainMenu.upOrDown = upOrDown;
    }

    public static double getxForLine() {
        return xForLine;
    }

    public static void setxForLine(double xForLine) {
        MainMenu.xForLine = xForLine;
    }

    public static double getyForLine() {
        return yForLine;
    }

    public static void setyForLine(double yForLine) {
        MainMenu.yForLine = yForLine;
    }

    public static int getNumberOfSpeed() {
        return numberOfSpeed;
    }

    public static void setNumberOfSpeed(int numberOfSpeed) {
        MainMenu.numberOfSpeed = numberOfSpeed;
    }

    public static double[] getSecondXes() {
        return secondXes;
    }

    public static void setSecondXes(double[] secondXes) {
        MainMenu.secondXes = secondXes;
    }

    public static double[] getSecondYes() {
        return secondYes;
    }

    public static void setSecondYes(double[] secondYes) {
        MainMenu.secondYes = secondYes;
    }

    public MainMenu(int level, Speed speed) {
        MainMenu.level = level;
        MainMenu.speed = speed;
    }

    public MainMenu() {
    }
}