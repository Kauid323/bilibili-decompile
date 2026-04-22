package kntr.base.account;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.adapter.AccountStateNotifier;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: KAccountStore.kt */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0087@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lkntr/base/account/KAccountStore;", "", "notifier", "Lkntr/base/account/adapter/AccountStateNotifier;", "<init>", "(Lkntr/base/account/adapter/AccountStateNotifier;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "defaultState", "Lkntr/base/account/AccountState;", "_machine", "Lkntr/base/udf/StoreMachine;", "Lkntr/base/account/AccountEvent;", "get_machine$annotations", "()V", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "dispatch", "", "action", "(Lkntr/base/account/AccountEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "account_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KAccountStore {
    private final StoreMachine<AccountState, AccountEvent> _machine;
    private final AccountState defaultState;
    private final AccountStateNotifier notifier;
    private final CoroutineScope scope;
    private final StateFlow<AccountState> state;

    public static /* synthetic */ void getState$annotations() {
    }

    private static /* synthetic */ void get_machine$annotations() {
    }

    @Inject
    public KAccountStore(AccountStateNotifier notifier) {
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.notifier = notifier;
        this.scope = CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE);
        this.defaultState = this.notifier.getCurrentState();
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = this.defaultState;
        Function1 specBlock$iv = new Function1() { // from class: kntr.base.account.KAccountStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _machine$lambda$0;
                _machine$lambda$0 = KAccountStore._machine$lambda$0(KAccountStore.this, (FlowReduxStoreBuilder) obj);
                return _machine$lambda$0;
            }
        };
        this._machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = FlowKt.stateIn(this._machine.getState(), this.scope, SharingStarted.Companion.getEagerly(), this.defaultState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _machine$lambda$0(final KAccountStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.base.account.KAccountStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _machine$lambda$0$0;
                _machine$lambda$0$0 = KAccountStore._machine$lambda$0$0(KAccountStore.this, (InStateBuilderBlock) obj);
                return _machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(AccountState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _machine$lambda$0$0(KAccountStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) $this$inState, this$0.notifier.getEventFlow(), (ExecutionPolicy) null, new KAccountStore$_machine$1$1$1(null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    public final StateFlow<AccountState> getState() {
        return this.state;
    }

    public final Object dispatch(AccountEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this._machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }
}