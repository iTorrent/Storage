package me.torrent.superheat;

import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

public class SHEntityListener extends EntityListener {
public static Superheat plugin;
	
	public SHEntityListener(Superheat instance)
	{
		plugin = instance;
	}
	
	
	
	
	public void onEntityDeath(EntityDeathEvent event) {
		 if(event.getEntity() instanceof Pig) {
            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(320,1));
                 return;
             }
		 }
	}
	

