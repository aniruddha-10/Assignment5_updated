import java.awt.event.*;
public class Controller extends Thread {
    private TemperatureModel model;
    private View view;

    private TemperatureThread temperatureThread;

    private HumidityThread humidityThread;

    private SoilMoistureThread soilMoistureThread;

    public Controller(View view, TemperatureModel model) {
        this.view = view;
        this.model = model;
        this.view.addStartButtonListener(new addStartButtonListener());
    }

    class addStartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                    double desiredTemp = view.getdesiredtemperature();
                    double heatingRate = view.getHeatingRate();
                    double coolingRate = view.getCoolingRate();
                    double desiredHumidity = view.getdesiredhhumidity();
                    double humidifierRate = view.getHumidifierRate();
                    double desiredSoilMoisture = view.getdesiredSoilMoisture();
                    double sprinklerRate = view.getSprinklerRate();
                    TemperatureModel model1 = new TemperatureModel(desiredTemp, heatingRate, coolingRate);
                    HumidityModel model2 = new HumidityModel(desiredHumidity,humidifierRate);
                    SoilMoistureModel model3 = new SoilMoistureModel(desiredSoilMoisture,sprinklerRate);
                    temperatureThread = new TemperatureThread(model1,view);
                    humidityThread = new HumidityThread(model2,view);
                    soilMoistureThread = new SoilMoistureThread(model3,view);
                    temperatureThread.start();
                    humidityThread.start();
                    soilMoistureThread.start();
                    model1.startSimulation();
                    model2.startSimulation();
                    model3.startSimulation();
                    view.setCurrentTemp(model1.getUpdatedTemp());
                    view.setFurnace(model1.isFurnace());
                    view.setAirConditioner(model1.isAC());
                    view.setCurrentHumidity(model2.getUpdatedHumidity());
                    view.setHumidifier(model2.isHumidifier());
                    view.setCurrentSoilMoisture(model3.getUpdatedSoilMoisture());
                    view.setSprinkler(model3.isSprinkler());

                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }
}

