package usercenter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UserHandleState;

/* compiled from: UserHandleViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0087@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lusercenter/UserHandleViewModel;", "Landroidx/lifecycle/ViewModel;", "model", "Lusercenter/UserHandleModel;", "<init>", "(Lusercenter/UserHandleModel;)V", "_sideEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lusercenter/UserHandleSideEffect;", "initialState", "Lusercenter/UserHandleState;", "stateMachine", "Lusercenter/UserHandleStateMachine;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "Lusercenter/UserHandleAction;", "(Lusercenter/UserHandleAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UserHandleViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<UserHandleSideEffect> _sideEffect;
    private final UserHandleState initialState;
    private final Flow<UserHandleSideEffect> sideEffect;
    private final StateFlow<UserHandleState> state;
    private final UserHandleStateMachine stateMachine;

    public static /* synthetic */ void getState$annotations() {
    }

    public UserHandleViewModel(UserHandleModel model) {
        String str;
        UserHandleState.Immutable immutable;
        String str2;
        Intrinsics.checkNotNullParameter(model, "model");
        this._sideEffect = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        if (!model.getEditable()) {
            CharSequence $this$trimStart$iv = model.getHandle();
            CharSequence $this$trimStart$iv$iv = $this$trimStart$iv;
            int index$iv$iv = 0;
            int length = $this$trimStart$iv$iv.length();
            while (true) {
                if (index$iv$iv < length) {
                    char it = $this$trimStart$iv$iv.charAt(index$iv$iv);
                    char it2 = it == '@' ? (char) 1 : (char) 0;
                    if (it2 != 0) {
                        index$iv$iv++;
                    } else {
                        str = $this$trimStart$iv$iv.subSequence(index$iv$iv, $this$trimStart$iv$iv.length());
                        break;
                    }
                } else {
                    break;
                }
            }
            String $this$trimStart$iv2 = str.toString();
            immutable = new UserHandleState.Immutable($this$trimStart$iv2, model.getSubmittedMessage());
        } else {
            CharSequence $this$trimStart$iv3 = model.getHandle();
            CharSequence $this$trimStart$iv$iv2 = $this$trimStart$iv3;
            int index$iv$iv2 = 0;
            int length2 = $this$trimStart$iv$iv2.length();
            while (true) {
                if (index$iv$iv2 < length2) {
                    char it3 = $this$trimStart$iv$iv2.charAt(index$iv$iv2);
                    char it4 = it3 == '@' ? (char) 1 : (char) 0;
                    if (it4 != 0) {
                        index$iv$iv2++;
                    } else {
                        str2 = $this$trimStart$iv$iv2.subSequence(index$iv$iv2, $this$trimStart$iv$iv2.length());
                        break;
                    }
                } else {
                    break;
                }
            }
            String $this$trimStart$iv4 = str2.toString();
            immutable = new UserHandleState.Mutable($this$trimStart$iv4, null, 2, null);
        }
        this.initialState = immutable;
        this.stateMachine = new UserHandleStateMachine(this.initialState, this._sideEffect);
        this.state = FlowKt.stateIn(this.stateMachine.getState(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), this.initialState);
        this.sideEffect = FlowKt.asSharedFlow(this._sideEffect);
    }

    public final StateFlow<UserHandleState> getState() {
        return this.state;
    }

    public final Object dispatch(UserHandleAction action, Continuation<? super Unit> continuation) {
        Object dispatch = this.stateMachine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public final Flow<UserHandleSideEffect> getSideEffect() {
        return this.sideEffect;
    }
}