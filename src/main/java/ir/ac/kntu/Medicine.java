package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Medicine {

    private double x = Constants.X_MEDICINE;

    private double y = Constants.Y_MEDICINE;

    private double vX = 0.02;

    private double vY = 0.02;

    private static ArrayList<Pane> panes = new ArrayList<>();

    private static ArrayList<Integer> integersForCapsuleOrNot = new ArrayList<>();

    private static ArrayList<Integer> integersForImage = new ArrayList<>();

    private static ArrayList<ImageView> imageViews = new ArrayList<>();

    private static int numberOfFaster = 0;

    public static void faster() {
        MainGame.getMedicine().setvY(MainGame.getMedicine().getvY() + 0.02);
        numberOfFaster++;
    }

    public static void lower() {
        for (int i = 0; i < numberOfFaster; i++) {
            MainGame.getMedicine().setvY(MainGame.getMedicine().getvY() - 0.02);
        }
        numberOfFaster = 0;
    }

    public void throwing(Pane root, GraphicsContext gc, Scene scene) throws InterruptedException {
    }

    public void firstMove(Pane root, GraphicsContext gc, Pane pane) {
        setX(getX() - getvX());
        setY(getY() - getvY());
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    public void secondMove(Pane root, GraphicsContext gc, Pane pane) {
        setX(getX() - getvX());
        setY(getY() - getvY());
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    public void thirdMove(Pane root, GraphicsContext gc, Pane pane) {
        setX(getX() - getvX());
        setY(getY() - getvY());
        pane.setLayoutX(getX());
        pane.setLayoutY(getY());
    }

    public static ArrayList<ImageView> getImageViews() {
        return imageViews;
    }

    public static void setImageViews(ArrayList<ImageView> imageViews) {
        Medicine.imageViews = imageViews;
    }

    public static ArrayList<Pane> getPanes() {
        return panes;
    }

    public static void setPanes(ArrayList<Pane> panes) {
        Medicine.panes = panes;
    }

    public static ArrayList<Integer> getIntegersForCapsuleOrNot() {
        return integersForCapsuleOrNot;
    }

    public static void setIntegersForCapsuleOrNot(ArrayList<Integer> integersForCapsuleOrNot) {
        Medicine.integersForCapsuleOrNot = integersForCapsuleOrNot;
    }

    public static ArrayList<Integer> getIntegersForImage() {
        return integersForImage;
    }

    public static void setIntegersForImage(ArrayList<Integer> integersForImage) {
        Medicine.integersForImage = integersForImage;
    }

    public static int getNumberOfFaster() {
        return numberOfFaster;
    }

    public static void setNumberOfFaster(int numberOfFaster) {
        Medicine.numberOfFaster = numberOfFaster;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public Medicine(double x, double y, double vX, double vY) {
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
    }

    public Medicine() {
    }
}
