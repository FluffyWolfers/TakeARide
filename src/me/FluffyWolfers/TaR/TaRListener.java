package me.FluffyWolfers.TaR;

import net.minecraft.server.v1_6_R2.EntityCreature;
import net.minecraft.server.v1_6_R2.PathEntity;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftCreature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TaRListener implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void getOnMob(PlayerInteractEntityEvent e){
		
		Player p = e.getPlayer();
		
		Entity en = e.getRightClicked();
		LivingEntity l = (LivingEntity) en;
		
		if(p.getItemInHand().getType().equals(Material.SADDLE)){
			
			if(p.hasPermission("takearide.ride")){
				
				l.setPassenger(p);
				
			}
			
		}
			
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void controlMob(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		if(p.getVehicle() != null){

			Entity en = p.getVehicle();
			LivingEntity l = (LivingEntity) en;
			
			if(p.hasPermission("takearide.control")){
				
				//l.setVelocity(p.getEyeLocation().getDirection());
				
				Location to = p.getLocation();
				
				Block b = p.getTargetBlock(null, 200);
				
				to.setX(b.getX());
				to.setY(b.getY());
				to.setZ(b.getZ());
				
                EntityCreature ec = ((CraftCreature)l).getHandle();
                PathEntity path = ec.getNavigation().a(to.getX(), to.getY(), to.getZ());
				ec.getNavigation().a(path, 1.35F);
                
			}
				
		}
			
	}
	
}
