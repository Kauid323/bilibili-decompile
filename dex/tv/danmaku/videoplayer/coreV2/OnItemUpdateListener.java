package tv.danmaku.videoplayer.coreV2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;

/* compiled from: OnItemUpdateListener.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/OnItemUpdateListener;", "", "onItemUpdate", "reason", "", "type", "Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;", "codecType", IjkMediaMeta.IJKM_KEY_FORMAT, "onMeteredNetworkUrlHook", "", "url", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OnItemUpdateListener {
    Object onItemUpdate(int i, IjkNetworkUtils.NetWorkType netWorkType, int i2, int i3);

    String onMeteredNetworkUrlHook(String str, IjkNetworkUtils.NetWorkType netWorkType);

    /* compiled from: OnItemUpdateListener.kt */
    /* renamed from: tv.danmaku.videoplayer.coreV2.OnItemUpdateListener$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static String $default$onMeteredNetworkUrlHook(OnItemUpdateListener _this, String url, IjkNetworkUtils.NetWorkType type) {
            Intrinsics.checkNotNullParameter(url, "url");
            return url;
        }
    }
}