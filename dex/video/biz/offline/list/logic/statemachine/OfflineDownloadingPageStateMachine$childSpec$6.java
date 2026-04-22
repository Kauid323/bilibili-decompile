package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.OfflinePageConfig;
import video.biz.offline.list.logic.model.OfflinePageState;

/* compiled from: OfflineDownloadingPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/SetConcurrentCount;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$6", f = "OfflineDownloadingPageStateMachine.kt", i = {0, 0, 0}, l = {114}, m = "invokeSuspend", n = {"action", "state", "needVipTip"}, s = {"L$0", "L$1", "L$2"}, v = 1)
final class OfflineDownloadingPageStateMachine$childSpec$6 extends SuspendLambda implements Function3<SetConcurrentCount, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineDownloadingPageStateMachine$childSpec$6(Continuation<? super OfflineDownloadingPageStateMachine$childSpec$6> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SetConcurrentCount setConcurrentCount, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineDownloadingPageStateMachine$childSpec$6 offlineDownloadingPageStateMachine$childSpec$6 = new OfflineDownloadingPageStateMachine$childSpec$6(continuation);
        offlineDownloadingPageStateMachine$childSpec$6.L$0 = setConcurrentCount;
        offlineDownloadingPageStateMachine$childSpec$6.L$1 = state;
        return offlineDownloadingPageStateMachine$childSpec$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Ref.BooleanRef needVipTip;
        final SetConcurrentCount action = (SetConcurrentCount) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.BooleanRef needVipTip2 = new Ref.BooleanRef();
                if (action.getCount() > 1) {
                    Object value = KAccountStoreKt.getAccountHolder().getState().getValue();
                    AccountState.Logged it = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
                    if (it != null && it.getUserInfo().getVip().getStatus() != 1) {
                        needVipTip2.element = true;
                    }
                }
                if (needVipTip2.element) {
                    return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$6$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            OfflinePageState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = OfflineDownloadingPageStateMachine$childSpec$6.invokeSuspend$lambda$1((OfflinePageState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                this.L$0 = action;
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(needVipTip2);
                this.label = 1;
                if (OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().setMaxConcurrent(action.getCount(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                needVipTip = needVipTip2;
                break;
                break;
            case 1:
                needVipTip = (Ref.BooleanRef) this.L$2;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineDownloadingPageStateMachine$childSpec$6$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                OfflinePageState invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = OfflineDownloadingPageStateMachine$childSpec$6.invokeSuspend$lambda$2(SetConcurrentCount.this, (OfflinePageState) obj);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$1(OfflinePageState $this$override) {
        OfflinePageState copy;
        copy = $this$override.copy((r18 & 1) != 0 ? $this$override.downloading : null, (r18 & 2) != 0 ? $this$override.completed : null, (r18 & 4) != 0 ? $this$override.dataState : null, (r18 & 8) != 0 ? $this$override.selectionState : null, (r18 & 16) != 0 ? $this$override.config : null, (r18 & 32) != 0 ? $this$override.storageInfo : null, (r18 & 64) != 0 ? $this$override.reserveInfo : null, (r18 & 128) != 0 ? $this$override.dialogType : DialogType.VipParallelDownloadAlert.INSTANCE);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$2(SetConcurrentCount $action, OfflinePageState $this$mutate) {
        OfflinePageState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : OfflinePageConfig.copy$default($this$mutate.getConfig(), null, null, $action.getCount(), 3, null), (r18 & 32) != 0 ? $this$mutate.storageInfo : null, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
        return copy;
    }
}