package net.builderdog.ancient_aether.data.generators.loot;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class AncientAetherChestLoot implements LootTableSubProvider {
    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> builder) {

        builder.accept(AncientAetherLoot.CHESTS_CAMP_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_SHOVEL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_AXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_SHOVEL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_AXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.HOLYSTONE_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BOAT.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_CHEST_BOAT.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER_HELMET))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE))
                        .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS))
                        .add(LootItem.lootTableItem(Items.LEATHER_BOOTS))
                        .add(LootItem.lootTableItem(AetherItems.LEATHER_GLOVES.get()))
                        .add(LootItem.lootTableItem(Items.SADDLE))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_MILK_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.AMBROSIUM_CAMPFIRE.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_CAMP_SKYROOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_CAMP_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(Blocks.WHITE_WOOL).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_CAMP_WYNDCAPS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_CAMP_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.FLUFFALO_WOOL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_SETTLEMENT_SKYROOT_GENERIC, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(6.0F, 12.0F))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_BERRY.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AncientAetherItems.GRAPES.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.SUGAR).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.AECHOR_PETAL.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_AMBER.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BUCKET.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_MILK_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_MOA_EGG.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_SETTLEMENT_SKYROOT_SHOP, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_SETTLEMENT_SKYROOT_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER_HELMET))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE))
                        .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS))
                        .add(LootItem.lootTableItem(Items.LEATHER_BOOTS))
                        .add(LootItem.lootTableItem(AetherItems.LEATHER_GLOVES.get()))
                        .add(LootItem.lootTableItem(Items.SADDLE))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_SETTLEMENT_SKYROOT_LIBRARY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_SETTLEMENT_SKYROOT_GENERIC))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(Items.BOOK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.SKYROOT_BOOKSHELF.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_SETTLEMENT_SECRET, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_CHINCHILLA.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_HIGH.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 2.0F))
                        .add(LootItem.lootTableItem(Items.PAPER).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.BOOK).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_SWORD.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_SHOVEL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PICKAXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_AXE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_RING.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PENDANT.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_ARMOR_TRIMS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherItems.WYND_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.WHALE_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.ASCENDED_ARMOR_TRIM_SMITHING_TEMPLATE.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_COMMON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.BLUE_MOA_EGG.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.TURQUOISE_MOA_EGG.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.SKY_BLUE_MOA_EGG.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_UNCOMMON, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_MOA_EGG.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AncientAetherItems.TEAL_MOA_EGG.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.LAVENDER_MOA_EGG.get()).setWeight(2))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_RARE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AetherItems.BLACK_MOA_EGG.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AncientAetherItems.BURGUNDY_MOA_EGG.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AncientAetherItems.SAKURA_MOA_EGG.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.VIOLET_MOA_EGG.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_LOOT).setWeight(6))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_SUPPLIES).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_MISCELLANEOUS).setWeight(2))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 4.0F))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.QUARTZ).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.AEROGEL.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_HOE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_SWORD.get()).setWeight(8))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_SHOVEL.get()).setWeight(6))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_AXE.get()).setWeight(6))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_PICKAXE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GLOVES.get()).setWeight(5))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_COMMON).setWeight(4))
                        .add(LootItem.lootTableItem(AetherItems.NATURE_STAFF.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_HELMET.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_BOOTS.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_CHESTPLATE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_LEGGINGS.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_ARMOR_TRIMS))
                        .add(LootItem.lootTableItem(AetherItems.GRAVITITE_HOE.get()))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(AetherBlocks.AMBROSIUM_TORCH.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_BUCKET.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_SUPPLIES, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.AMBROSIUM_SHARD.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.ICESTONE.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GEMSTONE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_HOE.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherItems.NATURE_STAFF.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherBlocks.PRESENT.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GLOVES.get()).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_COMMON))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE_SWORD.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3.0F, 5.0F))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.AECHOR_PETAL.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AncientAetherItems.FESTIVE_GUMMY_SWET.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.GINGERBREAD_MAN.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 8.0F))))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.SUGAR).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_REMEDY_BUCKET.get()))
                        .add(LootItem.lootTableItem(AetherItems.SKYROOT_MILK_BUCKET.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_MISCELLANEOUS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
                        .add(LootItem.lootTableItem(AetherBlocks.COLD_AERCLOUD.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.BLUE_AERCLOUD.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.VIOLET_AERCLOUD.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.WIND_BLOWER.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherBlocks.SLIDER_PROTOTYPE.get()))
                        .add(LootItem.lootTableItem(AetherItems.GOLDEN_PARACHUTE.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.PRESENT.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherItems.GINGERBREAD_MAN.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_STRAD).setWeight(2))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_COMMON))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE_SWORD.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                )
        );

        builder.accept(AncientAetherLoot.CHESTS_DUNGEON_SENTRY_LABORATORY_REWARD, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(6.0F, 9.0F))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_RING.get()).setWeight(4))
                        .add(LootItem.lootTableItem(AncientAetherItems.HERMES_PENDANT.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.ARKENIUM_RING.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.ARKENIUM_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.CLOUD_STAFF.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE_SWORD.get()).setWeight(3))
                        .add(LootItem.lootTableItem(AncientAetherItems.MECHANICAL_ARMOR_TRIM_SMITHING_TEMPLATE.get()).setWeight(3))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_MOA_EGGS_COMMON).setWeight(2))
                        .add(LootItem.lootTableItem(AetherItems.GRAVITITE_HOE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(AetherBlocks.ENCHANTED_GRAVITITE.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(AetherBlocks.PRESENT.get()).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootTableReference.lootTableReference(AncientAetherLoot.CHESTS_DUNGEON_ARMOR_TRIMS))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_HELMET.get()))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_CHESTPLATE.get()))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_LEGGINGS.get()))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_BOOTS.get()))
                        .add(LootItem.lootTableItem(AetherItems.ZANITE_GLOVES.get()))
                        .add(LootItem.lootTableItem(AetherItems.ICE_RING.get()))
                        .add(LootItem.lootTableItem(AetherItems.ICE_PENDANT.get()))
                        .add(LootItem.lootTableItem(AetherItems.POISON_DART_SHOOTER.get()))
                        .add(LootItem.lootTableItem(AetherItems.MUSIC_DISC_AETHER_TUNE.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 1.0F))
                        .add(LootItem.lootTableItem(AncientAetherItems.SHIELD_OF_INEBRIATION.get()))
                        .add(LootItem.lootTableItem(AncientAetherItems.SHIELD_OF_REMEDIATION.get()))
                )
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 3.0F))
                        .add(LootItem.lootTableItem(AncientAetherItems.FESTIVE_GUMMY_SWET.get()).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.ENCHANTED_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.GINGERBREAD_MAN.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F))))
                        .add(LootItem.lootTableItem(AetherItems.CANDY_CANE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                        .add(LootItem.lootTableItem(AetherItems.HEALING_STONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))))
                        .add(LootItem.lootTableItem(AetherItems.WHITE_APPLE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
                )
        );
    }
}