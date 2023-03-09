package e1;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String log="";
    private final Map<String, Integer> prodMap = new HashMap<>();
    private final Map<String,Integer> cart = new HashMap<>();
    private final int ordNo;
    Order(int ordNo){
        this.ordNo = ordNo;
    }
    void setStock(String product, int quantity){
        prodMap.put(product, quantity);
    }
    Map<String, Integer> getStock(){
        return prodMap;
    }
    void modifyStock(String product, int quantity){
        prodMap.replace(product,prodMap.get(product)+quantity);
    }
    private OrderState state = new OrderedState(prodMap,cart);

    public Map<String, Integer> getProdMap() {
        return prodMap;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void shopping() {
        state.shopping(this);
    }

    public void checkout() {
        state.checkout(this);
    }
    public void payment() {
        state.payment(this);
    }
    public void cancel(String date){
        state.cancelledOrCompleted(this,date);
    }

    public void complete(String date){state.completed(this,date);}
    public void addProduct(String product, int quantity){
        state.addProduct(product,quantity,this);
    }
    public void removeProduct(String product){
        state.removeProduct(product,this);
    }
    public void manageProduct(String product, int quantity){state.manageProduct(product,quantity,this);}
    public void screenInfo(){state.screenInfo();}
    public void addLog(String newLog){log = log.concat(newLog);}
    public void showLog(){
        System.out.println(log);
    }
}

