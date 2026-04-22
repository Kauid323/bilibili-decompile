package kntr.common.bilibubble;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliBubble.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.bilibubble.BiliBubbleKt$BiliBubble$1$1", f = "BiliBubble.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliBubbleKt$BiliBubble$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $bubbleWidth$delegate;
    final /* synthetic */ State<Function1<Integer, Unit>> $currentOnContentWidthCalculated$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliBubbleKt$BiliBubble$1$1(MutableIntState mutableIntState, State<? extends Function1<? super Integer, Unit>> state, Continuation<? super BiliBubbleKt$BiliBubble$1$1> continuation) {
        super(2, continuation);
        this.$bubbleWidth$delegate = mutableIntState;
        this.$currentOnContentWidthCalculated$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliBubbleKt$BiliBubble$1$1(this.$bubbleWidth$delegate, this.$currentOnContentWidthCalculated$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int BiliBubble_3csKH6Y$lambda$1;
        Function1 BiliBubble_3csKH6Y$lambda$3;
        int BiliBubble_3csKH6Y$lambda$12;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BiliBubble_3csKH6Y$lambda$1 = BiliBubbleKt.BiliBubble_3csKH6Y$lambda$1(this.$bubbleWidth$delegate);
                if (BiliBubble_3csKH6Y$lambda$1 > 0) {
                    BiliBubble_3csKH6Y$lambda$3 = BiliBubbleKt.BiliBubble_3csKH6Y$lambda$3(this.$currentOnContentWidthCalculated$delegate);
                    BiliBubble_3csKH6Y$lambda$12 = BiliBubbleKt.BiliBubble_3csKH6Y$lambda$1(this.$bubbleWidth$delegate);
                    BiliBubble_3csKH6Y$lambda$3.invoke(Boxing.boxInt(BiliBubble_3csKH6Y$lambda$12));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}