package ir.ac.kntu;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class UsersMenu {
    private static User currentUser;

    private static ArrayList<User> users = new ArrayList<>();

    static FileOutputStream fileOutputStream;

    static {
        try {
            fileOutputStream = new FileOutputStream("users.txt", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ObjectOutput objectOutput;

    static {
        try {
            objectOutput = new ObjectOutput(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream("users.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ObjectInputStream objectInputStream;

    static {
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int numberOfObjects = 0;

    @NotNull
    private static TextField getTextField1(Pane pane) {
        TextField textField1 = new TextField("Enter user name");
        textField1.setPrefSize(200, 30);
        textField1.setLayoutY(120);
        textField1.setLayoutX(50);
        textField1.setStyle("-fx-font-size: 20");
        textField1.setAlignment(Pos.BASELINE_LEFT);
        pane.getChildren().add(textField1);
        return textField1;
    }

    @NotNull
    private static TextField getTextField(Pane pane) {
        TextField textField = new TextField("Enter name");
        textField.setPrefSize(200, 30);
        textField.setLayoutY(40);
        textField.setLayoutX(50);
        textField.setStyle("-fx-font-size: 20");
        textField.setAlignment(Pos.BASELINE_LEFT);
        pane.getChildren().add(textField);
        return textField;
    }

    public static void addButton(VBox content, User user) {
        Button button = new Button("* Name:" + user.getName() + "|User Name : " + user.getUserName() + "|Record : " + user.getHighScore() + "|TimesOfPlaying : " + user.getNumberOfGames() + " *");
        button.setMinSize(441, 20);
        button.setOnAction(e -> {
            currentUser = user;
            Main.setLevelOfImprovement(Main.getLevelOfImprovement() + 1);
        });
        content.getChildren().add(button);
    }

    public static void secondCheck(VBox content, boolean a, Formatter formatter) {
        if (a) {// a -> for check we have a new user, or we have previous users
            numberOfObjects++;
            formatter.format("%d\n", numberOfObjects);
            formatter.close();
            try {
                users.add((User) objectInputStream.readObject());
//                System.out.println(users.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (!a) {
            ifNotA();
            for (User user : users) {
                addButton(content, user);
            }
        }
    }

    private static void ifNotA() {
        for (int i = 0; i < numberOfObjects; i++) {
            try {
                users.add((User) objectInputStream.readObject());
//                System.out.println(users.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getName().equals(users.get(j).getName()) && users.get(i).getUserName().equals(users.get(j).getUserName())) {
                    users.remove(users.get(i));
                    i--;
                    break;
                }
            }
        }
    }

    public static void firstCheckUp(VBox content, boolean a) throws IOException, ClassNotFoundException {
        FileWriter f = new FileWriter("number of objects.txt", true);
        Formatter formatter = new Formatter(f);
        try (BufferedReader br = new BufferedReader(new FileReader("number of objects.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                numberOfObjects = Integer.parseInt(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        secondCheck(content, a, formatter);
    }

    public static void usersMainMenu(Pane root, ScrollPane scrollpane, VBox content) throws IOException, ClassNotFoundException {
        firstCheckUp(content, true);
        Button button = new Button("* Name : " + users.get(users.size() - 1).getName() + "|User Name : " + users.get(users.size() - 1).getUserName() + "|Record : " + users.get(users.size() - 1).getHighScore() + "|TimesOfPlaying : " + users.get(users.size() - 1).getNumberOfGames() + " *");
        button.setMinSize(441, 20);
        button.setOnAction(e -> {
            currentUser = users.get(users.size() - 1);
            Main.setLevelOfImprovement(Main.getLevelOfImprovement() + 1);
        });
        content.getChildren().add(button);
    }

    public static void event(Pane root, ScrollPane scrollPane, VBox content, User user) {
        try {
            objectOutput.writeObject(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            usersMainMenu(root, scrollPane, content);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void registerUser(Pane root, ScrollPane scrollPane, VBox content) throws IOException {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Image backGround = new Image("images/extra.jpg", 300, 300, false, true);
        ImageView back = new ImageView(backGround);
        pane.getChildren().add(back);
        TextField textField = getTextField(pane);
        TextField textField1 = getTextField1(pane);
        Button button = new Button("Sign up");
        button.setFont(Font.font(15));
        button.setLayoutX(115);
        button.setLayoutY(190);
        button.setOnAction(e -> {
            User user = new User(textField.getText(), textField1.getText());
            event(root, scrollPane, content, user);
            stage.close();
        });
        pane.getChildren().add(button);
        Scene scene = new Scene(pane, 300, 300);
        stage.setTitle("Register For User");
        stage.setScene(scene);
        stage.show();
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public static void setNumberOfObjects(int numberOfObjects) {
        UsersMenu.numberOfObjects = numberOfObjects;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UsersMenu.currentUser = currentUser;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UsersMenu.users = users;
    }

    public UsersMenu() throws IOException {
    }
}