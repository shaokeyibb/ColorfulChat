package kim.minecraft.colorfulchat;

import java.util.Random;

import org.bukkit.Color;

public class RandomRgbGeneratePolicy implements IColorGeneratePolicy {

    private Random _random;

    public RandomRgbGeneratePolicy()
    {
        _random = new Random();
    }

    private Color generateColor()
    {
        return Color.fromRGB(_random.nextInt(255),_random.nextInt(255),_random.nextInt(255));
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < str.length();++i)
        {
            builder.append("§x");
            for(char rgb: String.valueOf(generateColor().asRGB()).toCharArray())
            {
                builder.append("§x");
                builder.append(rgb);
            }
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
}
