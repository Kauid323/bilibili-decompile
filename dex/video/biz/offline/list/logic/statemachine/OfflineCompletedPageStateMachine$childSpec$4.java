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
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.list.logic.model.DialogType;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.SelectionState;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* compiled from: OfflineCompletedPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "action", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$DeleteConfirmed;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$4", f = "OfflineCompletedPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineCompletedPageStateMachine$childSpec$4 extends SuspendLambda implements Function3<OfflineListAction.DeleteConfirmed, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OfflineCompletedPageStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineCompletedPageStateMachine$childSpec$4(OfflineCompletedPageStateMachine offlineCompletedPageStateMachine, Continuation<? super OfflineCompletedPageStateMachine$childSpec$4> continuation) {
        super(3, continuation);
        this.this$0 = offlineCompletedPageStateMachine;
    }

    public final Object invoke(OfflineListAction.DeleteConfirmed deleteConfirmed, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineCompletedPageStateMachine$childSpec$4 offlineCompletedPageStateMachine$childSpec$4 = new OfflineCompletedPageStateMachine$childSpec$4(this.this$0, continuation);
        offlineCompletedPageStateMachine$childSpec$4.L$0 = deleteConfirmed;
        offlineCompletedPageStateMachine$childSpec$4.L$1 = state;
        return offlineCompletedPageStateMachine$childSpec$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineCompletedPageStateMachine.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$4$1", f = "OfflineCompletedPageStateMachine.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$4$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ OfflineListAction.DeleteConfirmed $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineListAction.DeleteConfirmed deleteConfirmed, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = deleteConfirmed;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().removeVideo(this.$action.getKeys(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        OfflineListAction.DeleteConfirmed action = (OfflineListAction.DeleteConfirmed) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.processWithLoading(this.this$0, new AnonymousClass1(action, null));
                return state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineCompletedPageStateMachine$childSpec$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflinePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineCompletedPageStateMachine$childSpec$4.invokeSuspend$lambda$0((OfflinePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflinePageState invokeSuspend$lambda$0(OfflinePageState $this$override) {
        OfflinePageState copy;
        copy = $this$override.copy((r18 & 1) != 0 ? $this$override.downloading : null, (r18 & 2) != 0 ? $this$override.completed : null, (r18 & 4) != 0 ? $this$override.dataState : null, (r18 & 8) != 0 ? $this$override.selectionState : SelectionState.Inactive.INSTANCE, (r18 & 16) != 0 ? $this$override.config : null, (r18 & 32) != 0 ? $this$override.storageInfo : null, (r18 & 64) != 0 ? $this$override.reserveInfo : null, (r18 & 128) != 0 ? $this$override.dialogType : DialogType.None.INSTANCE);
        return copy;
    }
}