package net.builderdog.aether_crystallium.item;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AetherCrystallium.MOD_ID) ;

    public static final RegistryObject<Item> CRYSTAL_GOLD_INGOT = ITEMS.register("crystal_gold_ingot",
            () -> new Item(new Item.Properties()));
       public static final RegistryObject<Item> RAW_CRYSTAL_GOLD = ITEMS.register("raw_crystal_gold",
               () -> new Item(new Item.Properties()));
       public static final RegistryObject<Item> CRYSTAL_GOLD_NUGGET = ITEMS.register("crystal_gold_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AECHOR_PETAL_ICE_CREAM_BUCKET = ITEMS.register("aechor_petal_ice_cream_bucket",
            () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
