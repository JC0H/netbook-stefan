package pl.laptopy.polizingowe.errors;

public enum ErrorCode {
    NO_BRAND_FOUND("Nie znaleziono danej marki laptopa"),
    MESSAGE_WITH_ATTACHMENTS_EXCEPTION("Message with attachments wasn't sent properly."),
    NO_PRODUCT_WITH_GIVEN_ID("No Product with given ID.");

    private final String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
