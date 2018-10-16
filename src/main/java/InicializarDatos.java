import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Dark_Trainer on 16/10/2018.
 */
public class InicializarDatos {
    public static HashMap<String, String> mapProp;
    public InicializarDatos() {
        initProperties();
    }

    public HashMap<String,String> initProperties() {
        mapProp = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream input = null;
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String urlResources = rootPath + "resources.properties";
        try {
            input = new FileInputStream(urlResources);
            // load a properties file
            prop.load(input);
            Iterator it = prop.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                mapProp.put(pair.getKey().toString(), pair.getValue().toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return mapProp;
    }
}
