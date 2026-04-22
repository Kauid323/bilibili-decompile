package kntr.common.ouro.core.plugin.atMention;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroAtMentionPlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$spec$1$1$4$1", f = "OuroAtMentionPlugin.kt", i = {0, 0, 0}, l = {52}, m = "invokeSuspend", n = {"state", "currentState", "keyword"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class OuroAtMentionPlugin$spec$1$1$4$1 extends SuspendLambda implements Function2<State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OuroAtMentionPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroAtMentionPlugin$spec$1$1$4$1(OuroAtMentionPlugin ouroAtMentionPlugin, Continuation<? super OuroAtMentionPlugin$spec$1$1$4$1> continuation) {
        super(2, continuation);
        this.this$0 = ouroAtMentionPlugin;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> ouroAtMentionPlugin$spec$1$1$4$1 = new OuroAtMentionPlugin$spec$1$1$4$1(this.this$0, continuation);
        ouroAtMentionPlugin$spec$1$1$4$1.L$0 = obj;
        return ouroAtMentionPlugin$spec$1$1$4$1;
    }

    public final Object invoke(State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroAtMentionState currentState;
        OuroAtMentionState currentState2;
        AtMentionService atMentionService;
        Keyword keyword;
        Object result;
        OuroAtMentionState.Error error;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                currentState = this.this$0.currentState((OuroState) state.getSnapshot());
                if (currentState instanceof OuroAtMentionState.Loading) {
                    currentState2 = this.this$0.currentState((OuroState) state.getSnapshot());
                    Intrinsics.checkNotNull(currentState2, "null cannot be cast to non-null type kntr.common.ouro.core.plugin.atMention.OuroAtMentionState.Loading");
                    OuroAtMentionState.Loading currentState3 = (OuroAtMentionState.Loading) currentState2;
                    Keyword keyword2 = currentState3.getKeyword();
                    atMentionService = this.this$0.atMentionService;
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(currentState3);
                    this.L$2 = keyword2;
                    this.label = 1;
                    Object mo1884searchgIAlus = atMentionService.mo1884searchgIAlus(keyword2.getText(), (Continuation) this);
                    if (mo1884searchgIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    keyword = keyword2;
                    result = mo1884searchgIAlus;
                    break;
                } else {
                    return state.noChange();
                }
            case 1:
                keyword = (Keyword) this.L$2;
                OuroAtMentionState.Loading loading = (OuroAtMentionState.Loading) this.L$1;
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).m2645unboximpl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Throwable it = Result.m2639exceptionOrNullimpl(result);
        if (it == null) {
            error = new OuroAtMentionState.ShowContent(keyword, (List) result, null, 4, null);
        } else {
            error = new OuroAtMentionState.Error(keyword, it);
        }
        final OuroAtMentionState newState = error;
        final OuroAtMentionPlugin ouroAtMentionPlugin = this.this$0;
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$spec$1$1$4$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OuroState access$copy;
                access$copy = OuroAtMentionPlugin.access$copy(OuroAtMentionPlugin.this, (OuroState) obj, newState);
                return access$copy;
            }
        });
    }
}