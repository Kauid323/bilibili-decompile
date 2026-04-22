package tv.danmaku.player.plugin;

import android.content.Context;

public interface IPlayerPluginResolver {
    boolean resolvePlugin(Context context, PluginParams pluginParams, IPluginResolverListener iPluginResolverListener);
}