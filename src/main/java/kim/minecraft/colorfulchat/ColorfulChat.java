package kim.minecraft.colorfulchat;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ColorfulChat extends JavaPlugin {

    @Getter
    private static ColorfulChat instance;

    @Getter
    private static final HashMap<Player, Boolean> enable = new HashMap<>();

    @Override
    public void onEnable(){
        instance = this;
        Bukkit.getPluginManager().registerEvents(new Listener(),this);
        final PluginCommand command = Bukkit.getPluginCommand("colorfulchat");
        CommandHandler handler = new CommandHandler();
        command.setExecutor(handler);
    }
}
