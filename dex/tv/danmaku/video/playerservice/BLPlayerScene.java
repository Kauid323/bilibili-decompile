package tv.danmaku.video.playerservice;

import android.content.Context;
import android.content.res.Configuration;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLPlayerScene.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH'J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerScene;", "", "initialize", "", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/video/playerservice/BLPlayerService;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isActive", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "release", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface BLPlayerScene {
    void initialize(Context context, BLPlayerService bLPlayerService, LifecycleOwner lifecycleOwner);

    boolean isActive();

    void onConfigurationChanged(Configuration configuration);

    void onMultiWindowModeChanged(boolean z);

    void release();
}