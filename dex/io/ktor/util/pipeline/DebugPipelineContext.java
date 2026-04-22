package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import io.ktor.utils.io.KtorDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugPipelineContext.kt */
@KtorDsl
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004Bp\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012O\u0010\f\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\n¢\u0006\u0002\b\u000b0\u0006\u0012\u0006\u0010\r\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001b\u001a\u00028\u0000H\u0082@¢\u0006\u0004\b\u001b\u0010\u0017R]\u0010\f\u001aK\u0012G\u0012E\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\n¢\u0006\u0002\b\u000b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00028\u00008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lio/ktor/util/pipeline/DebugPipelineContext;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "TSubject", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "context", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lio/ktor/util/pipeline/PipelineInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptors", "subject", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "finish", "()V", "proceedWith", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initial", "execute$ktor_utils", "execute", "proceedLoop", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Object;", "getSubject", "()Ljava/lang/Object;", "setSubject", "(Ljava/lang/Object;)V", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "index", "I", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    private final CoroutineContext coroutineContext;
    private int index;
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    private TSubject subject;

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext(TContext tcontext, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> list, TSubject tsubject, CoroutineContext coroutineContext) {
        super(tcontext);
        Intrinsics.checkNotNullParameter(tcontext, "context");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(tsubject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.interceptors = list;
        this.coroutineContext = coroutineContext;
        this.subject = tsubject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public TSubject getSubject() {
        return this.subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void setSubject(TSubject tsubject) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void finish() {
        this.index = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation) {
        setSubject(tsubject);
        return proceed(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceed(Continuation<? super TSubject> continuation) {
        int index = this.index;
        if (index < 0) {
            return getSubject();
        }
        if (index >= this.interceptors.size()) {
            finish();
            return getSubject();
        }
        return proceedLoop(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.index = 0;
        setSubject(tsubject);
        return proceed(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object proceedLoop(Continuation<? super TSubject> continuation) {
        DebugPipelineContext$proceedLoop$1 debugPipelineContext$proceedLoop$1;
        Object coroutine_suspended;
        DebugPipelineContext debugPipelineContext;
        int index;
        Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> executeInterceptor;
        TSubject subject;
        if (continuation instanceof DebugPipelineContext$proceedLoop$1) {
            debugPipelineContext$proceedLoop$1 = (DebugPipelineContext$proceedLoop$1) continuation;
            if ((debugPipelineContext$proceedLoop$1.label & Integer.MIN_VALUE) != 0) {
                debugPipelineContext$proceedLoop$1.label -= Integer.MIN_VALUE;
                Object $result = debugPipelineContext$proceedLoop$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (debugPipelineContext$proceedLoop$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        debugPipelineContext = this;
                        break;
                    case 1:
                        debugPipelineContext = (DebugPipelineContext) debugPipelineContext$proceedLoop$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                do {
                    index = debugPipelineContext.index;
                    if (index == -1) {
                        List interceptors = debugPipelineContext.interceptors;
                        if (index >= interceptors.size()) {
                            debugPipelineContext.finish();
                        } else {
                            executeInterceptor = interceptors.get(index);
                            debugPipelineContext.index = index + 1;
                            subject = debugPipelineContext.getSubject();
                            debugPipelineContext$proceedLoop$1.L$0 = debugPipelineContext;
                            debugPipelineContext$proceedLoop$1.label = 1;
                        }
                    }
                    return debugPipelineContext.getSubject();
                } while (executeInterceptor.invoke(debugPipelineContext, subject, debugPipelineContext$proceedLoop$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        debugPipelineContext$proceedLoop$1 = new DebugPipelineContext$proceedLoop$1(this, continuation);
        Object $result2 = debugPipelineContext$proceedLoop$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (debugPipelineContext$proceedLoop$1.label) {
        }
        do {
            index = debugPipelineContext.index;
            if (index == -1) {
            }
            return debugPipelineContext.getSubject();
        } while (executeInterceptor.invoke(debugPipelineContext, subject, debugPipelineContext$proceedLoop$1) != coroutine_suspended);
        return coroutine_suspended;
    }
}