package im.base;

import com.bilibili.lib.brouter.uri.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: IMPageStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/brouter/uri/Uri;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMPageStatusKt$IMPageStatus$5$1$1", f = "IMPageStatus.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
final class IMPageStatusKt$IMPageStatus$5$1$1 extends SuspendLambda implements Function2<Uri, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Uri, Continuation<? super Unit>, Object> $onLogin;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMPageStatusKt$IMPageStatus$5$1$1(Function2<? super Uri, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super IMPageStatusKt$IMPageStatus$5$1$1> continuation) {
        super(2, continuation);
        this.$onLogin = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMPageStatusKt$IMPageStatus$5$1$1 = new IMPageStatusKt$IMPageStatus$5$1$1(this.$onLogin, continuation);
        iMPageStatusKt$IMPageStatus$5$1$1.L$0 = obj;
        return iMPageStatusKt$IMPageStatus$5$1$1;
    }

    public final Object invoke(Uri uri, Continuation<? super Unit> continuation) {
        return create(uri, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Uri it = (Uri) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<Uri, Continuation<? super Unit>, Object> function2 = this.$onLogin;
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (function2.invoke(it, this) == coroutine_suspended) {
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