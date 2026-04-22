package tv.danmaku.video.bilicardplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardPlayerContext.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/IControlContainerChangedCallback;", "", "onChanged", "", "context", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "type", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "screenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IControlContainerChangedCallback {
    void onChanged(ICardPlayerContext iCardPlayerContext, ControlContainerType controlContainerType, ScreenModeType screenModeType);

    /* compiled from: CardPlayerContext.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.IControlContainerChangedCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onChanged(IControlContainerChangedCallback _this, ICardPlayerContext context, ControlContainerType type, ScreenModeType screenModeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(screenModeType, "screenModeType");
        }
    }
}