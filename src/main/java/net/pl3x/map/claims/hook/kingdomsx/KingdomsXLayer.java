package net.pl3x.map.claims.hook.kingdomsx;

import libs.org.checkerframework.checker.nullness.qual.NonNull;
import net.pl3x.map.core.markers.layer.WorldLayer;
import net.pl3x.map.core.markers.marker.Marker;
import net.pl3x.map.core.world.World;

import java.util.Collection;

public class KingdomsXLayer extends WorldLayer {
    public static final String KEY = "kingdomsx";

    private final KingdomsXHook kingdomsXHook;

    public KingdomsXLayer(@NonNull KingdomsXHook kingdomsXHook, @NonNull World world) {
        super(KEY, world, () -> KingdomsXConfig.LAYER_LABEL);
        this.kingdomsXHook = kingdomsXHook;

        setShowControls(KingdomsXConfig.LAYER_SHOW_CONTROLS);
        setDefaultHidden(KingdomsXConfig.LAYER_DEFAULT_HIDDEN);
        setUpdateInterval(KingdomsXConfig.LAYER_UPDATE_INTERVAL);
        setPriority(KingdomsXConfig.LAYER_PRIORITY);
        setZIndex(KingdomsXConfig.LAYER_ZINDEX);
    }

    @Override
    public @NonNull Collection<@NonNull Marker<@NonNull ?>> getMarkers() {
        return this.kingdomsXHook.getClaims(getWorld());
    }
}
