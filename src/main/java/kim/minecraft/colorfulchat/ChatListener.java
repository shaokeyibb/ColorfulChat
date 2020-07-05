package kim.minecraft.colorfulchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements org.bukkit.event.Listener {

    private ColorfulChat _plugin;

    private IChatAdaptor _adaptor;

    public ChatListener(ColorfulChat plugin,IChatAdaptor adaptor)
    {
        _plugin = plugin;
        _adaptor = adaptor;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if(_plugin.getEnableTable().getOrDefault(e.getPlayer(),false))
        {
            String msg = _adaptor.getColorfulString(e.getMessage());
            e.setMessage(msg);
        }
    }
}
