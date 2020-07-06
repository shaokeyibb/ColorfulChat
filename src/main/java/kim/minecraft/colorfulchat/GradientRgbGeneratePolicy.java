package kim.minecraft.colorfulchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GradientRgbGeneratePolicy implements IColorGeneratePolicy {

    private final List<RgbGradientModel> _models;

    private final Random _random;

    public GradientRgbGeneratePolicy() {
        _models = new ArrayList<>();
        _models.add(RgbGradientModel.make(255, 0, 0, 255, 127, 0));
        _models.add(RgbGradientModel.make(255, 127, 0, 255, 255, 0));
        _models.add(RgbGradientModel.make(255, 255, 0, 0, 255, 0));
        _models.add(RgbGradientModel.make(0,255,0,0,255,255));
        _models.add(RgbGradientModel.make(0, 255, 255, 0, 0, 255));
        _models.add(RgbGradientModel.make(0, 0, 255, 0x0b, 00, 255));
        _random = new Random();
    }

    private static int getGradientNumber(int a, int b, int step, int n) {
        if (b > a) {
            int c = a;
            a = b;
            b = c;
        }
        return (b + ((a - b) * n / step)); 
    }

    private Color getGradientColor(Color from, Color to, int step, int n) {
        return new Color(
                getGradientNumber(from.getRed(), to.getRed(), step, n),
                getGradientNumber(from.getGreen(), to.getGreen(), step, n),
                getGradientNumber(from.getBlue(), to.getBlue(), step, n)
        );
    }

    private RgbGradientModel getColorModel() {
        int index = _random.nextInt(_models.size());
        return _models.get(index);
    }

    @Override
    public String getNextColorString(String str) {
        int step = str.length();
        RgbGradientModel model = getColorModel();
        ComponentBuilder builder = new ComponentBuilder();
        for (int i = 0; i < step; i++) {
            Color color = getGradientColor(model.begin, model.end, step - 1, i);
            builder.append(String.valueOf(str.charAt(i))).color(ChatColor.of(color));
        }
        return new TextComponent(builder.create()).toLegacyText();
    }

}
