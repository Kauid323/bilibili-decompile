package video.biz.offline.list.logic.statemachine;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String3_commonMainKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;
import video.biz.offline.list.logic.statemachine.OfflineResultPageUiEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$UploadFailed;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState$OfflineResolvePageUiState;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$3$3", f = "OfflineResloveStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineResolveDataStore$machine$1$3$3 extends SuspendLambda implements Function3<OfflineResolvePageEvent.UploadFailed, State<OfflineResolveState.OfflineResolvePageUiState>, Continuation<? super ChangedState<? extends OfflineResolveState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineResolveDataStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineResolveDataStore$machine$1$3$3(OfflineResolveDataStore offlineResolveDataStore, Continuation<? super OfflineResolveDataStore$machine$1$3$3> continuation) {
        super(3, continuation);
        this.this$0 = offlineResolveDataStore;
    }

    public final Object invoke(OfflineResolvePageEvent.UploadFailed uploadFailed, State<OfflineResolveState.OfflineResolvePageUiState> state, Continuation<? super ChangedState<? extends OfflineResolveState>> continuation) {
        OfflineResolveDataStore$machine$1$3$3 offlineResolveDataStore$machine$1$3$3 = new OfflineResolveDataStore$machine$1$3$3(this.this$0, continuation);
        offlineResolveDataStore$machine$1$3$3.L$0 = state;
        return offlineResolveDataStore$machine$1$3$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope coroutineScope;
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                coroutineScope = this.this$0.scope;
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$3$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineResolveState.OfflineResolvePageUiState copy$default;
                        copy$default = OfflineResolveState.OfflineResolvePageUiState.copy$default((OfflineResolveState.OfflineResolvePageUiState) obj, null, null, null, false, false, false, 55, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$3$3$1", f = "OfflineResloveStateMachine.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$machine$1$3$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfflineResolveDataStore this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineResolveDataStore offlineResolveDataStore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = offlineResolveDataStore;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object send;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    send = this.this$0.send(new OfflineResultPageUiEvent.ShowToast(PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_948(PlayerbaseresRes.INSTANCE.getString())), null, 2, null), (Continuation) this);
                    if (send == coroutine_suspended) {
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
}