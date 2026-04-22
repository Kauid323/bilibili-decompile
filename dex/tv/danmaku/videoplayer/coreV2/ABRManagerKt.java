package tv.danmaku.videoplayer.coreV2;

import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.AbrParamsInterface;

/* compiled from: ABRManager.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\b\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005\u001a\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005\u001a\u0006\u0010\r\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"EMPTY", "", "setMinQn", "", "maxQn", "", "getMinQn", "setMaxQn", "getMaxQn", "setUserQn", "userQn", "setUserPlayPrefer", "userPlayPrefer", "initOnlineParamsCallback", "playercore_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ABRManagerKt {
    private static final String EMPTY = "";

    public static final void setMinQn(int maxQn) {
        AbrParamsInterface.setMinQn(maxQn);
    }

    public static final int getMinQn() {
        return AbrParamsInterface.getMinQn();
    }

    public static final void setMaxQn(int maxQn) {
        AbrParamsInterface.setMaxQn(maxQn);
    }

    public static final int getMaxQn() {
        return AbrParamsInterface.getMaxQn();
    }

    public static final void setUserQn(int userQn) {
        AbrParamsInterface.setUserQn(userQn);
    }

    public static final void setUserPlayPrefer(int userPlayPrefer) {
        AbrParamsInterface.setUserPlayPrefer(userPlayPrefer);
    }

    public static final void initOnlineParamsCallback() {
        AbrParamsInterface.initOnlineParamsCallback(new AbrParamsInterface.MediaConfigCallback() { // from class: tv.danmaku.videoplayer.coreV2.ABRManagerKt$initOnlineParamsCallback$1
            @Override // tv.danmaku.ijk.media.player.AbrParamsInterface.MediaConfigCallback
            public String getConfigForKey(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return ConfigManager.Companion.getConfig(key, "");
            }

            @Override // tv.danmaku.ijk.media.player.AbrParamsInterface.MediaConfigCallback
            public boolean hitExperimentalGroupForKey(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return ConfigManager.Companion.isHitFF(key);
            }
        });
    }
}