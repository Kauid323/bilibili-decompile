package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.HookErrorType;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/OnMeteredNetworkUrlHookListener;", "", "onMeteredNetworkUrlHook", "", "url", "type", "Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;", "networkErrorType", "Ltv/danmaku/biliplayerv2/HookErrorType;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OnMeteredNetworkUrlHookListener {
    String onMeteredNetworkUrlHook(String str, IjkNetworkUtils.NetWorkType netWorkType, HookErrorType hookErrorType);

    /* compiled from: IPlayerCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ String onMeteredNetworkUrlHook$default(OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener, String str, IjkNetworkUtils.NetWorkType netWorkType, HookErrorType hookErrorType, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    hookErrorType = null;
                }
                return onMeteredNetworkUrlHookListener.onMeteredNetworkUrlHook(str, netWorkType, hookErrorType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMeteredNetworkUrlHook");
        }
    }
}