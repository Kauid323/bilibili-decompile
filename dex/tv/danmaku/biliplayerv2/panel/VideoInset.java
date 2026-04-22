package tv.danmaku.biliplayerv2.panel;

import android.graphics.Rect;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPanelContainer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/panel/VideoInset;", "", "<init>", "()V", "containerInset", "Landroid/graphics/Rect;", "getContainerInset", "()Landroid/graphics/Rect;", "setContainerInset", "(Landroid/graphics/Rect;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoInset {
    private Rect containerInset;

    public final Rect getContainerInset() {
        return this.containerInset;
    }

    public final void setContainerInset(Rect rect) {
        this.containerInset = rect;
    }
}