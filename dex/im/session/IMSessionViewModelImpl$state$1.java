package im.session;

import im.base.IMLog;
import im.session.log.LogTagKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionViewModelImpl$state$1", f = "IMSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionViewModelImpl$state$1 extends SuspendLambda implements Function2<FlowCollector<? super IMState>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IMSessionViewModelImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionViewModelImpl$state$1(IMSessionViewModelImpl iMSessionViewModelImpl, Continuation<? super IMSessionViewModelImpl$state$1> continuation) {
        super(2, continuation);
        this.this$0 = iMSessionViewModelImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionViewModelImpl$state$1(this.this$0, continuation);
    }

    public final Object invoke(FlowCollector<? super IMState> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getVMLogTag(), "会话列表 " + this.this$0.getPageType() + " 状态机启动(onStart)");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}