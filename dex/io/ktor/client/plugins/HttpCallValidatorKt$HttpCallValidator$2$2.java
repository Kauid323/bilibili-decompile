package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$2", f = "HttpCallValidator.kt", i = {1}, l = {TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, TbsListener.ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH}, m = "invokeSuspend", n = {"call"}, s = {"L$0"})
public final class HttpCallValidatorKt$HttpCallValidator$2$2 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ List<Function2<HttpResponse, Continuation<? super Unit>, Object>> $responseValidators;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidatorKt$HttpCallValidator$2$2(List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> list, Continuation<? super HttpCallValidatorKt$HttpCallValidator$2$2> continuation) {
        super(3, continuation);
        this.$responseValidators = list;
    }

    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$2 httpCallValidatorKt$HttpCallValidator$2$2 = new HttpCallValidatorKt$HttpCallValidator$2$2(this.$responseValidators, continuation);
        httpCallValidatorKt$HttpCallValidator$2$2.L$0 = sender;
        httpCallValidatorKt$HttpCallValidator$2$2.L$1 = httpRequestBuilder;
        return httpCallValidatorKt$HttpCallValidator$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object HttpCallValidator$lambda$2$validateResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Send.Sender $this$on = (Send.Sender) this.L$0;
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$1;
                this.L$0 = null;
                this.label = 1;
                Object proceed = $this$on.proceed(request, (Continuation) this);
                if (proceed != coroutine_suspended) {
                    $result2 = $result;
                    $result = proceed;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            case 2:
                HttpClientCall call = (HttpClientCall) this.L$0;
                ResultKt.throwOnFailure($result);
                return call;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpClientCall call2 = (HttpClientCall) $result;
        this.L$0 = call2;
        this.label = 2;
        HttpCallValidator$lambda$2$validateResponse = HttpCallValidatorKt.HttpCallValidator$lambda$2$validateResponse(this.$responseValidators, call2.getResponse(), (Continuation) this);
        return HttpCallValidator$lambda$2$validateResponse == coroutine_suspended ? coroutine_suspended : call2;
    }
}