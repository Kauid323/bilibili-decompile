package tv.danmaku.biliplayerv2.service;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ControlContainerServiceKtx.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"visibilityFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "getVisibilityFlow", "(Ltv/danmaku/biliplayerv2/service/IControlContainerService;)Lkotlinx/coroutines/flow/Flow;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ControlContainerServiceKtxKt {
    public static final Flow<Boolean> getVisibilityFlow(IControlContainerService $this$visibilityFlow) {
        Intrinsics.checkNotNullParameter($this$visibilityFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.distinctUntilChanged(FlowKt.conflate(FlowKt.callbackFlow(new ControlContainerServiceKtxKt$visibilityFlow$1($this$visibilityFlow, null)))));
    }
}