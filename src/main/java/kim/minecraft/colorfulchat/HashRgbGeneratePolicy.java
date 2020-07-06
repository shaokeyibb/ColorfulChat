package kim.minecraft.colorfulchat;

import org.bukkit.Color;

public class HashRgbGeneratePolicy implements IColorGeneratePolicy {

    private long getLongHash(int hash)
    {
       long longHash = hash;
       longHash |= (~(hash<<32));
       return longHash;
    }

    private int getRedByHash(long hash)
    {
       int red = (int)(hash>>48);
       return red;
    }

    private int getGreenByHash(long hash)
    {
        hash ^= 0xFFFF000000000000l;
        int green = (int)(hash>>32);
       return green;
    }

    private int getBuleByHash(long hash)
    {
        hash ^= 0xFFFFFFFF0000000l;
        int blue = (int)(hash>>16);
        return blue;
    }

    private Color getColor(char c)
    {
        Integer i = (int)c;
        int hash = i.hashCode();
        long longHash = getLongHash(hash);
        int red = getRedByHash(longHash) % 255;
        int blue = getBuleByHash(longHash) % 255;
        int green = getGreenByHash(longHash) % 255;
        return Color.fromBGR(blue, green, red);
    }

    @Override
    public String getNextColorString(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i =0;i<str.length();++i)
        {
            builder.append("§x");
            for(char c:String.valueOf(getColor(str.charAt(i)).asBGR()).toCharArray())
            {
                builder.append("§");
                builder.append(c);
            }
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
}