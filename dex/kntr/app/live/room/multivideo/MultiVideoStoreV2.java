package kntr.app.live.room.multivideo;

import com.bapis.bilibili.live.app.room.v1.KUniversalInfoResp;
import kntr.app.live.room.multivideo.LiveRoomMultiVideoEventV2;
import kntr.app.live.room.multivideo.LiveRoomMultiVideoStateV2;
import kntr.app.live.room.multivideo.poll.ILivePollConnection;
import kntr.app.live.room.multivideo.poll.LivePollConnection;
import kntr.app.live.room.multivideo.poll.LivePollParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.udf.Store;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: MultiVideoStoreV2.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0097@¢\u0006\u0002\u0010\u001bR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lkntr/app/live/room/multivideo/MultiVideoStoreV2;", "Lkntr/base/udf/Store;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoStateV2;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "stateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "eventFlow", "livePollConnection", "Lkntr/app/live/room/multivideo/poll/ILivePollConnection;", "Lcom/bapis/bilibili/live/app/room/v1/KUniversalInfoResp;", "isActive", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", RoomRecommendViewModel.EMPTY_CURSOR, "action", "(Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultiVideoStoreV2 implements Store<LiveRoomMultiVideoStateV2, LiveRoomMultiVideoEventV2> {
    private final MutableSharedFlow<LiveRoomMultiVideoStateV2> _stateFlow;
    private final MutableSharedFlow<LiveRoomMultiVideoEventV2> eventFlow;
    private ILivePollConnection<KUniversalInfoResp> livePollConnection;
    private final Flow<LiveRoomMultiVideoStateV2> state;
    private final SharedFlow<LiveRoomMultiVideoStateV2> stateFlow;

    public static /* synthetic */ void getState$annotations() {
    }

    public MultiVideoStoreV2(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this._stateFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.stateFlow = FlowKt.asSharedFlow(this._stateFlow);
        this.eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(scope, null), 3, (Object) null);
        this.state = this.stateFlow;
    }

    public /* bridge */ /* synthetic */ Object dispatch(Object action, Continuation $completion) {
        return dispatch((LiveRoomMultiVideoEventV2) action, (Continuation<? super Unit>) $completion);
    }

    /* compiled from: MultiVideoStoreV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.live.room.multivideo.MultiVideoStoreV2$1", f = "MultiVideoStoreV2.kt", i = {0}, l = {54}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    /* renamed from: kntr.app.live.room.multivideo.MultiVideoStoreV2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $scope;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scope = coroutineScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$scope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            final CoroutineScope $this$launch = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MutableSharedFlow mutableSharedFlow = MultiVideoStoreV2.this.eventFlow;
                    final CoroutineScope coroutineScope = this.$scope;
                    final MultiVideoStoreV2 multiVideoStoreV2 = MultiVideoStoreV2.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.label = 1;
                    if (mutableSharedFlow.collect(new FlowCollector() { // from class: kntr.app.live.room.multivideo.MultiVideoStoreV2.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((LiveRoomMultiVideoEventV2) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(LiveRoomMultiVideoEventV2 it, Continuation<? super Unit> continuation) {
                            if (it instanceof LiveRoomMultiVideoEventV2.Start) {
                                LivePollParam pollParam = new LivePollParam("[multiVideoV2] MultiVideoStoreV2", ((LiveRoomMultiVideoEventV2.Start) it).getDelay(), coroutineScope, new MultiVideoStoreV2$1$1$pollParam$1(it, null), false, 16, null);
                                multiVideoStoreV2.livePollConnection = new LivePollConnection(pollParam);
                                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new C00241(multiVideoStoreV2, null), 3, (Object) null);
                                ILivePollConnection iLivePollConnection = multiVideoStoreV2.livePollConnection;
                                if (iLivePollConnection != null) {
                                    iLivePollConnection.start();
                                }
                            } else if (it instanceof LiveRoomMultiVideoEventV2.Update) {
                                ILivePollConnection iLivePollConnection2 = multiVideoStoreV2.livePollConnection;
                                if (iLivePollConnection2 != null) {
                                    iLivePollConnection2.updateInterval(((LiveRoomMultiVideoEventV2.Update) it).getDelay());
                                }
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: MultiVideoStoreV2.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.live.room.multivideo.MultiVideoStoreV2$1$1$1", f = "MultiVideoStoreV2.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.live.room.multivideo.MultiVideoStoreV2$1$1$1  reason: invalid class name and collision with other inner class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class C00241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            int label;
                            final /* synthetic */ MultiVideoStoreV2 this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00241(MultiVideoStoreV2 multiVideoStoreV2, Continuation<? super C00241> continuation) {
                                super(2, continuation);
                                this.this$0 = multiVideoStoreV2;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00241(this.this$0, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                SharedFlow<T> subscribeMessageAsFlow;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        ILivePollConnection iLivePollConnection = this.this$0.livePollConnection;
                                        if (iLivePollConnection == null || (subscribeMessageAsFlow = iLivePollConnection.subscribeMessageAsFlow()) == null) {
                                            return Unit.INSTANCE;
                                        }
                                        final MultiVideoStoreV2 multiVideoStoreV2 = this.this$0;
                                        this.label = 1;
                                        if (subscribeMessageAsFlow.collect(new FlowCollector() { // from class: kntr.app.live.room.multivideo.MultiVideoStoreV2.1.1.1.1
                                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                return emit((KUniversalInfoResp) value, (Continuation<? super Unit>) $completion);
                                            }

                                            public final Object emit(KUniversalInfoResp info, Continuation<? super Unit> continuation) {
                                                Object emit = MultiVideoStoreV2.this._stateFlow.emit(new LiveRoomMultiVideoStateV2.Content(info), continuation);
                                                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
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
                                throw new KotlinNothingValueException();
                            }
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
            throw new KotlinNothingValueException();
        }
    }

    public final boolean isActive() {
        ILivePollConnection<KUniversalInfoResp> iLivePollConnection = this.livePollConnection;
        return iLivePollConnection != null && iLivePollConnection.isActive();
    }

    public Flow<LiveRoomMultiVideoStateV2> getState() {
        return this.state;
    }

    public Object dispatch(LiveRoomMultiVideoEventV2 action, Continuation<? super Unit> continuation) {
        Object emit = this.eventFlow.emit(action, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}