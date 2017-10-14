package io.samirl.mash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Capture implements Listener {
	private final Plugin plugin;
	private final Mash mash;
	
	public Capture(Plugin plugin, Mash mash) {
		this.plugin = plugin;
		this.mash = mash;
	}
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		
	}

}
