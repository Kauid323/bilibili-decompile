package video.biz.offline.list.logic.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.UtilsKt$checkNetworkState$2", f = "Utils.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UtilsKt$checkNetworkState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $continueAction;
    final /* synthetic */ boolean $hasFreeBrandWidthError;
    final /* synthetic */ OfflineBaseListStateMachine $machine;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$checkNetworkState$2(OfflineBaseListStateMachine offlineBaseListStateMachine, Function0<Unit> function0, boolean z, Continuation<? super UtilsKt$checkNetworkState$2> continuation) {
        super(2, continuation);
        this.$machine = offlineBaseListStateMachine;
        this.$continueAction = function0;
        this.$hasFreeBrandWidthError = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$checkNetworkState$2(this.$machine, this.$continueAction, this.$hasFreeBrandWidthError, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$machine.dispatch(new OfflineListAction.ShowBandWidthAlert(this.$continueAction, this.$hasFreeBrandWidthError), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
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