package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IControlContainerService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/ControlContainerVisibleObserver;", "", "onControlContainerVisibleChanged", "", "visible", "", "onControlContainerImmersiveChanged", "type", "", "immersive", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ControlContainerVisibleObserver {
    void onControlContainerImmersiveChanged(int i, boolean z);

    void onControlContainerVisibleChanged(boolean z);

    /* compiled from: IControlContainerService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.ControlContainerVisibleObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onControlContainerImmersiveChanged(ControlContainerVisibleObserver _this, int type, boolean immersive) {
        }
    }

    /* compiled from: IControlContainerService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onControlContainerImmersiveChanged(ControlContainerVisibleObserver $this, int type, boolean immersive) {
            CC.$default$onControlContainerImmersiveChanged($this, type, immersive);
        }
    }
}