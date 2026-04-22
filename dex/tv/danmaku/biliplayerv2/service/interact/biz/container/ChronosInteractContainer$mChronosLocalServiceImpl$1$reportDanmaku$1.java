package tv.danmaku.biliplayerv2.service.interact.biz.container;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.IRemoteHandler;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.OnInteractiveCallBack;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosInteractContainer.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"tv/danmaku/biliplayerv2/service/interact/biz/container/ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/OnInteractiveCallBack;", "onReportDanmakuSuccess", "", "regexFilter", "", "shieldUserId", "nativeId", "", "nativeType", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1 implements OnInteractiveCallBack {
    final /* synthetic */ ChronosInteractContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1(ChronosInteractContainer $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.sender.OnInteractiveCallBack
    public void onReportDanmakuSuccess(String regexFilter, String shieldUserId, long nativeId, int nativeType) {
        IRemoteHandler iRemoteHandler;
        iRemoteHandler = this.this$0.mRemoteHandler;
        Long valueOf = Long.valueOf(nativeId);
        final ChronosInteractContainer chronosInteractContainer = this.this$0;
        iRemoteHandler.appendFilters(shieldUserId, regexFilter, valueOf, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.container.ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ChronosInteractContainer$mChronosLocalServiceImpl$1$reportDanmaku$1.onReportDanmakuSuccess$lambda$0(ChronosInteractContainer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReportDanmakuSuccess$lambda$0(ChronosInteractContainer this$0) {
        PlayerContainer playerContainer;
        InteractLayerService.Companion companion = InteractLayerService.Companion;
        playerContainer = this$0.playerContainer;
        companion.openDanmakuBlockListWhenClosed(playerContainer);
    }
}