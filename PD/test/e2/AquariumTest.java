package e2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class AquariumTest {

    static Sensor ph=new Sensor(20,"Sensor 1 control seals","ph");
    static Sensor oxygen=new Sensor(18,"Sensor 2 control seals","oxygen");
    static Sensor temp=new Sensor(21,"Sensor 3 control seals","temp");

    static Alert red=new Alert(13,25,1,"RED ALERT");
    static Alert orange=new Alert(15,20,0,"ORANGE ALERT");

    static List<Tank> tankList=new ArrayList<>();
    static List<Alert> alertList=new ArrayList<>();
    @BeforeAll
    static void addSensorList(){
        sensorList.add(ph);
        sensorList.add(oxygen);
        sensorList.add(temp);
    }
    @BeforeAll
    static void addSensorList2(){
        sensorList2.add(oxygen);
    }
    @BeforeAll
    static void addTankList(){
        tankList.add(t1);
        tankList.add(t2);
    }
    @BeforeAll
    static void addAlertList(){
        alertList.add(orange);
        alertList.add(red);
    }
    static List<Sensor> sensorList=new ArrayList<>();
    static List<Sensor> sensorList2=new ArrayList<>();
    static Personal p1 = new Personal(sensorList,"TH");
    static Personal p2 = new Personal(sensorList2,"JOHN");
    static Tank t1=new Tank(sensorList,"loc1","DOLPHINS");
    static Tank t2=new Tank(sensorList,"loc2","SHARKS");
    static Tank t3=new Tank(sensorList,"loc3","SEALS");




    @Test
    void example(){
        Aquarium aq = new Aquarium(tankList);
        aq.addPersonal(p1);
        aq.addAlerts(alertList,ph);
        aq.changeValue(t1,ph,14f);
        aq.changeValue(t1,ph,12f);
        aq.showReport(p1);
    }
    @Test
    void pdfExample(){
        Aquarium aq = new Aquarium(tankList);
        aq.addPersonal(p2);
        aq.addAlerts(alertList,oxygen);
        aq.changeValue(t1,oxygen,14f);
        aq.changeValue(t1,oxygen,-100f);
        aq.changeValue(t1,oxygen,13.5f);
        aq.showReport(p2);

    }
    @Test
    void control1(){
        Aquarium aq = new Aquarium(tankList);
        aq.addTank(t1);
        aq.addPersonal(p1);
        aq.addAlerts(alertList,ph);
        aq.addAlerts(alertList,oxygen);
        aq.changeValue(t1,ph,14f);
        aq.changeValue(t1,ph,12f);
        aq.changeValue(t1,oxygen,14f);
        aq.changeValue(t1,oxygen,12f);
        aq.addTank(t3);
        aq.showReport(p1);
        assertThrows(IllegalArgumentException.class, () -> aq.showReport(p2));
    }

}
