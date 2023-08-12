package com.ownwn.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;

public class FillCubeCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {

        dispatcher.register(ClientCommandManager.literal("fillcube")

                .then(ClientCommandManager.argument("radius", IntegerArgumentType.integer(1, 100))
                        // radius of 500 is the most minecraft will allow, but you shouldn't do that unless you're running a supercomputer (1 billion blocks)

                        .then(ClientCommandManager.argument("block", StringArgumentType.string())
                                .executes((context) -> {
                                    runFill(IntegerArgumentType.getInteger(context, "radius"), StringArgumentType.getString(context, "block"));
                                    return 1;
                                }))));
    }

    public static void runFill(int radius, String blockName) {

        String cubeCoords = String.format("~-%d ~-%d ~-%d ~%d ~%d ~%d", radius, radius, radius, radius, radius, radius);
        MinecraftClient.getInstance().getNetworkHandler().sendCommand("fill " + cubeCoords + " " + blockName);
    }
}
