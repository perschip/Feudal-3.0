package me.invertmc.feudal;

import me.invertmc.feudal.commands.BaseCommand;
import me.invertmc.feudal.commands.HelpCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandManager implements CommandExecutor, TabCompleter {

	private final Map<String, BaseCommand> commands = new HashMap<>();

	public CommandManager(JavaPlugin plugin) {
		//commands.put("hello", new HelloCommand());
		//commands.put("goodbye", new GoodbyeCommand());
		commands.put("help", new HelpCommand(commands));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("Usage: /" + label + " <subcommand> [args]");
			return true;
		}

		BaseCommand subCommand = commands.get(args[0].toLowerCase());
		if (subCommand == null) {
			sender.sendMessage("Unknown command. Use /" + label + " help for a list of commands.");
			return true;
		}

		if (!subCommand.onCommand(sender, command, label, args)) {
			sender.sendMessage("Usage: " + subCommand.getUsage());
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) {
			return commands.keySet().stream()
					.filter(cmd -> cmd.startsWith(args[0].toLowerCase()))
					.collect(Collectors.toList());
		}
		if (args.length > 1) {
			BaseCommand subCommand = commands.get(args[0].toLowerCase());
			if (subCommand != null) {
				return subCommand.onTabComplete(sender, command, alias, args);
			}
		}
		return null;
	}
}
