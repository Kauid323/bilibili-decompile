package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.AfterReceiveHook$install$1", f = "BodyProgress.kt", i = {0}, l = {48, 49}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
final class AfterReceiveHook$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<HttpResponse, Continuation<? super HttpResponse>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AfterReceiveHook$install$1(Function2<? super HttpResponse, ? super Continuation<? super HttpResponse>, ? extends Object> function2, Continuation<? super AfterReceiveHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function2;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AfterReceiveHook$install$1 afterReceiveHook$install$1 = new AfterReceiveHook$install$1(this.$handler, continuation);
        afterReceiveHook$install$1.L$0 = pipelineContext;
        afterReceiveHook$install$1.L$1 = httpResponse;
        return afterReceiveHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        PipelineContext $this$intercept;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                HttpResponse response = (HttpResponse) this.L$1;
                Function2<HttpResponse, Continuation<? super HttpResponse>, Object> function2 = this.$handler;
                this.L$0 = $this$intercept2;
                this.label = 1;
                Object invoke = function2.invoke(response, this);
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
        HttpResponse newResponse = (HttpResponse) $result;
        if (newResponse != null) {
            this.L$0 = null;
            this.label = 2;
            if ($this$intercept.proceedWith(newResponse, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}