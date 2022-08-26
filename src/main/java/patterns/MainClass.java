package patterns;

public class MainClass {
    public static void main(String[] args) {

        //String applicationName = args[0];
        String applicationName = "loan";

        ApplicationFactory factory = new ApplicationFactory();
        Application application = factory.getApplication(applicationName);

        application.processApplication();


        //HashMap<Object,String>
    }
}
