import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * The {@code ConfigReader} class is responsible for reading configuration values
 * from a `.properties` file and providing typed access (String, int, double).
 * <p>
 *
 * @author Paul Gedrimas
 */
public class ConfigReader {
    /** Stores the loaded properties. */
    private Properties prop;
    /**
     * Constructs a {@code ConfigReader} and loads the properties from the given file.
     *
     * @param filename the path to the configuration `.properties` file
     */
    public ConfigReader(String filename){
        prop = new Properties();
        try {
            FileInputStream fs = new FileInputStream(filename);
            prop.load(fs);
        }
        catch (IOException e) {
            System.err.println("Couldn't read the file: "+ e.getMessage());
        }
    }
    /**
     * Retrieves a property value as a {@code String}.
     *
     * @param key the property key
     * @return the value associated with the key, or {@code null} if not found
     */
    public String get(String key){
        return prop.getProperty(key);
    }
    /**
     * Retrieves a property value as a {@code double}.
     *
     * @param key the property key
     * @return the parsed double value
     */
    public double getDouble(String key){
        return Double.parseDouble(prop.getProperty(key));
    }
    /**
     * Retrieves a property value as an {@code int}.
     *
     * @param key the property key
     * @return the parsed integer value
     */
    public int getInt(String key){
        return Integer.parseInt(prop.getProperty(key));
    }
}
