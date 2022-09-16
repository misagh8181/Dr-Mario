package ir.ac.kntu;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;

    private String userName;

    private double highScore;

    private int numberOfGames;

    private transient double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getHighScore() {
        return highScore;
    }

    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public User(User user) {
        this.name = user.name;
        this.userName = user.userName;
    }

    public User(String name, String userName, int highScore, int score) {
        this.name = name;
        this.userName = userName;
        this.highScore = highScore;
        this.score = score;
    }

    public User(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", highScore=" + highScore +
                ", score=" + score +
                '}';
    }
}
