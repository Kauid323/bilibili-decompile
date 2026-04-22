package io.ktor.client.plugins.cookies;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$Companion$install$3", f = "HttpCookies.kt", i = {}, l = {TbsListener.ErrorCode.DOWNLOAD_REDIRECT_EMPTY}, m = "invokeSuspend", n = {}, s = {})
final class HttpCookies$Companion$install$3 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCookies $plugin;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$Companion$install$3(HttpCookies httpCookies, Continuation<? super HttpCookies$Companion$install$3> continuation) {
        super(3, continuation);
        this.$plugin = httpCookies;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCookies$Companion$install$3 httpCookies$Companion$install$3 = new HttpCookies$Companion$install$3(this.$plugin, continuation);
        httpCookies$Companion$install$3.L$0 = httpResponse;
        return httpCookies$Companion$install$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpResponse response = (HttpResponse) this.L$0;
                this.label = 1;
                if (this.$plugin.saveCookiesFrom$ktor_client_core(response, (Continuation) this) == coroutine_suspended) {
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