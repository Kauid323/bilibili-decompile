package tv.danmaku.video.bilicardplayer.player;

import com.bilibili.cron.ChronosPackage;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.bilicardplayer.CardDanmakuCallback;

/* compiled from: DefaultCardPlayer.kt */
@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016J@\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00102&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016¨\u0006\u0011"}, d2 = {"tv/danmaku/video/bilicardplayer/player/DefaultCardPlayer$reqLiveInlineChronos$1$1", "Ltv/danmaku/video/bilicardplayer/CardDanmakuCallback;", "onResolveChronosPkgSuccess", "", "result", "Lcom/bilibili/cron/ChronosPackage;", "onLiveDanmakuComing", "dmId", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$LiveExtra;", "emoExtra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onLiveDanmakuComingV2", "", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultCardPlayer$reqLiveInlineChronos$1$1 implements CardDanmakuCallback {
    final /* synthetic */ DefaultCardPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultCardPlayer$reqLiveInlineChronos$1$1(DefaultCardPlayer $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.video.bilicardplayer.CardDanmakuCallback
    public void onResolveChronosPkgSuccess(ChronosPackage result) {
        IPlayerContainer iPlayerContainer;
        if (result != null) {
            DefaultCardPlayer defaultCardPlayer = this.this$0;
            BLog.d("DefaultCardPlayer", "run chronos package for live inline");
            iPlayerContainer = defaultCardPlayer.mPlayerContainer;
            if (iPlayerContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                iPlayerContainer = null;
            }
            iPlayerContainer.getInteractLayerService().runPackageForLive(result);
        }
    }

    @Override // tv.danmaku.video.bilicardplayer.CardDanmakuCallback
    public void onLiveDanmakuComing(final String dmId, final AddCustomDanmaku.LiveExtra extra, final HashMap<String, byte[]> hashMap) {
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        final DefaultCardPlayer defaultCardPlayer = this.this$0;
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$reqLiveInlineChronos$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCardPlayer$reqLiveInlineChronos$1$1.onLiveDanmakuComing$lambda$1(DefaultCardPlayer.this, dmId, extra, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLiveDanmakuComing$lambda$1(DefaultCardPlayer this$0, String $dmId, AddCustomDanmaku.LiveExtra $extra, HashMap $emoExtra) {
        IPlayerContainer iPlayerContainer;
        iPlayerContainer = this$0.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().addDanmaku($dmId, 103, $extra, $emoExtra);
    }

    @Override // tv.danmaku.video.bilicardplayer.CardDanmakuCallback
    public void onLiveDanmakuComingV2(final String dmId, final Object extra, final HashMap<String, byte[]> hashMap) {
        Intrinsics.checkNotNullParameter(dmId, "dmId");
        Intrinsics.checkNotNullParameter(extra, "extra");
        final DefaultCardPlayer defaultCardPlayer = this.this$0;
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.video.bilicardplayer.player.DefaultCardPlayer$reqLiveInlineChronos$1$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCardPlayer$reqLiveInlineChronos$1$1.onLiveDanmakuComingV2$lambda$2(DefaultCardPlayer.this, dmId, extra, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLiveDanmakuComingV2$lambda$2(DefaultCardPlayer this$0, String $dmId, Object $extra, HashMap $emoExtra) {
        IPlayerContainer iPlayerContainer;
        iPlayerContainer = this$0.mPlayerContainer;
        if (iPlayerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            iPlayerContainer = null;
        }
        iPlayerContainer.getInteractLayerService().addDanmaku($dmId, AddCustomDanmaku.TYPE_LIVE_DANMU_V2, $extra, $emoExtra);
    }
}