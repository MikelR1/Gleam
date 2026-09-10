package net.thatmaidenjaden.gleam.config;

import java.util.function.Supplier;

public class GleamConfigs {

    // COLORED LIGHTS
    public static Supplier<Boolean> ENABLE_COLORED_LIGHTS = GleamConfigImpl.ENABLE_COLORED_LIGHTS::value;
    public static Supplier<Boolean> ENABLE_UV_BLACKLIGHTS;
    public static Supplier<Double> GLOBAL_LIGHT_INTENSITY;
    public static Supplier<Double> GLOBAL_LIGHT_SATURATION;
    public static Supplier<Double> LIGHT_RENDER_DISTANCE;
}