package kntr.app.deepsearch.ui.ae;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeepBottomEffect.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.ae.KeepBottomEffectKt$keepBottom$4$1", f = "KeepBottomEffect.kt", i = {0, 0, 1, 1, 2}, l = {105, 107, 118}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "p", "$this$LaunchedEffect", "p", "$this$LaunchedEffect"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0"}, v = 1)
public final class KeepBottomEffectKt$keepBottom$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $imeVisible;
    final /* synthetic */ MutableState<Boolean> $isAtBottom$delegate;
    final /* synthetic */ LazyListState $this_keepBottom;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepBottomEffectKt$keepBottom$4$1(boolean z, LazyListState lazyListState, MutableState<Boolean> mutableState, Continuation<? super KeepBottomEffectKt$keepBottom$4$1> continuation) {
        super(2, continuation);
        this.$imeVisible = z;
        this.$this_keepBottom = lazyListState;
        this.$isAtBottom$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> keepBottomEffectKt$keepBottom$4$1 = new KeepBottomEffectKt$keepBottom$4$1(this.$imeVisible, this.$this_keepBottom, this.$isAtBottom$delegate, continuation);
        keepBottomEffectKt$keepBottom$4$1.L$0 = obj;
        return keepBottomEffectKt$keepBottom$4$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        if (r5.$this_keepBottom.getCanScrollForward() == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0096 -> B:29:0x0099). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean keepBottom$lambda$5;
        int p;
        boolean keepBottom$lambda$52;
        KeepBottomEffectKt$keepBottom$4$1 keepBottomEffectKt$keepBottom$4$1;
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$imeVisible) {
                    p = 0;
                    keepBottom$lambda$52 = KeepBottomEffectKt.keepBottom$lambda$5(this.$isAtBottom$delegate);
                    if (keepBottom$lambda$52) {
                        keepBottomEffectKt$keepBottom$4$1 = this;
                        if (!keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.isScrollInProgress() && CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                            if (keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.getLayoutInfo().getTotalItemsCount() > 0 && keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.getCanScrollForward()) {
                                keepBottomEffectKt$keepBottom$4$1.L$0 = $this$LaunchedEffect;
                                keepBottomEffectKt$keepBottom$4$1.I$0 = p;
                                keepBottomEffectKt$keepBottom$4$1.label = 1;
                                if (keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.scrollToItem(keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.getLayoutInfo().getTotalItemsCount() - 1, Integer.MAX_VALUE, (Continuation) keepBottomEffectKt$keepBottom$4$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            Duration.Companion companion = Duration.Companion;
                            keepBottomEffectKt$keepBottom$4$1.L$0 = $this$LaunchedEffect;
                            keepBottomEffectKt$keepBottom$4$1.I$0 = p;
                            keepBottomEffectKt$keepBottom$4$1.label = 2;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(10L, DurationUnit.MILLISECONDS), (Continuation) keepBottomEffectKt$keepBottom$4$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            p++;
                            if (p > 0) {
                                int i = p % 10;
                                if (i + ((((i ^ 10) & ((-i) | i)) >> 31) & 10) == 0) {
                                    break;
                                }
                            }
                            if (!keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.isScrollInProgress()) {
                                if (keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.getLayoutInfo().getTotalItemsCount() > 0) {
                                    keepBottomEffectKt$keepBottom$4$1.L$0 = $this$LaunchedEffect;
                                    keepBottomEffectKt$keepBottom$4$1.I$0 = p;
                                    keepBottomEffectKt$keepBottom$4$1.label = 1;
                                    if (keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.scrollToItem(keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.getLayoutInfo().getTotalItemsCount() - 1, Integer.MAX_VALUE, (Continuation) keepBottomEffectKt$keepBottom$4$1) == coroutine_suspended) {
                                    }
                                }
                                Duration.Companion companion2 = Duration.Companion;
                                keepBottomEffectKt$keepBottom$4$1.L$0 = $this$LaunchedEffect;
                                keepBottomEffectKt$keepBottom$4$1.I$0 = p;
                                keepBottomEffectKt$keepBottom$4$1.label = 2;
                                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(10L, DurationUnit.MILLISECONDS), (Continuation) keepBottomEffectKt$keepBottom$4$1) == coroutine_suspended) {
                                }
                                p++;
                                if (p > 0) {
                                }
                                if (!keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.isScrollInProgress()) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    keepBottom$lambda$5 = KeepBottomEffectKt.keepBottom$lambda$5(this.$isAtBottom$delegate);
                    if (keepBottom$lambda$5 && !this.$this_keepBottom.isScrollInProgress() && CoroutineScopeKt.isActive($this$LaunchedEffect) && this.$this_keepBottom.getLayoutInfo().getTotalItemsCount() > 0 && this.$this_keepBottom.getCanScrollForward()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$LaunchedEffect);
                        this.label = 3;
                        if (this.$this_keepBottom.scrollToItem(this.$this_keepBottom.getLayoutInfo().getTotalItemsCount() - 1, Integer.MAX_VALUE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                p = this.I$0;
                ResultKt.throwOnFailure($result);
                keepBottomEffectKt$keepBottom$4$1 = this;
                Duration.Companion companion22 = Duration.Companion;
                keepBottomEffectKt$keepBottom$4$1.L$0 = $this$LaunchedEffect;
                keepBottomEffectKt$keepBottom$4$1.I$0 = p;
                keepBottomEffectKt$keepBottom$4$1.label = 2;
                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(10L, DurationUnit.MILLISECONDS), (Continuation) keepBottomEffectKt$keepBottom$4$1) == coroutine_suspended) {
                }
                p++;
                if (p > 0) {
                }
                if (!keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.isScrollInProgress()) {
                }
                return Unit.INSTANCE;
            case 2:
                p = this.I$0;
                ResultKt.throwOnFailure($result);
                keepBottomEffectKt$keepBottom$4$1 = this;
                p++;
                if (p > 0) {
                }
                if (!keepBottomEffectKt$keepBottom$4$1.$this_keepBottom.isScrollInProgress()) {
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}