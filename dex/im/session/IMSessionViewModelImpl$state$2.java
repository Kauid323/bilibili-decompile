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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lim/session/IMState;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionViewModelImpl$state$2", f = "IMSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionViewModelImpl$state$2 extends SuspendLambda implements Function3<FlowCollector<? super IMState>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMSessionViewModelImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionViewModelImpl$state$2(IMSessionViewModelImpl iMSessionViewModelImpl, Continuation<? super IMSessionViewModelImpl$state$2> continuation) {
        super(3, continuation);
        this.this$0 = iMSessionViewModelImpl;
    }

    public final Object invoke(FlowCollector<? super IMState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        IMSessionViewModelImpl$state$2 iMSessionViewModelImpl$state$2 = new IMSessionViewModelImpl$state$2(this.this$0, continuation);
        iMSessionViewModelImpl$state$2.L$0 = th;
        return iMSessionViewModelImpl$state$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable it = (Throwable) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getVMLogTag(), "会话列表 " + this.this$0.getPageType() + " 状态机关闭(onCompletion) " + it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}