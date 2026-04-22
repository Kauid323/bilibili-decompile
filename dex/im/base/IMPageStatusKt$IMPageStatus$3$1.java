package im.base;

import com.bilibili.lib.brouter.uri.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: IMPageStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bilibili/lib/brouter/uri/Uri;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMPageStatusKt$IMPageStatus$3$1", f = "IMPageStatus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMPageStatusKt$IMPageStatus$3$1 extends SuspendLambda implements Function2<Uri, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMPageStatusKt$IMPageStatus$3$1(Continuation<? super IMPageStatusKt$IMPageStatus$3$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMPageStatusKt$IMPageStatus$3$1(continuation);
    }

    public final Object invoke(Uri uri, Continuation<? super Unit> continuation) {
        return create(uri, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}