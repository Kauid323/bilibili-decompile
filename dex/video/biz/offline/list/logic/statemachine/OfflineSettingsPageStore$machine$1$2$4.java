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
import video.biz.offline.base.infra.storage.StorageInfoImpl_androidKt;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageEvent;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageEvent$ChangeStorageType;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$2$4", f = "OfflineSettingsPageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineSettingsPageStore$machine$1$2$4 extends SuspendLambda implements Function3<OfflineSettingsPageEvent.ChangeStorageType, State<OfflineSettingsPageState.Ready>, Continuation<? super ChangedState<? extends OfflineSettingsPageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSettingsPageStore$machine$1$2$4(Continuation<? super OfflineSettingsPageStore$machine$1$2$4> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineSettingsPageEvent.ChangeStorageType changeStorageType, State<OfflineSettingsPageState.Ready> state, Continuation<? super ChangedState<? extends OfflineSettingsPageState>> continuation) {
        OfflineSettingsPageStore$machine$1$2$4 offlineSettingsPageStore$machine$1$2$4 = new OfflineSettingsPageStore$machine$1$2$4(continuation);
        offlineSettingsPageStore$machine$1$2$4.L$0 = changeStorageType;
        offlineSettingsPageStore$machine$1$2$4.L$1 = state;
        return offlineSettingsPageStore$machine$1$2$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final OfflineSettingsPageEvent.ChangeStorageType action = (OfflineSettingsPageEvent.ChangeStorageType) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StorageInfoImpl_androidKt.setStoragePreference(action.getType());
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$2$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineSettingsPageState.Ready invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineSettingsPageStore$machine$1$2$4.invokeSuspend$lambda$0(OfflineSettingsPageEvent.ChangeStorageType.this, (OfflineSettingsPageState.Ready) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSettingsPageState.Ready invokeSuspend$lambda$0(OfflineSettingsPageEvent.ChangeStorageType $action, OfflineSettingsPageState.Ready $this$mutate) {
        return OfflineSettingsPageState.Ready.copy$default($this$mutate, false, $action.getType(), null, 5, null);
    }
}