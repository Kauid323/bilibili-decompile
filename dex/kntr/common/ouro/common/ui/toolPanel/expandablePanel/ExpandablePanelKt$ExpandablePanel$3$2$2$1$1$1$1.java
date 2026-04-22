package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpandablePanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1", f = "ExpandablePanel.kt", i = {}, l = {136, 138}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExpandablePanelState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1(ExpandablePanelState expandablePanelState, Continuation<? super ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$state = expandablePanelState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$state.getAnchoredDraggableState().getCurrentValue() == ExpandablePanelState.Style.Normal && this.$state.isEnableExpand()) {
                    this.label = 1;
                    if (AnchoredDraggableKt.animateTo$default(this.$state.getAnchoredDraggableState(), ExpandablePanelState.Style.Expanded, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (AnchoredDraggableKt.animateTo$default(this.$state.getAnchoredDraggableState(), ExpandablePanelState.Style.Normal, (AnimationSpec) null, (Continuation) this, 2, (Object) null) == coroutine_suspended) {
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