package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IMediaCenterObserver;", "", "onTerminateByMediaCenter", "", "onRestoreFromMediaCenterTerminate", "onPreparedFromMediaCenterTerminate", "onPlayerReconnect", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaCenterObserver {
    void onPlayerReconnect();

    void onPreparedFromMediaCenterTerminate();

    void onRestoreFromMediaCenterTerminate();

    void onTerminateByMediaCenter();

    /* compiled from: IPlayerCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IMediaCenterObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onRestoreFromMediaCenterTerminate(IMediaCenterObserver _this) {
        }

        public static void $default$onPreparedFromMediaCenterTerminate(IMediaCenterObserver _this) {
        }

        public static void $default$onPlayerReconnect(IMediaCenterObserver _this) {
        }
    }
}