package coding.exercise.errorhandling;


public class BreedsIOException extends RuntimeException {
    public String message;
    public BreedsIOException(String message) {
        super(message);
        this.message = message;
    }
}
