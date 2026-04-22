package tv.danmaku.video.bilicardplayer;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardPlayerContext.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/video/bilicardplayer/ICardPlaySateChangedCallback;", "", "onStart", "", "context", "Ltv/danmaku/video/bilicardplayer/ICardPlayerContext;", "onSourcePlayable", "", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "onPreparing", "onPrepared", "onResume", "onPause", "onCompleted", "onStop", "onError", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ICardPlaySateChangedCallback {
    void onCompleted(ICardPlayerContext iCardPlayerContext);

    void onError(ICardPlayerContext iCardPlayerContext);

    void onPause(ICardPlayerContext iCardPlayerContext);

    void onPrepared(ICardPlayerContext iCardPlayerContext);

    void onPreparing(ICardPlayerContext iCardPlayerContext);

    void onResume(ICardPlayerContext iCardPlayerContext);

    boolean onSourcePlayable(ICardPlayerContext iCardPlayerContext, MediaResource mediaResource);

    void onStart(ICardPlayerContext iCardPlayerContext);

    void onStop(ICardPlayerContext iCardPlayerContext);

    /* compiled from: CardPlayerContext.kt */
    /* renamed from: tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$onSourcePlayable(ICardPlaySateChangedCallback _this, ICardPlayerContext context, MediaResource resource) {
            Intrinsics.checkNotNullParameter(context, "context");
            return true;
        }
    }
}