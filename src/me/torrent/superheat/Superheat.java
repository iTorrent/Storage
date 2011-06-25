package me.torrent.superheat;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Superheat extends JavaPlugin
{
  private final SHBlockListener blockListener = new SHBlockListener(this);
  private final SHEntityListener entityListener = new SHEntityListener(this);
  public static PermissionHandler Permissions = null;
  public final HashMap<Player, ArrayList<Block>> shUsers = new HashMap();
  private static final Logger log = Logger.getLogger("Minecraft");
  public boolean usePerm = false;

  public void onEnable() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvent(Event.Type.BLOCK_BREAK, this.blockListener, 
      Event.Priority.Normal, this);
    setupPermissions();
    log.info("[Superheat] Starting up....");
    log.info("[Superheat] Superheat enabled!");
  }

  public void onDisable() {
    log.info("[Superheat] Shutting down....");
    log.info("[Superheat] Disabled. Thanks for using Superheat!");
  }

  public void setupPermissions()
  {
    Plugin test = getServer().getPluginManager()
      .getPlugin("Permissions");

    if (Permissions == null)
      if (test != null) {
        getServer().getPluginManager().enablePlugin(test);
        Permissions = ((Permissions)test).getHandler();
        log.info("[Superheat] Using Permissions.");
        this.usePerm = true;
      } else {
        log.info("[Superheat] Permissions not found.");
        log.info("[Superheat] Superheat allowed for all memebers.");
        this.usePerm = false;
      }
  }

  public boolean enabled(Player player)
  {
    return this.shUsers.containsKey(player);
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (((commandLabel.equalsIgnoreCase("sh")) || 
      (commandLabel.equalsIgnoreCase("superheat"))) && ((sender instanceof Player))) {
      if (this.usePerm) {
        if (Permissions.has((Player)sender, "superheat.sh")) {
          toggleVision((Player)sender);
          return true;
        }
      } else {
        toggleVision((Player)sender);
        return true;
      }
    } else {
      sender.sendMessage("Command can only be used ingame.");
      return true;
    }

    return false;
  }

  public void toggleVision(Player player)
  {
    if (enabled(player)) {
      this.shUsers.remove(player);
      player.sendMessage(ChatColor.GOLD + "[Superheat]" + ChatColor.WHITE + 
        " Disabled.");
    } else {
      this.shUsers.put(player, null);
      player.sendMessage(ChatColor.GOLD + "[Superheat] " + 
        ChatColor.WHITE + "Enabled.");
    }
  }
}