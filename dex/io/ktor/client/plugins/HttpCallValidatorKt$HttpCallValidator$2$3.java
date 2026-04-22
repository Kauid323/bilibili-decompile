package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequest;", "cause"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$3", f = "HttpCallValidator.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"unwrappedCause"}, s = {"L$0"})
public final class HttpCallValidatorKt$HttpCallValidator$2$3 extends SuspendLambda implements Function3<HttpRequest, Throwable, Continuation<? super Throwable>, Object> {
    final /* synthetic */ List<HandlerWrapper> $callExceptionHandlers;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidatorKt$HttpCallValidator$2$3(List<? extends HandlerWrapper> list, Continuation<? super HttpCallValidatorKt$HttpCallValidator$2$3> continuation) {
        super(3, continuation);
        this.$callExceptionHandlers = list;
    }

    public final Object invoke(HttpRequest httpRequest, Throwable th, Continuation<? super Throwable> continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$3 httpCallValidatorKt$HttpCallValidator$2$3 = new HttpCallValidatorKt$HttpCallValidator$2$3(this.$callExceptionHandlers, continuation);
        httpCallValidatorKt$HttpCallValidator$2$3.L$0 = httpRequest;
        httpCallValidatorKt$HttpCallValidator$2$3.L$1 = th;
        return httpCallValidatorKt$HttpCallValidator$2$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object HttpCallValidator$lambda$2$processException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpRequest request = (HttpRequest) this.L$0;
                Throwable cause = ExceptionUtilsJvmKt.unwrapCancellationException((Throwable) this.L$1);
                this.L$0 = cause;
                this.label = 1;
                HttpCallValidator$lambda$2$processException = HttpCallValidatorKt.HttpCallValidator$lambda$2$processException(this.$callExceptionHandlers, cause, request, (Continuation) this);
                if (HttpCallValidator$lambda$2$processException == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return cause;
            case 1:
                Throwable unwrappedCause = (Throwable) this.L$0;
                ResultKt.throwOnFailure($result);
                return unwrappedCause;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}