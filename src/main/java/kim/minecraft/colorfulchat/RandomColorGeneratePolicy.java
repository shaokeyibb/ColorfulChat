package kim.minecraft.colorfulchat;

import java.util.Random;

public class RandomColorGeneratePolicy implements IColorGeneratePolicy {

    private Random _random;

    private char[] _colorCodes;

    public RandomColorGeneratePolicy()
    {
        _random = new Random();
        _colorCodes = "0123456789abcdef".toCharArray();
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < str.length();++i) {
            builder.append("§");
            builder.append(_colorCodes[_random.nextInt(_colorCodes.length)]);
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
