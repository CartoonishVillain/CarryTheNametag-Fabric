package com.cartoonishvillain.CarryNametag;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarryTheNametag implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("carrynametag");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

	}

	public static void doRename(Animal animal1, Animal animal2, AgeableMob ageableMob){
		TextComponent componentcustomName1 = (TextComponent) animal1.getCustomName();
		TextComponent componentcustomName2 = (TextComponent) animal2.getCustomName();

		if(componentcustomName1 != null && componentcustomName2 != null) {
			String customName1 = componentcustomName1.getText();
			String customName2 = componentcustomName2.getText();
			if(customName1.equals(customName2)){
				//the custom names are the same, so this new animal also has the same name.
				ageableMob.setCustomName(new TextComponent(customName1));
			}else{
				String name1 = customName1;
				String name2 = customName2;

				String newname1 = name1.substring(0, name1.length()/2);
				String newname2 = name2.substring(name2.length()/2);

				if(ageableMob.getRandom().nextInt(2) == 1) ageableMob.setCustomName(new TextComponent(newname1 + newname2));
				else ageableMob.setCustomName(new TextComponent(newname2 + newname1));
			}
		}

	}
}
