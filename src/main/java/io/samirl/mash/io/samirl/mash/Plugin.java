package io.samirl.mash;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	/**
	 * Are we in a MASH instance?
	 */
	public boolean inSession = false;
	
	private Capture chatCapture = new Capture(this, this.getMashInstance());
	private Mash mash = new Mash(this);
	
	/**
	 * We like immutable references!
	 * Mess with the capture class itself if needs be.
	 * 
	 * @return {Capture} our Capture instance
	 */
	public Capture getCapture() {
		return this.chatCapture;
	}
	
	public Mash getMashInstance() {
		return this.mash;
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(null, this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
