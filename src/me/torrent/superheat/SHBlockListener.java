package me.torrent.superheat;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class SHBlockListener extends BlockListener {
	public static Superheat plugin;
	
	public SHBlockListener(Superheat instance)
	{
		plugin = instance;
	}

	public void onBlockBreak(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
		int iih = player.getItemInHand().getTypeId();
		Material m = event.getBlock().getType();
		
		if ((plugin.enabled(player)))
		{
			if ((m == Material.STONE) && (iih == 285))
		{
			Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(1, 1));
	        event.getBlock().setType(Material.AIR);
	        return;
	      }
		 if ((event.getBlock().getType() == Material.COBBLESTONE) && (iih == 285))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);

	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(1, 1));
	        event.getBlock().setType(Material.AIR);
	       
	        return;
	      }

	      if ((event.getBlock().getType() == Material.LOG) && (iih == 286))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);

	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(263, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	       
	        return;
	      }

	      if ((event.getBlock().getType() == Material.GOLD_ORE) && (iih == 285))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);

	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(266, 1));
	        event.getBlock().setType(Material.AIR);
	       
	        return;
	      }

	      if ((event.getBlock().getType() == Material.IRON_ORE) && (iih == 285))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().setType(Material.AIR);
	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(265, 1));
	       
	        return;
	      }

	      if ((event.getBlock().getType() == Material.SAND) && (iih == 284))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);

	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(20, 1));
	        event.getBlock().setType(Material.AIR);
	       
	        return;
	      }

	      if ((event.getBlock().getType() == Material.CLAY) && (iih == 284))
	      {
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);

	        event.getBlock().getWorld().dropItemNaturally(locy, new ItemStack(336, 4));
	        event.getBlock().setType(Material.AIR);
	       
	        return;
	      }
	    }
	  }
	}