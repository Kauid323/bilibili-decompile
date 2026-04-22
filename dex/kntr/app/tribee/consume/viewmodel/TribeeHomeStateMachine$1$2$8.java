package kntr.app.tribee.consume.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.base.TribeeSteamBindingContainer;
import kntr.app.tribee.base.TribeeSteamBindingState;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
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
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "<unused var>", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitSteamBindResult;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$8", f = "TribeeHomeStateMachine.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {488, 492, 498}, m = "invokeSuspend", n = {"state", "state", "it", "$i$a$-let-TribeeHomeStateMachine$1$2$8$1", "state", "it", "$i$a$-let-TribeeHomeStateMachine$1$2$8$1"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$8 extends SuspendLambda implements Function3<TribeeHomeStateAction.AwaitSteamBindResult, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* compiled from: TribeeHomeStateMachine.kt */
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
    public TribeeHomeStateMachine$1$2$8(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$8> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.AwaitSteamBindResult awaitSteamBindResult, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$8 tribeeHomeStateMachine$1$2$8 = new TribeeHomeStateMachine$1$2$8(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$8.L$0 = state;
        return tribeeHomeStateMachine$1$2$8.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object awaitHomeResult;
        TribeeSteamBindingState it;
        int i;
        int i2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "router to steam binding page");
                TribeeSteamBindingContainer.INSTANCE.prepareHomeChannel();
                this.L$0 = state;
                this.label = 1;
                awaitHomeResult = TribeeSteamBindingContainer.INSTANCE.awaitHomeResult((Continuation) this);
                if (awaitHomeResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TribeeHomeStateMachine tribeeHomeStateMachine = this.this$0;
                it = (TribeeSteamBindingState) awaitHomeResult;
                switch (it != null ? -1 : WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                    case 1:
                        KLog_androidKt.getKLog().i("TribeeHomeStateMachine", "Steam binding successful, refreshing home page ...");
                        TribeeHomeStateAction.Refresh refresh = new TribeeHomeStateAction.Refresh(false, 1, null);
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.I$0 = 0;
                        this.label = 2;
                        if (tribeeHomeStateMachine.dispatch(refresh, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                        return state.noChange();
                    case 2:
                        KLog_androidKt.getKLog().i("TribeeHomeStateMachine", "Steam binding failed, awaiting result again...");
                        TribeeHomeStateAction.AwaitSteamBindResult awaitSteamBindResult = TribeeHomeStateAction.AwaitSteamBindResult.INSTANCE;
                        this.L$0 = state;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.I$0 = 0;
                        this.label = 3;
                        if (tribeeHomeStateMachine.dispatch(awaitSteamBindResult, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = 0;
                        return state.noChange();
                    default:
                        KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "Unknown Steam binding state: " + it);
                        return state.noChange();
                }
            case 1:
                ResultKt.throwOnFailure($result);
                awaitHomeResult = $result;
                TribeeHomeStateMachine tribeeHomeStateMachine2 = this.this$0;
                it = (TribeeSteamBindingState) awaitHomeResult;
                switch (it != null ? -1 : WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                }
            case 2:
                i = this.I$0;
                TribeeSteamBindingState tribeeSteamBindingState = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.noChange();
            case 3:
                i2 = this.I$0;
                TribeeSteamBindingState tribeeSteamBindingState2 = (TribeeSteamBindingState) this.L$1;
                ResultKt.throwOnFailure($result);
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}