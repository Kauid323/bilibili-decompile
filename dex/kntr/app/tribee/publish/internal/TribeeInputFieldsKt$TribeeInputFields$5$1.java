package kntr.app.tribee.publish.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInputFields.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.TribeeInputFieldsKt$TribeeInputFields$5$1", f = "TribeeInputFields.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeInputFieldsKt$TribeeInputFields$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollState $scroll;
    final /* synthetic */ MutableInteractionSource $scrollInteractionSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInputFieldsKt$TribeeInputFields$5$1(ScrollState scrollState, MutableInteractionSource mutableInteractionSource, Continuation<? super TribeeInputFieldsKt$TribeeInputFields$5$1> continuation) {
        super(2, continuation);
        this.$scroll = scrollState;
        this.$scrollInteractionSource = mutableInteractionSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInputFieldsKt$TribeeInputFields$5$1(this.$scroll, this.$scrollInteractionSource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow interactions = this.$scroll.getInteractionSource().getInteractions();
                final MutableInteractionSource mutableInteractionSource = this.$scrollInteractionSource;
                this.label = 1;
                if (interactions.collect(new FlowCollector() { // from class: kntr.app.tribee.publish.internal.TribeeInputFieldsKt$TribeeInputFields$5$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Interaction) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Interaction it, Continuation<? super Unit> continuation) {
                        Object emit = mutableInteractionSource.emit(it, continuation);
                        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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
}