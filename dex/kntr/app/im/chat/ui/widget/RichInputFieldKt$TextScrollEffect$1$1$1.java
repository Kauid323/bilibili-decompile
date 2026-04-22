package kntr.app.im.chat.ui.widget;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichInputField.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.RichInputFieldKt$TextScrollEffect$1$1$1", f = "RichInputField.kt", i = {}, l = {623, 627}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichInputFieldKt$TextScrollEffect$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $decorBoxHeight;
    final /* synthetic */ Float $lineBottom;
    final /* synthetic */ Float $lineTop;
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichInputFieldKt$TextScrollEffect$1$1$1(int i, ScrollState scrollState, Float f, Float f2, Continuation<? super RichInputFieldKt$TextScrollEffect$1$1$1> continuation) {
        super(2, continuation);
        this.$decorBoxHeight = i;
        this.$scrollState = scrollState;
        this.$lineBottom = f;
        this.$lineTop = f2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RichInputFieldKt$TextScrollEffect$1$1$1(this.$decorBoxHeight, this.$scrollState, this.$lineBottom, this.$lineTop, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$decorBoxHeight + this.$scrollState.getValue() < this.$lineBottom.floatValue()) {
                    this.label = 1;
                    if (ScrollState.animateScrollTo$default(this.$scrollState, RangesKt.coerceAtLeast((int) (this.$lineBottom.floatValue() - this.$decorBoxHeight), 0), (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (this.$scrollState.getValue() > this.$lineTop.floatValue()) {
                    this.label = 2;
                    if (ScrollState.animateScrollTo$default(this.$scrollState, (int) this.$lineTop.floatValue(), (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}