package io.samirl.mash;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mash implements CommandExecutor {
	private final Plugin plugin;
	private File directory = new File(System.getProperty("user.dir"));
	private File file;
	private String[] history;
	public String[] commands = {"ls", "cd", "ed", "rm", "!!"};
	public Map<String, Boolean> status = new HashMap<String, Boolean>();
	
	public Mash(Plugin plugin) {
		this.plugin = plugin;
		this.history = null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("MASH cannot yet be used through the console. Apologies for any inconvienience.");
			return false;
		}
		sender.sendMessage("Minecraft Adjusted SHell, version 1.0.0 - initialized.");
		// this.asyncShell();
		return false;
	}
	
	private void shell(String command) {
		String[] commandChain = command.split(" ");
		String topCommand = commandChain[0];
		String arguments = commandChain[1];
		if(!Stream.of(this.commands).anyMatch(x -> x == topCommand)) {
			this.status.put("mash: error: could not find command " + topCommand, false);
			return;
		}
		
		if(topCommand.contains("!!")) {
			
		}
		// Do the command.
		switch(topCommand) {
		case "ls":
			String[] files = {};
			for(File f : directory.listFiles()) {
				files[files.length] = f.getName();
				this.status.put(f.getName(), true);
			}
			this.status.put(Integer.toString(files.length), true); 
			break;
		}
		this.history[this.history.length] = command;
	}
}
