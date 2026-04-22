package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponseContainer;
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
/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.ReceiveError$install$1", f = "HttpCallValidator.kt", i = {0}, l = {149, 151}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class ReceiveError$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<HttpRequest, Throwable, Continuation<? super Throwable>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReceiveError$install$1(Function3<? super HttpRequest, ? super Throwable, ? super Continuation<? super Throwable>, ? extends Object> function3, Continuation<? super ReceiveError$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        ReceiveError$install$1 receiveError$install$1 = new ReceiveError$install$1(this.$handler, continuation);
        receiveError$install$1.L$0 = pipelineContext;
        return receiveError$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PipelineContext $this$intercept = this.label;
        try {
        } catch (Throwable cause) {
            Function3<HttpRequest, Throwable, Continuation<? super Throwable>, Object> function3 = this.$handler;
            HttpRequest request = ((HttpClientCall) $this$intercept.getContext()).getRequest();
            this.L$0 = null;
            this.label = 2;
            Object invoke = function3.invoke(request, cause, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result2 = $result;
            $result = invoke;
        }
        switch ($this$intercept) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                this.L$0 = $this$intercept2;
                this.label = 1;
                Object proceed = $this$intercept2.proceed((Continuation) this);
                $this$intercept = $this$intercept2;
                if (proceed == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$intercept = pipelineContext;
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                Throwable error = (Throwable) $result;
                if (error == null) {
                    return Unit.INSTANCE;
                }
                throw error;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}