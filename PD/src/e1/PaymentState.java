package e1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class PaymentState implements OrderState{
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final LocalDateTime date = LocalDateTime.now();
    private final String strDate = date.format(DATE_TIME_FORMATTER);
    private final int ordNo;
    private final Map<String, Integer> cart;
    PaymentState(int ordNo,Map<String, Integer> cart){
        this.ordNo = ordNo;
        this.cart = cart;
    }
    public static boolean notValidDate(String strDate)
    {
        if (!strDate.trim().equals("")) {
            try {
                LocalDateTime.parse(strDate,DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                return true;
            }
        }
        return false;
    }
    boolean isCompleted(String finalDate){
        if(notValidDate(finalDate)) throw new IllegalArgumentException("Invalid Date");
        LocalDateTime d1 = LocalDateTime.parse(strDate,DATE_TIME_FORMATTER);
        LocalDateTime d2 = LocalDateTime.parse(finalDate,DATE_TIME_FORMATTER);
        int minutes = (int) ChronoUnit.MINUTES.between(d1,d2);
        return (minutes > (24*60));
    }

    @Override
    public void addProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot add products in payment phase");
    }

    @Override
    public void removeProduct(String product,Order ord) {
        throw new IllegalStateException("Cannot remove products in payment phase");
    }

    @Override
    public void manageProduct(String product, int quantity,Order ord) {
        throw new IllegalStateException("Cannot manage products in payment phase");
    }

    @Override
    public void shopping(Order ord) {
        throw new IllegalStateException("Cannot shopping in payment phase");
    }

    @Override
    public void checkout(Order ord) {
        throw new IllegalStateException("Cannot checkout order in payment phase");
    }

    @Override
    public void payment(Order ord) {
        System.out.println("Already in payment");
    }

    @Override
    public void cancelledOrCompleted(Order ord,String date) {
        if(notValidDate(date)) throw new IllegalArgumentException("Invalid Date");
        if(isCompleted(date)) {ord.setState(new Completed(ordNo,cart)); ord.addLog("Order "+ordNo+": Completed order"+"\n");}
        else {ord.setState(new Cancel(ordNo)); ord.addLog("Order "+ordNo+": Completed order"+"\n"); }
    }

    @Override
    public void completed(Order ord, String date) {
        if(notValidDate(date)) throw new IllegalArgumentException("Invalid Date");
        if(isCompleted(date)) ord.setState(new Completed(ordNo,cart));
        else System.out.println("Not completed, you can still cancel your order");
    }

    @Override
    public void screenInfo() {
        int prodNo = 0;
        for (int f : cart.values()) {
            prodNo += f;
        }
        System.out.println("Order Number: " + ordNo);
        System.out.println("Phase: Paid order: " + prodNo + " products -- date " +strDate);
    }

}

