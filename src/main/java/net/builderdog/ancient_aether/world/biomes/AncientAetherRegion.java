package net.builderdog.ancient_aether.world.biomes;

import com.aetherteam.aether.data.resources.registries.AetherBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import teamrazor.aeroblender.aether.AetherRegionType;
import terrablender.api.Region;

import java.util.function.Consumer;


public class AncientAetherRegion extends Region {

    public AncientAetherRegion(ResourceLocation name, int weight)
    {
        super(name, AetherRegionType.THE_AETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        Climate.Parameter fullRange = Climate.Parameter.span(-1.5F, 1.5F);
        Climate.Parameter coldClimate = Climate.Parameter.span(-1.5F, -0.6F);
        Climate.Parameter temperateClimate = Climate.Parameter.span(-0.6F, 0.6F);
        Climate.Parameter tropicalClimate = Climate.Parameter.span(0.6F, 1.5F);

        addBiome(mapper, new Climate.ParameterPoint(coldClimate, Climate.Parameter.span(-1.5F, 0.17F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.WYNDCAP_TAIGA);
        addBiome(mapper, new Climate.ParameterPoint(coldClimate, Climate.Parameter.span(0.17F, 1.5F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.FESTIVE_WYNDCAP_TAIGA);

        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, Climate.Parameter.span(-1.5F, -0.25F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);
        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, Climate.Parameter.span(-0.25F, -0.05F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_GROVE);
        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, Climate.Parameter.span(-0.05F, 0.1F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_WOODLAND);
        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, Climate.Parameter.span(0.1F, 0.2F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_FOREST);
        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, Climate.Parameter.span(0.2F, 1.5F), Climate.Parameter.span(0.37F, 1.5F), fullRange, fullRange, fullRange, 0),
                AetherBiomes.SKYROOT_MEADOW);

        addBiome(mapper, new Climate.ParameterPoint(tropicalClimate, fullRange, Climate.Parameter.span(0.27F, 1.5F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SAKURA_JUNGLE);

        addBiome(mapper, new Climate.ParameterPoint(coldClimate, fullRange, Climate.Parameter.span(0.27F, 0.37F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.SNOWY_DIVINE_COAST);
        addBiome(mapper, new Climate.ParameterPoint(temperateClimate, fullRange, Climate.Parameter.span(0.27F, 0.37F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.QUICKSOIL_COAST);

        addBiome(mapper, new Climate.ParameterPoint(fullRange, fullRange, Climate.Parameter.span(-1.5F, 0.27F), fullRange, fullRange, fullRange, 0),
                AncientAetherBiomes.CLOUD_OCEAN);
    }
}