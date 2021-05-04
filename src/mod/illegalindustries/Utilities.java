package mod.illegalindustries;

import com.fs.starfarer.api.Global;


public class Utilities {
    public static float getStandardizedPortAccessibility(){
        try {
            int accessibility = Global.getSettings().getJSONObject("illegalindustries").getInt("standardizedPortAccessibility");
            return (float)accessibility/100;
        } catch (Exception e) {
            return 1.0f;
        }
    }
}
