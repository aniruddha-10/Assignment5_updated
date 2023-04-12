public class SoilMoistureThread extends Thread
{
    private SoilMoistureModel model;
    private View view;
    private boolean flag;

    public SoilMoistureThread(SoilMoistureModel model, View view)
    {
        this.model = model;
        this.view = view;
    }
    public void run()
    {
        flag = true;
        while(flag)
        {
            view.setCurrentSoilMoisture(model.getUpdatedSoilMoisture());
            view.setSprinkler(model.isSprinkler());
            if(model.EnvironmentSoilMoisture == view.getdesiredSoilMoisture())
            {
                view.setSprinkler(false);
                break;
            }
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException();
            }
        }
    }
}
