package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageAction;
import kntr.common.ouro.core.reducer.OuroEditActionReducerKt;
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
/* compiled from: OuroLocalImagePlugin.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/OuroState;", "action", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$InsertBlockImage;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$spec$1$1$1", f = "OuroLocalImagePlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroLocalImagePlugin$spec$1$1$1 extends SuspendLambda implements Function3<OuroLocalImageAction.InsertBlockImage, State<OuroState>, Continuation<? super ChangedState<? extends OuroState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroLocalImagePlugin$spec$1$1$1(Continuation<? super OuroLocalImagePlugin$spec$1$1$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OuroLocalImageAction.InsertBlockImage insertBlockImage, State<OuroState> state, Continuation<? super ChangedState<OuroState>> continuation) {
        OuroLocalImagePlugin$spec$1$1$1 ouroLocalImagePlugin$spec$1$1$1 = new OuroLocalImagePlugin$spec$1$1$1(continuation);
        ouroLocalImagePlugin$spec$1$1$1.L$0 = insertBlockImage;
        ouroLocalImagePlugin$spec$1$1$1.L$1 = state;
        return ouroLocalImagePlugin$spec$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final OuroLocalImageAction.InsertBlockImage action = (OuroLocalImageAction.InsertBlockImage) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$spec$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OuroState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OuroLocalImagePlugin$spec$1$1$1.invokeSuspend$lambda$0(OuroLocalImageAction.InsertBlockImage.this, (OuroState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState invokeSuspend$lambda$0(OuroLocalImageAction.InsertBlockImage $action, OuroState $this$mutate) {
        return OuroEditActionReducerKt.insertStorages$default($this$mutate, $action.getStorages$core_debug(), null, 2, null);
    }
}