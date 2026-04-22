package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
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

/* compiled from: ExpandablePanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1", f = "ExpandablePanel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: $$v$c$androidx-compose-ui-geometry-Offset$-available$0  reason: not valid java name */
    final /* synthetic */ long f52$$v$c$androidxcomposeuigeometryOffset$available$0;
    final /* synthetic */ AnchoredDraggableState<T> $this_preUpPostDownNestedScrollConnection;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1(AnchoredDraggableState<T> anchoredDraggableState, long j, Continuation<? super ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1> continuation) {
        super(2, continuation);
        this.$this_preUpPostDownNestedScrollConnection = anchoredDraggableState;
        this.f52$$v$c$androidxcomposeuigeometryOffset$available$0 = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1(this.$this_preUpPostDownNestedScrollConnection, this.f52$$v$c$androidxcomposeuigeometryOffset$available$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AnchoredDraggableState<T> anchoredDraggableState = this.$this_preUpPostDownNestedScrollConnection;
                int bits$iv$iv$iv = (int) (4294967295L & this.f52$$v$c$androidxcomposeuigeometryOffset$available$0);
                anchoredDraggableState.dispatchRawDelta(Float.intBitsToFloat(bits$iv$iv$iv));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}