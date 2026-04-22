package im.keywordBlocking.stateMachine;

import com.tencent.smtt.sdk.TbsListener;
import im.base.IMLog;
import im.keywordBlocking.KBActionAddItem;
import im.keywordBlocking.KBPageData;
import im.keywordBlocking.log.LogTagKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/keywordBlocking/KBPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$initialLoad$8$1", f = "KBStateMachine.kt", i = {}, l = {TbsListener.ErrorCode.DOWNLOAD_NOT_WIFI_ERROR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$initialLoad$8$1 extends SuspendLambda implements Function2<KBPageData, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KBStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBStateMachine$initialLoad$8$1(KBStateMachine kBStateMachine, Continuation<? super KBStateMachine$initialLoad$8$1> continuation) {
        super(2, continuation);
        this.this$0 = kBStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KBStateMachine$initialLoad$8$1(this.this$0, continuation);
    }

    public final Object invoke(KBPageData kBPageData, Continuation<? super Unit> continuation) {
        return create(kBPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.KB_LOG_TAG, "列表为空，直接弹出添加输入框");
                this.label = 1;
                if (this.this$0.dispatch(KBActionAddItem.INSTANCE, (Continuation) this) == coroutine_suspended) {
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