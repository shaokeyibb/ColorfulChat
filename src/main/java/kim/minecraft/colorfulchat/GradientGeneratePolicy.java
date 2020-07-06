package kim.minecraft.colorfulchat;

public class GradientGeneratePolicy implements IColorGeneratePolicy {

    private char[] _colors;

    public GradientGeneratePolicy()
    {
        _colors = "4c6e2ab319d5f780".toCharArray();
    }

    private int getColorIndex(int i)
    {
        int count = i/_colors.length;
        i %= _colors.length;
        if((count % 2) != 0)
        {
            return Math.abs(i - (_colors.length-1));
        }
        return i;
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < str.length();++i)
        {
            int colorIndex = getColorIndex(i);
            builder.append("§");
            builder.append(_colors[colorIndex]);
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
}