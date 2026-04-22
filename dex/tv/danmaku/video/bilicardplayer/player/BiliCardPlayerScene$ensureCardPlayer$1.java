package tv.danmaku.video.bilicardplayer.player;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliCardPlayerScene.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$ensureCardPlayer$1", "Ltv/danmaku/video/bilicardplayer/player/CardPlayerReadyObserver;", "onReady", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliCardPlayerScene$ensureCardPlayer$1 implements CardPlayerReadyObserver {
    final /* synthetic */ BiliCardPlayerScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliCardPlayerScene$ensureCardPlayer$1(BiliCardPlayerScene $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.video.bilicardplayer.player.CardPlayerReadyObserver
    public void onReady() {
        Collections.SafeIteratorList safeIteratorList;
        safeIteratorList = this.this$0.mPlayerReadyObservers;
        safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene$ensureCardPlayer$1$$ExternalSyntheticLambda0
            @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
            public final void run(Object obj) {
                ((CardPlayerReadyObserver) obj).onReady();
            }
        });
    }
}