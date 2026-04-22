package kntr.app.tribee.steam.viewmodel;

import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.base.TribeeSteamBindingContainer;
import kntr.app.tribee.base.TribeeSteamBindingState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
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
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/steam/state/TribeeSteamState;", "<unused var>", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$AwaitSteamBindResult;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$4", f = "TribeeSteamStateMachine.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, l = {339, 343, 346, 348, 363, 364}, m = "invokeSuspend", n = {"state", "state", "bindResult", "state", "bindResult", "state", "bindResult", "state", "bindResult", "state", "bindResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class TribeeSteamStateMachine$1$3$4 extends SuspendLambda implements Function3<TribeeSteamStateAction.AwaitSteamBindResult, State<TribeeSteamState>, Continuation<? super ChangedState<? extends TribeeSteamState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeSteamStateMachine this$0;

    /* compiled from: TribeeSteamStateMachine.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TribeeSteamBindingState.values().length];
            try {
                iArr[TribeeSteamBindingState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TribeeSteamBindingState.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamStateMachine$1$3$4(TribeeSteamStateMachine tribeeSteamStateMachine, Continuation<? super TribeeSteamStateMachine$1$3$4> continuation) {
        super(3, continuation);
        this.this$0 = tribeeSteamStateMachine;
    }

    public final Object invoke(TribeeSteamStateAction.AwaitSteamBindResult awaitSteamBindResult, State<TribeeSteamState> state, Continuation<? super ChangedState<? extends TribeeSteamState>> continuation) {
        TribeeSteamStateMachine$1$3$4 tribeeSteamStateMachine$1$3$4 = new TribeeSteamStateMachine$1$3$4(this.this$0, continuation);
        tribeeSteamStateMachine$1$3$4.L$0 = state;
        return tribeeSteamStateMachine$1$3$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0162 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object awaitSteamResult;
        TribeeSteamBindingState bindResult;
        Object string;
        Object string2;
        final State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i("TribeeSteamStateMachine", "Awaiting Steam binding result...");
                TribeeSteamBindingContainer.INSTANCE.prepareSteamChannel();
                this.L$0 = state;
                this.label = 1;
                awaitSteamResult = TribeeSteamBindingContainer.INSTANCE.awaitSteamResult((Continuation) this);
                if (awaitSteamResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bindResult = (TribeeSteamBindingState) awaitSteamResult;
                switch (bindResult != null ? -1 : WhenMappings.$EnumSwitchMapping$0[bindResult.ordinal()]) {
                    case 1:
                        if (((TribeeSteamState) state.getSnapshot()).isMaster()) {
                            KLog_androidKt.getKLog().i("TribeeSteamStateMachine", "Steam binding successful, polling page ...");
                            this.L$0 = state;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                            this.label = 2;
                            if (this.this$0.dispatch(new TribeeSteamStateAction.LaunchPolling(1), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            KLog_androidKt.getKLog().i("TribeeSteamStateMachine", "Steam binding successful, initial page ...");
                            this.L$0 = state;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                            this.label = 3;
                            if (this.this$0.dispatch(TribeeSteamStateAction.Initiate.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                        this.label = 4;
                        string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_37(TribeeRes.INSTANCE.getString()), (Continuation) this);
                        if (string == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final String resultTips = (String) string;
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$4$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeSteamState invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$3$4.invokeSuspend$lambda$0(resultTips, state, (TribeeSteamState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    case 2:
                        KLog_androidKt.getKLog().i("TribeeSteamStateMachine", "Steam binding failed, awaiting result again...");
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                        this.label = 5;
                        if (this.this$0.dispatch(TribeeSteamStateAction.AwaitSteamBindResult.INSTANCE, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                        this.label = 6;
                        string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_17(TribeeRes.INSTANCE.getString()), (Continuation) this);
                        if (string2 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final String resultTips2 = (String) string2;
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$4$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                TribeeSteamState invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$4.invokeSuspend$lambda$1(resultTips2, state, (TribeeSteamState) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    default:
                        KLog_androidKt.getKLog().e("TribeeSteamStateMachine", "Unknown Steam binding state: " + bindResult);
                        return state.noChange();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                awaitSteamResult = $result;
                bindResult = (TribeeSteamBindingState) awaitSteamResult;
                switch (bindResult != null ? -1 : WhenMappings.$EnumSwitchMapping$0[bindResult.ordinal()]) {
                }
            case 2:
                bindResult = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                this.label = 4;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_37(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                }
                break;
            case 3:
                bindResult = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                this.label = 4;
                string = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_37(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string == coroutine_suspended) {
                }
                break;
            case 4:
                TribeeSteamBindingState tribeeSteamBindingState = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                string = $result;
                final String resultTips3 = (String) string;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        TribeeSteamState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeSteamStateMachine$1$3$4.invokeSuspend$lambda$0(resultTips3, state, (TribeeSteamState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 5:
                bindResult = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.L$1 = SpillingKt.nullOutSpilledVariable(bindResult);
                this.label = 6;
                string2 = StringResourcesKt.getString(String0_commonMainKt.getTribee_global_string_17(TribeeRes.INSTANCE.getString()), (Continuation) this);
                if (string2 != coroutine_suspended) {
                }
                break;
            case 6:
                TribeeSteamBindingState tribeeSteamBindingState2 = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                string2 = $result;
                final String resultTips22 = (String) string2;
                return state.mutate(new Function1() { // from class: kntr.app.tribee.steam.viewmodel.TribeeSteamStateMachine$1$3$4$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        TribeeSteamState invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = TribeeSteamStateMachine$1$3$4.invokeSuspend$lambda$1(resultTips22, state, (TribeeSteamState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState invokeSuspend$lambda$0(String $resultTips, State $state, TribeeSteamState $this$mutate) {
        return $this$mutate.copyBy(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create($resultTips), "success"), ((TribeeSteamState) $state.getSnapshot()).getRequestingActions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamState invokeSuspend$lambda$1(String $resultTips, State $state, TribeeSteamState $this$mutate) {
        return $this$mutate.copyBy(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create($resultTips), null, 2, null), ((TribeeSteamState) $state.getSnapshot()).getRequestingActions());
    }
}