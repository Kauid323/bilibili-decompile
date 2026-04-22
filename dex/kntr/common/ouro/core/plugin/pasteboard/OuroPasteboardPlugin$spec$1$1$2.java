package kntr.common.ouro.core.plugin.pasteboard;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroPasteboardPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/pasteboard/OuroCutAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$2", f = "OuroPasteboardPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroPasteboardPlugin$spec$1$1$2 extends SuspendLambda implements Function3<OuroCutAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OuroPasteboardPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroPasteboardPlugin$spec$1$1$2(OuroPasteboardPlugin ouroPasteboardPlugin, Continuation<? super OuroPasteboardPlugin$spec$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = ouroPasteboardPlugin;
    }

    public final Object invoke(OuroCutAction ouroCutAction, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroPasteboardPlugin$spec$1$1$2 ouroPasteboardPlugin$spec$1$1$2 = new OuroPasteboardPlugin$spec$1$1$2(this.this$0, continuation);
        ouroPasteboardPlugin$spec$1$1$2.L$0 = ouroCutAction;
        ouroPasteboardPlugin$spec$1$1$2.L$1 = state;
        return ouroPasteboardPlugin$spec$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ChangedState handleCutAction;
        OuroCutAction action = (OuroCutAction) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                handleCutAction = this.this$0.handleCutAction(action, state);
                return handleCutAction;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}