package net.builderdog.aether_crystallium.worldgen;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.builderdog.aether_crystallium.worldgen.foliageplacer.HighlandsPineFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIGHLANDS_PINE_KEY = registerKey("highlands_pine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_CRYSTAL_GOLD_ORE_KEY = registerKey("aether_crystal_gold_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest aetherIslandBlocks = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> aetherCrystalGoldOre = List.of(OreConfiguration.target(aetherIslandBlocks,
                ModBlocks.CRYSTAL_GOLD_ORE.get().defaultBlockState()));

        register(context, HIGHLANDS_PINE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LOG.get()),
                        new StraightTrunkPlacer(5, 7, 3),
                        BlockStateProvider.simple(ModBlocks.HIGHLANDS_PINE_LEAVES.get()),
                        new HighlandsPineFoliagePlacer(ConstantInt.of(1), ConstantInt.ZERO, ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, AETHER_CRYSTAL_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(aetherCrystalGoldOre, 12, 0f));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AetherCrystallium.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}

