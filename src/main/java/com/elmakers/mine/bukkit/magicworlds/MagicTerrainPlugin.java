package com.elmakers.mine.bukkit.magicworlds;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*! \mainpage MagicTerrain Plugin
*
* \section intro_sec Introduction
*
* This is the MagicTerrain plugin for Bukkit.
*
*/

public class MagicTerrainPlugin extends JavaPlugin
{
	/*
	 * Public API
	 */
    public MagicWorldsController getController() {
        return controller;
    }

	/*
	 * Plugin interface
	 */

	public void onEnable() 
	{
		PluginManager pm = getServer().getPluginManager();
		Plugin magicWorlds = pm.getPlugin("MagicWorlds");
        if (magicWorlds == null || !(magicWorlds instanceof MagicWorldsPlugin))
        {
            getLogger().warning("MagicWorlds not found, disabling MagicTerrain");
            pm.disablePlugin(this);
            return;
        }

        controller = ((MagicWorldsPlugin)magicWorlds).getController();
	}

	public void onDisable() 
	{
	}

	/*
	 * Private data
	 */	
	private MagicWorldsController controller = null;
}
