package e2;
import java.util.ArrayList;
import java.util.List;


public class Personal {
    private final String name;
    private final List<Sensor> subscribed;
    private final List<String> report= new ArrayList<>();
    private final List<String> alertNamesList= new ArrayList<>();
    Personal(List<Sensor> subscribed,String name){
        this.subscribed = subscribed;
        this.name=name;
    }

    public List<Sensor> getSubscribed() {
        return subscribed;
    }
    public List<String>  getAlertNamesList(){
        for(Sensor sensor: getSubscribed()){
            if(sensor.getAlerts()==null) continue;
            for(Alert alert: sensor.getAlerts()){
                if(!alertNamesList.contains(alert.getName())) alertNamesList.add(alert.getName());
            }
        }
        return alertNamesList;
    }
    public void getReport(){
        for(Sensor sensor : subscribed){
            for(String str : sensor.getQueue()){
                if(str.contains(sensor.getName())) report.add(str+"\n");
            }
        }
    }
    public void showReport(){
        getReport();
            for(String s2: getAlertNamesList()){
                for(String s : report){
                    if(s.contains(s2)){
                    System.out.println(s.substring(1));
                }
            }
        }
    }


}
