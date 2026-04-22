package im.direct.notification.interactive;

import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: GetStringById.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.GetStringById_androidKt$getStringById$res$2", f = "GetStringById.android.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GetStringById_androidKt$getStringById$res$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetStringById_androidKt$getStringById$res$2(Continuation<? super GetStringById_androidKt$getStringById$res$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GetStringById_androidKt$getStringById$res$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object string = StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_880(Res.string.INSTANCE), (Continuation) this);
                return string == coroutine_suspended ? coroutine_suspended : string;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}