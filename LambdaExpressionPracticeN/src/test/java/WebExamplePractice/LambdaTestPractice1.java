package WebExamplePractice;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * STUDENT EXERCISE: E-commerce Automation Testing
 * Complete the test methods using Streams and Lambda expressions
 * <p>
 * Website: https://www.saucedemo.com
 * Username: standard_user
 * Password: secret_sauce
 * <p>
 * Learning Objectives:
 * - Use stream operations (filter, map, sorted, limit, collect)
 * - Apply lambda expressions for predicates and consumers
 * - Work with Optional and method references
 * - Perform aggregations (count, sum, average, max, min)
 */
public class LambdaTestPractice1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        login("standard_user", "secret_sauce");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * EXERCISE 1: Find and Count Expensive Products
     * <p>
     * Expected Result:
     * - Find all products with price > $25
     * - Print each product name and price
     * - Assert that there are exactly 2 expensive products
     * <p>
     * Hint: Use filter(), forEach(), and count()
     */
    @Test
    @DisplayName("Exercise 1: Filter Expensive Products")
    void testFindExpensiveProducts() {
        List<Product> products = getAllProducts();

        // TODO: Filter products with price > 25
        // TODO: Store the filtered products in a List

        // TODO: Print each expensive product (name and price)

        // TODO: Count expensive products and assert equals 2

        // Your code here

    }

    /**
     * EXERCISE 2: Find the Cheapest Product
     * <p>
     * Expected Result:
     * - Find the product with the lowest price
     * - Print the name and price of the cheapest product
     * - Assert that the price is $7.99
     * <p>
     * Hint: Use min() with Comparator.comparing() and Optional
     */
    @Test
    @DisplayName("Exercise 2: Find Cheapest Product")
    void testFindCheapestProduct() {
        List<Product> products = getAllProducts();

        // TODO: Find the product with minimum price using streams
        // TODO: Use Optional to handle the result

        // TODO: Print the cheapest product details

        // TODO: Assert that the cheapest product price is 7.99

        // Your code here

    }

    /**
     * EXERCISE 3: Sort and Add Top 4 Expensive Products to Cart
     * <p>
     * Expected Result:
     * - Sort products by price in descending order
     * - Take the top 4 most expensive products
     * - Add them to the shopping cart
     * - Print each product name as it's added
     * - Assert cart badge shows "4"
     * <p>
     * Hint: Use sorted() with reversed comparator, limit(), forEach()
     */
    @Test
    @DisplayName("Exercise 3: Add Top 4 Expensive Products to Cart")
    void testAddTopExpensiveProductsToCart() {
        List<Product> products = getAllProducts();

        // TODO: Sort products by price (highest first)
        // TODO: Limit to top 4
        // TODO: Add each to cart and print the name

        // Your code here

        // TODO: Verify cart badge shows 4 items

    }

    /**
     * EXERCISE 4: Calculate Average Price of Products
     * <p>
     * Expected Result:
     * - Calculate the average price of all products
     * - Print the average price formatted to 2 decimal places
     * - Assert that average is between $20 and $25
     * <p>
     * Hint: Use mapToDouble() and average()
     */
    @Test
    @DisplayName("Exercise 4: Calculate Average Product Price")
    void testCalculateAveragePrice() {
        List<Product> products = getAllProducts();

        // TODO: Calculate average price using streams
        // TODO: Store in a variable (handle Optional)

        // TODO: Print the average price

        // TODO: Assert average is between 20.0 and 25.0

        // Your code here

    }

    /**
     * EXERCISE 5: Find Products by Keyword
     * <p>
     * Expected Result:
     * - Find all products whose name contains "Sauce" (case-insensitive)
     * - Collect product names in a List<String>
     * - Print all matching product names
     * - Assert that exactly 2 products are found
     * <p>
     * Hint: Use filter() with String.toLowerCase() and contains()
     */
    @Test
    @DisplayName("Exercise 5: Search Products by Keyword")
    void testSearchProductsByKeyword() {
        List<Product> products = getAllProducts();
        String keyword = "Sauce";

        // TODO: Filter products containing keyword (case-insensitive)
        // TODO: Extract only the names into List<String>

        // TODO: Print all matching product names

        // TODO: Assert that 2 products match

        // Your code here

    }

    /**
     * EXERCISE 6: Group Products by Price Category
     * <p>
     * Expected Result:
     * - Group products into 3 categories:
     * * "Low" (price < $15)
     * * "Medium" ($15 <= price < $30)
     * * "High" (price >= $30)
     * - Print each category with product names
     * - Assert that "Low" category has 2 products
     * <p>
     * Hint: Use Collectors.groupingBy() with lambda for categorization
     */
    @Test
    @DisplayName("Exercise 6: Group Products by Price Category")
    void testGroupProductsByPriceCategory() {
        List<Product> products = getAllProducts();

        // TODO: Group products by price category
        // TODO: Create a Map<String, List<Product>>

        // TODO: Print each category and its products

        // TODO: Assert "Low" category has 2 products

        // Your code here

    }

    /**
     * EXERCISE 7: Check if All Products Have Descriptions
     * <p>
     * Expected Result:
     * - Verify that every product has a non-empty description
     * - Print "All products have descriptions" or "Some products missing descriptions"
     * - Assert that all products have descriptions
     * <p>
     * Hint: Use allMatch() with lambda predicate
     */
    @Test
    @DisplayName("Exercise 7: Validate All Products Have Descriptions")
    void testAllProductsHaveDescriptions() {
        List<Product> products = getAllProducts();

        // TODO: Check if all products have non-empty descriptions
        // TODO: Use allMatch() with appropriate predicate

        // TODO: Print appropriate message

        // TODO: Assert that all products have descriptions

        // Your code here

    }

    /**
     * EXERCISE 8: Find Products and Calculate Total Price
     * <p>
     * Expected Result:
     * - Find all products with price between $10 and $20 (inclusive)
     * - Calculate the total price of these products
     * - Print each product and the final total
     * - Assert total is greater than $25
     * <p>
     * Hint: Use filter(), mapToDouble(), and sum()
     */
    @Test
    @DisplayName("Exercise 8: Calculate Total Price of Mid-Range Products")
    void testCalculateTotalPriceOfMidRangeProducts() {
        List<Product> products = getAllProducts();

        // TODO: Filter products with price between 10 and 20 (inclusive)

        // TODO: Print each filtered product

        // TODO: Calculate total price using sum()

        // TODO: Print total price

        // TODO: Assert total > 25.0

        // Your code here

    }

    /**
     * EXERCISE 9: Sort Products Alphabetically and Get First 3
     * <p>
     * Expected Result:
     * - Sort all products by name alphabetically (A-Z)
     * - Get the first 3 products
     * - Print their names
     * - Assert the first product name starts with "Sauce"
     * <p>
     * Hint: Use sorted() with Comparator.comparing(), limit()
     */
    @Test
    @DisplayName("Exercise 9: Get First 3 Products Alphabetically")
    void testGetFirstThreeProductsAlphabetically() {
        List<Product> products = getAllProducts();

        // TODO: Sort products by name alphabetically
        // TODO: Limit to first 3
        // TODO: Collect into a list

        // TODO: Print the names of these 3 products

        // TODO: Assert first product name starts with "Sauce"

        // Your code here

    }

    /**
     * EXERCISE 10: Advanced - Custom Product Statistics
     * <p>
     * Expected Result:
     * - Calculate: total products, total price, average price,
     * cheapest price, most expensive price
     * - Print all statistics in a formatted way
     * - Assert total products equals 6
     * <p>
     * Hint: Use multiple stream operations or collect with Collectors.summarizingDouble()
     */
    @Test
    @DisplayName("Exercise 10: Generate Product Statistics")
    void testGenerateProductStatistics() {
        List<Product> products = getAllProducts();

        // TODO: Calculate statistics using streams
        // TODO: You can use multiple stream operations or DoubleSummaryStatistics

        // TODO: Print formatted statistics

        // TODO: Assert total products is 6

        // Your code here

    }

    // ========== HELPER METHODS (DO NOT MODIFY) ==========

    private void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("inventory_list")
        ));
    }

    private List<Product> getAllProducts() {
        List<WebElement> productElements = driver.findElements(
                By.className("inventory_item")
        );

        return productElements.stream()
                .map(this::extractProductDetails)
                .collect(Collectors.toList());
    }

    private Product extractProductDetails(WebElement element) {
        String name = element.findElement(By.className("inventory_item_name")).getText();
        String priceText = element.findElement(By.className("inventory_item_price"))
                .getText().replace("$", "");
        double price = Double.parseDouble(priceText);
        String description = element.findElement(By.className("inventory_item_desc")).getText();

        return new Product(name, price, description, element);
    }

    private void addToCart(Product product) {
        product.getElement()
                .findElement(By.xpath(".//button[contains(@id, 'add-to-cart')]"))
                .click();
    }

    // ========== PRODUCT MODEL CLASS ==========

    static class Product {
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

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }

        public WebElement getElement() {
            return element;
        }

        @Override
        public String toString() {
            return name + " - $" + price;
        }
    }
}

/**
 * SETUP INSTRUCTIONS:
 * <p>
 * 1. Add Maven Dependencies (pom.xml):
 *
 * <dependencies>
 * <dependency>
 * <groupId>org.seleniumhq.selenium</groupId>
 * <artifactId>selenium-java</artifactId>
 * <version>4.15.0</version>
 * </dependency>
 *
 * <dependency>
 * <groupId>org.junit.jupiter</groupId>
 * <artifactId>junit-jupiter</artifactId>
 * <version>5.10.1</version>
 * <scope>test</scope>
 * </dependency>
 * </dependencies>
 * <p>
 * 2. Download ChromeDriver: https://chromedriver.chromium.org/
 * 3. Add ChromeDriver to your system PATH
 * 4. Run tests individually or all together
 * <p>
 * GRADING RUBRIC:
 * - Each exercise is worth 10 points
 * - Correct stream operations: 5 points
 * - Proper lambda usage: 3 points
 * - Correct assertions: 2 points
 * Total: 100 points
 */
