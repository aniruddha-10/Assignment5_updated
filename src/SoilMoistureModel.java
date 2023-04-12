public class SoilMoistureModel
{
    public double EnvironmentSoilMoisture = 30.0;

    private double desiredSoilMositure;

    private double sprinklerRate;

    private boolean sprinkler;

    private boolean runningStatus;

    public SoilMoistureModel()
    {

    }
    public SoilMoistureModel(double desiredSoilMositure,double sprinklerRate)
    {
        this.desiredSoilMositure = desiredSoilMositure;
        this.sprinklerRate = sprinklerRate;
        this.sprinkler = false;
    }

    public void startSimulation()
    {
        runningStatus = true;
        new Thread(() ->
        {
            while(runningStatus)
            {
                if(EnvironmentSoilMoisture<desiredSoilMositure)
                {
                    sprinkler = true;
                }
                if(sprinkler)
                {
                    EnvironmentSoilMoisture += sprinklerRate;
                }

                if(EnvironmentSoilMoisture == desiredSoilMositure)
                {
                    break;
                }

                try
                {
                    Thread.sleep(4000L);
                }
                catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public boolean isSprinkler()
    {
        return sprinkler;
    }
    public double getUpdatedSoilMoisture()
    {
        return EnvironmentSoilMoisture;
    }
}
