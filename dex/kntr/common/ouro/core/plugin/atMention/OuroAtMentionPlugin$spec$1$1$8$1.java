package kntr.common.ouro.core.plugin.atMention;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kntr.common.ouro.core.model.node.OuroLinkKt;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionAction;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionState;
import kntr.common.ouro.core.reducer.OuroEditActionReducerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroAtMentionPlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionAction$SelectUser;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$spec$1$1$8$1", f = "OuroAtMentionPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroAtMentionPlugin$spec$1$1$8$1 extends SuspendLambda implements Function3<OuroAtMentionAction.SelectUser, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OuroAtMentionPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroAtMentionPlugin$spec$1$1$8$1(OuroAtMentionPlugin ouroAtMentionPlugin, Continuation<? super OuroAtMentionPlugin$spec$1$1$8$1> continuation) {
        super(3, continuation);
        this.this$0 = ouroAtMentionPlugin;
    }

    public final Object invoke(OuroAtMentionAction.SelectUser selectUser, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroAtMentionPlugin$spec$1$1$8$1 ouroAtMentionPlugin$spec$1$1$8$1 = new OuroAtMentionPlugin$spec$1$1$8$1(this.this$0, continuation);
        ouroAtMentionPlugin$spec$1$1$8$1.L$0 = selectUser;
        ouroAtMentionPlugin$spec$1$1$8$1.L$1 = state;
        return ouroAtMentionPlugin$spec$1$1$8$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroAtMentionState currentState;
        final OuroAtMentionAction.SelectUser action = (OuroAtMentionAction.SelectUser) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                currentState = this.this$0.currentState((OuroState) state.getSnapshot());
                Intrinsics.checkNotNull(currentState, "null cannot be cast to non-null type kntr.common.ouro.core.plugin.atMention.OuroAtMentionState.ShowContent");
                final OuroAtMentionState.ShowContent currentState2 = (OuroAtMentionState.ShowContent) currentState;
                final OuroAtMentionPlugin ouroAtMentionPlugin = this.this$0;
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin$spec$1$1$8$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroAtMentionPlugin$spec$1$1$8$1.invokeSuspend$lambda$0(OuroAtMentionAction.SelectUser.this, ouroAtMentionPlugin, currentState2, (OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroAtMentionAction.SelectUser $action, OuroAtMentionPlugin this$0, OuroAtMentionState.ShowContent $currentState, OuroState $this$mutate) {
        OuroColor ouroColor;
        AtMentionUser user = $action.getUser();
        ouroColor = this$0.fontColor;
        return OuroEditActionReducerKt.insertStorages($this$mutate, CollectionsKt.listOf(OuroLinkKt.createStorage$default(user, ouroColor, null, false, false, false, false, 62, null)), $currentState.getKeyword().getRange());
    }
}