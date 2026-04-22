package tv.danmaku.biliplayerv2.service.interact.core;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuVisibleObserver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/DanmakuVisibleObserver;", "", "onDanmakuVisibleChanged", "", "visible", "", "fromUser", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface DanmakuVisibleObserver {
    void onDanmakuVisibleChanged(boolean z, boolean z2);

    /* compiled from: DanmakuVisibleObserver.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.core.DanmakuVisibleObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onDanmakuVisibleChanged$default(DanmakuVisibleObserver danmakuVisibleObserver, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDanmakuVisibleChanged");
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            danmakuVisibleObserver.onDanmakuVisibleChanged(z, z2);
        }
    }
}