package tv.danmaku.bili.july2025;

import com.bilibili.app.comm.list.common.growth.july2025.GrowthAction;
import com.bilibili.app.comm.list.common.growth.july2025.GrowthEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GrowthCenterImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.july2025.GrowthCenterImpl$onAction$2", f = "GrowthCenterImpl.kt", i = {}, l = {BR.backgroundColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GrowthCenterImpl$onAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GrowthAction $action;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrowthCenterImpl$onAction$2(GrowthAction growthAction, Continuation<? super GrowthCenterImpl$onAction$2> continuation) {
        super(2, continuation);
        this.$action = growthAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GrowthCenterImpl$onAction$2(this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(this.$action, GrowthAction.DoInterestIndependent.INSTANCE)) {
                    mutableSharedFlow = GrowthCenterImpl._events;
                    this.label = 1;
                    if (mutableSharedFlow.emit(GrowthEvent.ShowInterestChoice.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}