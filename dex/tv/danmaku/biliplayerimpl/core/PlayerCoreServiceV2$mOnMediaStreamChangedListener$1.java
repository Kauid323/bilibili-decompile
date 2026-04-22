package tv.danmaku.biliplayerimpl.core;

import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.IPlayerSourceObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnMediaStreamChangedListener$1", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnMediaStreamChangedListener;", "onVideoStreamChanged", "", "isSuccess", "", "oldStream", "", "newStream", "fromAuto", "onAudioStreamChanged", "onRecommendVideoStreamStarted", "stream", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCoreServiceV2$mOnMediaStreamChangedListener$1 implements IMediaPlayContext.OnMediaStreamChangedListener {
    final /* synthetic */ PlayerCoreServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerCoreServiceV2$mOnMediaStreamChangedListener$1(PlayerCoreServiceV2 $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
    public void onVideoStreamChanged(final boolean isSuccess, final int oldStream, final int newStream, final boolean fromAuto) {
        Collections.SafeIteratorList safeIteratorList;
        BLog.i("PlayerCoreServiceV2", "Dispatching video stream change from " + oldStream + " to " + newStream + ", success: " + isSuccess + ".");
        safeIteratorList = this.this$0.mPlayerSourceObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnMediaStreamChangedListener$1$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IPlayerSourceObserver) obj).onSourceChanged(isSuccess, oldStream, newStream, fromAuto);
            }
        });
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
    public void onAudioStreamChanged(final boolean isSuccess, final int oldStream, final int newStream, final boolean fromAuto) {
        MediaItemParams mediaItemParams;
        Collections.SafeIteratorList safeIteratorList;
        BLog.i("PlayerCoreServiceV2", "Dispatching audio stream change from " + oldStream + " to " + newStream + ", success: " + isSuccess + ".");
        mediaItemParams = this.this$0.mCurrentMediaItemParams;
        if (mediaItemParams != null) {
            mediaItemParams.setAudioStreamId(newStream);
        }
        safeIteratorList = this.this$0.mPlayerSourceObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnMediaStreamChangedListener$1$$ExternalSyntheticLambda2
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IPlayerSourceObserver) obj).onAudioSourceChanged(isSuccess, oldStream, newStream, fromAuto);
            }
        });
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnMediaStreamChangedListener
    public void onRecommendVideoStreamStarted(final int stream) {
        Collections.SafeIteratorList safeIteratorList;
        BLog.i("PlayerCoreServiceV2", "Dispatching recommend quality to " + stream + ".");
        safeIteratorList = this.this$0.mPlayerSourceObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnMediaStreamChangedListener$1$$ExternalSyntheticLambda1
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((IPlayerSourceObserver) obj).onRecommendVideoSourceStarted(stream);
            }
        });
    }
}