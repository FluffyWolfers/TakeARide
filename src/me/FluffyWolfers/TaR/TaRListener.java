package me.FluffyWolfers.TaR;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class TaRListener implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void getOnMob(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		if(p.getItemInHand().getType().equals(Material.SADDLE)){
			
			if(p.isSneaking()){
				
				if(p.hasPermission("takearide.ride")){
					
					en.setPassenger(p);
					
				}
				
			}
			
		}
			
	}
	
}
