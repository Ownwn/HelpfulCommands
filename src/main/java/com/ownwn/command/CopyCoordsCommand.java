package com.ownwn.command;

import com.mojang.brigadier.CommandDispatcher;
import com.ownwn.BlockUtils;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class CopyCoordsCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("cc").executes(context -> {
            copyBlockCoords(new Vec3i(0, 0, 0));
            return 0;
        }).then(ClientCommandManager.literal("above").executes(context -> {
            copyBlockCoords(new Vec3i(0, 1, 0));
            return 0;
        })));

    }

    public static void copyBlockCoords(Vec3i offset) {
        BlockPos pos = BlockUtils.getBlockCoords(false);
        if (pos == null || MinecraftClient.getInstance().world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
            BlockUtils.sendMessage(Text.literal("Invalid Pos!").setStyle(Style.EMPTY.withColor(Formatting.RED)));
            return;
        }

        BlockUtils.sendMessage(Text.literal("Copied Coords!").setStyle(Style.EMPTY.withColor(Formatting.GREEN)));
        if (offset != null) {
            pos = pos.add(offset);
        }
        MinecraftClient.getInstance().keyboard.setClipboard(BlockUtils.blockToString(pos) + " ");

    }


}
