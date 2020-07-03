package kim.minecraft.colorfulchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommandHandler implements CommandExecutor {

    private ColorfulChat _plugin;

    public ChatCommandHandler(ColorfulChat plugin)
    {
        _plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "仅玩家可使用此命令");
            return true;
        }

        Player player = (Player) commandSender;

        /*if (ColorfulChat.getEnableTable().containsKey(player)) {
            ColorfulChat.getEnable().put(player, !ColorfulChat.getEnable().get(player));
        } else {
            ColorfulChat.getEnable().put(player, true);
        }*/

        player.sendMessage(ChatColor.YELLOW + "切换彩色聊天模式成功!");

        return true;
    }
}
