package net.pl3x.map.claims.hook.kingdomsx;

import libs.org.checkerframework.checker.nullness.qual.NonNull;
import net.pl3x.map.claims.hook.Hook;
import net.pl3x.map.core.markers.marker.Marker;
import net.pl3x.map.core.markers.option.Options;
import net.pl3x.map.core.util.Colors;
import net.pl3x.map.core.world.World;
import org.bukkit.event.Listener;
import org.kingdoms.main.Kingdoms;
import java.util.Collection;
import java.util.stream.Collectors;

public class KingdomsXHook implements Listener, Hook {
    public KingdomsXHook() {
        KingdomsXConfig.reload();
    }

    private boolean isWorldEnabled(@NonNull String name) {
        return Kingdoms.isLoaded();
    }

    @Override
    public void registerWorld(@NonNull World world) {
        if (isWorldEnabled(world.getName())) {
            world.getLayerRegistry().register(KingdomsXLayer.KEY, new KingdomsXLayer(this, world));
        }
    }

    @Override
    public @NonNull Collection<@NonNull Marker<@NonNull ?>> getClaims(@NonNull World world) {
        if (!isWorldEnabled(world.getName())) {
            return EMPTY_LIST;
        }
        return Kingdoms.get().getDataCenter().getLandManager().peekAllData().stream()
                .filter(land -> land.getLocation().getBukkitWorld().getName().equals(world.getName()))
                .map(claim -> new KingdomsXClaim(world, claim))
                .map(claim -> {
                    String key = "kingdomsx-claim" + claim.getID();
                    return Marker.rectangle(key, claim.getMin(), claim.getMax())
                            .setOptions(getOptions(claim));
                })
                .collect(Collectors.toList());
    }

    private @NonNull Options getOptions(@NonNull KingdomsXClaim claim) {
        Options.Builder builder;
        builder = Options.builder()
                .strokeWeight(KingdomsXConfig.MARKER_BASIC_STROKE_WEIGHT)
                .strokeColor(KingdomsXConfig.MARKER_BASIC_STROKE_COLOR_USE_KINGDOM_COLOR ? Colors.argb(claim.getColor().getAlpha(), claim.getColor().getRed(), claim.getColor().getGreen(), claim.getColor().getBlue())  : Colors.fromHex(KingdomsXConfig.MARKER_BASIC_STROKE_COLOR))
                .fillColor(KingdomsXConfig.MARKER_BASIC_FILL_COLOR_USE_KINGDOM_COLOR ? Colors.argb(claim.getColor().getAlpha(), claim.getColor().getRed(), claim.getColor().getGreen(), claim.getColor().getBlue()) : Colors.fromHex(KingdomsXConfig.MARKER_BASIC_FILL_COLOR))
                .popupContent(processPopup(KingdomsXConfig.MARKER_BASIC_POPUP, claim));

        return builder.build();
    }

    private @NonNull String processPopup(@NonNull String popup, @NonNull KingdomsXClaim claim) {
        return popup.replace("<world>", claim.getWorld().getName())
                .replace("<id>", String.valueOf(claim.getID()))
                .replace("<owner>", claim.getOwnerName());
    }
}
