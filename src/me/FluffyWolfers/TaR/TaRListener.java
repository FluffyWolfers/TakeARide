package me.FluffyWolfers.TaR;

import net.minecraft.server.v1_6_R2.EntityCreature;
import net.minecraft.server.v1_6_R2.PathEntity;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftCreature;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
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
			
		}else if(p.getItemInHand().getType().equals(Material.STICK)){
			
			if(p.hasPermission("takearide.follow")){
				
				if(en instanceof Monster){
					
					if(((Monster)en).getTarget() == null){
						
						boolean flag = false;
						
						if(en instanceof Zombie){
							((Zombie) l).setTarget(p);
							flag = true;
						}
						if(en instanceof Creeper){
							((Creeper) l).setTarget(p);
							flag = true;
						}
						if(en instanceof Spider){
							((Spider) l).setTarget(p);
							flag = true;
						}
						if(en instanceof Skeleton){
							((Skeleton) l).setTarget(p);
							flag = true;
						}
						if(en instanceof Enderman){
							((Enderman) l).setTarget(p);
							flag = true;
						}
						if(en instanceof PigZombie){
							((PigZombie) l).setTarget(p);
							flag = true;
						}
						
						if(flag){
							p.sendMessage(en.getType().getName().substring(0, 1).toUpperCase() + en.getType().getName().substring(1).toLowerCase() + " is now following you");
						}
						
						flag = false;
						
					}else{
						
						p.sendMessage(en.getType().getName().substring(0, 1).toUpperCase() + en.getType().getName().substring(1).toLowerCase() + " is no longer following you");
						
						((Monster)en).setTarget(null);
						
					}
					
				}
				
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
