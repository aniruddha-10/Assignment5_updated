public class HumidityThread extends Thread
{
    private HumidityModel model;
    private View view;
    private boolean flag;
    public HumidityThread(HumidityModel model,View view)
    {
        this.model = model;
        this.view = view;
        this.flag = false;
    }
    @Override
    public void run()
    {
        flag = true;
        while(flag)
        {
            view.setCurrentHumidity(model.getUpdatedHumidity());
            view.setHumidifier(model.isHumidifier());
            if(model.EnvironmentHumidity == view.getdesiredhhumidity())
            {
                view.setHumidifier(false);
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
