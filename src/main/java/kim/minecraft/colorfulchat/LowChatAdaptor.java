package kim.minecraft.colorfulchat;

public class LowChatAdaptor implements IChatAdaptor {

    public String getColoredString(String original) {
        StringBuilder builder = new StringBuilder();
        char[] hex = "0123456789abcdef".toCharArray();
        char[] chars = original.toCharArray();
        for(int i = 0;i < chars.length;++i)
        {
            builder.append("§");
            int code = chars[i] % 16;
            builder.append(hex[code]);
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    @Override
    public String getColorfulString(String msg) {
        
        return getColoredString(msg);
    }
    
}