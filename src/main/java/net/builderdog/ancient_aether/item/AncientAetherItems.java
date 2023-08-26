package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.api.AetherMoaTypes;
import com.aetherteam.aether.item.miscellaneous.AetherRecordItem;
import com.aetherteam.aether.item.miscellaneous.DungeonKeyItem;
import com.aetherteam.aether.item.miscellaneous.MoaEggItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.client.AncientAetherSoundEvents;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.aetherteam.aether.item.AetherItems.AETHER_LOOT;

public class AncientAetherItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MOD_ID) ;

    public static final Component ANCIENT_DUNGEON_TOOLTIP = Component.translatable("ancient_aether.dungeon.ancient_dungeon").withStyle(Style.EMPTY.withItalic(true).withColor(TextColor.parseColor("#3A466B")));

    //Misc
    public static final RegistryObject<Item> ANCIENT_SENTRY_RUNE = ITEMS.register("ancient_sentry_rune",
            () -> new Item(new Item.Properties().rarity(AETHER_LOOT)));
    public static final RegistryObject<Item> ANCIENT_DUNGEON_KEY = ITEMS.register("ancient_dungeon_key",
            () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MOD_ID, "ancient"), new Item.Properties().stacksTo(1).rarity(AETHER_LOOT).fireResistant()));

    //Dungeon Loot
    public static final RegistryObject<SwordItem> ANCIENT_SWORD = ITEMS.register("ancient_sword", () -> new AncientSwordItem().addDungeonTooltip(ANCIENT_DUNGEON_TOOLTIP));

    //Signs
    public static final RegistryObject<Item> HIGHSPROOT_SIGN = ITEMS.register("highsproot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get()));
    public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()));

    //Food
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> RAW_BUFFALO_RIBS = ITEMS.register("raw_buffalo_ribs",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).build())));
    public static final RegistryObject<Item> COOKED_BUFFALO_RIBS = ITEMS.register("cooked_buffalo_ribs",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(1.2f).build())));
    public static final RegistryObject<Item> BUFFALO_RIB = ITEMS.register("buffalo_rib",
            () -> new BuffaloRib(new Item.Properties().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.25f).build())));

    //Boats
    public static final RegistryObject<Item> HIGHSPROOT_BOAT = ITEMS.register("highsproot_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> HIGHSPROOT_CHEST_BOAT = ITEMS.register("highsproot_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));
    public static final RegistryObject<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));


    //Spawn Eggs
    public static final RegistryObject<SpawnEggItem> HIGHLAND_BUFFALO_SPAWN_EGG = ITEMS.register("highland_buffalo_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.HIGHLAND_BUFFALO, 0x4B6F89, 0x96C4D3, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ROOTHYRN_SPAWN_EGG = ITEMS.register("roothyrn_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.ROOTHYRN, 0x737558, 0x6FA871, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> LEAPING_SENTRY_SPAWN_EGG = ITEMS.register("leaping_sentry_spawn_egg",
            () -> new ForgeSpawnEggItem(AncientAetherEntities.LEAPING_SENTRY, 0x808080, 0xE072D7, new Item.Properties()));
    public static final RegistryObject<Item> SAKURA_MOA_EGG = ITEMS.register("sakura_moa_egg",
            () -> new MoaEggItem(AncientAetherMoaTypes.SAKURA, 0xD09FA9, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
