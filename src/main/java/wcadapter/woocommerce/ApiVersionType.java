package wcadapter.woocommerce;

/**
 * Enum that represents WooCommerce API versions
 */
public enum ApiVersionType {
    V1("v1"),
    V2("v2");

    private String value;

    ApiVersionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}