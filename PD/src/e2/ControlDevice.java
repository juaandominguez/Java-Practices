package e2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControlDevice  implements Observer  {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final LocalDateTime date = LocalDateTime.now();
    private final String strDate = date.format(DATE_TIME_FORMATTER);
    private final Tank tank;



    public String getStrDate() {
        return strDate;
    }



    ControlDevice(Tank tank) {
        this.tank = tank;
    }


    @Override
    public void update(Subject s) {
        for (Sensor sensor : tank.getSensors()) {
            if(sensor.getAlerts() == null) continue;
            for (Alert alert : sensor.getAlerts()) {
                if (sensor.getValue() > alert.getMax()|| sensor.getValue() < alert.getMin()) {
                    String report = String.format("%d%s:\n%s, %s\n%s: parameter %s, level %f\n%s",alert.getPriority(),alert.getName(),tank.getName(), tank.getLocation(), sensor.getName(), sensor.getParameter(), sensor.getValue(), getStrDate());
                    sensor.setValue(sensor.getDefaultValue());
                    sensor.adQueue(report);
                    break;
                }
            }
        }
    }
}
