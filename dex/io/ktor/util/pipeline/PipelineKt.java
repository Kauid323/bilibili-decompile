package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import io.ktor.util.debug.ContextUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0005\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001a|\u0010\u000f\u001a\u00020\u0003\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u0000*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\t\u001a\u00020\b2;\b\b\u0010\u000e\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n¢\u0006\u0002\b\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010*p\b\u0000\u0010\u0011\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\".\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n2.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n*|\u0010\u0012\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\"5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n¢\u0006\u0002\b\r25\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n¢\u0006\u0002\b\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TContext", "Lio/ktor/util/pipeline/Pipeline;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "context", "execute", "(Lio/ktor/util/pipeline/Pipeline;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TSubject", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "block", "intercept", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "PipelineInterceptorCoroutine", "PipelineInterceptor", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PipelineKt {
    public static final <TContext> Object execute(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        Object initContextInDebugMode = ContextUtilsKt.initContextInDebugMode(new PipelineKt$execute$2(pipeline, tcontext, null), continuation);
        return initContextInDebugMode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? initContextInDebugMode : Unit.INSTANCE;
    }

    private static final <TContext> Object execute$$forInline(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        ContextUtilsKt.initContextInDebugMode(new PipelineKt$execute$2(pipeline, tcontext, null), continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <TSubject, TContext> void intercept(Pipeline<?, TContext> pipeline, PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(pipeline, "<this>");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(function3, "block");
        Intrinsics.needClassReification();
        pipeline.intercept(phase, new PipelineKt$intercept$1(function3, null));
    }
}