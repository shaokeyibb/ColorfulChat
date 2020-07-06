package kim.minecraft.colorfulchat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Color;

public class GradientRgbGeneratePolicy implements IColorGeneratePolicy {

    private List<RgbGradientModel> _models;

    private Random _random;

    public GradientRgbGeneratePolicy()
    {
        _models = new ArrayList<>();
        //_models.add(RgbGradientModel.make(0, 255, 255, 255, 255, 255));
        //_models.add(RgbGradientModel.make(255, 255, 0, 255, 255, 255));
        //_models.add(RgbGradientModel.make(255, 0, 255, 255, 255, 255));
        
        _models.add(RgbGradientModel.make(255, 0, 0, 255, 127,0));
        //_models.add(RgbGradientModel.make(255, 127, 0, 255, 255, 0));
        _models.add(RgbGradientModel.make(255, 255, 0,0,255,0));
        //_models.add(RgbGradientModel.make(0,255,0,0,255,255));
        _models.add(RgbGradientModel.make(0,255,255,0,0,255));
        _models.add(RgbGradientModel.make(0,0,255,0x0b,00,255));
        _random = new Random();
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

    private RgbGradientModel getColorModel()
    {
        int index = _random.nextInt(_models.size());
        return _models.get(index);
    }

    @Override
    public String getNextColorString(String str) {
        int step = str.length();
        StringBuilder builder = new StringBuilder();
        for(int i =0 ;i < step;i++)
        {
            RgbGradientModel model = getColorModel();
            Color color = getGradientColor(model.begin,model.end, step, i);
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