package me.invertmc.feudal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HelpCommand extends BaseCommand {

	private final Map<String, BaseCommand> commands;

	public HelpCommand(Map<String, BaseCommand> commands) {
		this.commands = commands;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("Available commands:");
		for (Map.Entry<String, BaseCommand> entry : commands.entrySet()) {
			sender.sendMessage(entry.getKey() + ": " + entry.getValue().getUsage());
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return Collections.emptyList();
	}

	@Override
	public String getUsage() {
		return "/feudal help";
	}
}