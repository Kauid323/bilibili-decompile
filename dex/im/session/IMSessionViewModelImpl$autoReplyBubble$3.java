package im.session;

import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
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

/* compiled from: IMSessionViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.IMSessionViewModelImpl$autoReplyBubble$3", f = "IMSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSessionViewModelImpl$autoReplyBubble$3 extends SuspendLambda implements Function2<KAutoReplyToast, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionViewModelImpl$autoReplyBubble$3(Continuation<? super IMSessionViewModelImpl$autoReplyBubble$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMSessionViewModelImpl$autoReplyBubble$3 = new IMSessionViewModelImpl$autoReplyBubble$3(continuation);
        iMSessionViewModelImpl$autoReplyBubble$3.L$0 = obj;
        return iMSessionViewModelImpl$autoReplyBubble$3;
    }

    public final Object invoke(KAutoReplyToast kAutoReplyToast, Continuation<? super Unit> continuation) {
        return create(kAutoReplyToast, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KAutoReplyToast it = (KAutoReplyToast) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getVMLogTag(), "自动回复气泡: " + it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}