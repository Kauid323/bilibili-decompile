package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestLifecycle.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", "", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", "proceed", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycleKt$HttpRequestLifecycle$1$1", f = "HttpRequestLifecycle.kt", i = {0}, l = {27}, m = "invokeSuspend", n = {"executionContext"}, s = {"L$0"})
public final class HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 extends SuspendLambda implements Function3<HttpRequestBuilder, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClientPluginBuilder<Unit> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(ClientPluginBuilder<Unit> clientPluginBuilder, Continuation<? super HttpRequestLifecycleKt$HttpRequestLifecycle$1$1> continuation) {
        super(3, continuation);
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    public final Object invoke(HttpRequestBuilder httpRequestBuilder, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 httpRequestLifecycleKt$HttpRequestLifecycle$1$1 = new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(this.$this_createClientPlugin, continuation);
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$0 = httpRequestBuilder;
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$1 = function1;
        return httpRequestLifecycleKt$HttpRequestLifecycle$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CompletableJob executionContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                Function1 proceed = (Function1) this.L$1;
                CompletableJob executionContext2 = SupervisorKt.SupervisorJob(request.getExecutionContext());
                Job job = this.$this_createClientPlugin.getClient().getCoroutineContext().get(Job.Key);
                Intrinsics.checkNotNull(job);
                HttpRequestLifecycleKt.attachToClientEngineJob(executionContext2, job);
                try {
                    request.setExecutionContext$ktor_client_core((Job) executionContext2);
                    this.L$0 = executionContext2;
                    this.label = 1;
                    if (proceed.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    executionContext = executionContext2;
                    executionContext.complete();
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    cause = th;
                    executionContext = executionContext2;
                    try {
                        executionContext.completeExceptionally(cause);
                        throw cause;
                    } catch (Throwable cause) {
                        executionContext.complete();
                        throw cause;
                    }
                }
            case 1:
                executionContext = (CompletableJob) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    executionContext.complete();
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    cause = th2;
                    executionContext.completeExceptionally(cause);
                    throw cause;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}