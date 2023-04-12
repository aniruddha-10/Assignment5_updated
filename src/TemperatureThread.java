public class TemperatureThread extends Thread
{
    private TemperatureModel model;
    private View view;
    private boolean flag;

    public  TemperatureThread(TemperatureModel model,View view)
    {
        this.model = model;
        this.view = view;
        this.flag = false;
    }
    @Override
    public void run()
    {
        flag = true;
        while (flag)
        {
            view.setCurrentTemp(model.getUpdatedTemp());
            view.setFurnace(model.isFurnace());
            view.setAirConditioner(model.isAC());
            if((model.EnvironmentTemp == view.getdesiredtemperature()) && (model.isFurnace() || model.isAC()))
            {
                view.setFurnace(false);
                view.setAirConditioner(false);
                break;
            }
             try{
                Thread.sleep(1000L);
             } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


