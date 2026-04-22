package tv.danmaku.player.plugin;

public interface IPluginResolverListener {
    void onError(Throwable th);

    void onPostResolve(PluginResult pluginResult);

    void onPreResolve();

    void onProgress(float f);
}