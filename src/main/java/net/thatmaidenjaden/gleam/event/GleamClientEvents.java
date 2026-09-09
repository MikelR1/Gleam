package net.thatmaidenjaden.gleam.event;

import net.fabricmc.fabric.api.client.rendering.v1.CoreShaderRegistrationCallback;
import net.thatmaidenjaden.gleam.client.lighting.GleamLightEngine;

public class GleamClientEvents {

    public static void onShaderRegistration() {
        CoreShaderRegistrationCallback.EVENT.register(context -> GleamLightEngine.getInstance().rebindBlocks());
    }
}