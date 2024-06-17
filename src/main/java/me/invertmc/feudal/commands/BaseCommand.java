package me.invertmc.feudal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class BaseCommand {
	public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);
	public abstract List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args);
	public abstract String getUsage();
}
