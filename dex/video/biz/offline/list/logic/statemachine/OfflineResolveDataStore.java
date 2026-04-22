package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.base.udf.StoreMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineResolveState;

/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolveDataStore;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "videoId", "", "cid", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/String;)V", "machine", "Lkntr/base/udf/StoreMachine;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolveState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "getMachine$annotations", "()V", "getMachine", "()Lkntr/base/udf/StoreMachine;", "_uiEventsChannel", "Lkotlinx/coroutines/channels/Channel;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent;", "uiEventsChannel", "Lkotlinx/coroutines/flow/Flow;", "getUiEventsChannel$annotations", "getUiEventsChannel", "()Lkotlinx/coroutines/flow/Flow;", "send", "", "event", "(Lvideo/biz/offline/list/logic/statemachine/OfflineResultPageUiEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineResolveDataStore {
    public static final int $stable = 8;
    private final Channel<OfflineResultPageUiEvent> _uiEventsChannel;
    private final String cid;
    private final StoreMachine<OfflineResolveState, OfflineResolvePageEvent> machine;
    private final CoroutineScope scope;
    private final Flow<OfflineResultPageUiEvent> uiEventsChannel;
    private final String videoId;

    public static /* synthetic */ void getMachine$annotations() {
    }

    public static /* synthetic */ void getUiEventsChannel$annotations() {
    }

    public OfflineResolveDataStore(CoroutineScope scope, String videoId, String cid) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(cid, "cid");
        this.scope = scope;
        this.videoId = videoId;
        this.cid = cid;
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = OfflineResolveState.Idle.INSTANCE;
        Function1 specBlock$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = OfflineResolveDataStore.machine$lambda$0(OfflineResolveDataStore.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this._uiEventsChannel = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
        this.uiEventsChannel = FlowKt.receiveAsFlow(this._uiEventsChannel);
    }

    public final StoreMachine<OfflineResolveState, OfflineResolvePageEvent> getMachine() {
        return this.machine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final OfflineResolveDataStore this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = OfflineResolveDataStore.machine$lambda$0$0(OfflineResolveDataStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineResolveState.Idle.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$1;
                machine$lambda$0$1 = OfflineResolveDataStore.machine$lambda$0$1(OfflineResolveDataStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineResolveState.Loading.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineResolveDataStore$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$2;
                machine$lambda$0$2 = OfflineResolveDataStore.machine$lambda$0$2(OfflineResolveDataStore.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(OfflineResolveState.OfflineResolvePageUiState.class), block$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(OfflineResolveDataStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new OfflineResolveDataStore$machine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$1(OfflineResolveDataStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineResolveDataStore$machine$1$2$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineResolvePageEvent.VideosLoaded.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineResolveDataStore$machine$1$2$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineResolvePageEvent.VideosLoadFailed.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$2(OfflineResolveDataStore this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OfflineResolveDataStore$machine$1$3$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OfflineResolvePageEvent.Upload.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OfflineResolveDataStore$machine$1$3$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OfflineResolvePageEvent.UploadSuccess.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new OfflineResolveDataStore$machine$1$3$3(this$0, null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OfflineResolvePageEvent.UploadFailed.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    public final Flow<OfflineResultPageUiEvent> getUiEventsChannel() {
        return this.uiEventsChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object send(OfflineResultPageUiEvent event, Continuation<? super Unit> continuation) {
        Object send = this._uiEventsChannel.send(event, continuation);
        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
    }

    public final void dispatch(OfflineResolvePageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineResolveDataStore$dispatch$1(this, event, null), 3, (Object) null);
    }
}