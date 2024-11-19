package kr.jimin.disableJoinMessage

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin

class DisableJoinMessage : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        e.joinMessage = ""
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        e.quitMessage = ""
    }
}