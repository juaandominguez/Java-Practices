package e2;

import java.util.*;

public class Sensor extends Subject{
    private final String name;
    private final String parameter;
    private float value;
    private final float defaultValue;
    private List<Alert> alerts;
    private final PriorityQueue<String> queue=new PriorityQueue<>(new CustomComparator());
    Sensor(float value,String name,String parameter){
        this.value=value;
        this.defaultValue = value;
        this.name=name;
        this.parameter=parameter;
    }

    public void setValue(float value) {
        this.value = value;
        notifyObservers();
    }
    public String getParameter(){
        return parameter;

    }

    public float getDefaultValue(){
        return defaultValue;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }
    Comparator<Alert> comparator = new Comparator<Alert>() {
        @Override
        public int compare(Alert o1, Alert o2) {
            if(o1.getPriority() == o2.getPriority()) return 0;
            return o1.getPriority() < o2.getPriority()? 1: -1;
        }
    };
    public PriorityQueue<String> getQueue() {
        return queue;
    }

    static class CustomComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            StringTokenizer tokens1 = new StringTokenizer(s1);
            String first = tokens1.nextToken();
            StringTokenizer tokens2 = new StringTokenizer(s2);
            String second = tokens2.nextToken();

            return first.compareTo(second);
        }
    }

    void adQueue(String s){
        queue.add(s);
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
        for(Alert alert: alerts){
            if(defaultValue > alert.getMax()||defaultValue< alert.getMin()) throw new IllegalArgumentException("Alert should have a value outside the normal limits");
        }
        alerts.sort(comparator);
    }

    public List<Alert> getAlerts() {
        return alerts;
    }
}