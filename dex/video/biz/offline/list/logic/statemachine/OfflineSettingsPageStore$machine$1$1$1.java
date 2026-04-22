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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.base.utils.DateKt;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageState;
import video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$1$1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSettingsPageStore.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$1$1", f = "OfflineSettingsPageStore.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class OfflineSettingsPageStore$machine$1$1$1 extends SuspendLambda implements Function2<State<OfflineSettingsPageState.Loading>, Continuation<? super ChangedState<? extends OfflineSettingsPageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSettingsPageStore$machine$1$1$1(Continuation<? super OfflineSettingsPageStore$machine$1$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineSettingsPageStore$machine$1$1$1 = new OfflineSettingsPageStore$machine$1$1$1(continuation);
        offlineSettingsPageStore$machine$1$1$1.L$0 = obj;
        return offlineSettingsPageStore$machine$1$1$1;
    }

    public final Object invoke(State<OfflineSettingsPageState.Loading> state, Continuation<? super ChangedState<? extends OfflineSettingsPageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineSettingsPageStore.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSettingsPageState$Ready;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$1$1$1", f = "OfflineSettingsPageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChangedState<? extends OfflineSettingsPageState.Ready>>, Object> {
        final /* synthetic */ State<OfflineSettingsPageState.Loading> $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<OfflineSettingsPageState.Loading> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChangedState<OfflineSettingsPageState.Ready>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    long startTime = DateKt.getCurrentTimeMillis();
                    ChangedState newState = this.$state.override(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSettingsPageStore$machine$1$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            OfflineSettingsPageState.Ready invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OfflineSettingsPageStore$machine$1$1$1.AnonymousClass1.invokeSuspend$lambda$0((OfflineSettingsPageState.Loading) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    LogKt.getVBLog().info("Settings Page loading cost: " + (DateKt.getCurrentTimeMillis() - startTime) + " ms.");
                    return newState;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OfflineSettingsPageState.Ready invokeSuspend$lambda$0(OfflineSettingsPageState.Loading $this$override) {
            return new OfflineSettingsPageState.Ready(false, null, null, 7, null);
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