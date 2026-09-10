package net.thatmaidenjaden.gleam.config;

import folk.sisby.kaleido.api.KaleidoConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;
import folk.sisby.kaleido.lib.quiltconfig.impl.builders.ConfigBuilderImpl;
import net.fabricmc.loader.api.FabricLoader;

public class GleamConfigImpl {
    public static final TrackedValue<Boolean> ENABLE_COLORED_LIGHTS = TrackedValue.create(true, "enableColoredLights", builder -> builder.metadata(Comment.TYPE, comments -> comments.add("Toggle colored lights")));

    public static void init() {
        ConfigBuilderImpl impl = new ConfigBuilderImpl(KaleidoConfig.tomlEnvironment(FabricLoader.getInstance().getConfigDir()), "", "gleam-client", FabricLoader.getInstance().getConfigDir());
        impl.section("coloredLightSettings", coloredLights -> {
            coloredLights.metadata(Comment.TYPE, comments -> comments.add("Colored Light Settings"))
                    .field(ENABLE_COLORED_LIGHTS);
        });
        impl.build();
    }
}