public class TemperatureModel {
    // to set the environment temperature and other values
    public double EnvironmentTemp = 20.0;
    private double desiredTemp;
    private double heatingRate;
    private double coolingRate;

    private boolean furnace;
    private boolean AC;

    private boolean runningStatus;

    public TemperatureModel() {
    }
    public TemperatureModel(double desiredTemp, double heatingRate, double coolingRate)
    {
        this.desiredTemp = desiredTemp;
        this.heatingRate = heatingRate;
        this.coolingRate = coolingRate;
        this.furnace = false;
        this.AC = false;
    }
    public void startSimulation() {
        runningStatus = true;
        new Thread(() ->
        {
            while (runningStatus)
            {
                if (EnvironmentTemp < desiredTemp)
                {
                    furnace = true;
                    AC = false;
                } else if (EnvironmentTemp > desiredTemp)
                {
                    furnace = false;
                    AC = true;
                } else
                {
                    furnace = false;
                    AC = false;
                }
                if (furnace)
                {
                    EnvironmentTemp += heatingRate;
                    System.out.println(EnvironmentTemp);
                } else if (AC)
                {
                    EnvironmentTemp -= coolingRate;
                    System.out.println(EnvironmentTemp);
                }
                if (desiredTemp == EnvironmentTemp)
                    break;
                try
                {
                    Thread.sleep(4000L);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public boolean isFurnace()
    {
        return furnace;
    }

    public boolean isAC()
    {
        return AC;
    }

    public double getUpdatedTemp()
    {
        return EnvironmentTemp;
    }
}






















    //    public static double EnvironmentHumidity = 40.0;
//    public static double EnvironmentSoilMoisture = 30.0;
//
//    // to store the desired values as per the user's need
//    private double desiredTemp;
//    private double desiredHumidity;
//    private double desiredSoilMoisture;
//
//    // input for the rate at which the devices going to work
//    private double heatingRate;
//    private double coolingRate;
//    private double humidifierRate;
//    private double sprinklerRate;
//
//    // to store the values of the updated values such as temp,humidity and soil Moisture  as per the rates
//    private double updatedTemp;
//    private double updatedHumidity;
//    private double updatedSoilMoisture;
//
//    // TO store the status of each of the devices
//    private boolean furnaceStatus;
//    private boolean airConditionerStatus;
//    private boolean humidifierStatus;
//    private boolean sprinklerStatus;
//
//    private int refreshRate;
//
//    public TemperatureModel() {
//        furnaceStatus = false;
//        airConditionerStatus = false;
//        humidifierStatus = false;
//        sprinklerStatus = false;
//    }
//
//    public void setHeatingRate(double heatingRate) {
//        this.heatingRate = heatingRate;
//    }
//
//    public void setCoolingRate(double coolingRate) {
//        this.coolingRate = coolingRate;
//    }
//
//    public void setDesiredTemp(double desiredTemp) {
//        this.desiredTemp = desiredTemp;
//    }
//
//    public void setDesiredHumidity(double desiredHumidity) {
//        this.desiredHumidity = desiredHumidity;
//    }
//
//    public void setDesiredSoilMoisture(double desiredSoilMoisture) {
//        this.desiredSoilMoisture = desiredSoilMoisture;
//    }
//
//    public void setHumidifierRate(double humidifierRate) {
//        this.humidifierRate = humidifierRate;
//    }
//
//    public void setSprinklerRate(double sprinklerRate) {
//        this.sprinklerRate = sprinklerRate;
//    }
//    public void startSimulation()
//    {
//        // to store the status of the simulation
//        boolean runningStatus = true;
//        while (runningStatus)
//        {
//            if (furnaceStatus) {
//                updatedTemp = EnvironmentTemp + heatingRate;
//            } else if (airConditionerStatus) {
//                updatedTemp = EnvironmentTemp - coolingRate;
//            }
//            if (humidifierStatus) {
//                updatedHumidity = EnvironmentHumidity + humidifierRate;
//            } else {
//                updatedHumidity = EnvironmentHumidity - humidifierRate;
//            }
//            if (sprinklerStatus) {
//                updatedSoilMoisture = EnvironmentSoilMoisture + sprinklerRate;
//            } else {
//                updatedSoilMoisture = EnvironmentSoilMoisture - sprinklerRate;
//            }
//            if (updatedTemp < desiredTemp - 3.0)
//                furnaceStatus = true;
//            else
//                furnaceStatus = false;
//            if (updatedTemp > desiredTemp + 3.0)
//                airConditionerStatus = true;
//            else
//                airConditionerStatus = false;
//
//            if (updatedHumidity < desiredHumidity)
//                humidifierStatus = true;
//            else
//                humidifierStatus = false;
//
//            if (updatedSoilMoisture < desiredSoilMoisture)
//                sprinklerStatus = true;
//            else
//                sprinklerStatus = false;
//            if (updatedTemp == desiredTemp && updatedHumidity == desiredHumidity && updatedSoilMoisture == desiredSoilMoisture) {
//                runningStatus = false;
//            }
//        }
//    }
//    public double getUpdatedTemp() {
//        return updatedTemp;
//    }
//    public double getUpdatedHumidity() {
//        return updatedHumidity;
//    }
//
//    public double getUpdatedSoilMoisture() {
//        return updatedSoilMoisture;
//    }
//
//    public boolean isFurnaceStatus() {
//        return furnaceStatus;
//    }
//    public boolean isAirConditionerStatus() {
//        return airConditionerStatus;
//    }
//    public boolean isHumidifierStatus() {
//        return humidifierStatus;
//    }
//    public boolean isSprinklerStatus() {
//        return sprinklerStatus;
//    }
