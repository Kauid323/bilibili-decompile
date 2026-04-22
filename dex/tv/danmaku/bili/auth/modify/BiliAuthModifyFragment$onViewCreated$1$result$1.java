package tv.danmaku.bili.auth.modify;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthModifyFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.modify.BiliAuthModifyFragment$onViewCreated$1$result$1", f = "BiliAuthModifyFragment.kt", i = {}, l = {BR.bgImageUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthModifyFragment$onViewCreated$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ BiliAuthModifyFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliAuthModifyFragment$onViewCreated$1$result$1(BiliAuthModifyFragment biliAuthModifyFragment, Continuation<? super BiliAuthModifyFragment$onViewCreated$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = biliAuthModifyFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliAuthModifyFragment$onViewCreated$1$result$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object modifyAllow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BLog.i(BiliAuthModifyFragment.TAG, "request Modify Allow");
                this.label = 1;
                modifyAllow = this.this$0.getModifyAllow((Continuation) this);
                if (modifyAllow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return modifyAllow;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}