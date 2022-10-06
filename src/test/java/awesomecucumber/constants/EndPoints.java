package awesomecucumber.constants;

public enum EndPoints {
    STORE("/store"),
    ACCOUNT("/account");

    private String url;

    EndPoints(String url) {
        this.url = url;
    }
}
