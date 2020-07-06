package kim.minecraft.colorfulchat;

import org.bukkit.Color;

public class RgbGradientModel {
    public Color begin;

    public Color end;

    public static RgbGradientModel make(int r,int g,int b,int R,int G,int B) {
        Color begin = Color.fromRGB(r, g, b);
        Color end = Color.fromRGB(R,G,B);
        RgbGradientModel model = new RgbGradientModel();
        model.begin = begin;
        model.end = end;
        return model;
    }
}
