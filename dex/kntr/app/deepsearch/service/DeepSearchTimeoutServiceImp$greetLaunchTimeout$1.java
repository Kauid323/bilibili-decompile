package kntr.app.deepsearch.service;

import kntr.app.deepsearch.base.model.biz.DeepSearchTimeout;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: DeepSearchTimeoutServiceImp.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.service.DeepSearchTimeoutServiceImp$greetLaunchTimeout$1", f = "DeepSearchTimeoutServiceImp.kt", i = {0, 1}, l = {57, 58}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"}, v = 1)
final class DeepSearchTimeoutServiceImp$greetLaunchTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepSearchTimeoutServiceImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchTimeoutServiceImp$greetLaunchTimeout$1(DeepSearchTimeoutServiceImp deepSearchTimeoutServiceImp, Continuation<? super DeepSearchTimeoutServiceImp$greetLaunchTimeout$1> continuation) {
        super(2, continuation);
        this.this$0 = deepSearchTimeoutServiceImp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchTimeoutServiceImp$greetLaunchTimeout$1 = new DeepSearchTimeoutServiceImp$greetLaunchTimeout$1(this.this$0, continuation);
        deepSearchTimeoutServiceImp$greetLaunchTimeout$1.L$0 = obj;
        return deepSearchTimeoutServiceImp$greetLaunchTimeout$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0056 -> B:9:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DeepSearchTimeoutServiceImp$greetLaunchTimeout$1 deepSearchTimeoutServiceImp$greetLaunchTimeout$1;
        MutableSharedFlow mutableSharedFlow;
        long j2;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                deepSearchTimeoutServiceImp$greetLaunchTimeout$1 = this;
                if (!CoroutineScopeKt.isActive($this$launch)) {
                    j2 = deepSearchTimeoutServiceImp$greetLaunchTimeout$1.this$0.timeoutInterval;
                    deepSearchTimeoutServiceImp$greetLaunchTimeout$1.L$0 = $this$launch;
                    deepSearchTimeoutServiceImp$greetLaunchTimeout$1.label = 1;
                    if (DelayKt.delay(j2, (Continuation) deepSearchTimeoutServiceImp$greetLaunchTimeout$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow = deepSearchTimeoutServiceImp$greetLaunchTimeout$1.this$0.greetFlow;
                    deepSearchTimeoutServiceImp$greetLaunchTimeout$1.L$0 = $this$launch;
                    deepSearchTimeoutServiceImp$greetLaunchTimeout$1.label = 2;
                    if (mutableSharedFlow.emit(DeepSearchTimeout.Companion.create(), (Continuation) deepSearchTimeoutServiceImp$greetLaunchTimeout$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!CoroutineScopeKt.isActive($this$launch)) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                deepSearchTimeoutServiceImp$greetLaunchTimeout$1 = this;
                mutableSharedFlow = deepSearchTimeoutServiceImp$greetLaunchTimeout$1.this$0.greetFlow;
                deepSearchTimeoutServiceImp$greetLaunchTimeout$1.L$0 = $this$launch;
                deepSearchTimeoutServiceImp$greetLaunchTimeout$1.label = 2;
                if (mutableSharedFlow.emit(DeepSearchTimeout.Companion.create(), (Continuation) deepSearchTimeoutServiceImp$greetLaunchTimeout$1) == coroutine_suspended) {
                }
                if (!CoroutineScopeKt.isActive($this$launch)) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                deepSearchTimeoutServiceImp$greetLaunchTimeout$1 = this;
                if (!CoroutineScopeKt.isActive($this$launch)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}