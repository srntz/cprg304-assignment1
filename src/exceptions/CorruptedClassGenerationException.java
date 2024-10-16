package exceptions;

public class CorruptedClassGenerationException extends Exception {
    public CorruptedClassGenerationException() {
        super();
    }

    public CorruptedClassGenerationException(String message) {
        super(message);
    }
}
