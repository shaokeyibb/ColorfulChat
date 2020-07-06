package kim.minecraft.colorfulchat;

import java.awt.*;

public class RgbGradientModel {
    public Color begin;

    public Color end;

    public static RgbGradientModel make(int r, int g, int b, int R, int G, int B) {
        RgbGradientModel model = new RgbGradientModel();
        model.begin = new Color(r, g, b);
        model.end = new Color(R, G, B);
        return model;
    }
}
