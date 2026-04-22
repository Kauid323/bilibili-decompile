package io.ktor.util.pipeline;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import com.bilibili.studio.editor.moudle.editormain.ui.toolbar.beans.EditorToolBarItemType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [TContext] */
/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "subject"}, k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", i = {}, l = {EditorToolBarItemType.CLIP_EDIT_DELETE}, m = "invokeSuspend", n = {}, s = {})
public final class PipelineKt$intercept$1<TContext> extends SuspendLambda implements Function3<PipelineContext<? extends Object, TContext>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PipelineKt$intercept$1(Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super PipelineKt$intercept$1> continuation) {
        super(3, continuation);
        this.$block = function3;
    }

    public final Object invoke(PipelineContext<? extends Object, TContext> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        PipelineKt$intercept$1 pipelineKt$intercept$1 = new PipelineKt$intercept$1(this.$block, continuation);
        pipelineKt$intercept$1.L$0 = pipelineContext;
        pipelineKt$intercept$1.L$1 = obj;
        return pipelineKt$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((PipelineContext) ((PipelineContext) obj), obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$interceptor = (PipelineContext) this.L$0;
                Object subject = this.L$1;
                Intrinsics.reifiedOperationMarker(3, "TSubject");
                if (!(subject instanceof Object)) {
                    return Unit.INSTANCE;
                }
                if (!($this$interceptor instanceof PipelineContext)) {
                    $this$interceptor = null;
                }
                if ($this$interceptor != null) {
                    Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> function3 = this.$block;
                    this.L$0 = null;
                    this.label = 1;
                    if (function3.invoke($this$interceptor, subject, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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