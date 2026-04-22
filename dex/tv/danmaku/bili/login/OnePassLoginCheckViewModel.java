package tv.danmaku.bili.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.login.LoginCheckState;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/login/OnePassLoginCheckViewModel;", "Landroidx/lifecycle/ViewModel;", "Ltv/danmaku/bili/login/LoginCheckActionHandler;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/login/LoginCheckState;", AuthResultCbHelper.ARGS_STATE, "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onAction", "", "action", "Ltv/danmaku/bili/login/LoginCheckAction;", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginCheckViewModel extends ViewModel implements LoginCheckActionHandler {
    public static final int $stable = 8;
    private final MutableStateFlow<LoginCheckState> _state = StateFlowKt.MutableStateFlow(LoginCheckState.IDLE.INSTANCE);
    private final StateFlow<LoginCheckState> state = FlowKt.asStateFlow(this._state);

    public final StateFlow<LoginCheckState> getState() {
        return this.state;
    }

    @Override // tv.danmaku.bili.login.LoginCheckActionHandler
    public void onAction(LoginCheckAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new OnePassLoginCheckViewModel$onAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        OnePassLoginCheckViewModel$load$1 onePassLoginCheckViewModel$load$1;
        OnePassLoginCheckViewModel onePassLoginCheckViewModel;
        if (continuation instanceof OnePassLoginCheckViewModel$load$1) {
            onePassLoginCheckViewModel$load$1 = (OnePassLoginCheckViewModel$load$1) continuation;
            if ((onePassLoginCheckViewModel$load$1.label & Integer.MIN_VALUE) != 0) {
                onePassLoginCheckViewModel$load$1.label -= Integer.MIN_VALUE;
                Object $result = onePassLoginCheckViewModel$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (onePassLoginCheckViewModel$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            this._state.setValue(LoginCheckState.Loading.INSTANCE);
                            onePassLoginCheckViewModel$load$1.label = 1;
                            if (BuildersKt.withContext(Dispatchers.getIO(), new OnePassLoginCheckViewModel$load$2(this, null), onePassLoginCheckViewModel$load$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (IOException e) {
                            onePassLoginCheckViewModel = this;
                            onePassLoginCheckViewModel._state.setValue(LoginCheckState.Failed.INSTANCE);
                            return Unit.INSTANCE;
                        }
                    case 1:
                        onePassLoginCheckViewModel = this;
                        try {
                            ResultKt.throwOnFailure($result);
                        } catch (IOException e2) {
                            onePassLoginCheckViewModel._state.setValue(LoginCheckState.Failed.INSTANCE);
                            return Unit.INSTANCE;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        onePassLoginCheckViewModel$load$1 = new OnePassLoginCheckViewModel$load$1(this, continuation);
        Object $result2 = onePassLoginCheckViewModel$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (onePassLoginCheckViewModel$load$1.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|14|15|16))|25|6|7|8|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispose(Continuation<? super Unit> continuation) {
        OnePassLoginCheckViewModel$dispose$1 onePassLoginCheckViewModel$dispose$1;
        OnePassLoginCheckViewModel onePassLoginCheckViewModel;
        if (continuation instanceof OnePassLoginCheckViewModel$dispose$1) {
            onePassLoginCheckViewModel$dispose$1 = (OnePassLoginCheckViewModel$dispose$1) continuation;
            if ((onePassLoginCheckViewModel$dispose$1.label & Integer.MIN_VALUE) != 0) {
                onePassLoginCheckViewModel$dispose$1.label -= Integer.MIN_VALUE;
                Object $result = onePassLoginCheckViewModel$dispose$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (onePassLoginCheckViewModel$dispose$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        onePassLoginCheckViewModel$dispose$1.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new OnePassLoginCheckViewModel$dispose$2(null), onePassLoginCheckViewModel$dispose$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        onePassLoginCheckViewModel = this;
                        break;
                    case 1:
                        onePassLoginCheckViewModel = this;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                onePassLoginCheckViewModel._state.setValue(LoginCheckState.Cleared.INSTANCE);
                return Unit.INSTANCE;
            }
        }
        onePassLoginCheckViewModel$dispose$1 = new OnePassLoginCheckViewModel$dispose$1(this, continuation);
        Object $result2 = onePassLoginCheckViewModel$dispose$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (onePassLoginCheckViewModel$dispose$1.label) {
        }
        onePassLoginCheckViewModel._state.setValue(LoginCheckState.Cleared.INSTANCE);
        return Unit.INSTANCE;
    }
}