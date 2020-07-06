package kim.minecraft.colorfulchat;

public class HashGeneratePolicy implements IColorGeneratePolicy {

    private char[] _colorCodes;

    public HashGeneratePolicy()
    {
        _colorCodes = "0123456789abcderf".toCharArray();
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < str.length();++i) {
            builder.append("§");
            char c = str.charAt(i);
            int index = c % _colorCodes.length;
            builder.append(_colorCodes[index]);
            builder.append(c);
        }
        return builder.toString();
    }
    
}