package cart;

public class Product {
    private String code;
    private String description;
    private double price;

    // constructor, getter, setter
    public Product() {}

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getPriceCurrencyFormat() {
        return String.format("$%.2f", price);
    }
}