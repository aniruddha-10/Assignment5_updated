public class Main {
    public static void main(String[] args) {
        TemperatureModel model1 = new TemperatureModel();
        View view1 = new View();
        Controller controller = new Controller(view1, model1);
        System.out.println(model1.getUpdatedTemp());
    }
}