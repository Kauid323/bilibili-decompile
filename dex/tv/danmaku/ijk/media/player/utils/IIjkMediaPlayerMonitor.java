package tv.danmaku.ijk.media.player.utils;

import android.content.Context;
import android.os.Looper;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;

public interface IIjkMediaPlayerMonitor {
    int getActiveNetworkInfoType();

    String getCpuName();

    Looper getLooper();

    IjkNetworkUtils.NetWorkType getNetworkState();

    IIjkMediaPlayerMonitor init(Context context);

    void pause();

    void start();
}