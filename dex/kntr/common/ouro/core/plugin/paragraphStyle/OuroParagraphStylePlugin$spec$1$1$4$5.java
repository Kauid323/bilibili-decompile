package kntr.common.ouro.core.plugin.paragraphStyle;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroParagraphStylePlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "<unused var>", "Lkntr/common/ouro/core/plugin/paragraphStyle/OuroToggleTextAction;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$spec$1$1$4$5", f = "OuroParagraphStylePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroParagraphStylePlugin$spec$1$1$4$5 extends SuspendLambda implements Function3<OuroToggleTextAction, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroParagraphStylePlugin$spec$1$1$4$5(Continuation<? super OuroParagraphStylePlugin$spec$1$1$4$5> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OuroToggleTextAction ouroToggleTextAction, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroParagraphStylePlugin$spec$1$1$4$5 ouroParagraphStylePlugin$spec$1$1$4$5 = new OuroParagraphStylePlugin$spec$1$1$4$5(continuation);
        ouroParagraphStylePlugin$spec$1$1$4$5.L$0 = state;
        return ouroParagraphStylePlugin$spec$1$1$4$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.paragraphStyle.OuroParagraphStylePlugin$spec$1$1$4$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroParagraphStylePlugin$spec$1$1$4$5.invokeSuspend$lambda$0((OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroState $this$mutate) {
        OuroState text;
        text = OuroParagraphStylePlugin.INSTANCE.toText($this$mutate);
        return text;
    }
}