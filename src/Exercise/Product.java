package Exercise;

import java.time.LocalDate;

public class Product {
    private final String productName;
    private final Integer amount;
    private final LocalDate date;

    public Product(String productName, Integer amount, LocalDate date) {
        this.productName = productName;
        this.amount = amount;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
