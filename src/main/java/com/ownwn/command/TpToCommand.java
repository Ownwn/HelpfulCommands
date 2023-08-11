package com.ownwn.command;

import com.mojang.brigadier.CommandDispatcher;
import com.ownwn.BlockUtils;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class TpToCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("tpto").executes(context -> {
            BlockPos pos = BlockUtils.getBlockCoords(true);
            MinecraftClient.getInstance().getNetworkHandler().sendCommand("tp " + BlockUtils.blockToString(pos));
            return 0;
        }));
    }
}
