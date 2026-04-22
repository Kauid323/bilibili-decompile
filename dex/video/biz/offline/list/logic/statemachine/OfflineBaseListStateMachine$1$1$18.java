package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.infra.storage.IStorageInfoKt;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$18;
import video.biz.offline.list.logic.statemachine.OfflineListAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineBaseListStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineListAction$GetStorageInfo;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$18", f = "OfflineBaseListStateMachine.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class OfflineBaseListStateMachine$1$1$18 extends SuspendLambda implements Function3<OfflineListAction.GetStorageInfo, State<OfflinePageState>, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineBaseListStateMachine$1$1$18(Continuation<? super OfflineBaseListStateMachine$1$1$18> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineListAction.GetStorageInfo getStorageInfo, State<OfflinePageState> state, Continuation<? super ChangedState<OfflinePageState>> continuation) {
        OfflineBaseListStateMachine$1$1$18 offlineBaseListStateMachine$1$1$18 = new OfflineBaseListStateMachine$1$1$18(continuation);
        offlineBaseListStateMachine$1$1$18.L$0 = state;
        return offlineBaseListStateMachine$1$1$18.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineBaseListStateMachine.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$18$1", f = "OfflineBaseListStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$18$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChangedState<? extends OfflinePageState>>, Object> {
        final /* synthetic */ State<OfflinePageState> $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<OfflinePageState> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChangedState<OfflinePageState>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final Ref.ObjectRef storeInfo = new Ref.ObjectRef();
                    TimeSource.Monotonic $this$measureTime$iv$iv = TimeSource.Monotonic.INSTANCE;
                    long mark$iv$iv = $this$measureTime$iv$iv.markNow-z9LOYto();
                    storeInfo.element = IStorageInfoKt.currentStorageInfo(OfflineFacadeImpl_androidKt.getOfflineFacadeImpl().getStorageInfo());
                    long it = TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(mark$iv$iv);
                    LogKt.getVBLog().info("OfflineBaseListStateMachine getStorageInfo cost: " + Duration.getInWholeMilliseconds-impl(it) + " ms");
                    return this.$state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine$1$1$18$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            OfflinePageState invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = OfflineBaseListStateMachine$1$1$18.AnonymousClass1.invokeSuspend$lambda$2(storeInfo, (OfflinePageState) obj);
                            return invokeSuspend$lambda$2;
                        }
                    });
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OfflinePageState invokeSuspend$lambda$2(Ref.ObjectRef $storeInfo, OfflinePageState $this$mutate) {
            OfflinePageState copy;
            copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.downloading : null, (r18 & 2) != 0 ? $this$mutate.completed : null, (r18 & 4) != 0 ? $this$mutate.dataState : null, (r18 & 8) != 0 ? $this$mutate.selectionState : null, (r18 & 16) != 0 ? $this$mutate.config : null, (r18 & 32) != 0 ? $this$mutate.storageInfo : (StorageInfoModel) $storeInfo.element, (r18 & 64) != 0 ? $this$mutate.reserveInfo : null, (r18 & 128) != 0 ? $this$mutate.dialogType : null);
            return copy;
        }
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new AnonymousClass1(state, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return withContext;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}