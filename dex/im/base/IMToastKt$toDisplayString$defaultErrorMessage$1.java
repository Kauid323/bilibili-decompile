package im.base;

import bili.resource.common.CommonRes;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMToast.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMToastKt$toDisplayString$defaultErrorMessage$1", f = "IMToast.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMToastKt$toDisplayString$defaultErrorMessage$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMToastKt$toDisplayString$defaultErrorMessage$1(Continuation<? super IMToastKt$toDisplayString$defaultErrorMessage$1> continuation) {
        super(1, continuation);
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new IMToastKt$toDisplayString$defaultErrorMessage$1(continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object suspendGetString = CommonRes.INSTANCE.suspendGetString(String0_commonMainKt.getCommon_global_string_378(Res.string.INSTANCE), (Continuation) this);
                return suspendGetString == coroutine_suspended ? coroutine_suspended : suspendGetString;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}