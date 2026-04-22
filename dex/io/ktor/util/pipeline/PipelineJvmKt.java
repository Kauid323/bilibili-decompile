package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: PipelineJvm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u009a\u0001\u0010\r\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002I\u0010\t\u001aE\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0007¢\u0006\u0002\b\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TSubject", "TContext", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelineInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptor", "context", "subject", "continuation", "pipelineStartCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function3;Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PipelineJvmKt {
    public static final <TSubject, TContext> Object pipelineStartCoroutineUninterceptedOrReturn(Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3, PipelineContext<TSubject, TContext> pipelineContext, TSubject tsubject, Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(function3, "interceptor");
        Intrinsics.checkNotNullParameter(pipelineContext, "context");
        Intrinsics.checkNotNullParameter(tsubject, "subject");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(pipelineContext, tsubject, continuation);
    }
}