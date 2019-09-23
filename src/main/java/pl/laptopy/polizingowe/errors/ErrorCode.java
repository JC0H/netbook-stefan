package pl.laptopy.polizingowe.errors;

public enum ErrorCode {
    NO_BRAND_FOUND("Nie znaleziono danej marki laptopa");

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
