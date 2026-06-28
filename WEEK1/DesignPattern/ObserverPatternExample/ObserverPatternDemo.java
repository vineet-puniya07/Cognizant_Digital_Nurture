package ObserverPatternExample;

public class ObserverPatternDemo {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Vinit");
        Observer webUser = new WebApp("Vinni");

        // Register observers
        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        // Update stock price
        stockMarket.setStockPrice("Cognizant", 3850.50);

        // Remove one observer
        stockMarket.removeObserver(webUser);

        // Update stock price again
        stockMarket.setStockPrice("Infosys", 1625.75);
    }
}