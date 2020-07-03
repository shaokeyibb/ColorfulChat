package kim.minecraft.colorfulchat;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class ColorfulChat extends JavaPlugin {

    private Map<Player,Boolean> _enableTable;

    public Map<Player,Boolean> getEnableTable()
    {
        return _enableTable;
    }

    public ColorfulChat()
    {
        _enableTable = new HashMap<>();
    }


    @Override
    public void onEnable(){
        IChatAdaptor adaptor = null;
        if(getServer().getBukkitVersion().contains("1.16"))
        {
            adaptor = new DefaultChatAdaptor();
        }
        else
        {
            adaptor = new LowChatAdaptor();
        }
        Bukkit.getPluginManager().registerEvents(new ChatListener(this,adaptor),this);
        PluginCommand command = Bukkit.getPluginCommand("colorfulchat");
        ChatCommandHandler handler = new ChatCommandHandler(this);
        command.setExecutor(handler);
    }
}
