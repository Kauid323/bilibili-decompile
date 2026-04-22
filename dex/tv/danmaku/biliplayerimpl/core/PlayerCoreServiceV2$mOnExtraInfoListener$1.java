package tv.danmaku.biliplayerimpl.core;

import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.IMediaCenterObserver;
import tv.danmaku.biliplayerv2.service.IPlayerReleaseObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.IMediaPlayContext;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mOnExtraInfoListener$1", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayContext$OnExtraInfoListener;", "savePlayerState", "", "onInfo", "what", "", "params", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCoreServiceV2$mOnExtraInfoListener$1 implements IMediaPlayContext.OnExtraInfoListener {
    final /* synthetic */ PlayerCoreServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerCoreServiceV2$mOnExtraInfoListener$1(PlayerCoreServiceV2 $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        r1 = r5.this$0.mCurrentMediaItemParams;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void savePlayerState() {
        boolean isLiveResource;
        Pair dashAutoRange;
        MediaItemParams mediaItemParams;
        int state = this.this$0.getState();
        switch (state) {
            case 4:
            case 5:
            case 6:
                isLiveResource = this.this$0.isLiveResource();
                if (!isLiveResource && mediaItemParams != null) {
                    mediaItemParams.setStartPosition(this.this$0.getRealCurrentPosition());
                }
                PlayerCoreServiceV2 playerCoreServiceV2 = this.this$0;
                Integer valueOf = Integer.valueOf(this.this$0.getCurrentQuality());
                dashAutoRange = this.this$0.getDashAutoRange();
                playerCoreServiceV2.mRestoreState = new PlayerCoreServiceV2.RestoreState(state, valueOf, dashAutoRange);
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.videoplayer.coreV2.IMediaPlayContext.OnExtraInfoListener
    public void onInfo(int what, Object params) {
        MediaItemParams mediaItemParams;
        MediaItemParams mediaItemParams2;
        Collections.SafeIteratorList safeIteratorList;
        Collections.SafeIteratorList safeIteratorList2;
        Collections.SafeIteratorList safeIteratorList3;
        Collections.SafeIteratorList safeIteratorList4;
        Collections.SafeIteratorList safeIteratorList5;
        Collections.SafeIteratorList safeIteratorList6;
        switch (what) {
            case 1:
                this.this$0.mAbsentPlayerByOther = true;
                if (this.this$0.getState() == 4) {
                    this.this$0.setState(5);
                } else {
                    mediaItemParams = this.this$0.mCurrentMediaItemParams;
                    if (mediaItemParams != null) {
                        mediaItemParams.setRenderAfterPrepare(true);
                    }
                }
                mediaItemParams2 = this.this$0.mCurrentMediaItemParams;
                if (mediaItemParams2 != null) {
                    mediaItemParams2.setRecommendStartQualityRange(null);
                }
                savePlayerState();
                safeIteratorList = this.this$0.mMediaCenterObserverList;
                safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda3
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IMediaCenterObserver) obj).onTerminateByMediaCenter();
                    }
                });
                return;
            case 2:
                this.this$0.mIsCorePlayerActive = true;
                this.this$0.mRestoreState = null;
                return;
            case 3:
                this.this$0.mIsCorePlayerActive = false;
                savePlayerState();
                return;
            case 4:
                safeIteratorList2 = this.this$0.mMediaCenterObserverList;
                safeIteratorList2.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda4
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IMediaCenterObserver) obj).onRestoreFromMediaCenterTerminate();
                    }
                });
                return;
            case 5:
                safeIteratorList3 = this.this$0.mMediaCenterObserverList;
                safeIteratorList3.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda5
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IMediaCenterObserver) obj).onPreparedFromMediaCenterTerminate();
                    }
                });
                return;
            case 6:
                safeIteratorList4 = this.this$0.mPlayerReleaseObserverList;
                safeIteratorList4.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda0
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IPlayerReleaseObserver) obj).onPlayerWillRelease();
                    }
                });
                return;
            case 7:
                safeIteratorList5 = this.this$0.mPlayerReleaseObserverList;
                safeIteratorList5.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda1
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        ((IPlayerReleaseObserver) obj).onPlayerItemRelease();
                    }
                });
                return;
            case 8:
                safeIteratorList6 = this.this$0.mPlayerReleaseObserverList;
                safeIteratorList6.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mOnExtraInfoListener$1$$ExternalSyntheticLambda2
                    @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                    public final void run(Object obj) {
                        PlayerCoreServiceV2$mOnExtraInfoListener$1.onInfo$lambda$2((IPlayerReleaseObserver) obj);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInfo$lambda$2(IPlayerReleaseObserver it) {
        try {
            it.onPlayerItemWillChanged();
        } catch (AbstractMethodError e) {
        }
    }
}