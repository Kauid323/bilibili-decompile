package tv.danmaku.video.bilicardplayer;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;
import tv.danmaku.video.playerservice.BLPlayerService;

/* compiled from: BiliCardPlayerManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Ltv/danmaku/video/bilicardplayer/BiliCardPlayerManager;", "", "<init>", "()V", "with", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "remove", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliCardPlayerManager {
    public static final BiliCardPlayerManager INSTANCE = new BiliCardPlayerManager();

    private BiliCardPlayerManager() {
    }

    public final BiliCardPlayerScene with(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BLPlayerService.Companion this_$iv = BLPlayerService.Companion;
        return (BiliCardPlayerScene) this_$iv.getInstance().with(activity, BiliCardPlayerScene.class);
    }

    public final BiliCardPlayerScene with(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BLPlayerService.Companion this_$iv = BLPlayerService.Companion;
        return (BiliCardPlayerScene) this_$iv.getInstance().with(fragment, BiliCardPlayerScene.class);
    }

    public final BiliCardPlayerScene with(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLPlayerService.Companion this_$iv = BLPlayerService.Companion;
        return (BiliCardPlayerScene) this_$iv.getInstance().with(context, BiliCardPlayerScene.class);
    }

    public final void remove(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLPlayerService.Companion.remove(context, BiliCardPlayerScene.class);
    }

    public final void remove(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BLPlayerService.Companion.remove(fragment, BiliCardPlayerScene.class);
    }

    public final void remove(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BLPlayerService.Companion.remove(activity, BiliCardPlayerScene.class);
    }
}