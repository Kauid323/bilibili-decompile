package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayDirectorServiceV2.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/VideoDirectorObserver;", "Ltv/danmaku/biliplayerv2/service/ResolveListener;", "onItemWillChange", "", "new", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "old", "onItemStart", "item", "onItemCompleted", "playableParams", "onPlayableParamsChanged", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface VideoDirectorObserver extends ResolveListener {
    void onItemCompleted(Video.PlayableParams playableParams);

    void onItemStart(Video.PlayableParams playableParams);

    void onItemWillChange(Video.PlayableParams playableParams, Video.PlayableParams playableParams2);

    void onPlayableParamsChanged(Video.PlayableParams playableParams);

    /* compiled from: IPlayDirectorServiceV2.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.VideoDirectorObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
    }
}