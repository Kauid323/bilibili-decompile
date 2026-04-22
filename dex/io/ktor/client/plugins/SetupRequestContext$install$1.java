package io.ktor.client.plugins;

import host.R;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestLifecycle.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.SetupRequestContext$install$1", f = "HttpRequestLifecycle.kt", i = {}, l = {R.styleable.CameraView_cameraSnapshotMaxHeight}, m = "invokeSuspend", n = {}, s = {})
public final class SetupRequestContext$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<HttpRequestBuilder, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SetupRequestContext$install$1(Function3<? super HttpRequestBuilder, ? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super SetupRequestContext$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        SetupRequestContext$install$1 setupRequestContext$install$1 = new SetupRequestContext$install$1(this.$handler, continuation);
        setupRequestContext$install$1.L$0 = pipelineContext;
        return setupRequestContext$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestLifecycle.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.SetupRequestContext$install$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(1, obj, PipelineContext.class, "proceed", "proceed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 8);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return SetupRequestContext$install$1.invokeSuspend$proceed((PipelineContext) this.receiver, continuation);
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                Function3<HttpRequestBuilder, Function1<? super Continuation<? super Unit>, ? extends Object>, Continuation<? super Unit>, Object> function3 = this.$handler;
                Object context = $this$intercept.getContext();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1($this$intercept);
                this.label = 1;
                if (function3.invoke(context, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object invokeSuspend$proceed(PipelineContext $this$invokeSuspend_u24proceed, Continuation $completion) {
        Object proceed = $this$invokeSuspend_u24proceed.proceed($completion);
        return proceed == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceed : Unit.INSTANCE;
    }
}