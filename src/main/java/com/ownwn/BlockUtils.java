package com.ownwn;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;

public class BlockUtils {

    public static BlockPos getBlockCoords(boolean getSide) {

        BlockHitResult raycast = (BlockHitResult) MinecraftClient.getInstance().player.raycast(100, 1f / 20f, true);
        BlockPos pos = raycast.getBlockPos();
        if (getSide) {
            pos = pos.offset(raycast.getSide());
        }
        return pos;
    }


    public static String blockToString(BlockPos pos) {
        String coordString = "";
        coordString+= pos.getX();
        coordString+= " ";
        coordString+= pos.getY();
        coordString+= " ";
        coordString+= pos.getZ();
        return coordString;
    }

    public static void sendMessage(Text text) {
        if (MinecraftClient.getInstance().player == null) {
            return;
        }
        MinecraftClient.getInstance().player.sendMessage(text, true);
    }


}
