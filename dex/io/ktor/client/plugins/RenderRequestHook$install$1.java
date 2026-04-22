package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpPlainText.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.RenderRequestHook$install$1", f = "HttpPlainText.kt", i = {0}, l = {145, 146}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class RenderRequestHook$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<HttpRequestBuilder, Object, Continuation<? super OutgoingContent>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RenderRequestHook$install$1(Function3<? super HttpRequestBuilder, Object, ? super Continuation<? super OutgoingContent>, ? extends Object> function3, Continuation<? super RenderRequestHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        RenderRequestHook$install$1 renderRequestHook$install$1 = new RenderRequestHook$install$1(this.$handler, continuation);
        renderRequestHook$install$1.L$0 = pipelineContext;
        renderRequestHook$install$1.L$1 = obj;
        return renderRequestHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        PipelineContext $this$intercept;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                Object content = this.L$1;
                Function3<HttpRequestBuilder, Object, Continuation<? super OutgoingContent>, Object> function3 = this.$handler;
                Object context = $this$intercept2.getContext();
                this.L$0 = $this$intercept2;
                this.label = 1;
                Object content2 = function3.invoke(context, content, this);
                if (content2 != coroutine_suspended) {
                    $result2 = $result;
                    $result = content2;
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
        OutgoingContent result = (OutgoingContent) $result;
        if (result != null) {
            this.L$0 = null;
            this.label = 2;
            if ($this$intercept.proceedWith(result, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}