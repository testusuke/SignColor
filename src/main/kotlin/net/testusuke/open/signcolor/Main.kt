package net.testusuke.open.signcolor

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.SignChangeEvent
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by testusuke on 2020/08/04
 * @author testusuke
 */
class Main:JavaPlugin(),Listener {

    companion object{
        lateinit var plugin:Main
    }

    override fun onEnable() {
        plugin = this
        //  Listener
        server.pluginManager.registerEvents(this,this)
    }

    @EventHandler
    fun onCreateSign(event:SignChangeEvent){
        if(!event.player.isOp)return
        event.setLine(0,event.getLine(0)?.replace("&","§"))
        event.setLine(1,event.getLine(1)?.replace("&","§"))
        event.setLine(2,event.getLine(2)?.replace("&","§"))
        event.setLine(3,event.getLine(3)?.replace("&","§"))
        event.player.sendMessage("§a看板のカラーコードを適応しました。")
    }
}