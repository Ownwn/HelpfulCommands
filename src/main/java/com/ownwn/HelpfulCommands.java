package com.ownwn;

import com.ownwn.command.CopyCoordsCommand;
import com.ownwn.command.TpToCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class HelpfulCommands implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ClientCommandRegistrationCallback.EVENT.register((dispatcher, access) -> {
			CopyCoordsCommand.register(dispatcher);
			TpToCommand.register(dispatcher);

		});
	}
}