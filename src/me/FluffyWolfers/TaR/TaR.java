package me.FluffyWolfers.TaR;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TaR extends JavaPlugin{

	public static TaR t;
	public static PluginDescriptionFile pdf;

	public void onEnable(){

		t = this;
		pdf = this.getDescription();
		
		Bukkit.getLogger().info("[TakeARide v" + pdf.getVersion() + "] Starting up...");

		this.getServer().getPluginManager().registerEvents(new TaRListener(), this);

	}

}