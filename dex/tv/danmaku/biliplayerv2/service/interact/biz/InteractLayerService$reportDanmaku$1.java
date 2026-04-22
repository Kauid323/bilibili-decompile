package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bilibili.lib.accounts.BiliAccounts;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.OnInteractiveCallBack;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractLayerService.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"tv/danmaku/biliplayerv2/service/interact/biz/InteractLayerService$reportDanmaku$1", "Ltv/danmaku/biliplayerv2/service/interact/biz/sender/OnInteractiveCallBack;", "onReportDanmakuSuccess", "", "regexFilter", "", "shieldUserId", "nativeId", "", "nativeType", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractLayerService$reportDanmaku$1 implements OnInteractiveCallBack {
    final /* synthetic */ InteractLayerService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InteractLayerService$reportDanmaku$1(InteractLayerService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.sender.OnInteractiveCallBack
    public void onReportDanmakuSuccess(String regexFilter, String shieldUserId, long nativeId, int nativeType) {
        PlayerContainer playerContainer;
        playerContainer = this.this$0.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        long mid = BiliAccounts.get(playerContainer.getContext()).mid();
        if (mid >= 0) {
            this.this$0.getDanmakuParams().getBlockUserIds().add(shieldUserId == null ? "" : shieldUserId);
            Collection $this$toTypedArray$iv = this.this$0.getDanmakuParams().getBlockUserIds();
            String[] it = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
            this.this$0.blockUsers(it);
            InteractLayerService interactLayerService = this.this$0;
            Long valueOf = Long.valueOf(nativeId);
            final InteractLayerService interactLayerService2 = this.this$0;
            interactLayerService.appendFilters(shieldUserId, regexFilter, valueOf, new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.InteractLayerService$reportDanmaku$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InteractLayerService$reportDanmaku$1.onReportDanmakuSuccess$lambda$1(InteractLayerService.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReportDanmakuSuccess$lambda$1(InteractLayerService this$0) {
        PlayerContainer playerContainer;
        InteractLayerService.Companion companion = InteractLayerService.Companion;
        playerContainer = this$0.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        companion.openDanmakuBlockListWhenClosed(playerContainer);
    }
}