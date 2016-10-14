package me.abandoncaptian.RandomTP;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	Logger myPluginLogger = Bukkit.getLogger();
	
	@Override
	public void onEnable()
	{
		myPluginLogger.info("abandon's Random Teleport Enabled");
		myPluginLogger.warning("abandon's Random Teleport is experiencing a fatal error");
	}
	
	@Override
	public void onDisable()
	{
		myPluginLogger.severe("abandon's Random Teleport Disabled");
	}
	
	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel,String[] args)
	{
		if(commandLabel.equalsIgnoreCase("rtp") && theSender instanceof Player)
		{
			Player thePlayer = (Player) theSender;
			int rX = (int) (Math.random() * 10000);
			int rZ = (int) (Math.random() * 10000);
			int rY = (int) thePlayer.getWorld().getHighestBlockYAt(rX, rZ);
			Location randomLocation = new Location(thePlayer.getWorld(), rX, rY, rZ);
			thePlayer.teleport(randomLocation);
			
			if(thePlayer.hasPermission("rtp.descrete")){
			thePlayer.sendMessage(ChatColor.GRAY + "Teleportation Successful!");
			} else {thePlayer.sendMessage(ChatColor.GRAY + "Randomly teleported to X: " + ChatColor.WHITE + rX + ChatColor.GRAY + " Y: " + ChatColor.WHITE + rY + ChatColor.GRAY + " Z: " + ChatColor.WHITE + rZ);}
		}
		
		return  true;
	}
}
