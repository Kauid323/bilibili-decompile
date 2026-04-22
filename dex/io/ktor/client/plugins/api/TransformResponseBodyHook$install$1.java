package io.ktor.client.plugins.api;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.content.NullBody;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KtorCallContexts.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.api.TransformResponseBodyHook$install$1", f = "KtorCallContexts.kt", i = {0, 0}, l = {104, TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR}, m = "invokeSuspend", n = {"$this$intercept", "typeInfo"}, s = {"L$0", "L$1"})
public final class TransformResponseBodyHook$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<Object>, Object> $handler;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformResponseBodyHook$install$1(Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<Object>, ? extends Object> function5, Continuation<? super TransformResponseBodyHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function5;
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        TransformResponseBodyHook$install$1 transformResponseBodyHook$install$1 = new TransformResponseBodyHook$install$1(this.$handler, continuation);
        transformResponseBodyHook$install$1.L$0 = pipelineContext;
        return transformResponseBodyHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PipelineContext $this$intercept;
        TypeInfo typeInfo;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) $this$intercept.getSubject();
                typeInfo = httpResponseContainer.component1();
                Object content = httpResponseContainer.component2();
                if (content instanceof ByteReadChannel) {
                    Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<Object>, Object> function5 = this.$handler;
                    TransformResponseBodyContext transformResponseBodyContext = new TransformResponseBodyContext();
                    HttpResponse response = ((HttpClientCall) $this$intercept.getContext()).getResponse();
                    this.L$0 = $this$intercept;
                    this.L$1 = typeInfo;
                    this.label = 1;
                    Object content2 = function5.invoke(transformResponseBodyContext, response, content, typeInfo, this);
                    if (content2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = content2;
                    if ($result != null) {
                        return Unit.INSTANCE;
                    }
                    if (!($result instanceof NullBody) && !typeInfo.getType().isInstance($result)) {
                        throw new IllegalStateException("transformResponseBody returned " + $result + " but expected value of type " + typeInfo);
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    Object newContent = $this$intercept.proceedWith(new HttpResponseContainer(typeInfo, $result), (Continuation) this);
                    if (newContent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                $this$intercept = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                typeInfo = (TypeInfo) this.L$1;
                $result2 = $result;
                if ($result != null) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}