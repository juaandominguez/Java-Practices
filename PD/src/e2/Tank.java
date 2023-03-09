package e2;

import java.util.List;

public class Tank {
    private final String name;
    private final String location;
    private final List<Sensor> sensors;

    public String getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
    public List<Sensor> getSensors() {
        return sensors;
    }


    Tank(List<Sensor> sensors,String location,String name){
    this.sensors = sensors;
    this.location=location;
    this.name=name;
    }
}

