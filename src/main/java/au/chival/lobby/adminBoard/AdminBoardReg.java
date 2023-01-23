package au.chival.lobby.adminBoard;

import static au.chival.lobby.Main.plugin;

public class AdminBoardReg {
    public AdminBoardReg() {
        plugin.getServer().getPluginManager().registerEvents(new AdminBoardGUI(), plugin);
    }
}
