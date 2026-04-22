package kntr.app.tribee.consume.page;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$2$1", f = "TribeeHomePage.kt", i = {}, l = {490}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomeContent$5$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ ScrollState $pageScrollState;
    final /* synthetic */ MutableFloatState $progress$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomePageKt$TribeeHomeContent$5$2$1(ScrollState scrollState, Density density, MutableFloatState mutableFloatState, Continuation<? super TribeeHomePageKt$TribeeHomeContent$5$2$1> continuation) {
        super(2, continuation);
        this.$pageScrollState = scrollState;
        this.$density = density;
        this.$progress$delegate = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomeContent$5$2$1(this.$pageScrollState, this.$density, this.$progress$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ScrollState scrollState = this.$pageScrollState;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int value;
                        value = scrollState.getValue();
                        return Integer.valueOf(value);
                    }
                });
                final Density density = this.$density;
                final MutableFloatState mutableFloatState = this.$progress$delegate;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).intValue(), $completion);
                    }

                    public final Object emit(int it, Continuation<? super Unit> continuation) {
                        MutableFloatState mutableFloatState2 = mutableFloatState;
                        Density $this$emit_u24lambda_u240 = density;
                        mutableFloatState2.setFloatValue(RangesKt.coerceIn(it / ($this$emit_u24lambda_u240.toPx-0680j_4(TribeeHomePageKt.getNAVIGATION_HEIGHT()) * 1.35f), 0.0f, 1.0f));
                        return Unit.INSTANCE;
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