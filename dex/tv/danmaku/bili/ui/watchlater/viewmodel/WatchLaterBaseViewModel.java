package tv.danmaku.bili.ui.watchlater.viewmodel;

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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.bili.ui.watchlater.data.WLAction;
import tv.danmaku.bili.ui.watchlater.data.WLEvent;
import tv.danmaku.bili.ui.watchlater.data.WLState;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterBaseViewModel.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0019\u001a\u00020\u001a2\u001e\u0010\u001b\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0004¢\u0006\u0002\u0010\u001fJ-\u0010 \u001a\u00020\u001a2\u001e\u0010\u001b\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0004¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u0019\u001a\u00020!2\u0006\u0010\"\u001a\u00028\u0000H\u0084@¢\u0006\u0002\u0010#J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0013H\u0084@¢\u0006\u0002\u0010$J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020'J\u001d\u0010*\u001a\u00020!2\u0006\u0010)\u001a\u00020'2\u0006\u0010\"\u001a\u00028\u0000H$¢\u0006\u0002\u0010+J\r\u0010,\u001a\u00028\u0000H&¢\u0006\u0002\u0010-R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterBaseViewModel;", "S", "Ltv/danmaku/bili/ui/watchlater/data/WLState;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "get_state", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_state$delegate", "Lkotlin/Lazy;", "watchLaterState", "Lkotlinx/coroutines/flow/StateFlow;", "getWatchLaterState", "()Lkotlinx/coroutines/flow/StateFlow;", "watchLaterState$delegate", "_event", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "event$delegate", "emitState", "Lkotlinx/coroutines/Job;", "builder", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "emitEvent", "", "state", "(Ltv/danmaku/bili/ui/watchlater/data/WLState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ltv/danmaku/bili/ui/watchlater/data/WLEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "_action", "Lkotlinx/coroutines/channels/Channel;", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "sendAction", "action", "onAction", "(Ltv/danmaku/bili/ui/watchlater/data/WLAction;Ltv/danmaku/bili/ui/watchlater/data/WLState;)V", "initialState", "()Ltv/danmaku/bili/ui/watchlater/data/WLState;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class WatchLaterBaseViewModel<S extends WLState> extends ViewModel {
    public static final int $stable = 8;
    private final Lazy _state$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            MutableStateFlow _state_delegate$lambda$0;
            _state_delegate$lambda$0 = WatchLaterBaseViewModel._state_delegate$lambda$0(WatchLaterBaseViewModel.this);
            return _state_delegate$lambda$0;
        }
    });
    private final Lazy watchLaterState$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$$ExternalSyntheticLambda1
        public final Object invoke() {
            StateFlow watchLaterState_delegate$lambda$0;
            watchLaterState_delegate$lambda$0 = WatchLaterBaseViewModel.watchLaterState_delegate$lambda$0(WatchLaterBaseViewModel.this);
            return watchLaterState_delegate$lambda$0;
        }
    });
    private final MutableSharedFlow<WLEvent> _event = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private final Lazy event$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$$ExternalSyntheticLambda2
        public final Object invoke() {
            SharedFlow event_delegate$lambda$0;
            event_delegate$lambda$0 = WatchLaterBaseViewModel.event_delegate$lambda$0(WatchLaterBaseViewModel.this);
            return event_delegate$lambda$0;
        }
    });
    private final Channel<WLAction> _action = ChannelKt.Channel$default((int) ActionMessageWithAnimationVH.INVALID_COLOR_INT, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    public abstract S initialState();

    protected abstract void onAction(WLAction wLAction, S s);

    public WatchLaterBaseViewModel() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableStateFlow<S> get_state() {
        return (MutableStateFlow) this._state$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow _state_delegate$lambda$0(WatchLaterBaseViewModel this$0) {
        return StateFlowKt.MutableStateFlow(this$0.initialState());
    }

    public final StateFlow<S> getWatchLaterState() {
        return (StateFlow) this.watchLaterState$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow watchLaterState_delegate$lambda$0(WatchLaterBaseViewModel this$0) {
        return FlowKt.asStateFlow(this$0.get_state());
    }

    public final SharedFlow<WLEvent> getEvent() {
        return (SharedFlow) this.event$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedFlow event_delegate$lambda$0(WatchLaterBaseViewModel this$0) {
        return FlowKt.asSharedFlow(this$0._event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Job emitState(Function1<? super Continuation<? super S>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterBaseViewModel$emitState$1(function1, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Job emitEvent(Function1<? super Continuation<? super WLEvent>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterBaseViewModel$emitEvent$1(function1, this, null), 3, (Object) null);
    }

    protected final Object emitState(S s, Continuation<? super Unit> continuation) {
        Object emit = get_state().emit(s, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    protected final Object emitEvent(WLEvent event, Continuation<? super Unit> continuation) {
        Object emit = this._event.emit(event, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* compiled from: WatchLaterBaseViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$1", f = "WatchLaterBaseViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WatchLaterBaseViewModel<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WatchLaterBaseViewModel<S> watchLaterBaseViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = watchLaterBaseViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WatchLaterBaseViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$1$1", f = "WatchLaterBaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class C00021 extends SuspendLambda implements Function2<WLAction, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ WatchLaterBaseViewModel<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00021(WatchLaterBaseViewModel<S> watchLaterBaseViewModel, Continuation<? super C00021> continuation) {
                super(2, continuation);
                this.this$0 = watchLaterBaseViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00021 = new C00021(this.this$0, continuation);
                c00021.L$0 = obj;
                return c00021;
            }

            public final Object invoke(WLAction wLAction, Continuation<? super Unit> continuation) {
                return create(wLAction, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        WLAction it = (WLAction) this.L$0;
                        this.this$0.onAction(it, (WLState) this.this$0.get_state().getValue());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FlowKt.collectLatest(FlowKt.consumeAsFlow(((WatchLaterBaseViewModel) this.this$0)._action), new C00021(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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

    public final Job sendAction(WLAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterBaseViewModel$sendAction$1(this, action, null), 3, (Object) null);
    }
}