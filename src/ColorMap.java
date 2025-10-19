import java.util.HashMap;
import java.awt.*;
import java.util.Random;
// This class was supposed to create random colors of celestial bodies
// but it was outside the brief and didn't have time to implement it.
public class ColorMap {
    private static final HashMap<String,Color> colorMap = new HashMap<>();
    static {
        colorMap.put("blue",new Color(66,242,247));
        colorMap.put("grey",new Color(39,39,39));
        colorMap.put("yellow",new Color(255,249,165));
        colorMap.put("orange",new Color(226,113,29));
        colorMap.put("red",new Color(249,112,104));
    }
    public static Color get (String color) {
        return colorMap.get(color);
    }

    public static Color getRandomColor(){
        List<String> keys = new ArrayList<>();
        for (String key : colorMap.keySet()){
            keys.add(key);
        }
        Random rand = new Random();
        return colorMap.get(keys.get(rand.nextInt(keys.size())));
    }
}
