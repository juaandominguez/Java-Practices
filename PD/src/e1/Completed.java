package e1;

import java.util.Map;

public class Completed implements OrderState {
    private final Map<String, Integer> cart;
    private final int ordNo;

    Completed(int ordNo, Map<String, Integer> cart) {
        this.ordNo = ordNo;
        this.cart = cart;
    }

    @Override
    public void addProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot add products in completed phase");
    }

    @Override
    public void removeProduct(String product,Order ord) {
        throw new IllegalStateException("Cannot remove products in completed phase");
    }

    @Override
    public void manageProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot manage products in completed phase");
    }

    @Override
    public void shopping(Order ord) {
        throw new IllegalStateException("Cannot shopping in completed phase");
    }

    @Override
    public void checkout(Order ord) {
        throw new IllegalStateException("Cannot checkout in completed phase");
    }

    @Override
    public void payment(Order ord) {
        throw new IllegalStateException("Cannot pay for products in completed phase");
    }

    @Override
    public void cancelledOrCompleted(Order ord, String date) {
        throw new IllegalStateException("Cannot cancel products in completed phase");
    }

    @Override
    public void completed(Order ord, String date) {
        System.out.println("Already completed order");
    }

    @Override
    public void screenInfo() {
        int prodNo = 0;
        for (int f : cart.values()) {
            prodNo += f;
        }
        System.out.println("Order Number: " + ordNo);
        System.out.println("Phase: Completed order: " + prodNo + " products");
    }
}

