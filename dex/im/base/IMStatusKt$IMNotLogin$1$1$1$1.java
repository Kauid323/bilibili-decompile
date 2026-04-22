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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMStatus.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMStatusKt$IMNotLogin$1$1$1$1", f = "IMStatus.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMStatusKt$IMNotLogin$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Uri, Continuation<? super Unit>, Object> $routeHandler;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMStatusKt$IMNotLogin$1$1$1$1(Function2<? super Uri, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super IMStatusKt$IMNotLogin$1$1$1$1> continuation) {
        super(2, continuation);
        this.$routeHandler = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMStatusKt$IMNotLogin$1$1$1$1(this.$routeHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<Uri, Continuation<? super Unit>, Object> function2 = this.$routeHandler;
                Uri parse = Uri.Companion.parse("bilibili://login");
                this.label = 1;
                if (function2.invoke(parse, this) == coroutine_suspended) {
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