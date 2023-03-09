package e1;

public interface OrderState {

    void addProduct(String product, int quantity,Order ord);
    void removeProduct(String product,Order ord);
    void manageProduct(String product, int quantity,Order ord);
    void shopping(Order ord);
    void checkout(Order ord);
    void payment(Order ord);
    void cancelledOrCompleted(Order ord, String date);
    void completed(Order ord, String date);
    void screenInfo();

}

