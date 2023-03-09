package e1;

import java.util.Map;

public class ShoppingState implements OrderState {
    private Map<String, Integer> cart;
    private final int ordNo;
    ShoppingState(int ordNo,Map<String, Integer> cart){
        this.ordNo = ordNo;
        this.cart = cart;
    }

    @Override
    public void addProduct(String product, int quantity,Order ord) {
        if(!ord.getProdMap().containsKey(product)) return;
        if(quantity>0 && quantity <= ord.getProdMap().get(product)) {
            if(!cart.containsKey(product)) cart.put(product,quantity);
            else cart.replace(product,cart.get(product)+quantity);
            ord.modifyStock(product,-quantity);
            ord.addLog("- Add: Item: "+product+" - Quantity: "+quantity+ " -> Shopping Cart -- Products : "+cart.size()+"\n");
        }
    }

    @Override
    public void removeProduct(String product,Order ord) {
        if (!cart.containsKey(product)) return;
        int quantity = cart.get(product);
        cart.remove(product);
        ord.modifyStock(product,+quantity);
        ord.addLog("- Remove: Item: "+product+" -> Shopping Cart -- Products : "+cart.size()+"\n");

    }

    @Override
    public void manageProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException();
    }

    @Override
    public void shopping(Order ord) {
        System.out.println("Already in the shopping state");
    }

    @Override
    public void checkout(Order ord) {
        if(cart.size()==0) {
            System.out.println("Need items to checkout");
            return;}
        ord.setState(new CheckoutState(ordNo,cart));
        ord.addLog("Order "+ordNo+": Check Out Phase\n");
    }

    @Override
    public void payment(Order ord) {
        throw new IllegalStateException("Cannot pay for order in shopping phase");
    }

    @Override
    public void cancelledOrCompleted(Order ord, String date) {
        throw new IllegalStateException("Cannot cancel the order in shopping phase");
    }

    @Override
    public void completed(Order ord, String date) {
        throw new IllegalStateException("Cannot complete the order in shopping phase");
    }

    @Override
    public void screenInfo() {
        System.out.println("Order Number: " + ordNo);
        System.out.println("Phase: Shopping -- "+ cart.size() + " products");
    }
}

