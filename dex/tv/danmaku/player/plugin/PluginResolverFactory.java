package tv.danmaku.player.plugin;

import tv.danmaku.player.plugin.mod.ModPluginResolver;

public class PluginResolverFactory {
    public static IPlayerPluginResolver obtain() {
        return new ModPluginResolver();
    }
}