package hust.soict.ite6.aims.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "PlayerException: " + getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
