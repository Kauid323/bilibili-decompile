package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosRequestHandler;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InteractLayerServiceKtx.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0003\u001a\"\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"danmakuParamsFlow", "Lkotlinx/coroutines/flow/Flow;", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;", "danmakuVisibleChangeFlow", "Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuVisibleChangeParams;", "keepChronosMessageHandler", "", "handler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;", "(Ltv/danmaku/biliplayerv2/service/interact/biz/IInteractLayerService;Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRequestHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InteractLayerServiceKtxKt {
    public static final Flow<DanmakuParams> danmakuParamsFlow(IInteractLayerService $this$danmakuParamsFlow) {
        Intrinsics.checkNotNullParameter($this$danmakuParamsFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.conflate(FlowKt.callbackFlow(new InteractLayerServiceKtxKt$danmakuParamsFlow$1($this$danmakuParamsFlow, null))));
    }

    public static final Flow<DanmakuVisibleChangeParams> danmakuVisibleChangeFlow(IInteractLayerService $this$danmakuVisibleChangeFlow) {
        Intrinsics.checkNotNullParameter($this$danmakuVisibleChangeFlow, "<this>");
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new InteractLayerServiceKtxKt$danmakuVisibleChangeFlow$1($this$danmakuVisibleChangeFlow, null))));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object keepChronosMessageHandler(IInteractLayerService $this$keepChronosMessageHandler, ChronosRequestHandler<?, ?> chronosRequestHandler, Continuation<?> continuation) {
        InteractLayerServiceKtxKt$keepChronosMessageHandler$1 interactLayerServiceKtxKt$keepChronosMessageHandler$1;
        IInteractLayerService $this$keepChronosMessageHandler2;
        ChronosRequestHandler handler;
        if (continuation instanceof InteractLayerServiceKtxKt$keepChronosMessageHandler$1) {
            interactLayerServiceKtxKt$keepChronosMessageHandler$1 = (InteractLayerServiceKtxKt$keepChronosMessageHandler$1) continuation;
            if ((interactLayerServiceKtxKt$keepChronosMessageHandler$1.label & Integer.MIN_VALUE) != 0) {
                interactLayerServiceKtxKt$keepChronosMessageHandler$1.label -= Integer.MIN_VALUE;
                Object $result = interactLayerServiceKtxKt$keepChronosMessageHandler$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (interactLayerServiceKtxKt$keepChronosMessageHandler$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$keepChronosMessageHandler.registerChronosMessageHandler(chronosRequestHandler);
                        try {
                            interactLayerServiceKtxKt$keepChronosMessageHandler$1.L$0 = $this$keepChronosMessageHandler;
                            interactLayerServiceKtxKt$keepChronosMessageHandler$1.L$1 = chronosRequestHandler;
                            interactLayerServiceKtxKt$keepChronosMessageHandler$1.label = 1;
                            if (DelayKt.awaitCancellation(interactLayerServiceKtxKt$keepChronosMessageHandler$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$keepChronosMessageHandler2 = $this$keepChronosMessageHandler;
                            handler = chronosRequestHandler;
                            throw new KotlinNothingValueException();
                        } catch (Throwable th) {
                            th = th;
                            $this$keepChronosMessageHandler2 = $this$keepChronosMessageHandler;
                            handler = chronosRequestHandler;
                            $this$keepChronosMessageHandler2.unregisterChronosMessageHandler(handler);
                            throw th;
                        }
                    case 1:
                        handler = (ChronosRequestHandler) interactLayerServiceKtxKt$keepChronosMessageHandler$1.L$1;
                        $this$keepChronosMessageHandler2 = (IInteractLayerService) interactLayerServiceKtxKt$keepChronosMessageHandler$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        } catch (Throwable th2) {
                            th = th2;
                            $this$keepChronosMessageHandler2.unregisterChronosMessageHandler(handler);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        interactLayerServiceKtxKt$keepChronosMessageHandler$1 = new InteractLayerServiceKtxKt$keepChronosMessageHandler$1(continuation);
        Object $result2 = interactLayerServiceKtxKt$keepChronosMessageHandler$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (interactLayerServiceKtxKt$keepChronosMessageHandler$1.label) {
        }
    }
}