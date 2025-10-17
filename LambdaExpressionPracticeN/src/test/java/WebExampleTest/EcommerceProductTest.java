package WebExampleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import org.saif.experiment.sandfall.Product;

/**
 * E-commerce Product Testing with Streams and Lambdas
 * Demonstrates practical use of functional programming in Selenium automation
 */
public class EcommerceProductTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        // Setup ChromeDriver using WebDriverManager (automatic driver management)
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options for better stability
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Filter and Purchase Products Using Streams")
    void testProductFilteringWithStreams() {
        // Login
        login("standard_user", "secret_sauce");

        // Get all product elements
        List<WebElement> productElements = driver.findElements(
                By.className("inventory_item")
        );

        // Convert WebElements to Product objects using streams
        List<Product> products = productElements.stream()
                .map(this::extractProductDetails)
                .collect(Collectors.toList());

        System.out.println("Total Products Found: " + products.size());

        // Example 1: Filter products under $20 using lambda
        List<Product> affordableProducts = products.stream()
                .filter(p -> p.getPrice() < 20.0)
                .collect(Collectors.toList());

        System.out.println("\n--- Products Under $20 ---");
        affordableProducts.forEach(p ->
                System.out.println(p.getName() + " - $" + p.getPrice())
        );

        // Example 2: Get the most expensive product
        Optional<Product> mostExpensive = products.stream()
                .max(Comparator.comparing(Product::getPrice));

        mostExpensive.ifPresent(p ->
                System.out.println("\nMost Expensive: " + p.getName() + " - $" + p.getPrice())
        );

        // Example 3: Find products with specific keyword
        String keyword = "Backpack";
        List<Product> matchingProducts = products.stream()
                .filter(p -> p.getName().contains(keyword))
                .collect(Collectors.toList());

        System.out.println("\n--- Products containing '" + keyword + "' ---");
        matchingProducts.forEach(p -> System.out.println(p.getName()));

        // Example 4: Add cheapest 3 products to cart using streams
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .forEach(product -> {
                    System.out.println("Adding to cart: " + product.getName());
                    addToCart(product);
                });

        // Verify cart badge count
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int cartCount = Integer.parseInt(cartBadge.getText());
        Assertions.assertEquals(3, cartCount, "Cart should contain 3 items");

        // Example 5: Calculate total price using reduce of the 3 cheapest products
        double totalPrice = products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .mapToDouble(Product::getPrice)
                .reduce(0, Double::sum);

        System.out.println("\nTotal Price of 3 cheapest items: $" +
                String.format("%.2f", totalPrice));
    }

    @Test
    @DisplayName("Validate Product Sorting with Streams")
    void testProductSorting() {
        login("standard_user", "secret_sauce");

        // Select sort option (Price: Low to High)
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        sortDropdown.click();
        sortDropdown.findElement(By.xpath("//option[@value='lohi']")).click();

        // Wait for sorting to complete
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("inventory_item")
        ));

        // Get products after sorting
        List<Product> sortedProducts = driver.findElements(By.className("inventory_item"))
                .stream()
                .map(this::extractProductDetails)
                .collect(Collectors.toList());

        // Verify sorting using streams
        boolean isSortedCorrectly = sortedProducts.stream()
                .reduce(true,
                        (acc, product) -> {
                            if (!acc) return false;
                            int currentIndex = sortedProducts.indexOf(product);
                            if (currentIndex == 0) return true;
                            return product.getPrice() >= sortedProducts.get(currentIndex - 1).getPrice();
                        },
                        Boolean::logicalAnd
                );

        Assertions.assertTrue(isSortedCorrectly, "Products should be sorted by price ascending");

        // Display sorted products
        System.out.println("\n--- Products Sorted by Price (Low to High) ---");
        sortedProducts.forEach(p ->
                System.out.println(p.getName() + " - $" + p.getPrice())
        );
    }

    @Test
    @DisplayName("Group Products by Price Range")
    void testProductGrouping() {
        login("standard_user", "secret_sauce");

        List<Product> products = driver.findElements(By.className("inventory_item"))
                .stream()
                .map(this::extractProductDetails)
                .collect(Collectors.toList());

        // Group products by price range using streams
        Map<String, List<Product>> productsByPriceRange = products.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getPrice() < 15) return "Budget ($0-$15)";
                    else if (p.getPrice() < 30) return "Mid-Range ($15-$30)";
                    else return "Premium ($30+)";
                }));

        // Display grouped products
        System.out.println("\n--- Products Grouped by Price Range ---");
        productsByPriceRange.forEach((range, productList) -> {
            System.out.println("\n" + range + ":");
            productList.forEach(p ->
                    System.out.println("  - " + p.getName() + " ($" + p.getPrice() + ")")
            );
        });

        // Calculate average price per group
        System.out.println("\n--- Average Price per Range ---");
        productsByPriceRange.forEach((range, productList) -> {
            double avgPrice = productList.stream()
                    .mapToDouble(Product::getPrice)
                    .average()
                    .orElse(0.0);
            System.out.println(range + ": $" + String.format("%.2f", avgPrice));
        });
    }

    // Helper method: Login
    private void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.className("inventory_list")
        ));
    }

    // Helper method: Extract product details (demonstrates lambda usage)
    public Product extractProductDetails(WebElement element) {
        String name = element.findElement(By.className("inventory_item_name")).getText();
        String priceText = element.findElement(By.className("inventory_item_price"))
                .getText()
                .replace("$", "");
        double price = Double.parseDouble(priceText);
        String description = element.findElement(By.className("inventory_item_desc")).getText();

        return new Product(name, price, description, element);
    }

    // Helper method: Add product to cart
    private void addToCart(Product product) {
        product.getElement()
                .findElement(By.xpath(".//button[contains(@id, 'add-to-cart')]"))
                .click();
    }

}
