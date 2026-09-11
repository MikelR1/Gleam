package net.thatmaidenjaden.gleam.config.screen;

import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thatmaidenjaden.gleam.config.GleamConfigImpl;

import java.util.ArrayList;

public class ClothConfigScreen {
    public static Screen getScreen(Screen parent) {
        ConfigBuilder configBuilder = ConfigBuilder.create()
                .setTitle(Component.literal("Gleam Client Configuration"))
                .setSavingRunnable(() -> GleamConfigImpl.CONFIG.save());
        ConfigCategory coloredLightSettings = configBuilder.getOrCreateCategory(Component.translatable("gleam.configuration.coloredLightSettings"));
        coloredLightSettings.addEntry(booleanEntry(configBuilder, GleamConfigImpl.ENABLE_COLORED_LIGHTS, Component.translatable("gleam.configuration.enableColoredLights")));
        return configBuilder.setParentScreen(parent).build();
    }

    public static BooleanListEntry booleanEntry(ConfigBuilder configBuilder, TrackedValue<Boolean> value, MutableComponent name) {
        ArrayList<Component> tooltipComponents = new ArrayList<>();
        tooltipComponents.add(name.copy().withStyle(ChatFormatting.BOLD));
        value.metadata(Comment.TYPE).forEach(comment -> tooltipComponents.add(Component.literal(comment)));

        return configBuilder.entryBuilder()
                .startBooleanToggle(name, value.value())
                .setDefaultValue(value.getDefaultValue())
                .setTooltip(tooltipComponents.toArray(new Component[0])).setSaveConsumer(value::setValue).build();
    }
}
