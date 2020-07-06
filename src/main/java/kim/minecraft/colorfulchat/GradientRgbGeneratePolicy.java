package kim.minecraft.colorfulchat;

import java.util.Random;

import org.bukkit.Color;

public class GradientRgbGeneratePolicy implements IColorGeneratePolicy {

    private Random _random;

    public GradientRgbGeneratePolicy()
    {
        _random = new Random();
    }

    private Color getRandomColor()
    {
        return Color.fromBGR(_random.nextInt(255),_random.nextInt(255),_random.nextInt(255));
    }

    private int getGradientNumber(int a,int b,int step,int n)
    {
        int r = a + (b-a)/step * n;
        return r;
    }

    private Color getGradientColor(Color from,Color to,int step,int n)
    {
        int a = from.getBlue();
        int b = to.getBlue();
        int blue = getGradientNumber(a, b,step,n);
        a = from.getGreen();
        b = to.getGreen();
        int green = getGradientNumber(a, b, step, n);
        a = from.getRed();
        b = to.getRed();
        int red = getGradientNumber(a, b, step, n);
        return Color.fromBGR(blue, green, red);
    }

    @Override
    public String getNextColorString(String str) {
        Color from = getRandomColor();
        Color to = getRandomColor();
        int step = str.length();
        StringBuilder builder = new StringBuilder();
        for(int i =0 ;i < step;i++)
        {
            Color color = getGradientColor(from, to, step, i);
            builder.append("§x");
            for(char c : String.valueOf(color.asBGR()).toCharArray())
            {
                builder.append("§");
                builder.append(c);
            }
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
}