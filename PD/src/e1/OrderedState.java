package e1;

import java.util.Map;

public class OrderedState implements OrderState {
    private Map<String, Integer> prodMap;
    private final Map<String, Integer> cart;
    OrderedState(Map<String, Integer> prodMap,Map<String, Integer> cart){
        this.prodMap = prodMap;
        this.cart = cart;
    }

    @Override
    public void addProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void removeProduct(String product,Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void manageProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void shopping(Order ord) {
        ord.setState(new ShoppingState(ord.getOrdNo(),cart)); ord.addLog("Order "+ord.getOrdNo()+ ": Shopping Phase\n");
    }

    @Override
    public void checkout(Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void payment(Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void cancelledOrCompleted(Order ord, String date) {
        throw new IllegalStateException();
    }

    @Override
    public void completed(Order ord, String date) {
        throw new IllegalStateException();
    }

    @Override
    public void screenInfo() {
        System.out.println("Welcome to the shop!");
    }
}

