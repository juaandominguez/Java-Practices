package e1;

public class Cancel implements OrderState{
    private final int ordNo;
    Cancel(int ordNo){
        this.ordNo = ordNo;
    }
    @Override
    public void addProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot add products in cancel phase");
    }

    @Override
    public void removeProduct(String product,Order ord) {
        throw new IllegalStateException("Cannot remove products in cancel phase");
    }

    @Override
    public void manageProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot manage products in cancel phase");
    }

    @Override
    public void shopping(Order ord) {
        throw new IllegalStateException("Cannot access shopping cart in cancel phase");

    }

    @Override
    public void checkout(Order ord) {
        throw new IllegalStateException("Cannot access checkout in cancel stage");

    }

    @Override
    public void payment(Order ord) {
        throw new IllegalStateException("Cannot pay for order in cancel phase");
    }

    @Override
    public void cancelledOrCompleted(Order ord,String date) {
        throw new IllegalStateException();
    }

    @Override
    public void screenInfo() {
        System.out.println("Order Number: " + ordNo);
        System.out.println("Phase: Cancelled order");
    }
    @Override
    public void completed(Order ord, String date){
        throw new IllegalStateException("Cannot complete order in cancel phase");
    }
}

