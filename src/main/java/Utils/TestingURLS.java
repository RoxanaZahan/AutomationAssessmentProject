package Utils;

public enum TestingURLS {
    GROUPON_STAGING ("https://staging.groupon.com"),
    GROUPON_PROD ("groupon.com");

    private final String url;

    TestingURLS(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
