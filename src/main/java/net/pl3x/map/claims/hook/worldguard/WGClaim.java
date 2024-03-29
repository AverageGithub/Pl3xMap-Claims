package net.pl3x.map.claims.hook.worldguard;

import com.sk89q.worldedit.math.BlockVector2;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionType;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import libs.org.checkerframework.checker.nullness.qual.NonNull;
import libs.org.checkerframework.checker.nullness.qual.Nullable;
import net.pl3x.map.core.markers.Point;
import net.pl3x.map.core.world.World;

public class WGClaim {
    private final World world;
    private final ProtectedRegion region;
    private final Point min;
    private final Point max;

    public WGClaim(@NonNull World world, @NonNull ProtectedRegion region) {
        this.world = world;
        this.region = region;

        BlockVector3 min = this.region.getMinimumPoint();
        BlockVector3 max = this.region.getMaximumPoint();
        this.min = Point.of(min.getX(), min.getZ());
        this.max = Point.of(max.getX(), max.getZ());
    }

    public @NonNull World getWorld() {
        return this.world;
    }

    public @NonNull String getID() {
        return this.region.getId();
    }

    public @NonNull DefaultDomain getOwners() {
        return this.region.getOwners();
    }

    public @NonNull DefaultDomain getMembers() {
        return this.region.getMembers();
    }

    public @NonNull Point getMin() {
        return this.min;
    }

    public @NonNull Point getMax() {
        return this.max;
    }

    public @Nullable ProtectedRegion getParent() {
        return this.region.getParent();
    }

    public int getPriority() {
        return this.region.getPriority();
    }

    public @Nonnull Map<Flag<?>, Object> getFlags() {
        return this.region.getFlags();
    }

    public List<BlockVector2> getPoints() {
        return this.region.getPoints();
    }

    public RegionType getType() {
        return this.region.getType();
    }
}
