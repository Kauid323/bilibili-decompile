package io.ktor.client.plugins.observer;

import io.ktor.client.plugins.observer.AfterReceiveHook;
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

/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.AfterReceiveHook$install$1", f = "ResponseObserver.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
final class AfterReceiveHook$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<AfterReceiveHook.Context, HttpResponse, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AfterReceiveHook$install$1(Function3<? super AfterReceiveHook.Context, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AfterReceiveHook$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AfterReceiveHook$install$1 afterReceiveHook$install$1 = new AfterReceiveHook$install$1(this.$handler, continuation);
        afterReceiveHook$install$1.L$0 = pipelineContext;
        return afterReceiveHook$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                Function3<AfterReceiveHook.Context, HttpResponse, Continuation<? super Unit>, Object> function3 = this.$handler;
                AfterReceiveHook.Context context = new AfterReceiveHook.Context($this$intercept);
                Object subject = $this$intercept.getSubject();
                this.label = 1;
                if (function3.invoke(context, subject, this) == coroutine_suspended) {
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