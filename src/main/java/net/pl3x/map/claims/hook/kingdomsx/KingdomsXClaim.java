package net.pl3x.map.claims.hook.kingdomsx;

import libs.org.checkerframework.checker.nullness.qual.NonNull;
import net.pl3x.map.core.markers.Point;
import net.pl3x.map.core.world.World;
import org.bukkit.Location;
import org.kingdoms.constants.land.Land;
import java.awt.*;
import java.util.UUID;

public class KingdomsXClaim {
    private final World world;
    private final Land land;
    private final Point min;
    private final Point max;

    public KingdomsXClaim(@NonNull World world, @NonNull Land land) {
        this.world = world;
        this.land = land;

        Location min = this.land.getLocation().getCenterLocation();
        Location max = this.land.getLocation().getCenterLocation();
        this.min = Point.of(min.getX() - 8, min.getZ() - 8);
        this.max = Point.of(max.getX() + 8, max.getZ() + 8);
    }

    public @NonNull World getWorld() {
        return this.world;
    }

    public @NonNull UUID getID() {
        return this.land.getKingdom().getId();
    }

    public @NonNull String getOwnerName() {
        return this.land.getClaimer().getOfflinePlayer().getName();
    }

    public @NonNull Point getMin() {
        return this.min;
    }

    public @NonNull Point getMax() {
        return this.max;
    }

    public Color getColor() {
        return land.getKingdom().getColor();
    }
}
