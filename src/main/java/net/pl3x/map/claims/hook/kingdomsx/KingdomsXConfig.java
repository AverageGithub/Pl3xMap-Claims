package net.pl3x.map.claims.hook.kingdomsx;

import net.pl3x.map.claims.Pl3xMapClaims;
import net.pl3x.map.core.configuration.AbstractConfig;
import java.nio.file.Path;

public class KingdomsXConfig extends AbstractConfig {
    private static final KingdomsXConfig KINGDOMS_X_CONFIG = new KingdomsXConfig();
    @Key("settings.layer.label")
    @Comment("Label for map layer")
    public static String LAYER_LABEL = "KingdomsX";
    @Key("settings.layer.show-controls")
    @Comment("Show controls for map layer")
    public static boolean LAYER_SHOW_CONTROLS = true;
    @Key("settings.layer.default-hidden")
    @Comment("Whether map layer is hidden by default")
    public static boolean LAYER_DEFAULT_HIDDEN = false;
    @Key("settings.layer.update-interval")
    @Comment("Update interval for map layer")
    public static int LAYER_UPDATE_INTERVAL = 30;
    @Key("settings.layer.priority")
    @Comment("Priority for map layer")
    public static int LAYER_PRIORITY = 10;
    @Key("settings.layer.z-index")
    @Comment("zIndex for map layer")
    public static int LAYER_ZINDEX = 10;
    @Key("settings.claim.basic.stroke.color")
    @Comment("Stroke color (#AARRGGBB)")
    public static String MARKER_BASIC_STROKE_COLOR = "#FF00FF00";
    @Key("settings.claim.basic.stroke.weight")
    @Comment("Stroke weight")
    public static int MARKER_BASIC_STROKE_WEIGHT = 3;
    @Key("settings.claim.basic.fill.color")
    @Comment("Fill color (#AARRGGBB)")
    public static String MARKER_BASIC_FILL_COLOR = "#3300FF00";
    @Key("settings.claim.basic.popup")
    @Comment("Popup for basic claims")
    public static String MARKER_BASIC_POPUP = """
            Claim Owner: <span style="font-weight:bold;"><owner></span><trusts>""";
    @Key("settings.claim.kingdom.fill.color")
    @Comment("Use Kingdom Color?")
    public static boolean MARKER_BASIC_FILL_COLOR_USE_KINGDOM_COLOR = false;
    @Key("settings.claim.kingdom.stroke.color")
    @Comment("Stroke color (#AARRGGBB)")
    public static boolean MARKER_BASIC_STROKE_COLOR_USE_KINGDOM_COLOR = false;

    public static void reload() {
        Path mainDir = Pl3xMapClaims.getPlugin(Pl3xMapClaims.class).getDataFolder().toPath();
        KINGDOMS_X_CONFIG.reload(mainDir.resolve("kingdomsx.yml"), KingdomsXConfig.class);
    }
}
