package tv.danmaku.bili.ui.favorites.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIEvent;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIState;
import tv.danmaku.bili.ui.favorites.viewmodel.IUserAction;

/* compiled from: BaseFavoritesViewModel.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010!\u001a\u00020\"2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010$¢\u0006\u0002\b%J\u0013\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00028\u0000¢\u0006\u0002\u0010(J+\u0010)\u001a\u00020*2\u001e\u0010+\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00020,\u0012\u0006\u0012\u0004\u0018\u00010-0$¢\u0006\u0002\u0010.J\u0016\u0010)\u001a\u00020\"2\u0006\u0010/\u001a\u00028\u0002H\u0086@¢\u0006\u0002\u00100J\r\u00101\u001a\u00028\u0001H$¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020\"2\u0006\u0010'\u001a\u00028\u0000H$¢\u0006\u0002\u0010(J\"\u00104\u001a\u00020\"2\u0006\u00105\u001a\u0002062\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0086@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020<H\u0096@¢\u0006\u0002\u0010=R!\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Ltv/danmaku/bili/ui/favorites/viewmodel/BaseFavoritesViewModel;", "UserAction", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;", "UIState", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIState;", "UIEffect", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIEvent;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_uiStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_uiStateFlow$delegate", "Lkotlin/Lazy;", "uiStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUiStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "uiStateFlow$delegate", "_eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_eventFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "_eventFlow$delegate", "uiEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiEventFlow$delegate", "_userAction", "Lkotlinx/coroutines/channels/Channel;", "updateState", "", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "sendAction", "action", "(Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;)V", "sendEffect", "Lkotlinx/coroutines/Job;", "builder", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "effect", "(Ltv/danmaku/bili/ui/favorites/viewmodel/IUIEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initUiState", "()Ltv/danmaku/bili/ui/favorites/viewmodel/IUIState;", "onAction", "deleteItems", "resources", "", "fid", "", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDeleteSuccess", "success", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class BaseFavoritesViewModel<UserAction extends IUserAction, UIState extends IUIState, UIEffect extends IUIEvent> extends ViewModel {
    public static final int $stable = 8;
    private final Lazy _uiStateFlow$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            MutableStateFlow _uiStateFlow_delegate$lambda$0;
            _uiStateFlow_delegate$lambda$0 = BaseFavoritesViewModel._uiStateFlow_delegate$lambda$0(BaseFavoritesViewModel.this);
            return _uiStateFlow_delegate$lambda$0;
        }
    });
    private final Lazy uiStateFlow$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$$ExternalSyntheticLambda1
        public final Object invoke() {
            StateFlow uiStateFlow_delegate$lambda$0;
            uiStateFlow_delegate$lambda$0 = BaseFavoritesViewModel.uiStateFlow_delegate$lambda$0(BaseFavoritesViewModel.this);
            return uiStateFlow_delegate$lambda$0;
        }
    });
    private final Lazy _eventFlow$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$$ExternalSyntheticLambda2
        public final Object invoke() {
            MutableSharedFlow _eventFlow_delegate$lambda$0;
            _eventFlow_delegate$lambda$0 = BaseFavoritesViewModel._eventFlow_delegate$lambda$0();
            return _eventFlow_delegate$lambda$0;
        }
    });
    private final Lazy uiEventFlow$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$$ExternalSyntheticLambda3
        public final Object invoke() {
            SharedFlow uiEventFlow_delegate$lambda$0;
            uiEventFlow_delegate$lambda$0 = BaseFavoritesViewModel.uiEventFlow_delegate$lambda$0(BaseFavoritesViewModel.this);
            return uiEventFlow_delegate$lambda$0;
        }
    });
    private final Channel<UserAction> _userAction = ChannelKt.Channel$default((int) FlowControlConfig.RETRY_MAX_TIMES, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    protected abstract UIState initUiState();

    protected abstract void onAction(UserAction useraction);

    public Object onDeleteSuccess(boolean z, Continuation<? super Unit> continuation) {
        return onDeleteSuccess$suspendImpl(this, z, continuation);
    }

    public BaseFavoritesViewModel() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow _uiStateFlow_delegate$lambda$0(BaseFavoritesViewModel this$0) {
        return StateFlowKt.MutableStateFlow(this$0.initUiState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableStateFlow<UIState> get_uiStateFlow() {
        return (MutableStateFlow) this._uiStateFlow$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow uiStateFlow_delegate$lambda$0(BaseFavoritesViewModel this$0) {
        return FlowKt.asStateFlow(this$0.get_uiStateFlow());
    }

    public final StateFlow<UIState> getUiStateFlow() {
        return (StateFlow) this.uiStateFlow$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableSharedFlow _eventFlow_delegate$lambda$0() {
        return SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableSharedFlow<UIEffect> get_eventFlow() {
        return (MutableSharedFlow) this._eventFlow$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedFlow uiEventFlow_delegate$lambda$0(BaseFavoritesViewModel this$0) {
        return FlowKt.asSharedFlow(this$0.get_eventFlow());
    }

    public final SharedFlow<UIEffect> getUiEventFlow() {
        return (SharedFlow) this.uiEventFlow$delegate.getValue();
    }

    public final void updateState(Function1<? super UIState, ? extends UIState> function1) {
        Object prevValue$iv;
        Object nextValue$iv;
        Intrinsics.checkNotNullParameter(function1, "reducer");
        MutableStateFlow $this$update$iv = get_uiStateFlow();
        do {
            prevValue$iv = $this$update$iv.getValue();
            IUIState iUIState = (IUIState) prevValue$iv;
            nextValue$iv = (IUIState) function1.invoke(get_uiStateFlow().getValue());
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void sendAction(UserAction useraction) {
        Intrinsics.checkNotNullParameter(useraction, "action");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseFavoritesViewModel$sendAction$1(this, useraction, null), 3, (Object) null);
    }

    public final Job sendEffect(Function1<? super Continuation<? super UIEffect>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseFavoritesViewModel$sendEffect$1(function1, this, null), 3, (Object) null);
    }

    public final Object sendEffect(UIEffect uieffect, Continuation<? super Unit> continuation) {
        Object emit = get_eventFlow().emit(uieffect, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* compiled from: BaseFavoritesViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$1", f = "BaseFavoritesViewModel.kt", i = {}, l = {BR.bgHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseFavoritesViewModel<UserAction, UIState, UIEffect> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseFavoritesViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow consumeAsFlow = FlowKt.consumeAsFlow(((BaseFavoritesViewModel) this.this$0)._userAction);
                    final BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel = this.this$0;
                    this.label = 1;
                    if (consumeAsFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((C00161<T>) ((IUserAction) value), (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(UserAction useraction, Continuation<? super Unit> continuation) {
                            baseFavoritesViewModel.onAction(useraction);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
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

    public static /* synthetic */ Object deleteItems$default(BaseFavoritesViewModel baseFavoritesViewModel, String str, Long l, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                l = null;
            }
            return baseFavoritesViewModel.deleteItems(str, l, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteItems");
    }

    public final Object deleteItems(String resources, Long fid, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.catch(FlowKt.flow(new BaseFavoritesViewModel$deleteItems$2(resources, fid, null)), new BaseFavoritesViewModel$deleteItems$3(null)).collect(new BaseFavoritesViewModel$deleteItems$4(this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    static /* synthetic */ <UserAction extends IUserAction, UIState extends IUIState, UIEffect extends IUIEvent> Object onDeleteSuccess$suspendImpl(BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel, boolean success, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}