package me.FluffyWolfers.TaR;

import org.bukkit.plugin.java.JavaPlugin;

public class TaR extends JavaPlugin{
	
	public void onEnable(){
		
		this.getServer().getPluginManager().registerEvents(new TaRListener(), this);
		
	}
	
}
