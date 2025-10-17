package org.saif.experiment.sandfall;

import org.openqa.selenium.WebElement;

public class Product {
    private final String name;
    private final double price;
    private final String description;
    private final WebElement element;

    public Product(String name, double price, String description, WebElement element) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.element = element;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public WebElement getElement() { return element; }
}
