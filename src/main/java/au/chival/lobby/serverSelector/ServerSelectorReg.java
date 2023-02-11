package au.chival.lobby.serverSelector;

import static au.chival.lobby.Main.plugin;

public class ServerSelectorReg {
    public ServerSelectorReg() {
        plugin.getServer().getPluginManager().registerEvents(new ServerSelectorGUI(), plugin);
    }
}
