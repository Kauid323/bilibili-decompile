package j$.util;

public class ConversionRuntimeException extends RuntimeException {
    public ConversionRuntimeException(String message) {
        super(message);
    }

    public static RuntimeException exception(String type, Object suffix) {
        throw new ConversionRuntimeException("Unsupported " + type + " :" + suffix);
    }
}