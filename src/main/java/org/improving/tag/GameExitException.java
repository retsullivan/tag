package org.improving.tag;

public class GameExitException extends RuntimeException {

    String message = "You have exited the game";
    public GameExitException(){};
    public GameExitException(String error) {
        error = message;
    }
    public String toString() {
        return (message);
    }
}