package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelineContext.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a¢\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00012O\u0010\u000b\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0002\b\n0\u00042\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TSubject", "TContext", "context", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelineInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptors", "subject", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "debugMode", "pipelineContextFor", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Z)Lio/ktor/util/pipeline/PipelineContext;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PipelineContextKt {
    public static /* synthetic */ PipelineContext pipelineContextFor$default(Object obj, List list, Object obj2, CoroutineContext coroutineContext, boolean z, int i, Object obj3) {
        if ((i & 16) != 0) {
            z = false;
        }
        return pipelineContextFor(obj, list, obj2, coroutineContext, z);
    }

    public static final <TSubject, TContext> PipelineContext<TSubject, TContext> pipelineContextFor(TContext tcontext, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list, TSubject tsubject, CoroutineContext coroutineContext, boolean debugMode) {
        Intrinsics.checkNotNullParameter(tcontext, "context");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(tsubject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if (PipelineContext_jvmKt.getDISABLE_SFG() || debugMode) {
            return new DebugPipelineContext(tcontext, list, tsubject, coroutineContext);
        }
        return new SuspendFunctionGun(tsubject, tcontext, list);
    }
}