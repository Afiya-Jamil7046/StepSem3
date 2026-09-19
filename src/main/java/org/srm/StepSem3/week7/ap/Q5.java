class Cart {
    private final String cartId;
    private int[] prices;
    private int count = 0;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new int[maxItems];
    }

    void addItem(int price) {
        if (price <= 0) {
            System.out.println("Rejected: price must be positive");
            return;
        }
        if (count >= prices.length) {
            System.out.println("Cart is full");
            return;
        }
        prices[count] = price;
        count++;
    }

    int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return count;
    }

    String getCartId() {
        return cartId;
    }
}

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(cart.getTotal());     // 500
        System.out.println(cart.getItemCount()); // 3
    }
}