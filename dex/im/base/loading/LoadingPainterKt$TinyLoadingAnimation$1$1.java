package im.base.loading;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoadingPainter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.loading.LoadingPainterKt$TinyLoadingAnimation$1$1", f = "LoadingPainter.kt", i = {1, 1}, l = {28, 31}, m = "invokeSuspend", n = {"nextFrame", "start"}, s = {"L$0", "J$0"}, v = 1)
public final class LoadingPainterKt$TinyLoadingAnimation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $frame$delegate;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingPainterKt$TinyLoadingAnimation$1$1(MutableIntState mutableIntState, Continuation<? super LoadingPainterKt$TinyLoadingAnimation$1$1> continuation) {
        super(2, continuation);
        this.$frame$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadingPainterKt$TinyLoadingAnimation$1$1(this.$frame$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object withFrameMillis;
        long start;
        final Ref.LongRef nextFrame;
        long j;
        LoadingPainterKt$TinyLoadingAnimation$1$1 loadingPainterKt$TinyLoadingAnimation$1$1;
        final MutableIntState mutableIntState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                withFrameMillis = MonotonicFrameClockKt.withFrameMillis(new Function1() { // from class: im.base.loading.LoadingPainterKt$TinyLoadingAnimation$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Duration invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = LoadingPainterKt$TinyLoadingAnimation$1$1.invokeSuspend$lambda$0(((Long) obj).longValue());
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this);
                if (withFrameMillis == coroutine_suspended) {
                    return coroutine_suspended;
                }
                start = ((Duration) withFrameMillis).unbox-impl();
                nextFrame = new Ref.LongRef();
                j = LoadingPainterKt.LOADING_FRAME_TICK;
                nextFrame.element = Duration.plus-LRDsOJo(start, j);
                loadingPainterKt$TinyLoadingAnimation$1$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                withFrameMillis = $result;
                start = ((Duration) withFrameMillis).unbox-impl();
                nextFrame = new Ref.LongRef();
                j = LoadingPainterKt.LOADING_FRAME_TICK;
                nextFrame.element = Duration.plus-LRDsOJo(start, j);
                loadingPainterKt$TinyLoadingAnimation$1$1 = this;
                break;
            case 2:
                start = this.J$0;
                nextFrame = (Ref.LongRef) this.L$0;
                ResultKt.throwOnFailure($result);
                loadingPainterKt$TinyLoadingAnimation$1$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            mutableIntState = loadingPainterKt$TinyLoadingAnimation$1$1.$frame$delegate;
            loadingPainterKt$TinyLoadingAnimation$1$1.L$0 = nextFrame;
            loadingPainterKt$TinyLoadingAnimation$1$1.J$0 = start;
            loadingPainterKt$TinyLoadingAnimation$1$1.label = 2;
        } while (MonotonicFrameClockKt.withFrameMillis(new Function1() { // from class: im.base.loading.LoadingPainterKt$TinyLoadingAnimation$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = LoadingPainterKt$TinyLoadingAnimation$1$1.invokeSuspend$lambda$1(nextFrame, mutableIntState, ((Long) obj).longValue());
                return invokeSuspend$lambda$1;
            }
        }, (Continuation) loadingPainterKt$TinyLoadingAnimation$1$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Duration invokeSuspend$lambda$0(long it) {
        Duration.Companion companion = Duration.Companion;
        return Duration.box-impl(DurationKt.toDuration(it, DurationUnit.MILLISECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Ref.LongRef $nextFrame, MutableIntState $frame$delegate, long millis) {
        int TinyLoadingAnimation$lambda$1;
        long j;
        Duration.Companion companion = Duration.Companion;
        long now = DurationKt.toDuration(millis, DurationUnit.MILLISECONDS);
        if (Duration.compareTo-LRDsOJo(now, $nextFrame.element) >= 0) {
            TinyLoadingAnimation$lambda$1 = LoadingPainterKt.TinyLoadingAnimation$lambda$1($frame$delegate);
            $frame$delegate.setIntValue((TinyLoadingAnimation$lambda$1 + 1) % 12);
            long j2 = $nextFrame.element;
            j = LoadingPainterKt.LOADING_FRAME_TICK;
            $nextFrame.element = Duration.plus-LRDsOJo(j2, j);
        }
        return Unit.INSTANCE;
    }
}