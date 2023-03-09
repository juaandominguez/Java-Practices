package e2;
public class Alert{
    private final String name;
    private final float min,max;
    private final int priority;
    Alert(float min,float max,int priority,String name){
        this.min = min;
        this.max = max;
        this.name=name;
        this.priority = priority;
    }
    public String getName(){return name;}
    public float getMin(){return min;}
    public float getMax(){return max;}
    public int getPriority(){
        return priority;
    }

}
