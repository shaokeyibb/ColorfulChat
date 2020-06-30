package kim.minecraft.colorfulchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        if (ColorfulChat.getEnable().getOrDefault(e.getPlayer(),false)){
            e.setMessage(ColorUtils.getColoredString(e.getMessage()));
        }
    }
}
