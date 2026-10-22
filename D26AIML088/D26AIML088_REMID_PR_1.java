// Problem 1: Stationery Shop Receipts (Units 1 & 2)
// The college stationery shop issues a receipt number to every valid purchase and keeps a running total of revenue. Write a program that reads purchases, prints a receipt line for each valid purchase and prints a summary at the end.

// Price List (fixed)
// Code	Item	Price (₹)
// N	Notebook	45
// P	Pen	10
// M	Marker	25
// F	File	30
// Task
// A class Product with private final fields name (String) and price (int), a constructor Product(String name, int price) that uses this, and getters getName() and getPrice().
// A method static Product findProduct(char code) that uses a switch expression (arrow form) to return the matching Product object, or null for any other code.
// A class Purchase with:
// private fields receiptNo (int), product (Product) and quantity (int);
// static variables nextReceipt (starting at 201), totalPurchases and totalRevenue;
// a constructor Purchase(Product product, int quantity) that uses this, assigns the next receipt number and updates both static totals;
// getAmount(), which returns price × quantity;
// static methods getTotalPurchases() and getTotalRevenue();
// an overridden toString() in the format shown in the Output Format.
// A purchase is invalid if the code is not on the price list or the quantity is ≤ 0. Do not create a Purchase object for an invalid purchase, and do not use up a receipt number for it.

class Product {
    private final String name;
    private final int price;
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    static Product findProduct(char code) {
        return switch (code) {
            case 'N' -> new Product("Notebook", 45);
            case 'P' -> new Product("Pen", 10);
            case 'M' -> new Product("Marker", 25);
            case 'F' -> new Product("File", 30);
            default -> null;
        };
    }
}

class Purchase {
    private final int receiptNo;
    private final Product product;
    private final int quantity;
    private static int nextReceipt = 201;
    private static int totalPurchases = 0;
    private static int totalRevenue = 0;

    Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.receiptNo = nextReceipt++;
        totalPurchases++;
        totalRevenue += getAmount();
    }

    public int getAmount() {
        return product.getPrice() * quantity;
    }

    public static int getTotalPurchases() {
        return totalPurchases;
    }

    public static int getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "Receipt " + receiptNo + ": " + product.getName() + " x " + quantity + " = " + getAmount();
    }
}


public class INTERNAL_REMEDIAL_pr_1 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            char code = parts[0].charAt(0);
            int quantity = Integer.parseInt(parts[1]);

            Product product = Product.findProduct(code);
            if (product != null && quantity > 0) {
                Purchase purchase = new Purchase(product, quantity);
                System.out.println(purchase);
            } else {
                System.out.println("Invalid item: " + code + " " + quantity);
            }
        }

        System.out.println("Total receipts: " + Purchase.getTotalPurchases() + ", Total revenue: " + Purchase.getTotalRevenue());
    }
}

