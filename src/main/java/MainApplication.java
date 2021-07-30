import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApplication extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        System.out.println("testing output");
        new MainApplication().run(args);
    }
    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {
    }
}
