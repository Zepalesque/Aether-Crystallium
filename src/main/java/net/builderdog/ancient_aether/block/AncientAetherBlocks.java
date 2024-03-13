package net.builderdog.ancient_aether.block;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.block.construction.BookshelfBlock;
import com.aetherteam.aether.block.dungeon.DoorwayBlock;
import com.aetherteam.aether.block.dungeon.TrappedBlock;
import com.aetherteam.aether.block.dungeon.TreasureDoorwayBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import com.aetherteam.aether.block.natural.AetherDoubleDropsOreBlock;
import com.aetherteam.aether.block.natural.AetherLogBlock;
import com.aetherteam.aether.blockentity.AltarBlockEntity;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.blocktype.*;
import net.builderdog.ancient_aether.data.resources.AncientAetherLoot;
import net.builderdog.ancient_aether.entity.AncientAetherEntityTypes;
import net.builderdog.ancient_aether.item.AncientAetherItems;
import net.builderdog.ancient_aether.world.treegrower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.aetherteam.aether.block.AetherBlocks.*;
import static net.minecraft.world.level.block.Blocks.*;

@SuppressWarnings("deprecation")
public class AncientAetherBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AncientAether.MODID);

    public static final RegistryObject<Block> GRAVITY_GRAVEL = registerBlock("gravity_gravel", () -> new AetherDoubleDropBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).jumpFactor(1.5F).strength(0.25F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WYND_ICE = registerBlock("wynd_ice", () -> new Block(Block.Properties.copy(PACKED_ICE)));

    public static final RegistryObject<Block> AETHER_QUARTZ_ORE = registerBlock("aether_quartz_ore", () -> new AetherDoubleDropsOreBlock(Block.Properties.copy(NETHER_QUARTZ_ORE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> VALKYRUM_ORE = registerBlock("valkyrum_ore", () -> new ValkyrumBlock(Block.Properties.of().strength(4.0F, 4.0F).requiresCorrectToolForDrops().mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<Block> ATMOSINE_CRYSTAL = registerBlock("atmosine_crystal", () -> new AtmosineCrystalBlock(false, BlockBehaviour.Properties.of().strength(3.0F, 3.0F).mapColor(MapColor.NONE).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 10)));

    public static final RegistryObject<Block> CRYSTAL_SKYROOT_LEAVES = registerBlock("crystal_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(CRYSTAL_LEAVES.get())));
    public static final RegistryObject<Block> ENCHANTED_SKYROOT_LEAVES = registerBlock("enchanted_skyroot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).mapColor(MapColor.LAPIS).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> SKYROOT_PINE_LEAVES = registerBlock("skyroot_pine_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get())));
    public static final RegistryObject<Block> HIGHSPROOT_LEAVES = registerBlock("highsproot_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).mapColor(MapColor.TERRACOTTA_BLUE).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> SAKURA_LEAVES = registerBlock("sakura_leaves", () -> new AetherDoubleDropsLeaves(BlockBehaviour.Properties.copy(SKYROOT_LEAVES.get()).sound(SoundType.CHERRY_LEAVES).mapColor(MapColor.COLOR_PINK).isValidSpawn(AncientAetherBlocks::ocelotOrParrot).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));

    public static final RegistryObject<Block> CRYSTAL_SKYROOT_SAPLING = registerBlock("crystal_skyroot_sapling", () -> new SaplingBlock(new CrystalSkyrootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.DIAMOND)));
    public static final RegistryObject<Block> ENCHANTED_SKYROOT_SAPLING = registerBlock("enchanted_skyroot_sapling", () -> new SaplingBlock(new EnchantedSkyrootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.LAPIS)));
    public static final RegistryObject<Block> SKYROOT_PINE_SAPLING = registerBlock("skyroot_pine_sapling", () -> new SaplingBlock(new SkyrootPineTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get())));
    public static final RegistryObject<Block> HIGHSPROOT_SAPLING = registerBlock("highsproot_sapling", () -> new SaplingBlock(new HighsprootTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.TERRACOTTA_BLUE)));
    public static final RegistryObject<Block> SAKURA_SAPLING = registerBlock("sakura_sapling", () -> new SaplingBlock(new SakuraTreeGrower(), BlockBehaviour.Properties.copy(SKYROOT_SAPLING.get()).mapColor(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> SKY_GRASS = registerBlock("sky_grass", () -> new SkyGrassBlock(Block.Properties.copy(GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> HIGHLAND_VIOLA = registerBlock("highland_viola", () -> new FlowerBlock(() -> MobEffects.REGENERATION, 4, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> SKY_BLUES = registerBlock("sky_blues", () -> new FlowerBlock(() -> MobEffects.POISON, 4, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> WYND_THISTLE = registerBlock("wynd_thistle", () -> new FlowerBlock(() -> MobEffects.HARM, 4, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> SAKURA_BLOSSOMS = registerBlock("sakura_blossoms", () -> new FlowerBlock(() -> MobEffects.HEALTH_BOOST, 4, Block.Properties.copy(WHITE_FLOWER.get())));
    public static final RegistryObject<Block> TRAPPED_SAKURA_BLOSSOMS = registerBlock("trapped_sakura_blossoms", () -> new TrappedFlowerBlock(AncientAetherEntityTypes.ROOTHYRN::get, AIR::defaultBlockState, Block.Properties.copy(SAKURA_BLOSSOMS.get())));
    public static final RegistryObject<Block> GRAPE_VINE = BLOCKS.register("grape_vine", () -> new GrapeVineBlock(Block.Properties.copy(VINE).noLootTable()));

    public static final RegistryObject<Block> HIGHSPROOT_LOG = registerBlock("highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_LOG.get())));
    public static final RegistryObject<Block> HIGHSPROOT_WOOD = registerBlock("highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_WOOD.get())));
    public static final RegistryObject<Block> STRIPPED_HIGHSPROOT_LOG = registerBlock("stripped_highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_HIGHSPROOT_WOOD = registerBlock("stripped_highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_WOOD.get())));
    public static final RegistryObject<Block> SAKURA_LOG = registerBlock("sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_LOG.get())));
    public static final RegistryObject<Block> SAKURA_WOOD = registerBlock("sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(SKYROOT_WOOD.get())));
    public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = registerBlock("stripped_sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = registerBlock("stripped_sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.copy(STRIPPED_SKYROOT_WOOD.get())));

    public static final RegistryObject<WallBlock> HIGHSPROOT_LOG_WALL = registerBlock("highsproot_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> HIGHSPROOT_WOOD_WALL = registerBlock("highsproot_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_LOG_WALL = registerBlock("stripped_highsproot_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_HIGHSPROOT_WOOD_WALL = registerBlock("stripped_highsproot_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> SAKURA_LOG_WALL = registerBlock("sakura_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> SAKURA_WOOD_WALL = registerBlock("sakura_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_LOG_WALL = registerBlock("stripped_sakura_log_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<WallBlock> STRIPPED_SAKURA_WOOD_WALL = registerBlock("stripped_sakura_wood_wall", () -> new WallBlock(Block.Properties.copy(SKYROOT_FENCE.get())));

    public static final RegistryObject<Block> HIGHSPROOT_PLANKS = registerBlock("highsproot_planks", () -> new Block(BlockBehaviour.Properties.copy(SKYROOT_PLANKS.get())));
    public static final RegistryObject<Block> HIGHSPROOT_STAIRS = registerBlock("highsproot_stairs", () -> new StairBlock(() -> HIGHSPROOT_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(SKYROOT_STAIRS.get()))));
    public static final RegistryObject<Block> HIGHSPROOT_SLAB = registerBlock("highsproot_slab", () -> new SlabBlock(Block.Properties.copy(SKYROOT_SLAB.get())));
    public static final RegistryObject<FenceBlock> HIGHSPROOT_FENCE = registerBlock("highsproot_fence", () -> new FenceBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<FenceGateBlock> HIGHSPROOT_FENCE_GATE = registerBlock("highsproot_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(SKYROOT_FENCE_GATE.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<DoorBlock> HIGHSPROOT_DOOR = registerBlock("highsproot_door", () -> new DoorBlock(Block.Properties.copy(SKYROOT_DOOR.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> HIGHSPROOT_TRAPDOOR = registerBlock("highsproot_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(SKYROOT_TRAPDOOR.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> HIGHSPROOT_BUTTON = registerBlock("highsproot_button", () -> new ButtonBlock(Block.Properties.copy(SKYROOT_BUTTON.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> HIGHSPROOT_PRESSURE_PLATE = registerBlock("highsproot_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(SKYROOT_PRESSURE_PLATE.get()), AncientAetherBlockSets.HIGHSPROOT_BLOCK_SET));
    public static final RegistryObject<Block> HIGHSPROOT_SIGN = BLOCKS.register("highsproot_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(SKYROOT_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<Block> HIGHSPROOT_WALL_SIGN = BLOCKS.register("highsproot_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<CeilingHangingSignBlock> HIGHSPROOT_HANGING_SIGN = BLOCKS.register("highsproot_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_HANGING_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<WallHangingSignBlock> HIGHSPROOT_WALL_HANGING_SIGN = BLOCKS.register("highsproot_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_HANGING_SIGN.get()), AncientAetherBlockSets.HIGHSPROOT));
    public static final RegistryObject<Block> HIGHSPROOT_BOOKSHELF = registerBlock("highsproot_bookshelf", () -> new BookshelfBlock(Block.Properties.copy(SKYROOT_BOOKSHELF.get())));

    public static final RegistryObject<Block> SAKURA_PLANKS = registerBlock("sakura_planks", () -> new Block(BlockBehaviour.Properties.copy(SKYROOT_PLANKS.get())));
    public static final RegistryObject<Block> SAKURA_STAIRS = registerBlock("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(SKYROOT_STAIRS.get()))));
    public static final RegistryObject<Block> SAKURA_SLAB = registerBlock("sakura_slab", () -> new SlabBlock(Block.Properties.copy(SKYROOT_SLAB.get())));
    public static final RegistryObject<FenceBlock> SAKURA_FENCE = registerBlock("sakura_fence", () -> new FenceBlock(Block.Properties.copy(SKYROOT_FENCE.get())));
    public static final RegistryObject<FenceGateBlock> SAKURA_FENCE_GATE = registerBlock("sakura_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(SKYROOT_FENCE_GATE.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<DoorBlock> SAKURA_DOOR = registerBlock("sakura_door", () -> new DoorBlock(Block.Properties.copy(SKYROOT_DOOR.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> SAKURA_TRAPDOOR = registerBlock("sakura_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(SKYROOT_TRAPDOOR.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> SAKURA_BUTTON = registerBlock("sakura_button", () -> new ButtonBlock(Block.Properties.copy(SKYROOT_BUTTON.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> SAKURA_PRESSURE_PLATE = registerBlock("sakura_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(SKYROOT_PRESSURE_PLATE.get()), AncientAetherBlockSets.SAKURA_BLOCK_SET));
    public static final RegistryObject<Block> SAKURA_SIGN = BLOCKS.register("sakura_sign", () -> new AncientAetherSignBlock(BlockBehaviour.Properties.copy(SKYROOT_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<Block> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new AncientAetherWallSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<CeilingHangingSignBlock> SAKURA_HANGING_SIGN = BLOCKS.register("sakura_hanging_sign", () -> new AncientAetherCeilingHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_HANGING_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<WallHangingSignBlock> SAKURA_WALL_HANGING_SIGN = BLOCKS.register("sakura_wall_hanging_sign", () -> new AncientAetherWallHangingSignBlock(BlockBehaviour.Properties.copy(SKYROOT_WALL_HANGING_SIGN.get()), AncientAetherBlockSets.SAKURA));
    public static final RegistryObject<Block> SAKURA_BOOKSHELF = registerBlock("sakura_bookshelf", () -> new BookshelfBlock(Block.Properties.copy(SKYROOT_BOOKSHELF.get())));

    public static final RegistryObject<Block> VALKYRUM_BLOCK = registerBlock("valkyrum_block", () -> new ValkyrumBlock(Block.Properties.copy(ZANITE_BLOCK.get()).strength(6.0F, 8.0F).mapColor(MapColor.QUARTZ)));
    public static final RegistryObject<GlassBlock> AEROGEL_GLASS = registerBlock("aerogel_glass", () -> new GlassBlock(Block.Properties.copy(AEROGEL.get()).isRedstoneConductor(AncientAetherBlocks::never).isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<IronBarsBlock> AEROGEL_GLASS_PANE = registerBlock("aerogel_glass_pane", () -> new IronBarsBlock(Block.Properties.copy(AEROGEL_GLASS.get())));
    public static final RegistryObject<DoorBlock> AEROGEL_GLASS_DOOR = registerBlock("aerogel_glass_door", () -> new DoorBlock(Block.Properties.copy(AEROGEL_GLASS.get()), AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> AEROGEL_GLASS_TRAPDOOR = registerBlock("aerogel_glass_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(AEROGEL_GLASS.get()), AncientAetherBlockSets.AEROGEL_GLASS_BLOCK_SET));
    public static final RegistryObject<Block> FLUFFALO_WOOL = registerBlock("fluffalo_wool", () -> new Block(BlockBehaviour.Properties.copy(WHITE_WOOL).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> FLUFFALO_CARPET = registerBlock("fluffalo_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(FLUFFALO_WOOL.get())));

    public static final RegistryObject<Block> CARVED_TILES = registerBlock("carved_tiles", () -> new Block(Block.Properties.copy(CARVED_STONE.get())));
    public static final RegistryObject<Block> WYND_SENTRY_STONE = registerBlock("wynd_sentry_stone", () -> new Block(Block.Properties.copy(SENTRY_STONE.get()).lightLevel(s -> 7)));
    public static final RegistryObject<Block> CARVED_TILE_STAIRS = registerBlock("carved_tile_stairs", () -> new StairBlock(() -> CARVED_TILES.get().defaultBlockState(), (Block.Properties.copy(CARVED_TILES.get()))));
    public static final RegistryObject<Block> CARVED_TILE_SLAB = registerBlock("carved_tile_slab", () -> new SlabBlock(Block.Properties.copy(CARVED_TILES.get())));
    public static final RegistryObject<Block> CARVED_TILE_WALL = registerBlock("carved_tile_wall", () -> new WallBlock(Block.Properties.copy(CARVED_TILES.get())));

    public static final RegistryObject<Block> AEROGETIC_STONE = registerBlock("aerogetic_stone", () -> new Block(Block.Properties.copy(CARVED_STONE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_AEROGETIC_STONE = registerBlock("light_aerogetic_stone", () -> new Block(Block.Properties.copy(AEROGETIC_STONE.get()).lightLevel(s -> 11)));
    public static final RegistryObject<Block> CORRUPTED_AEROGETIC_STONE = registerBlock("corrupted_aerogetic_stone", () -> new Block(Block.Properties.copy(LIGHT_AEROGETIC_STONE.get())));
    public static final RegistryObject<Block> AEROGETIC_STAIRS = registerBlock("aerogetic_stairs", () -> new StairBlock(() -> AEROGETIC_STONE.get().defaultBlockState(), (Block.Properties.copy(AEROGETIC_STONE.get()))));
    public static final RegistryObject<Block> AEROGETIC_SLAB = registerBlock("aerogetic_slab", () -> new SlabBlock(Block.Properties.copy(AEROGETIC_STONE.get())));
    public static final RegistryObject<Block> AEROGETIC_WALL = registerBlock("aerogetic_wall", () -> new WallBlock(Block.Properties.copy(AEROGETIC_STONE.get())));

    public static final RegistryObject<Block> LOCKED_CARVED_TILES = registerBlock("locked_carved_tiles", () -> new Block(Block.Properties.copy(CARVED_TILES.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_WYND_SENTRY_STONE = registerBlock("locked_wynd_sentry_stone", () -> new Block(Block.Properties.copy(WYND_SENTRY_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_AEROGETIC_STONE = registerBlock("locked_aerogetic_stone", () -> new Block(Block.Properties.copy(AEROGETIC_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> LOCKED_LIGHT_AEROGETIC_STONE = registerBlock("locked_light_aerogetic_stone", () -> new Block(Block.Properties.copy(LOCKED_AEROGETIC_STONE.get()).lightLevel(s -> 11).noLootTable()));
    public static final RegistryObject<Block> LOCKED_CORRUPTED_AEROGETIC_STONE = registerBlock("locked_corrupted_aerogetic_stone", () -> new Block(Block.Properties.copy(LOCKED_LIGHT_AEROGETIC_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> TRAPPED_CARVED_TILES = registerBlock("trapped_carved_tiles", () -> new TrappedBlock(AetherEntityTypes.SENTRY::get, () -> CARVED_TILES.get().defaultBlockState(), Block.Properties.copy(CARVED_TILES.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_AEROGETIC_STONE = registerBlock("trapped_aerogetic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.copy(AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_LIGHT_AEROGETIC_STONE = registerBlock("trapped_light_aerogetic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> LIGHT_AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.copy(LIGHT_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TRAPPED_CORRUPTED_AEROGETIC_STONE = registerBlock("trapped_corrupted_aerogetic_stone", () -> new TrappedBlock(AncientAetherEntityTypes.AERONAUTIC_LEAPER::get, () -> CORRUPTED_AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.copy(CORRUPTED_AEROGETIC_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> BOSS_DOORWAY_WYND_SENTRY_STONE = registerBlock("boss_doorway_wynd_sentry_stone", () -> new DoorwayBlock(AncientAetherEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.copy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_AEROGETIC_STONE = registerBlock("boss_doorway_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_LIGHT_AEROGETIC_STONE = registerBlock("boss_doorway_light_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_LIGHT_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> BOSS_DOORWAY_CORRUPTED_AEROGETIC_STONE = registerBlock("boss_doorway_corrupted_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.copy(LOCKED_CORRUPTED_AEROGETIC_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> TREASURE_DOORWAY_WYND_SENTRY_STONE = registerBlock("treasure_doorway_wynd_sentry_stone", () -> new TreasureDoorwayBlock(Block.Properties.copy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_AEROGETIC_STONE = registerBlock("treasure_doorway_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_LIGHT_AEROGETIC_STONE = registerBlock("treasure_doorway_light_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_LIGHT_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<Block> TREASURE_DOORWAY_CORRUPTED_AEROGETIC_STONE = registerBlock("treasure_doorway_corrupted_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.copy(LOCKED_CORRUPTED_AEROGETIC_STONE.get()).noLootTable()));

    public static final RegistryObject<RotatedPillarBlock> HOLYSTONE_BRICK_MOSAIC = registerBlock("holystone_brick_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HOLYSTONE_BRICKS.get())));
    public static final RegistryObject<RotatedPillarBlock> CARVED_STONE_MOSAIC = registerBlock("carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> ANGELIC_STONE_MOSAIC = registerBlock("angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.ANGELIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> HELLFIRE_STONE_MOSAIC = registerBlock("hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.HELLFIRE_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> AEROGETIC_STONE_MOSAIC = registerBlock("aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AEROGETIC_STONE.get())));
    public static final RegistryObject<RotatedPillarBlock> GALE_STONE_MOSAIC = registerBlock("gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(AetherBlocks.CARVED_STONE.get())));

    public static final RegistryObject<RotatedPillarBlock> LOCKED_CARVED_STONE_MOSAIC = registerBlock("locked_carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_ANGELIC_STONE_MOSAIC = registerBlock("locked_angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_ANGELIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_HELLFIRE_STONE_MOSAIC = registerBlock("locked_hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_HELLFIRE_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_AEROGETIC_STONE_MOSAIC = registerBlock("locked_aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final RegistryObject<RotatedPillarBlock> LOCKED_GALE_STONE_MOSAIC = registerBlock("locked_gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.copy(LOCKED_CARVED_STONE.get()).noLootTable()));

    public static final RegistryObject<Block> AMBROSIUM_LANTERN = registerBlock("ambrosium_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 15)));
    public static final RegistryObject<Block> WYND_LANTERN = registerBlock("wynd_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 7)));
    public static final RegistryObject<Block> SUN_LANTERN = registerBlock("sun_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(LANTERN).lightLevel(s -> 12)));
    public static final RegistryObject<Block> AMBROSIUM_CAMPFIRE = registerBlock("ambrosium_campfire", () -> new AmbrosiumCampfireBlock(true, 1, Block.Properties.copy(Blocks.CAMPFIRE)));

    public static final RegistryObject<Block> VIOLET_AERCLOUD = registerBlock("violet_aercloud", () -> new VioletAercloudBlock(BlockBehaviour.Properties.copy(COLD_AERCLOUD.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> WIND_BLOWER = registerBlock("wind_blower", () -> new WindBlowerBlock(BlockBehaviour.Properties.copy(COLD_AERCLOUD.get())));
    public static final RegistryObject<Block> SLIDER_PROTOTYPE = registerBlock("slider_prototype", () -> new SliderPrototypeBlock(BlockBehaviour.Properties.copy(CARVED_STONE.get()).strength(5f).noOcclusion()));
    public static final RegistryObject<Block> UNPOWERED_ANCIENT_OBELISK = registerBlock("unpowered_ancient_obelisk", () -> new ObeliskBlock(BlockBehaviour.Properties.copy(STONE).sound(SoundType.STONE).lightLevel(s -> 3).noLootTable().strength(-1.0F, 3600000.0F).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_OBELISK = registerBlock("ancient_obelisk", () -> new Block(BlockBehaviour.Properties.copy(AEROGETIC_STONE.get()).strength(5f).lightLevel(s -> 12).noOcclusion()));

    public static final RegistryObject<Block> HOLYSTONE_VASE = registerBlock("holystone_vase", () -> new VaseBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().sound(SoundType.DECORATED_POT).noOcclusion().isSuffocating(AncientAetherBlocks::never).isViewBlocking(AncientAetherBlocks::never)));
    public static final RegistryObject<Block> MOSSY_HOLYSTONE_VASE = registerBlock("mossy_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> FROZEN_HOLYSTONE_VASE = registerBlock("frozen_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> SENTRY_VASE = registerBlock("sentry_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> ANGELIC_VASE = registerBlock("angelic_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> HELLFIRE_VASE = registerBlock("hellfire_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> AEROGETIC_VASE = registerBlock("aerogetic_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));
    public static final RegistryObject<Block> GALE_VASE = registerBlock("gale_vase", () -> new VaseBlock(BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get())));

    public static final RegistryObject<Block> ANCIENT_HOLYSTONE_VASE = registerBlock("ancient_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(HOLYSTONE_VASE.get()).sound(SoundType.DECORATED_POT_CRACKED).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_MOSSY_HOLYSTONE_VASE = registerBlock("ancient_mossy_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_MOSSY_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_FROZEN_HOLYSTONE_VASE = registerBlock("ancient_frozen_holystone_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_FROZEN_HOLYSTONE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_SENTRY_VASE = registerBlock("ancient_sentry_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_SENTRY_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_ANGELIC_VASE = registerBlock("ancient_angelic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_ANGELIC_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_HELLFIRE_VASE = registerBlock("ancient_hellfire_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_HELLFIRE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_AEROGETIC_VASE = registerBlock("ancient_aerogetic_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_AEROGETIC_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_GALE_VASE = registerBlock("ancient_gale_vase", () -> new AncientVaseBlock(AncientAetherLoot.SELECTORS_GALE_VASE, BlockBehaviour.Properties.copy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));

    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHLAND_VIOLA = BLOCKS.register("potted_highland_viola", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKY_BLUES, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SKY_BLUES = BLOCKS.register("potted_sky_blues", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKY_BLUES, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_WYND_THISTLE = BLOCKS.register("potted_wynd_thistle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WYND_THISTLE, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SAKURA_BLOSSOMS = BLOCKS.register("potted_sakura_blossoms", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_BLOSSOMS, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKYROOT_PINE_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_CRYSTAL_SKYROOT_SAPLING = BLOCKS.register("potted_crystal_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYSTAL_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_HIGHSPROOT_SAPLING = BLOCKS.register("potted_highsproot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHSPROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<FlowerPotBlock> POTTED_ENCHANTED_SKYROOT_SAPLING = BLOCKS.register("potted_enchanted_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ENCHANTED_SKYROOT_SAPLING, Block.Properties.copy(Blocks.FLOWER_POT)));

    public static void registerFuels() {
        AltarBlockEntity.addItemEnchantingTime(AncientAetherBlocks.ATMOSINE_CRYSTAL.get(), 500);
    }

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.SKYROOT_PINE_SAPLING.getId(), AncientAetherBlocks.POTTED_SKYROOT_PINE_SAPLING);
        pot.addPlant(AncientAetherBlocks.HIGHSPROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_HIGHSPROOT_SAPLING);
        pot.addPlant(AncientAetherBlocks.SAKURA_SAPLING.getId(), AncientAetherBlocks.POTTED_SAKURA_SAPLING);
        pot.addPlant(AncientAetherBlocks.HIGHLAND_VIOLA.getId(), AncientAetherBlocks.POTTED_HIGHLAND_VIOLA);
        pot.addPlant(AncientAetherBlocks.SKY_BLUES.getId(), AncientAetherBlocks.POTTED_SKY_BLUES);
        pot.addPlant(AncientAetherBlocks.WYND_THISTLE.getId(), AncientAetherBlocks.POTTED_WYND_THISTLE);
        pot.addPlant(AncientAetherBlocks.SAKURA_BLOSSOMS.getId(), AncientAetherBlocks.POTTED_SAKURA_BLOSSOMS);
        pot.addPlant(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.getId(), AncientAetherBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING);
    }

    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.CRYSTAL_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.ENCHANTED_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKYROOT_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.CRYSTAL_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.ENCHANTED_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKYROOT_PINE_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKY_GRASS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHLAND_VIOLA.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SKY_BLUES.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.WYND_THISTLE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_BLOSSOMS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.GRAPE_VINE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.STRIPPED_SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.HIGHSPROOT_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientAetherBlocks.SAKURA_FENCE.get(), 5, 20);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        AncientAetherItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerWoodTypes() {
        WoodType.register(AncientAetherBlockSets.HIGHSPROOT);
        WoodType.register(AncientAetherBlockSets.SAKURA);
    }
    private static boolean never(BlockState test1, BlockGetter test2, BlockPos test3) {
        return false;
    }

    private static boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}