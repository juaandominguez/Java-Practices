package e1;

import java.util.Map;

public class CheckoutState implements OrderState{
    private final Map<String, Integer> cart;
    private final int ordNo;
    CheckoutState(int ordNo,Map<String, Integer> cart){
        this.ordNo = ordNo;
        this.cart =cart;
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
        if(!cart.containsKey(product)) throw new IllegalArgumentException();
        if((quantity > 0 && quantity <= ord.getProdMap().get(product))||(quantity < 0 && (-quantity)<=cart.get(product))){
            cart.replace(product,cart.get(product)+quantity); ord.modifyStock(product,-quantity);
            ord.addLog("- Modify: Item: "+product+" - Quantity: "+quantity+ " -> Checkout Order -- Products : "+cart.size()+"\n");

        }

    }

    @Override
    public void shopping(Order ord) {
        ord.setState(new ShoppingState(ordNo,cart));
    }

    @Override
    public void checkout(Order ord) {
        System.out.println("Already in checkout");
    }

    @Override
    public void payment(Order ord) {
        ord.setState(new PaymentState(ordNo,cart));
        ord.addLog("Order "+ordNo+": Payment Phase\n");
    }

    @Override
    public void cancelledOrCompleted(Order ord, String date) {
        throw new IllegalStateException("Cannot cancel/complete the order in checkout phase");
    }

    @Override
    public void screenInfo() {
        System.out.println("Order Number: " + ordNo);
        System.out.println("Phase: Check Out -- "+ cart.size() + " products");
    }
    @Override
    public void completed(Order ord, String date){
        throw new IllegalStateException("Cannot complete order in checkout phase");
    }
}

