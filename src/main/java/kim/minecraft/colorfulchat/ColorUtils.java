package kim.minecraft.colorfulchat;

import org.bukkit.Color;

import java.util.Random;

public class ColorUtils {

    private static Color generatorRandomColor(){
        Random random = new Random();
        return Color.fromRGB(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public static String getColoredString(String original){
        StringBuilder builder = new StringBuilder();
        for (char c : original.toCharArray()) {
            StringBuilder rgbBuilder = new StringBuilder();
            rgbBuilder.append("§x");
            for (char rgb : String.valueOf(generatorRandomColor().asRGB()).toCharArray()) {
                rgbBuilder.append("§");
                rgbBuilder.append(rgb);
            }
            builder.append(rgbBuilder.toString());
            builder.append(c);
        }
        return builder.toString();
    }
}
