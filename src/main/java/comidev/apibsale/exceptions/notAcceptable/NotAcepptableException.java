package comidev.apibsale.exceptions.notAcceptable;

public class NotAcepptableException extends RuntimeException {
    private static String DESCRIPTION = "Not Acceptable (406)";

    public NotAcepptableException(String message) {
        super(DESCRIPTION + " | " + message);
    }
}
