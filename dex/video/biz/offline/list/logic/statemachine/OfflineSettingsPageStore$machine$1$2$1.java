package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageEvent;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ToggleAutoResumptionSwitch;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$2$1", f = "OfflineSettingsPageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineSettingsPageStore$machine$1$2$1 extends SuspendLambda implements Function3<OfflineSettingsPageEvent.ToggleAutoResumptionSwitch, State<OfflineSettingsPageState.Ready>, Continuation<? super ChangedState<? extends OfflineSettingsPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSettingsPageStore$machine$1$2$1(Continuation<? super OfflineSettingsPageStore$machine$1$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineSettingsPageEvent.ToggleAutoResumptionSwitch toggleAutoResumptionSwitch, State<OfflineSettingsPageState.Ready> state, Continuation<? super ChangedState<? extends OfflineSettingsPageState>> continuation) {
        OfflineSettingsPageStore$machine$1$2$1 offlineSettingsPageStore$machine$1$2$1 = new OfflineSettingsPageStore$machine$1$2$1(continuation);
        offlineSettingsPageStore$machine$1$2$1.L$0 = state;
        return offlineSettingsPageStore$machine$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineSettingsPageState.Ready invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineSettingsPageStore$machine$1$2$1.invokeSuspend$lambda$0((OfflineSettingsPageState.Ready) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSettingsPageState.Ready invokeSuspend$lambda$0(OfflineSettingsPageState.Ready $this$mutate) {
        boolean before = $this$mutate.isAutoResumption();
        Config.Companion.setAutoResumption(!before);
        return OfflineSettingsPageState.Ready.copy$default($this$mutate, !before, null, null, 6, null);
    }
}