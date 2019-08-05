package co.za.ned.customException;

public class NegativeCurrencyException extends RuntimeException {
    public NegativeCurrencyException(String s) {
        super(s + "  Source amount cannot be negative value or zero");
    }

    public NegativeCurrencyException() {
        super("  Source amount cannot be negative value or zero");
    }

    @Override
    public String getMessage() {
        return "Source amount cannot be negative value or zero";
    }
}
