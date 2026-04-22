package tv.danmaku.bili.video.multibzplayer;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MultiBzPlayerScene.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/video/multibzplayer/Business;", "", "gap", "Ltv/danmaku/bili/video/multibzplayer/AbsBusinessGap;", "container", "Landroid/view/ViewGroup;", "<init>", "(Ltv/danmaku/bili/video/multibzplayer/AbsBusinessGap;Landroid/view/ViewGroup;)V", "getGap", "()Ltv/danmaku/bili/video/multibzplayer/AbsBusinessGap;", "getContainer", "()Landroid/view/ViewGroup;", "multibzplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Business {
    private final ViewGroup container;
    private final AbsBusinessGap gap;

    public Business(AbsBusinessGap gap, ViewGroup container) {
        Intrinsics.checkNotNullParameter(gap, "gap");
        Intrinsics.checkNotNullParameter(container, "container");
        this.gap = gap;
        this.container = container;
    }

    public final AbsBusinessGap getGap() {
        return this.gap;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }
}