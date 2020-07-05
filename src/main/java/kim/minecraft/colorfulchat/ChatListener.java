package kim.minecraft.colorfulchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements org.bukkit.event.Listener {

    private ColorfulChat _plugin;

    private IColorGeneratePolicy _policy;

    public ChatListener(ColorfulChat plugin,IColorGeneratePolicy policy)
    {
        _plugin = plugin;
        _policy = policy;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if(_plugin.getEnableTable().getOrDefault(e.getPlayer(),false))
        {
            String msg = _policy.getNextColorString(e.getMessage());
            e.setMessage(msg);
        }
    }
}
