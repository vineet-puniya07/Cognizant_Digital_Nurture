package InventoryManagementSystem;

import java.util.HashMap;

public class InventoryManagement {

    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {

        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully.");
    }

    public void updateProduct(int id, String name, int quantity, double price) {

        Product p = inventory.get(id);

        if (p != null) {
            p.setProductName(name);
            p.setQuantity(quantity);
            p.setPrice(price);

            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public void deleteProduct(int id) {

        if (inventory.remove(id) != null)
            System.out.println("Product Deleted Successfully.");
        else
            System.out.println("Product Not Found.");
    }

    public void searchProduct(int id) {

        Product p = inventory.get(id);

        if (p != null)
            System.out.println(p);
        else
            System.out.println("Product Not Found.");
    }

    public void displayInventory() {

        for (Product p : inventory.values()) {
            System.out.println("-----------------------");
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        InventoryManagement obj = new InventoryManagement();

        obj.addProduct(new Product(101, "Laptop", 15, 65000));
        obj.addProduct(new Product(102, "Mouse", 50, 700));
        obj.addProduct(new Product(103, "Keyboard", 30, 1200));

        System.out.println("\nInventory:");

        obj.displayInventory();

        System.out.println("\nUpdating Product...");

        obj.updateProduct(102, "Wireless Mouse", 60, 900);

        System.out.println("\nSearching Product:");

        obj.searchProduct(102);

        System.out.println("\nDeleting Product...");

        obj.deleteProduct(103);

        System.out.println("\nFinal Inventory:");

        obj.displayInventory();
    }
}