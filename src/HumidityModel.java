public class HumidityModel
{
    public double EnvironmentHumidity = 40.0;

    private double desiredHumidity;

    private double humidifierRate;

    private boolean humidifier;

    private boolean runningStatus;

    public HumidityModel()
    {

    }
    public HumidityModel(double desiredHumidity,double humidifierRate)
    {
        this.desiredHumidity = desiredHumidity;
        this.humidifierRate = humidifierRate;
        this.humidifier = false;
    }

    public void startSimulation()
    {
        runningStatus = true;

        new Thread(() ->
        {
            while(runningStatus)
            {
                if(EnvironmentHumidity<desiredHumidity)
                {
                    humidifier = true;
                }

                if(humidifier)
                {
                    EnvironmentHumidity += humidifierRate;
                }

                if(EnvironmentHumidity == desiredHumidity)
                    break;
                try
                {
                    Thread.sleep(4000L);
                }
                catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public boolean isHumidifier()
    {
        return humidifier;
    }
    public double getUpdatedHumidity()
    {
        return EnvironmentHumidity;
    }
}
