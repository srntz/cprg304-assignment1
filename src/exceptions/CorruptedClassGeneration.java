package exceptions;

public class CorruptedClassGeneration extends Exception {
    public CorruptedClassGeneration() {
        super();
    }

    public CorruptedClassGeneration(String message) {
        super(message);
    }
}
