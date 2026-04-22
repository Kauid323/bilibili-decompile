package io.ktor.client.plugins.api;

import com.unionpay.tsmservice.mini.data.Constant;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.api.TransformRequestBodyHook$install$1", f = "KtorCallContexts.kt", i = {0}, l = {78, Constant.JAR_VERSION_CODE}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class TransformRequestBodyHook$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, Continuation<? super OutgoingContent>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformRequestBodyHook$install$1(Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object> function5, Continuation<? super TransformRequestBodyHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function5;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        TransformRequestBodyHook$install$1 transformRequestBodyHook$install$1 = new TransformRequestBodyHook$install$1(this.$handler, continuation);
        transformRequestBodyHook$install$1.L$0 = pipelineContext;
        return transformRequestBodyHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        PipelineContext $this$intercept;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                Function5<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, Continuation<? super OutgoingContent>, Object> function5 = this.$handler;
                TransformRequestBodyContext transformRequestBodyContext = new TransformRequestBodyContext();
                Object context = $this$intercept2.getContext();
                Object subject = $this$intercept2.getSubject();
                TypeInfo bodyType = ((HttpRequestBuilder) $this$intercept2.getContext()).getBodyType();
                this.L$0 = $this$intercept2;
                this.label = 1;
                Object invoke = function5.invoke(transformRequestBodyContext, context, subject, bodyType, this);
                if (invoke != coroutine_suspended) {
                    $result2 = $result;
                    $result = invoke;
                    $this$intercept = $this$intercept2;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                $result2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OutgoingContent newContent = (OutgoingContent) $result;
        if (newContent != null) {
            this.L$0 = null;
            this.label = 2;
            if ($this$intercept.proceedWith(newContent, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}