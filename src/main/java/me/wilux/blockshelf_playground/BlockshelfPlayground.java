package me.wilux.blockshelf_playground;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.wilux.blockshelf.api.CustomBlock;
import me.wilux.blockshelf.api.CustomRegistry;
import me.wilux.blockshelf.extentions.GuiAble;
import me.wilux.blockshelf_playground.blocks.*;
import me.wilux.blockshelf_playground.commands.DebugCommand;
import me.wilux.blockshelf_playground.commands.DebugCommand2;
import me.wilux.blockshelf_playground.commands.SetAbility;
import me.wilux.blockshelf_playground.items.WateringCan;
import me.wilux.blockshelf_playground.items.WireSpool;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public class BlockshelfPlayground extends JavaPlugin {

    public static Logger logger;
    public static ProtocolManager protocolManager;
    public static JavaPlugin plugin;

    public static final String UNOBTAINABLE_BLOCK = "ILLEGAL ITEM";
    public static final String CBLOCKNAME_EXDIRT = "exdirt";
    public static final String CBLOCKNAME_INDEXER = "indexer";
    public static HashMap<Player, GuiAble> currentlyOpenInventory;

    @Override
    public void onEnable() {
        //TODO fix GUI registry
        //TODO fix setblock in CustomBlock
        //TODO make armorstands marker ad invisible
        plugin = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        logger = getLogger();

        //Bad way to do it
        //PlayerHacks.hackPlayer();

        super.onEnable();

        //TODO, move to TempStorage
        currentlyOpenInventory = new HashMap<Player, GuiAble>();

        this.getCommand("rpsend").setExecutor(new DebugCommand());
        this.getCommand("rpdelete").setExecutor(new DebugCommand2());
        this.getCommand("setability").setExecutor(new SetAbility());
        //getServer().getPluginManager().registerEvents(new PlaceBlockListener(), this);

        ElectricFurnace.register();
        CoalGenerator.register();
        Press.register();
        Grinder.register();

        WireSpool.register();
        WateringCan.register();

        PacketTesting.init();
        CustomRecipes.init();
        //NMStesting.init();

    }

    @Override
    public void onDisable() {
    }

    static final int GUI_CHEST = 2;
    static final int GUI_STONECUTTER = 22;
}
