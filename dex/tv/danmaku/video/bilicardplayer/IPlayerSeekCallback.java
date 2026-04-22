package tv.danmaku.video.bilicardplayer;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardPlayerContext.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/IPlayerSeekCallback;", "", "onSeekStart", "", "position", "", "onSeekComplete", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerSeekCallback {
    void onSeekComplete(long j);

    void onSeekStart(long j);

    /* compiled from: CardPlayerContext.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.IPlayerSeekCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onSeekStart(IPlayerSeekCallback _this, long position) {
        }

        public static void $default$onSeekComplete(IPlayerSeekCallback _this, long position) {
        }
    }
}