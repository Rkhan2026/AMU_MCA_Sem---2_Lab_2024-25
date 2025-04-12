package week_11;

// Custom unchecked exception for parsing-related errors
class DateParsingException extends RuntimeException {
    public DateParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}