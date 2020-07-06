package kim.minecraft.colorfulchat;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class ColorfulChat extends JavaPlugin {

    private final Map<Player, Boolean> _enableTable;

    public Map<Player, Boolean> getEnableTable() {
        return _enableTable;
    }

    public ColorfulChat() {
        _enableTable = new HashMap<>();
    }


    @Override
    public void onEnable() {

        IColorGeneratePolicy policy;
        try {
            net.md_5.bungee.api.ChatColor.of("#66ccff");
            policy = new GradientRgbGeneratePolicy();
        } catch (Throwable ignore) {
            policy = new GradientGeneratePolicy();
        }
        getLogger().info("Using " + policy.getClass().getSimpleName());
        Bukkit.getPluginManager().registerEvents(new ChatListener(this, policy), this);
        PluginCommand command = Bukkit.getPluginCommand("colorfulchat");
        ChatCommandHandler handler = new ChatCommandHandler(this);
        command.setExecutor(handler);
    }
}
