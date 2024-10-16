package exceptions;

public class InvalidFileFormat extends Exception {
    public InvalidFileFormat() {
        super();
    }

    public InvalidFileFormat(String message) {
        super(message);
    }
}
