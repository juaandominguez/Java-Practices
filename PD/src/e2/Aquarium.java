package e2;

import java.util.ArrayList;
import java.util.List;

public class Aquarium  {
    private final List<Tank> tankList;
    private final List<Personal> personalList = new ArrayList<>();
    Aquarium(List<Tank> tankList) {
        this.tankList = tankList;
        for (Tank t : tankList){
            attDevs(t);
        }
    }
    public void addTank(Tank t){
        if(!tankList.contains(t)){
        tankList.add(t);
        attDevs(t);}
        else System.out.println("Duplicated tank");
    }
    public void attDevs(Tank t){
        for(Sensor sensor : t.getSensors()){
            sensor.attach(new ControlDevice(t));
        }
    }
    public void addPersonal(Personal p){
        personalList.add(p);
    }
    public void changeValue(Tank t,Sensor s,float newVal){
        for(Sensor sensor : t.getSensors()){
            if(sensor.equals(s)){sensor.setValue(newVal);}
        }
    }
    public void showReport(Personal p){
        if(!personalList.contains(p)) throw new IllegalArgumentException("Person does not belong to the aquarium personal");
        p.showReport();
    }
    public void addAlerts(List<Alert> alerts ,Sensor sensor){
        sensor.setAlerts(alerts);
    }
}

