package kntr.app.tribee.publish.core.v2;

import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Map;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: TribeePublishStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "action", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction$SwitchSettingItem;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleInput$7", f = "TribeePublishStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeePublishStateMachine$handleInput$7 extends SuspendLambda implements Function3<TribeePublishAction.SwitchSettingItem, State<TribeePublishContent>, Continuation<? super ChangedState<? extends TribeePublishState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishStateMachine$handleInput$7(Continuation<? super TribeePublishStateMachine$handleInput$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeePublishAction.SwitchSettingItem switchSettingItem, State<TribeePublishContent> state, Continuation<? super ChangedState<? extends TribeePublishState>> continuation) {
        TribeePublishStateMachine$handleInput$7 tribeePublishStateMachine$handleInput$7 = new TribeePublishStateMachine$handleInput$7(continuation);
        tribeePublishStateMachine$handleInput$7.L$0 = switchSettingItem;
        tribeePublishStateMachine$handleInput$7.L$1 = state;
        return tribeePublishStateMachine$handleInput$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeePublishAction.SwitchSettingItem action = (TribeePublishAction.SwitchSettingItem) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Map items = MapsKt.toMutableMap(((TribeePublishContent) state.getSnapshot()).getSettingItems());
                KUpPermissionType key = action.getType();
                TribeePublishSettingItem tribeePublishSettingItem = ((TribeePublishContent) state.getSnapshot()).getSettingItems().get(key);
                TribeePublishSettingItem.Switch value = tribeePublishSettingItem instanceof TribeePublishSettingItem.Switch ? (TribeePublishSettingItem.Switch) tribeePublishSettingItem : null;
                if (value != null) {
                    TribeePublishSettingItem.Switch it = value;
                    items.put(key, TribeePublishSettingItem.Switch.copy$default(it, null, null, null, action.isChecked(), false, false, 55, null));
                }
                return state.mutate(new Function1() { // from class: kntr.app.tribee.publish.core.v2.TribeePublishStateMachine$handleInput$7$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeePublishContent invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeePublishStateMachine$handleInput$7.invokeSuspend$lambda$1(items, (TribeePublishContent) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeePublishContent invokeSuspend$lambda$1(Map $items, TribeePublishContent $this$mutate) {
        return TribeePublishContent.copy$default($this$mutate, null, null, null, null, null, null, null, false, MapsKt.toMap($items), false, false, false, false, null, 16127, null);
    }
}